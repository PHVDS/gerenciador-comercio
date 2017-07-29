package br.com.walison.lucros.classes.modelos;

import br.com.walison.lucros.classes.Calendario;
import br.com.walison.lucros.classes.Conexao;
import br.com.walison.lucros.classes.FormatoNumerico;
import br.com.walison.lucros.classes.GeraCriptografa;
import br.com.walison.lucros.classes.GeraPdf;
import br.com.walison.lucros.classes.NotaVenda;
import br.com.walison.lucros.classes.TrataNumeros;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walison Cecílio
 */
public class Venda {
    
    private short cod_ven;
    private float vl_ven;
    private float vl_des_ven;
    private String dt_com_prod;
    private String hr_com_prod;
    private Conta conta;
    private LinkedList<Subtotal> subtotais;
    private float vl_recebido;
    private float vl_troco;
    private NotaVenda notaVenda;
    private GeraPdf nota;
    
    public Venda(short cod_ven, float vl_ven, float vl_recebido, float vl_troco, String dt_com_prod, String ht_com_prod){
        this.cod_ven = cod_ven;
        this.vl_ven = vl_ven;
        this.vl_recebido = vl_recebido;
        this.vl_troco = vl_troco;
        this.vl_des_ven = 0;
        this.dt_com_prod = dt_com_prod;
        this.hr_com_prod = ht_com_prod;
        this.conta = null;
        this.subtotais = new LinkedList<>();
    }
    
