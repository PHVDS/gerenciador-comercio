package br.com.walison.lucros.classes.modelos;

import br.com.walison.lucros.classes.FormatoNumerico;

/**
 *
 * @author Walison Cecílio
 */
public class Subtotal {
    
    private Produto produto; 
    private short qtd_prod;
    private float vl_com;
    private float vl_des_com;
    private float vl_prod;  
    
    private short cod_lote;

    
    public Subtotal(Produto produto, short qtd_prod, float vl_prod){
        FormatoNumerico f = new FormatoNumerico();
        
        if(produto.isUnidade()){
            this.vl_com = Float.parseFloat(f.duasCasasDecimais(vl_prod * qtd_prod));
        }else {
            this.vl_com = Float.parseFloat(f.duasCasasDecimais(produto.calculaPeso(qtd_prod, vl_prod)));
        }
        
        this.vl_prod = vl_prod;
        this.produto = produto;
        this.qtd_prod = qtd_prod;
    }
    
    public Subtotal(Produto produto, short qtd_prod, float vl_prod, short cod_lote){
        FormatoNumerico f = new FormatoNumerico();
        
        if(produto.isUnidade()){
            this.vl_com = Float.parseFloat(f.duasCasasDecimais(vl_prod * qtd_prod));
        }else {
            this.vl_com = Float.parseFloat(f.duasCasasDecimais(produto.calculaPeso(qtd_prod, vl_prod)));
        }
        
        this.vl_prod = vl_prod;
        this.produto = produto;
        this.qtd_prod = qtd_prod;
        this.cod_lote = cod_lote;
    }
    
    public float converteGramaPraQuilo() {
        float retorno = 0;
        short qtd = this.qtd_prod;
        FormatoNumerico f = new FormatoNumerico();
        
        while(qtd >= 9){
            if(qtd >= 1000){
                retorno += 1;
                qtd -= 1000;
            }else if(qtd >= 100){
                retorno += 0.1;
                qtd -= 100;
            }else if(qtd >= 10){
                retorno += 0.01;
                qtd -= 10;
            }
        }
        return Float.parseFloat(f.duasCasasDecimais(retorno));
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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
        this.qtd_prod += qtd_prod;
    }

    /**
     * @return the vl_com
     */
    public float getVl_com() {
        return vl_com;
    }

    /**
     * @param vl_com the vl_com to set
     */
    public void setVl_com(float vl_com) {
        this.vl_com = vl_com;
    }

    /**
     * @return the vl_des_com
     */
    public float getVl_des_com() {
        return vl_des_com;
    }

    /**
     * @param vl_des_com the vl_des_com to set
     */
    public void setVl_des_com(float vl_des_com) {
        this.vl_des_com = vl_des_com;
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
     * @return the cod_lote
     */
    public short getCod_lote() {
        return cod_lote;
    }

    /**
     * @param cod_lote the cod_lote to set
     */
    public void setCod_lote(short cod_lote) {
        this.cod_lote = cod_lote;
    }  
}

