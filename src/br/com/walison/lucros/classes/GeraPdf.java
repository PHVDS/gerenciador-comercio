package br.com.walison.lucros.classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author cecilio
 */
public class GeraPdf {
    
    private Document documento;
    private PdfWriter escritor;
 
    public GeraPdf(String caminhoArquivo) throws FileNotFoundException, DocumentException{
        this.documento = new Document();
        this.escritor.getInstance(this.documento, new FileOutputStream("/home/cecilio/" + caminhoArquivo + ".pdf"));
        documento.open();
       // documento.setPageSize(PageSize.A8);
    }
    
    public void Escrever(String texto) throws DocumentException{
        documento.add(new Paragraph(texto, new Font(Font.FontFamily.COURIER, 8)));
    }

    /**
     * @return the documento
     */
    public Document getDocumento() {
        return documento;
    }

    /**
     * @return the escritor
     */
    public PdfWriter getEscritor() {
        return escritor;
    }
    
}
