package br.com.walison.lucros.classes.modelos;

/**
 *
 * @author Walison Cecílio
 */
public class Fornecedor {
    
    private short cod_for;
    private String nom_for;
    private String cnpj_for;
    private String tel_for;
    private String email_for;
    
    public Fornecedor(short cod_for, String nom_for, String cnpj_for, String tel_for, String email_for){
        this.cod_for = cod_for;
        this.nom_for = nom_for;
        this.cnpj_for = cnpj_for;
        this.tel_for = tel_for;
        this.email_for = email_for;
    }

    public String toString(){
        return this.nom_for;
    }
    
    /**
     * @return the cod_for
     */
    public short getCod_for() {
        return cod_for;
    }

    /**
     * @return the nom_for
     */
    public String getNom_for() {
        return nom_for;
    }

    /**
     * @param nom_for the nom_for to set
     */
    public void setNom_for(String nom_for) {
        this.nom_for = nom_for;
    }

    /**
     * @return the cnpj_for
     */
    public String getCnpj_for() {
        return cnpj_for;
    }

    /**
     * @param cnpj_for the cnpj_for to set
     */
    public void setCnpj_for(String cnpj_for) {
        this.cnpj_for = cnpj_for;
    }

    /**
     * @return the tel_for
     */
    public String getTel_for() {
        return tel_for;
    }

    /**
     * @param tel_for the tel_for to set
     */
    public void setTel_for(String tel_for) {
        this.tel_for = tel_for;
    }

    /**
     * @return the email_for
     */
    public String getEmail_for() {
        return email_for;
    }

    /**
     * @param email_for the email_for to set
     */
    public void setEmail_for(String email_for) {
        this.email_for = email_for;
    }
    
    
    
}
