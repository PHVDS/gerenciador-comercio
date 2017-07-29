package br.com.walison.lucros.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Walison Cecílio
 */
public class Conexao {
    
    public Connection getConexao(){
        try {
            //Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/lucros", "root", "***");
            Connection conexao = DriverManager.getConnection("jdbc:sqlite:/home/cecilio/lucros");
            //Connection conexao = DriverManager.getConnection("jdbc:sqlite:C:\'banco\'lucros");
            conexao.setAutoCommit(false);
            return conexao;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }  
}
