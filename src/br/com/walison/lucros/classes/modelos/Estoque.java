package br.com.walison.lucros.classes.modelos;

import br.com.walison.lucros.classes.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Walison Cecílio
 */
public class Estoque {
    
    private short qtd_prod; // Quantidade em estoque
    private String dt_val_prod; // Data de validade
    private String dt_prod; // Data que foi colocado em estoque
    private String hr_prod; // Hora que foi colocado em estoque
    private float vl_com_prod; // Valor de compra do produto
    private short qtd_venda_prod; // Quantidade de vendas
    private Fornecedor fornecedor;
    
    public Estoque (short qtd_prod, String dt_val_prod, String dt_prod, String hr_prod, float vl_com_prod, short cod_for) {
        this.qtd_prod = qtd_prod;
        this.dt_val_prod = dt_val_prod;
        this.dt_prod = dt_prod;
        this.hr_prod = hr_prod;
        this.vl_com_prod = vl_com_prod;
    }
    
    public void CarregraFornecedor(short cod_for) throws SQLException{
        String sql = "SELECT * FROM fornecedores WHERE cod_for = " + cod_for + " LIMIT 1;";
        Connection conn = new Conexao().getConexao();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        
        if(rs.next()){
            Fornecedor f = new Fornecedor(rs.getShort(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            this.setFornecedor(fornecedor);
        }
        
    }
    
    public Estoque () {
        this.qtd_prod = 0;
    }
    
    public boolean estoqueVazio () {
        if(this.qtd_prod == 0)
            return true;
        else
            return false;
    }
    
    public void retirarEstoque(int qtde){
        this.qtd_prod -= qtde;
    }
    

    /**
     * @return the qtd_prod
     */
    public short getQtd_prod() {
        return qtd_prod;
    }

    /**
     * @param qtd_prod the qtd_prod to set
     */
    public void setQtd_prod(short qtd_prod) {
        this.qtd_prod = qtd_prod;
    }

    /**
     * @return the dt_val_prod
     */
    public String getDt_val_prod() {
        return dt_val_prod;
    }

    /**
     * @param dt_val_prod the dt_val_prod to set
     */
    public void setDt_val_prod(String dt_val_prod) {
        this.dt_val_prod = dt_val_prod;
    }

    /**
     * @return the dt_prod
     */
    public String getDt_prod() {
        return dt_prod;
    }

    /**
     * @param dt_prod the dt_prod to set
     */
    public void setDt_prod(String dt_prod) {
        this.dt_prod = dt_prod;
    }

    /**
     * @return the hr_prod
     */
    public String getHr_prod() {
        return hr_prod;
    }

    /**
     * @param hr_prod the hr_prod to set
     */
    public void setHr_prod(String hr_prod) {
        this.hr_prod = hr_prod;
    }

    /**
     * @return the vl_com_prod
     */
    public float getVl_com_prod() {
        return vl_com_prod;
    }

    /**
     * @param vl_com_prod the vl_com_prod to set
     */
    public void setVl_com_prod(float vl_com_prod) {
        this.vl_com_prod = vl_com_prod;
    }

    /**
     * @return the qtd_venda_prod
     */
    public short getQtd_venda_prod() {
        return qtd_venda_prod;
    }

    /**
     * @param qtd_venda_prod the qtd_venda_prod to set
     */
    public void setQtd_venda_prod(short qtd_venda_prod) {
        this.qtd_venda_prod = qtd_venda_prod;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
      
}
