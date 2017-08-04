package br.com.walison.lucros.classes;

import br.com.walison.lucros.classes.modelos.Produto;
import br.com.walison.lucros.classes.modelos.Fornecedor;
import br.com.walison.lucros.classes.modelos.Venda;
import br.com.walison.lucros.classes.modelos.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.TreeMap;
import javax.swing.JComboBox;

/**
 *
 * @author Walison Cecílio
 */
public class Sistema {
    
    public Sistema(){}
    
    public LinkedList<Cliente> BuscarClientes() throws SQLException{
        
        LinkedList<Cliente> clientes = new LinkedList<>();
        
        Connection conexao = new Conexao().getConexao();
        ResultSet r = conexao.createStatement().executeQuery("SELECT * FROM clientes;");

        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return clientes;    
        }
        
        while(r.next()){
            Cliente cliente = new Cliente(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), r.getString(4), r.getString(5), Short.parseShort(r.getString(6)), r.getString(7), Short.parseShort(r.getString(8)), r.getString(9), r.getString(10), r.getString(11), r.getString(12), r.getString(13));
            clientes.add(cliente);
        }
        
        r.close();
        conexao.close();
        return clientes;
    }
    
    public LinkedList<Produto> BuscarProdutos() throws SQLException{
        
        LinkedList<Produto> produtos = new LinkedList<>();
        String sql = "SELECT * FROM produtos ORDER BY nom_prod;";

        Connection conexao = new Conexao().getConexao();
        ResultSet r = conexao.createStatement().executeQuery(sql);
                
        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return produtos;    
        }
        
        while(r.next()){
            Produto produto = new Produto(
                r.getShort(1), 
                r.getString(2), 
                r.getString(3), 
                r.getFloat(4), 
                r.getString(5),
                r.getBoolean(6), 
                r.getString(7),
                r.getBoolean(8),
                r.getShort(9)
            );     
            produtos.add(produto);
        }    
        
        r.close();
        conexao.close();
        return produtos;
    }
    
    public TreeMap<String, Produto> BuscarProdutosArvore() throws SQLException{
        TreeMap<String, Produto> produtos = new TreeMap<>();
        String sql = "SELECT * FROM produtos WHERE qtd_estoque >= 1 ORDER BY nom_prod;";

        Connection conexao = new Conexao().getConexao();
        ResultSet r = conexao.createStatement().executeQuery(sql);
        
        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return produtos;    
        }
        
        while(r.next()){
            Produto produto = new Produto(
                r.getShort(1), 
                r.getString(2), 
                r.getString(3), 
                r.getFloat(4), 
                r.getString(5),
                r.getBoolean(6), 
                r.getString(7),
                r.getBoolean(8),
                r.getShort(9)
            );
            produtos.put(produto.getCod_bar_prod(), produto);
        } 
        r.close();
        conexao.close();
        return produtos;
    }
    
    public LinkedList<Fornecedor> BuscarFornecedores() throws SQLException{
        LinkedList<Fornecedor> fornecedores = new LinkedList<>();
        
        Connection conexao = new Conexao().getConexao();
        ResultSet r = conexao.createStatement().executeQuery("SELECT * FROM fornecedores WHERE nom_for != 'SEM FORNECEDOR' ORDER BY nom_for;");
        ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM fornecedores WHERE nom_for = 'SEM FORNECEDOR' ORDER BY nom_for;");
        
        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return fornecedores;    
        }
        
        if(!rs.isBeforeFirst()){
            rs.close();
            conexao.close();
            return fornecedores;
        }else{
            if(rs.next()){
                Fornecedor fornecedor = new Fornecedor(Short.parseShort(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                fornecedores.add(fornecedor);
            }
        }
        
        while(r.next()){
            Fornecedor fornecedor = new Fornecedor(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), r.getString(4), r.getString(5));
            fornecedores.add(fornecedor);
        }
        
        rs.close();
        r.close();
        conexao.close();
        return fornecedores;
    }
    
    public void ComboBoxFornecedor(JComboBox<String> comboBox, LinkedList<Fornecedor> fornecedor){
        comboBox.removeAllItems();
        
        for(Fornecedor f : fornecedor){
            comboBox.addItem(f.getNom_for());
        }
    }
        
    public LinkedList<Venda> BuscarVendas(boolean carregarVenda, boolean carregarVendaLucro, String where) throws SQLException{
        LinkedList<Venda> vendas = new LinkedList<>();
        
        Connection conexao = new Conexao().getConexao();
        ResultSet r = conexao.createStatement().executeQuery("SELECT * FROM vendas " + where + " ORDER BY dt_com_prod desc");

        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return vendas;
        }
        
        while(r.next()){
            Venda v = new Venda(r.getShort(1), r.getFloat(2), r.getFloat(7), r.getFloat(8), r.getString(4), r.getString(5));
            
            if(carregarVenda)
                v.CarregarVenda();
            
            if(carregarVendaLucro)
                v.CarregarVendaLucros();
            
            vendas.add(v);
        }
        
        r.close();
        return vendas;
    }  
}
