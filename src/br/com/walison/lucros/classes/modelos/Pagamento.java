package br.com.walison.lucros.classes.modelos;

import java.util.LinkedList;

/**
 *
 * @author Walison Cecílio
 */
public class Pagamento {
    
    private short cod_pag;
    private float vl_pago, vl_divida, vl_resto;
    private String dt_pag, hr_pag;
    private LinkedList<Venda> vendas;
    
    public Pagamento(short cod_pag, float vl_pago, float vl_divida, float vl_resto, String data, String hora){
        this.cod_pag = cod_pag;
        this.vl_pago = vl_pago;
        this.vl_divida = vl_divida;
        this.vl_resto = vl_resto;
        this.dt_pag = dt_pag;
        this.hr_pag = hr_pag;
        this.vendas = new LinkedList<Venda>();
    }

    /**
     * @return the cod_pag
     */
    public short getCod_pag() {
        return cod_pag;
    }

    /**
     * @return the vl_pago
     */
    public float getVl_pago() {
        return vl_pago;
    }

    /**
     * @param vl_pago the vl_pago to set
     */
    public void setVl_pago(float vl_pago) {
        this.vl_pago = vl_pago;
    }

    /**
     * @return the vl_divida
     */
    public float getVl_divida() {
        return vl_divida;
    }

    /**
     * @param vl_divida the vl_divida to set
     */
    public void setVl_divida(float vl_divida) {
        this.vl_divida = vl_divida;
    }

    /**
     * @return the vl_resto
     */
    public float getVl_resto() {
        return vl_resto;
    }

    /**
     * @param vl_resto the vl_resto to set
     */
    public void setVl_resto(float vl_resto) {
        this.vl_resto = vl_resto;
    }

    /**
     * @return the dt_pag
     */
    public String getDt_pag() {
        return dt_pag;
    }

    /**
     * @param dt_pag the dt_pag to set
     */
    public void setDt_pag(String dt_pag) {
        this.dt_pag = dt_pag;
    }

    /**
     * @return the hr_pag
     */
    public String getHr_pag() {
        return hr_pag;
    }

    /**
     * @param hr_pag the hr_pag to set
     */
    public void setHr_pag(String hr_pag) {
        this.hr_pag = hr_pag;
    }

    /**
     * @return the vendas
     */
    public LinkedList<Venda> getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(LinkedList<Venda> vendas) {
        this.vendas = vendas;
    }
    
    
}
