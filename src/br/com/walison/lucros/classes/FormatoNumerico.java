package br.com.walison.lucros.classes;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Walison Cecílio
 */
public class FormatoNumerico {
    
    private final NumberFormat duasCasas;
    private final NumberFormat dinheiro;

    
    public FormatoNumerico() {      
        this.duasCasas = new DecimalFormat("00.00");
        this.dinheiro = NumberFormat.getCurrencyInstance();
    }
    
    public String duasCasasDecimais(double valor) {
        return this.duasCasas.format(valor).replace(',', '.');           
    }
    
    public String din(double valor) {
        return this.dinheiro.format(valor);
    }

    
}