    public Venda() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        this.cod_ven = (short) new GeraCriptografa().gerarNumero(conexao, "vendas", "cod_ven");
        conexao.close();
        this.vl_ven = 0;
        this.vl_des_ven = 0;
        this.conta = null;
        this.subtotais = new LinkedList<>();       
    }
    
    public void CarregarVenda() throws SQLException{
        Connection c = new Conexao().getConexao();
        Statement stmt = c.createStatement();
        Statement stmtP = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT qtd_prod, cod_prod, vl_prod FROM subtotais WHERE cod_ven = " + this.cod_ven + ";");
        
        while(rs.next()){
            ResultSet r = stmtP.executeQuery("SELECT * FROM produtos WHERE cod_prod = " + rs.getInt(2) + " LIMIT 1;");
            Produto p = null;
            
            if(r.next()){
                p = new Produto(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), Float.parseFloat(r.getString(4)),  r.getString(5), r.getBoolean(6), r.getString(7), r.getBoolean(8), r.getShort(9));
            }
            
            Subtotal co = new Subtotal(p, rs.getShort(1), rs.getFloat(3));
            this.getCompras().add(co);
        }
        
        rs.close();
        c.close();
    }
    
    public void CarregarVendaLucros() throws SQLException{
        Connection c = new Conexao().getConexao();
        Statement stmt = c.createStatement();
        Statement stmtP = c.createStatement();
        ResultSet rs = stmt.executeQuery("select qtd, cod_prod, vl_com_prod, cod_lote from lote_estoque left join estoque using(cod_lote) join produtos using(cod_prod) where cod_ven = " + this.cod_ven + ";");
        
        while(rs.next()){
            
            ResultSet r = stmtP.executeQuery("SELECT * FROM produtos WHERE cod_prod = " + rs.getInt(2) + " LIMIT 1;");
            Produto p = null;
            
            if(r.next()){
                p = new Produto(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), Float.parseFloat(r.getString(4)),  r.getString(5), r.getBoolean(6), r.getString(7), r.getBoolean(8), r.getShort(9));
            }
            
            Subtotal co = new Subtotal(p, rs.getShort(1), rs.getFloat(3), rs.getShort(4));
            this.getCompras().add(co);
        }
        rs.close();
        c.close();
    }
    
    public boolean addCompra(Subtotal compra){
        FormatoNumerico f = new FormatoNumerico();
        for(Subtotal c : this.getCompras()){
            if(c.getProduto().getCod_prod() == compra.getProduto().getCod_prod()){
                c.setQtd_prod((short)(compra.getQtd_prod()));
                c.setVl_com(Float.parseFloat(f.duasCasasDecimais((c.getVl_com() + compra.getVl_com()))));
                this.vl_ven += Float.parseFloat(f.duasCasasDecimais(compra.getVl_com()));
                return false;
            }
        }
        
        this.vl_ven += Float.parseFloat(f.duasCasasDecimais(compra.getVl_com()));
        this.getCompras().add(compra);
        return true;
    }
    
    public void EscreverNota(){
        try {
            this.nota = new GeraPdf(this.cod_ven + "--" + new TrataNumeros().trataDatas(this.dt_com_prod));
        
            this.nota.Escrever("----------------------------------------------\n");
            this.nota.Escrever("\"PROGRAMAR PORRA\\n\"\n");
            this.nota.Escrever("CNPJ XXXXXXXXXXXX  \nINSTCRIÇÃO ESTADUAL XXXXXXXXXX\n");
            this.nota.Escrever("RUA X Nº XXXX CONJ XXXXX XXXXXXXXX BAIRRO \nXXXXXX XXXXX XXXXX-SE\n");
            this.nota.Escrever("\nDATA: " + this.dt_com_prod + " " + this.hr_com_prod + "\n");
            this.nota.Escrever("----------------------------------------------\n");
            this.nota.Escrever(String.format("%3s  %40s\n%10s     %10s \n", "QTD", "DESCRIÇÃO", "VL. UNIT", "VL. TOTAL"));
            
            for(Subtotal compra : this.getCompras()){
                String desc = compra.getProduto().getNom_prod() + " " + compra.getProduto().getDesc_prod();
            
                if(desc.length() > 30)
                    desc = desc.substring(0, 29);

                this.nota.Escrever(String.format("%3d  %40s\n%8.2f     %8.2f \n", compra.getQtd_prod(), desc, compra.getVl_prod(), compra.getVl_com()));
            }
            
            this.nota.Escrever("\n");
            this.nota.Escrever(String.format("%s %.2f \n" ,"VL. PAGO: R$ ", this.vl_recebido));
            this.nota.Escrever(String.format("%s %.2f \n", "VL. TROCO: R$ ", this.vl_troco));
            this.nota.Escrever(String.format("%s %.2f \n", "VL. COMPRA: R$ ", this.vl_ven));
            this.nota.getDocumento().setPageSize(PageSize.A8);
            this.nota.getDocumento().close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
    public void EscreverLinhaNota(){
        try {
            this.notaVenda = new NotaVenda(this.cod_ven + "-" + new TrataNumeros().trataDatas(this.dt_com_prod));
        } catch (IOException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cont = 1;
        
        this.getNotaVenda().getEscritor().print("--------------------------------------\n");
        this.getNotaVenda().getEscritor().print("PROGRAMAR PORRA\n");
        this.getNotaVenda().getEscritor().print("CNPJ XXXXXXXXXXXXX  \nINSTCRIÇÃO ESTADUAL XXXXXXXX\n");
        this.getNotaVenda().getEscritor().print("RUA x Nº xxx CONJ xxxx xxxxx \nBAIRRO xxxxx xxxx xxxxxxx-SE\n");
        this.getNotaVenda().getEscritor().print("\nDATA: " + this.dt_com_prod + " " + this.hr_com_prod + "\n");
        this.getNotaVenda().getEscritor().print("--------------------------------------\n");

        this.getNotaVenda().getEscritor().printf("%3s  %30s\n%10s  %10s \n", "QTD", "DESCRIÇÃO", "VL. UNIT", "VL. TOTAL");
        for(Subtotal compra : this.getCompras()){
            String desc = compra.getProduto().getNom_prod() + " " + compra.getProduto().getDesc_prod();
            
            if(desc.length() > 30)
                desc = desc.substring(0, 29);
            
            this.getNotaVenda().getEscritor().printf("%3d  %30s\n%8.2f  %8.2f \n", compra.getQtd_prod(), desc, compra.getVl_prod(), compra.getVl_com());
        }
        this.getNotaVenda().getEscritor().print("\n");
    }
    
    public void FecharNota(){
        this.getNotaVenda().getEscritor().printf("%s %.2f \n" ,"VL. PAGO: R$ ", this.vl_recebido);
        this.getNotaVenda().getEscritor().printf("%s %.2f \n", "VL. TROCO: R$ ", this.vl_troco);
        this.getNotaVenda().getEscritor().printf("%s %.2f \n", "VL. COMPRA: R$ ", this.vl_ven);
        this.getNotaVenda().getEscritor().close();
    }
    
    public boolean removerCompra(Produto produto){
        for(Subtotal c : this.getCompras()){
            if(c.getProduto().equals(produto)){
                this.vl_ven -= c.getVl_com();
                this.getCompras().remove(c);
                return true;
            }
        }
        return false;
    }
    
    public void setDataHora(){
        
        Calendario calendario = new Calendario();
        this.dt_com_prod = calendario.retornaData();
        this.hr_com_prod = calendario.retornaHora();
        
    }
    
    @Override
    public String toString(){
        return "" + this.cod_ven;
    }
    

    /**
     * @return the cod_ven
     */
    public short getCod_ven() {
        return cod_ven;
    }

    /**
     * @return the vl_ven
     */
    public float getVl_ven() {
        return vl_ven;
    }

    /**
     * @param vl_ven the vl_ven to set
     */
    public void setVl_ven(float vl_ven) {
        this.vl_ven = vl_ven;
    }

    /**
     * @return the vl_des_ven
     */
    public float getVl_des_ven() {
        return vl_des_ven;
    }

    /**
     * @param vl_des_ven the vl_des_ven to set
     */
    public void setVl_des_ven(float vl_des_ven) {
        this.vl_des_ven = vl_des_ven;
    }

    /**
     * @return the dt_com_prod
     */
    public String getDt_com_prod() {
        return dt_com_prod;
    }

    /**
     * @param dt_com_prod the dt_com_prod to set
     */
    public void setDt_com_prod(String dt_com_prod) {
        this.dt_com_prod = dt_com_prod;
    }

    /**
     * @return the hr_com_prod
     */
    public String getHr_com_prod() {
        return hr_com_prod;
    }

    /**
     * @param hr_com_prod the hr_com_prod to set
     */
    public void setHr_com_prod(String hr_com_prod) {
        this.hr_com_prod = hr_com_prod;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the compras
     */
    public LinkedList<Subtotal> getCompras() {
        return subtotais;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(LinkedList<Subtotal> compras) {
        this.subtotais = compras;
    }

    /**
     * @return the vl_recebido
     */
    public float getVl_recebido() {
        return vl_recebido;
    }

    /**
     * @param vl_recebido the vl_recebido to set
     */
    public void setVl_recebido(float vl_recebido) {
        this.vl_recebido = vl_recebido;
    }

    /**
     * @return the vl_troco
     */
    public float getVl_troco() {
        return vl_troco;
    }

    /**
     * @param vl_troco the vl_troco to set
     */
    public void setVl_troco(float vl_troco) {
        this.vl_troco = vl_troco;
    }

    /**
     * @return the notaVenda
     */
    public NotaVenda getNotaVenda() {
        return notaVenda;
    }
}
