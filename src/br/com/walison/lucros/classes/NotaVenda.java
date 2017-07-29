
package br.com.walison.lucros.classes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Walison Cecilio
 */
public class NotaVenda {
    
    private FileWriter arquivo;
    private FileReader leitor;
    private PrintWriter escritor;
    
    public NotaVenda(String caminhoArquivo) throws IOException{
        this.arquivo = new FileWriter("/home/cecilio/" + caminhoArquivo + ".txt");
        //this.arquivo = new FileWriter("C:\'notas\'" + caminhoArquivo + ".txt");
        this.escritor = new PrintWriter(this.getArquivo());
        this.leitor = new FileReader("/home/cecilio/" + caminhoArquivo + ".txt");
        //this.leitor = new FileReader("C:\'notas\'" + caminhoArquivo + ".txt");
    }
    
    public static void main (String [] args) throws IOException{
        NotaVenda n = new NotaVenda("walison");
        
        n.escritor.print("Walison");
        n.escritor.close();
        n.escritor.print("Walison");
        n.escritor.close();
    }

    /**
     * @return the arquivo
     */
    public FileWriter getArquivo() {
        return arquivo;
    }

    /**
     * @return the leitor
     */
    public FileReader getLeitor() {
        return leitor;
    }

    /**
     * @return the escritor
     */
    public PrintWriter getEscritor() {
        return escritor;
    }
}
