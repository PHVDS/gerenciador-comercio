package br.com.walison.lucros.classes;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walison Cecílio
 */
public class GeraCriptografa {
    
    public GeraCriptografa(){}
    
    public static void main (String [] args) throws NoSuchAlgorithmException{
        GeraCriptografa g = new GeraCriptografa();
        
        byte b[] = g.criptografar("admin");
        
        for(int i = 0; i <= b.length - 1; i++){
            System.out.print(b[i]);
        }
    }
    
    public byte[] criptografar(String senha) throws NoSuchAlgorithmException{    
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte cript[];
        
        try {
            
            cript = algorithm.digest(senha.getBytes("UTF-8"));
            return cript;
            
        } catch (UnsupportedEncodingException ex) {
            return null;
        }     
    }
    
    private int gerarCod(){       
        Random rand = new Random(); 
        return rand.nextInt(8999) + 1000;      
    }
    
    public int gerarNumero(Connection conexao, String tabela, String coluna) throws SQLException {   
        try {   
            boolean loop = true;
            
            while(loop){                    
                int cod = new GeraCriptografa().gerarCod();
                String sql = "SELECT * FROM " + tabela + " WHERE " + coluna + " = " + cod + " LIMIT 1";

                ResultSet result = conexao.createStatement().executeQuery(sql);

                if(!result.isBeforeFirst())
                    return cod;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
}
