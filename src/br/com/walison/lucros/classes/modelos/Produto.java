package br.com.walison.lucros.classes.modelos;

/**
 *
 * @author Walison Cecílio
 */
public class Produto {
    
    private short cod_prod;
    private String nom_prod;
    private String mar_prod ;
    private float vl_prod;
    private String desc_prod;
    private boolean unidade; // SE FOR FALSO É UNIDADE SE NÃO É PESO
    private boolean cadastrado; 
    private String cod_bar_prod;
    private short qtd_estoque;    
    
    public Produto(short cod_prod, String nom_prod, String mar_prod, float vl_prod, String desc_prod, boolean unidade, String cod_bar_prod, boolean cadastrado, short qtd_estoque){        
        this.cod_prod = cod_prod;
        this.nom_prod = nom_prod;
        this.mar_prod = mar_prod;
        this.vl_prod = vl_prod;
        this.desc_prod = desc_prod;
        this.unidade = unidade;
        this.cadastrado = true;
        this.cod_bar_prod = cod_bar_prod;
        this.cadastrado = cadastrado;
//        this.estoque = new LinkedList<>();
        this.qtd_estoque = qtd_estoque;
    }
    
    public Produto(String nom_prod, String desc_prod, float vl_prod, boolean unidade, boolean cadastrado){
        this.nom_prod = nom_prod;
        this.mar_prod = "";
        this.desc_prod = desc_prod;
        this.vl_prod = vl_prod;
        this.unidade = unidade;
        this.cadastrado = cadastrado;
        //this.estoque = new LinkedList<>();
    }
    
    public float calculaPeso(short peso, float valorQuilo){
        return (valorQuilo / 1000) * peso;
    }
    
    @Override
    public String toString(){
        if(this.desc_prod.equals("") || this.desc_prod == null)
            return this.getNom_prod() + "  " + this.mar_prod;
        else
            return this.getNom_prod() + "  " + this.getDesc_prod() + "  " + this.mar_prod;
    }

    /**
     * @return the cod_prod
     */
    public int getCod_prod() {
        return cod_prod;
    }

    /**
     * @return the nom_prod
     */
    public String getNom_prod() {
        return nom_prod;
    }

    /**
     * @param nom_prod the nom_prod to set
     */
    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    /**
     * @return the mar_prod
     */
    public String getMar_prod() {
        return mar_prod;
    }

    /**
     * @param mar_prod the mar_prod to set
     */
    public void setMar_prod(String mar_prod) {
        this.mar_prod = mar_prod;
    }

    /**
     * @return the vl_prod
     */
    public float getVl_prod() {
        return vl_prod;
    }

    /**
     * @param vl_prod the vl_prod to set
     */
    public void setVl_prod(float vl_prod) {
        this.vl_prod = vl_prod;
    }

    /**
     * @return the desc_prod
     */
    public String getDesc_prod() {
        return desc_prod;
    }
    
    /**
     * @param desc_prod the desc_prod to set
     */
    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }  

    /**
     * @return the unidade
     */
    public boolean isUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(boolean unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the cadastrado
     */
    public boolean isCadastrado() {
        return cadastrado;
    }

    /**
     * @param cadastrado the cadastrado to set
     */
    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    /**
     * @return the cod_bar_prod
     */
    public String getCod_bar_prod() {
        return cod_bar_prod;
    }

    /**
     * @param cod_prod the cod_prod to set
     */
    public void setCod_prod(short cod_prod) {
        this.cod_prod = cod_prod;
    }

    /**
     * @return the qtd_estoque
     */
    public short getQtd_estoque() {
        return qtd_estoque;
    }

    /**
     * @param qtd_estoque the qtd_estoque to set
     */
    public void setQtd_estoque(short qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
}
