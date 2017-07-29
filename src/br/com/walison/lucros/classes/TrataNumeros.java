package br.com.walison.lucros.classes;

/**
 *
 * @author Walison Cecílio
 */
public class TrataNumeros {
    
    // RESPONSÁVEL PRO TRATAR FORMATOS DE DATAS, NUMEROS PARA O BANCO E PARA EXIBIÇÃO
    
    public TrataNumeros (){}
    
    public String trataNumeros(String cpf){
        if(!cpf.equals("(  )      -    ")){
            char number[] = cpf.toCharArray();
            cpf = "";
            
            for(int i = 0; i < number.length; i++){
                if(!(number[i] == '.' || number[i] == '-' || number[i] == '/' || number[i] == '(' || number[i] == ')' || number[i] == ' ')){
                    cpf += number[i];
                }
            }  
            
            long nCpf = Long.parseLong(cpf);        
            return ""+nCpf;
        }
        return ""+0;
    }
    
    public String trataDatas(String data){
        if(!data.equals("  /  /    ")){
            long n = Long.parseLong(this.trataNumeros(data));
            String dt = ""+n;
            
            if(dt.length() == 8){
                return dt.substring(4,8) + "-" + dt.substring(2, 4) + "-" + dt.substring(0, 2);
            }else{
                dt = 0 + dt;
                return dt.substring(4,8) + "-" + dt.substring(2, 4) + "-" + dt.substring(0, 2);
            }
        }
        return "1111-11-11";
    }
    
    public String tranformaDataLegivel(String data) {       
        return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4); 
    }
    
    public float trataDinheiro(String dim){
        if(!dim.equals("") && dim.length() != 8){
            dim = dim.substring(3, 6);
            return Float.parseFloat(dim);
        }else if(dim.length() == 8){
            dim = dim.substring(3, 8);
            return  Float.parseFloat(dim);
        }
        return 0;
    }
}
