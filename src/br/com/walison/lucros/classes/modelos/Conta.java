
package br.com.walison.lucros.classes.modelos;

import java.util.LinkedList;

/**
 *
 * @author Walison Cecílio
 */
public class Conta {
    
    private short cod_con;
    private float sal_con;
    private float lim_con;
    private float div_con;
    private String dt_pag;
    private boolean pagou;
    private boolean atraso;
    private LinkedList<Venda> compras;
    
    public Conta(short cod_con, float lim_con, float div_con, String dt_pag, boolean pagou, boolean atraso){
        this.cod_con = cod_con;
        this.sal_con = lim_con - div_con;
        this.lim_con = lim_con;
        this.div_con = div_con;
        this.dt_pag = dt_pag;
        this.pagou = pagou;
        this.atraso = atraso;
        this.compras = null; // NULO POR ENQUANTO LOGO LOGO VOU PREENCHELO
    }

    public short getCod_con() {
        return cod_con;
    }

    public float getSal_con() {
        return sal_con;
    }

    public void setSal_con(float sal_con) {
        this.sal_con = sal_con;
    }

    public float getLim_con() {
        return lim_con;
    }

    public void setLim_con(float lim_con) {
        this.lim_con = lim_con;
    }

    public float getDiv_con() {
        return div_con;
    }

    public void setDiv_con(float div_con) {
        this.div_con = div_con;
    }

    public String getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(String dt_pag) {
        this.dt_pag = dt_pag;
    } 

    /**
     * @return the pagou
     */
    public boolean isPagou() {
        return pagou;
    }

    /**
     * @param pagou the pagou to set
     */
    public void setPagou(boolean pagou) {
        this.pagou = pagou;
    }  

    /**
     * @return the atraso
     */
    public boolean isAtraso() {
        return atraso;
    }

    /**
     * @param atraso the atraso to set
     */
    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    /**
     * @return the compras
     */
    public LinkedList<Venda> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(LinkedList<Venda> compras) {
        this.compras = compras;
    }
}
