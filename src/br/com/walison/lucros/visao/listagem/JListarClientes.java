package br.com.walison.lucros.visao.listagem;

import br.com.walison.lucros.classes.Janela;
import br.com.walison.lucros.classes.modelos.Cliente;
import br.com.walison.lucros.classes.Conexao;
import br.com.walison.lucros.classes.Sistema;
import br.com.walison.lucros.classes.TrataNumeros;
import br.com.walison.lucros.visao.edicao.JEditarCliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walison Cecílio
 */
public class JListarClientes extends javax.swing.JPanel {

    /**
     * Creates new form JClientes
     */
    public JListarClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        bVoltar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bDetalhes = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Listar de Clientes Cadastrados");

        cPesquisa.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        cPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPesquisaActionPerformed(evt);
            }
        });
        cPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cPesquisaKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel2.setText("Nome ou Numero da Conta");

        tabela.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "Nº CONTA", "LIMITE", "SALDO", "DIVIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(25);
        tabela.setRowMargin(3);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(2).setMinWidth(1);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(1);
            tabela.getColumnModel().getColumn(3).setMinWidth(1);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(1);
            tabela.getColumnModel().getColumn(4).setMinWidth(1);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(1);
            tabela.getColumnModel().getColumn(5).setMinWidth(2);
            tabela.getColumnModel().getColumn(5).setPreferredWidth(2);
        }

        bVoltar.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        bVoltar.setText("VOLTAR");
        bVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVoltarMouseClicked(evt);
            }
        });

        bEditar.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        bEditar.setText("EDITAR");
        bEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditarMouseClicked(evt);
            }
        });
        bEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bEditarKeyPressed(evt);
            }
        });

        bDetalhes.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        bDetalhes.setText("DETAHES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bDetalhes)
                .addGap(52, 52, 52)
                .addComponent(bEditar)
                .addGap(57, 57, 57)
                .addComponent(bVoltar)
                .addGap(492, 492, 492))
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(0, 469, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEditar)
                    .addComponent(bVoltar)
                    .addComponent(bDetalhes))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVoltarMouseClicked
        try {
            this.getJ().voltar();
        } catch (SQLException ex) {
            Logger.getLogger(JListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bVoltarMouseClicked

    private void bEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditarMouseClicked
        this.abrir();
    }//GEN-LAST:event_bEditarMouseClicked

    private void bEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bEditarKeyPressed

    }//GEN-LAST:event_bEditarKeyPressed

    private void cPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPesquisaActionPerformed

    private void cPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPesquisaKeyReleased
        try {
            this.buscarPorNumeroConta();
        } catch (SQLException ex) {
            Logger.getLogger(JListarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cPesquisaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDetalhes;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField cPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
    private LinkedList<Cliente> clientes;
    private Janela j;
    private Janela j2;
    private Sistema sis = new Sistema();
    private NumberFormat dim = NumberFormat.getCurrencyInstance();
    
    private boolean buscarPorNumeroConta () throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cod_con = " + this.cPesquisa.getText() + ";";
        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        Connection conexao = new Conexao().getConexao();
            
        ResultSet r = conexao.createStatement().executeQuery(sql);
        
        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return false;
        }

        modelo.setNumRows(0);

        while(r.next()){
            Cliente c= new Cliente(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), r.getString(4), r.getString(5), Short.parseShort(r.getString(6)), r.getString(7), Short.parseShort(r.getString(8)), r.getString(9), r.getString(10), r.getString(11), r.getString(12), r.getString(13));

            Object linha[] = { c, c.getCpf_cli(), c.getConta().getCod_con(), dim.format(c.getConta().getLim_con()), dim.format(c.getConta().getSal_con()), dim.format(c.getConta().getDiv_con()) };
            modelo.addRow(linha);  
        }
        r.close();
        conexao.close();
        return true;
    }
    
    private boolean buscarPorNome () throws SQLException {
        String sql = "SELECT * FROM clientes WHERE nom_cli LIKE '%" + this.cPesquisa.getText() + "%';";
        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        Connection conexao = new Conexao().getConexao();
        
        ResultSet r = conexao.createStatement().executeQuery(sql);
        
        if(!r.isBeforeFirst()){
            r.close();
            conexao.close();
            return false;
        }
        
        modelo.setNumRows(0);
            
        while(r.next()){
            Cliente c= new Cliente(Short.parseShort(r.getString(1)), r.getString(2), r.getString(3), r.getString(4), r.getString(5), Short.parseShort(r.getString(6)), r.getString(7), Short.parseShort(r.getString(8)), r.getString(9), r.getString(10), r.getString(11), r.getString(12), r.getString(13));

            Object linha[] = { c, c.getCpf_cli(), c.getConta().getCod_con(), dim.format(c.getConta().getLim_con()), dim.format(c.getConta().getSal_con()), dim.format(c.getConta().getDiv_con()) };
            modelo.addRow(linha);  
        }
        r.close();
        conexao.close();
        return true;
    }
    
    private void abrir () {
        this.setJ2(new Janela());
        JEditarCliente a = new JEditarCliente();
        a.setJ(this.j2);
        
        this.setaCampos(a);
        this.j.dispose();
    }
    
    private void setaCampos (JEditarCliente a) {
        TrataNumeros trataNumeros = new TrataNumeros();
        Cliente c = (Cliente) this.tabela.getValueAt(this.tabela.getSelectedRow(), 0);
        
        a.setCliente(c);
        a.getcNomCadCli().setText(c.getNom_cli());
        a.getcSobNomCadCli().setText(c.getSob_nom_cli());
        a.getcCpfCadCli().setText(c.getCpf_cli());
        a.getcDatCadCli().setText(trataNumeros.tranformaDataLegivel(c.getDt_nasc_cli()));
        a.getcTelCadCli().setText(c.getTel_cli());
        a.getcLimCadCli().setText(""+c.getConta().getLim_con());
        a.getcDatPagCadCli().setText(c.getConta().getDt_pag());
        a.getcRuaCadCli().setText(c.getRua());
        a.getcNumCadCli().setText(""+c.getNum_cas_cli());
        a.getcConjCadCli().setText(c.getConj_cli());
        a.getcBaiCadCli().setText(c.getBai_cli());
        a.getcCidCadCli().setText(c.getCid_cli());

        this.j2.setPanel(a);
        this.j2.add(this.j2.getMenu());
        this.j2.add(a);
        this.j2.getMenu().setJanelaFechar(j2);
    }
    
    /**
     * @return the j
     */
    public Janela getJ() {
        return j;
    }

    /**
     * @param j the j to set
     */
    public void setJ(Janela j) {
        this.j = j;
    }

    /**
     * @return the j2
     */
    public Janela getJ2() {
        return j2;
    }

    /**
     * @param j2 the j2 to set
     */
    public void setJ2(Janela j2) {
        this.j2 = j2;
    }

    /**
     * @return the sis
     */
    public Sistema getSis() {
        return sis;
    }

    /**
     * @param sis the sis to set
     */
    public void setSis(Sistema sis) {
        this.sis = sis;
    }

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getTabela() {
        return tabela;
    }

    /**
     * @param jTable1 the jTable1 to set
     */
    public void setTabela(javax.swing.JTable tabela) {
        this.tabela = tabela;
    }

    /**
     * @return the clientes
     */
    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }  
}
