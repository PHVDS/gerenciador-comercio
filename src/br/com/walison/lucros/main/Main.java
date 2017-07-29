package br.com.walison.lucros.main;

import br.com.walison.lucros.visao.login.JLogin;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Walison Cecílio  
 */
public class Main {
    
    public static void main (String[] args) throws SQLException{
        JLogin j = new JLogin();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setResizable(false);
        j.setLocationRelativeTo(null);
        j.getSenha().requestFocus();
    }
}
