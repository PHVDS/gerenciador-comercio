package br.com.walison.lucros.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Walison Cecilio
 */
public class Calendario {
    
    // RESPONSÁVEL POR PEGAR DATA E HORA ATUAL
    private SimpleDateFormat hora;
    private SimpleDateFormat data;
    private Locale locale;
    private GregorianCalendar calendar; 
       
    public Calendario() {  
        locale = new Locale("pt","BR");
        calendar = new GregorianCalendar(); 
        data = new SimpleDateFormat("dd'/'MM'/'yyyy", this.locale);
        hora = new SimpleDateFormat("HH':'mm':'ss", this.locale);    
    }
    
    public String retornaData() {
        return this.data.format(this.calendar.getTime());
    }
    
    public String retornaHora() {
        return this.hora.format(this.calendar.getTime());
    }
    
    public String retornaData(Date data){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy"); 
        return f.format(data);
    }
    
}
