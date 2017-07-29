package br.com.walison.lucros.classes;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Walison Cecílio
 */
public class Tela {
    
    private Toolkit kit;
    private Dimension tamTela; 
    private int larg; 
    private int alt;
    
    public Tela(){
        this.kit = Toolkit.getDefaultToolkit(); 
        this.tamTela = kit.getScreenSize(); 
        this.larg = tamTela.width;  
        this.alt = tamTela.height; 
    }
    
    

    /**
     * @return the larg
     */
    public int getLarg() {
        return larg;
    }

    /**
     * @return the alt
     */
    public int getAlt() {
        return alt;
    }

    /**
     * @return the tamTela
     */
    public Dimension getTamTela() {
        return tamTela;
    }
   
        
}
