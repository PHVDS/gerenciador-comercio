package br.com.walison.lucros.classes;

import br.com.walison.lucros.classes.modelos.Produto;
import br.com.walison.lucros.classes.modelos.Venda;
import br.com.walison.lucros.classes.modelos.Cliente;
import br.com.walison.lucros.visao.cadastros.JCadastroCliente;
import br.com.walison.lucros.visao.cadastros.JCadastroFornecedor;
import br.com.walison.lucros.visao.cadastros.JCadastroProduto;
import br.com.walison.lucros.visao.listagem.JListarClientes;
import br.com.walison.lucros.visao.listagem.JListarProdutos;
import br.com.walison.lucros.visao.listagem.JListarVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walison Cecílio
 */
public class Menu extends JMenuBar{
    
    private Tela t = new Tela();
    private Janela janelaProx;
    private NumberFormat dim = NumberFormat.getCurrencyInstance();
    private Janela janelaFechar;
    
    public Menu(){
        
        setSize(t.getLarg(), 20);
        
        JMenu novo = new JMenu(); 
        novo.setText("Novo");
        
            JMenuItem novoProd = new JMenuItem("Novo Produto");
            JMenuItem novoCli = new JMenuItem("Novo Cliente");
            JMenuItem novoFor = new JMenuItem("Novo Fornecedor");
        
        novo.add(novoProd);
        novo.add(novoCli);
        novo.add(novoFor);
        
        JMenu listar = new JMenu();
        listar.setText("Listar");
        
            JMenuItem listarProd = new JMenuItem("Listar Produtos Cadastrados");
            JMenuItem listarCli = new JMenuItem("Listar Clientes Cadastrados");
            JMenuItem listarVend = new JMenuItem("Listar Vendas");
        
        listar.add(listarProd);
        listar.add(listarCli);
        listar.add(listarVend);
        
        JMenu analizar = new JMenu("Analizar");
        
            JMenuItem analizarEstoque = new JMenuItem("Analizar Estoque");
            JMenuItem analizarLucros = new JMenuItem("Analizae Lucros");
            JMenuItem analizarProdutosDestaque = new JMenuItem("Analizar Produtos em Destaque");
            
        analizar.add(analizarEstoque);
        analizar.add(analizarLucros);
        analizar.add(analizarProdutosDestaque);
        
        JMenu sobre = new JMenu("Sobre");
                
        add(novo);
        add(listar);
        add(analizar);
        add(sobre);       
        
        ListarProduto lp = new ListarProduto();
        listarProd.addActionListener(lp);
        
        CadFor cf = new CadFor();
        novoFor.addActionListener(cf);
        
        CadProd cp = new CadProd();
        novoProd.addActionListener(cp);
        
        CadCli cc = new CadCli();
        novoCli.addActionListener(cc);
        
        ListarCliente lc = new ListarCliente();
        listarCli.addActionListener(lc);
        
        ListarVendas lv = new ListarVendas();
        listarVend.addActionListener(lv);
        
        sobre.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Lucros 2017.1.1 é um software gerenciador de comercio "
                + "desenvilvido por \nWalison Cecílio.", "Sobre", 1, null);
            }
        });       
    }
    
    private class ListarProduto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JListarProdutos a;
            janelaProx = new Janela();
            
            try {
                a = new JListarProdutos();
                a.setJ(janelaProx);

                a.setProdutos(a.getSis().BuscarProdutos());
                
                DefaultTableModel modeloTable = (DefaultTableModel) a.getTabela().getModel();

                for(Produto p : a.getProdutos()){
                    Object linha[] = { p.getCod_bar_prod(), p, p.getMar_prod(), dim.format(p.getVl_prod()), p.getQtd_estoque()  };
                    modeloTable.addRow(linha);   
                }
                
                janelaProx.setPanel(a);
                janelaProx.add(janelaProx.getMenu());
                janelaProx.add(janelaProx.getPanel());  
                janelaProx.getMenu().setJanelaFechar(janelaProx);
                getJanelaFechar().dispose();
            
            } catch (SQLException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private class ListarCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JListarClientes a;
            janelaProx = new Janela();
            
            try {
                a = new JListarClientes();
                a.setJ(janelaProx);

                a.setClientes(a.getSis().BuscarClientes());

                DefaultTableModel modeloTable = (DefaultTableModel) a.getTabela().getModel();

                for(Cliente c : a.getClientes()){
                    Object linha[] = { c, c.getCpf_cli(), c.getConta().getCod_con(), dim.format(c.getConta().getLim_con()), dim.format(c.getConta().getSal_con()), dim.format(c.getConta().getDiv_con()) };
                    modeloTable.addRow(linha);   
                }
                
                janelaProx.setPanel(a);
                janelaProx.add(janelaProx.getMenu());
                janelaProx.add(janelaProx.getPanel());  
                janelaProx.getMenu().setJanelaFechar(janelaProx);
                getJanelaFechar().dispose();
            
            } catch (SQLException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private class ListarVendas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JListarVendas a = new JListarVendas();
            janelaProx = new Janela();
            a.setJ(janelaProx);
            TrataNumeros t = new TrataNumeros();
            FormatoNumerico f = new FormatoNumerico();
            
            try {
                a.setVedas(new Sistema().BuscarVendas(false, false, ""));
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            a.getData2().setDate(new Date());
            
            DefaultTableModel model = (DefaultTableModel) a.getjTable1().getModel();
            
            for(Venda v : a.getVedas()){
                Object[] linha = {v, f.din(v.getVl_ven()), f.din(v.getVl_recebido()), f.din(v.getVl_troco()), t.tranformaDataLegivel(v.getDt_com_prod()), v.getHr_com_prod()};
                model.addRow(linha);
            }
            
            janelaProx.setPanel(a);
            janelaProx.add(janelaProx.getMenu());
            janelaProx.add(janelaProx.getPanel());  
            janelaProx.getMenu().setJanelaFechar(janelaProx);
            getJanelaFechar().dispose();
        }
    }
    
    private class CadFor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JCadastroFornecedor a = new JCadastroFornecedor();
            janelaProx = new Janela();
            
            a.setJ(janelaProx);
            janelaProx.setPanel(a);
            janelaProx.add(janelaProx.getMenu());
            janelaProx.add(janelaProx.getPanel());
            janelaProx.getMenu().setJanelaFechar(janelaProx);
            janelaFechar.dispose();
        }
        
    }
    
    private class CadCli implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCadastroCliente a;
            a = new JCadastroCliente();
            janelaProx = new Janela();
            a.setJ(janelaProx);
            janelaProx.setPanel(a);
            janelaProx.add(janelaProx.getMenu());
            janelaProx.add(janelaProx.getPanel());
            janelaProx.getMenu().setJanelaFechar(janelaProx);
            janelaFechar.dispose();
        }
        
    }
    
    private class CadProd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaProx = new Janela();
            JCadastroProduto a = new JCadastroProduto();
            a.setJ(janelaProx);
            a.getRadioUnidade().setSelected(true);
            a.setUnidade(true);
            
            janelaProx.setPanel(a);
            janelaProx.add(janelaProx.getMenu());
            janelaProx.add(janelaProx.getPanel());
            janelaProx.getMenu().setJanelaFechar(janelaProx);
            janelaFechar.dispose();
            
        }
        
    }

    /**
     * @return the janelaFechar
     */
    public Janela getJanelaFechar() {
        return janelaFechar;
    }

    /**
     * @param janelaFechar the janelaFechar to set
     */
    public void setJanelaFechar(Janela janelaFechar) {
        this.janelaFechar = janelaFechar;
    }
    
}
