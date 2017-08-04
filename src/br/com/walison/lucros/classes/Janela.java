package br.com.walison.lucros.classes;

import br.com.walison.lucros.visao.JPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Walison Cecílio
 */
public class Janela extends JFrame {
    
    private JPanel panel;
    private Menu menu =  new Menu();
    
    public Janela(){
        Tela t = new Tela();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(t.getTamTela());
        this.setVisible(false);
        this.setTitle("LUCROS 2017.1.1");
       // this.setResizable(false);
    }
    
    public Janela(int width, int height){
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);    
        this.setVisible(false);
        this.setTitle("LUCROS 2017.1.1");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void voltar() throws SQLException{
        Janela j = new Janela();
        JPrincipal a = new JPrincipal();
        a.setJ(j);
        a.setProdutos(new Sistema().BuscarProdutosArvore());

        a.getPanelCli().setVisible(false);
        j.setPanel(a);
        j.add(menu);
        j.add(j.getPanel());
        menu.setJanelaFechar(j);
        this.dispose();
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
        this.setVisible(true);
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }  
}
