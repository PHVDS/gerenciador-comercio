package br.com.walison.lucros.visao.outras;

import br.com.walison.lucros.classes.Janela;
import br.com.walison.lucros.classes.modelos.Subtotal;
import br.com.walison.lucros.classes.Conexao;
import br.com.walison.lucros.classes.Mensagem;
import br.com.walison.lucros.classes.TrataNumeros;
import br.com.walison.lucros.classes.modelos.Produto;
import br.com.walison.lucros.visao.JPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walison Cecílio
 */
public class JProdutoNaoCadastrado extends javax.swing.JPanel {

    /**
     * Creates new form JProdutoNaoCadastrado
     */
    public JProdutoNaoCadastrado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNom = new javax.swing.JLabel();
        cNom = new javax.swing.JTextField();
        lUni = new javax.swing.JLabel();
        cUni = new javax.swing.JTextField();
        Adicionar = new javax.swing.JButton();
        cVl = new javax.swing.JFormattedTextField();
        lVlDesCadProd = new javax.swing.JLabel();
        lDecCadProd = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cDesCadProd = new javax.swing.JTextPane();
        bSair = new javax.swing.JButton();

        lNom.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lNom.setText("NOME:  ");

        cNom.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        lUni.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lUni.setText("QTD:");

        cUni.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        Adicionar.setText("ADICIONAR");
        Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdicionarMouseClicked(evt);
            }
        });

        try {
            cVl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ ##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cVl.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        cVl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cVlActionPerformed(evt);
            }
        });

        lVlDesCadProd.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lVlDesCadProd.setText("VALOR:");

        lDecCadProd.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        lDecCadProd.setText("DESCRIÇÃO:");

        cDesCadProd.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(cDesCadProd);

        bSair.setText("SAIR");
        bSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lVlDesCadProd)
                                    .addComponent(lUni))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lNom)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cNom, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cUni, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cVl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lDecCadProd)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Adicionar)
                                .addGap(18, 18, 18)
                                .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNom)
                    .addComponent(cNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUni)
                    .addComponent(cUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lVlDesCadProd)
                    .addComponent(cVl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDecCadProd)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adicionar)
                    .addComponent(bSair))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cVlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cVlActionPerformed
                    
    }//GEN-LAST:event_cVlActionPerformed

    private void AdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseClicked
        this.principal.setEnabled(true);
        try {
            this.iniciar();
        } catch (SQLException ex) {
            Logger.getLogger(JProdutoNaoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.j.dispose();
    }//GEN-LAST:event_AdicionarMouseClicked

    private void bSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSairMouseClicked
        this.principal.setEnabled(true);
        
        this.j.dispose();
    }//GEN-LAST:event_bSairMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton bSair;
    private javax.swing.JTextPane cDesCadProd;
    private javax.swing.JTextField cNom;
    private javax.swing.JTextField cUni;
    private javax.swing.JFormattedTextField cVl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lDecCadProd;
    private javax.swing.JLabel lNom;
    private javax.swing.JLabel lUni;
    private javax.swing.JLabel lVlDesCadProd;
    // End of variables declaration//GEN-END:variables
    private Janela j;
    private Janela principal;
    private NumberFormat dim = NumberFormat.getCurrencyInstance();
    private Mensagem mensagem = new Mensagem();
    
    public void iniciar() throws SQLException{
         Connection c = new Conexao().getConexao();
        
        String sql = "insert into produtos (nom_prod, mar_prod, vl_prod, desc_prod, unidade) values (?, "
                + "?, ?, ?, ?)";
        
        try {
            TrataNumeros trataNumeros = new TrataNumeros();
            
            JPrincipal painelJVender = (JPrincipal) this.principal.getPanel();
            DefaultTableModel modeloTable = (DefaultTableModel) painelJVender.getTabela().getModel();
            modeloTable.setNumRows(0);
            
            PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            Produto p = new Produto(this.cNom.getText().toUpperCase(), this.cDesCadProd.getText().toUpperCase(), trataNumeros.trataDinheiro(this.cVl.getText()), true, false);
            
            s.setString(1, p.getNom_prod());
            s.setString(2, ".");
            s.setDouble(3, p.getVl_prod());
            s.setString(4, p.getDesc_prod());
            s.setBoolean(5, true);

            s.executeUpdate();

            ResultSet r = s.getGeneratedKeys();

            if(r.next()){
                p.setCod_prod((short)r.getInt(1));
            }
            
            short qtd = Short.parseShort(this.cUni.getText());
            p.setCadastrado(false);
            Subtotal co = new Subtotal(p, qtd, trataNumeros.trataDinheiro(this.cVl.getText()));

            painelJVender.getVenda().addCompra(co);
            this.atualizarTabelaCompra(painelJVender, modeloTable);
            c.commit();
        } catch (java.lang.NumberFormatException a) {
            this.mensagem.msg("Campo quantidade deve ser um número inteiro!!");
            JPrincipal painelJVender = (JPrincipal) this.principal.getPanel();
            DefaultTableModel modeloTable = (DefaultTableModel) painelJVender.getTabela().getModel();
            this.atualizarTabelaCompra(painelJVender, modeloTable);
            c.rollback();
        } catch (SQLException e) {
            c.rollback();
        } finally {
            c.close();
        }
    }
    
    private void atualizarTabelaCompra(JPrincipal painelJVender, DefaultTableModel modeloTable){
        int i = 1;
        
        for(Subtotal c : painelJVender.getVenda().getCompras()){
            Object linha[] = { ""+(i++), c.getProduto(), ""+c.getQtd_prod()+" UN", dim.format(c.getProduto().getVl_prod()), dim.format(c.getVl_com()) };
            painelJVender.getlValor().setText(dim.format(painelJVender.getVenda().getVl_ven()));
            modeloTable.addRow(linha);
        }

        painelJVender.getcPesquisa().setText("");
        painelJVender.getlValor().setText(dim.format(painelJVender.getVenda().getVl_ven()));
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
     * @return the principal
     */
    public Janela getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(Janela principal) {
        this.principal = principal;
    }
}
