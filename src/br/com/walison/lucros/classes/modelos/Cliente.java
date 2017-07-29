package br.com.walison.lucros.classes.modelos;

import br.com.walison.lucros.classes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Walison Cecílio
 */
public class Cliente {

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    private short cod_cli;
    private String nom_cli;
    private String sob_nom_cli;
    private String cpf_cli;
    private String dt_nasc_cli;
    private String rua;
    private short num_cas_cli;
    private String conj_cli;
    private String bai_cli;
    private String cid_cli;
    private String uf_cli;
    private String tel_cli;
    private Conta conta;
    
    public Cliente(){
        
    }
    
    public Cliente(short cod_cli, String nom_cli, String sob_nom_cli, String cpf_cli, String dt_nasc_cli, short cod_con, String rua,  short num_cas_cli, String conj_cli, String bai_cli, String cid_cli, String uf_cli, String tel_cli) throws SQLException{
        this.cod_cli = cod_cli;
        this.nom_cli = nom_cli;
        this.sob_nom_cli = sob_nom_cli;
        this.cpf_cli = cpf_cli;
        this.dt_nasc_cli = dt_nasc_cli;
        this.num_cas_cli = num_cas_cli;
        this.conj_cli = conj_cli;
        this.bai_cli = bai_cli;
        this.cid_cli = cid_cli;
        this.uf_cli = uf_cli;
        this.tel_cli = tel_cli;
        this.rua = rua;

        Connection conexao = new Conexao().getConexao();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM contas WHERE cod_con = ?;");
        stmt.setShort(1, cod_con);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Conta conta = new Conta(rs.getShort(1), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7));
            this.setConta(conta);
        }
        
        rs.close();
        conexao.close();
    }
    
    @Override
    public String toString(){
        return this.nom_cli + " " + this.sob_nom_cli;
    }
    
    public String info(){
        
        NumberFormat dim = NumberFormat.getCurrencyInstance();
        
        String dia;
        
        if(Integer.parseInt(this.conta.getDt_pag()) < 10)
            dia = "0"+this.conta.getDt_pag();
        else
            dia = this.conta.getDt_pag();
      
        return "CLIENTE: " + this.toString()
        + "      SALDO: " + dim.format(this.conta.getSal_con()) + "      LIMITE: " + dim.format(this.conta.getLim_con())
        + "      DIVIDA: " + dim.format(this.conta.getDiv_con()) + "      DIA DE PAGAMENTO: " + dia;
        
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getSob_nom_cli() {
        return sob_nom_cli;
    }


    public void setSob_nom_cli(String sob_nom_cli) {
        this.sob_nom_cli = sob_nom_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getDt_nasc_cli() {
        return dt_nasc_cli;
    }

    public void setDt_nasc_cli(String dt_nasc_cli) {
        this.dt_nasc_cli = dt_nasc_cli;
    }

    public short getNum_cas_cli() {
        return num_cas_cli;
    }

    public void setNum_cas_cli(short num_cas_cli) {
        this.num_cas_cli = num_cas_cli;
    }

    public String getConj_cli() {
        return conj_cli;
    }

    public void setConj_cli(String conj_cli) {
        this.conj_cli = conj_cli;
    }

    public String getBai_cli() {
        return bai_cli;
    }

    public void setBai_cli(String bai_cli) {
        this.bai_cli = bai_cli;
    }

    public String getCid_cli() {
        return cid_cli;
    }

    public void setCid_cli(String cid_cli) {
        this.cid_cli = cid_cli;
    }

    public String getUf_cli() {
        return uf_cli;
    }

    public void setUf_cli(String uf_cli) {
        this.uf_cli = uf_cli;
    }

    public String getTel_cli() {
        return tel_cli;
    }

    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
}
