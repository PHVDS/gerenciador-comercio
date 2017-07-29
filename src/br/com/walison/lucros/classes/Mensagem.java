package br.com.walison.lucros.classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Walison Cecílio
 */
public class Mensagem {
    
    public Mensagem(){}
    
    public void msg(){
        JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios!");
    }
    
    public void msg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
