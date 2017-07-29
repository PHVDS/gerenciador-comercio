package br.com.walison.lucros.visao.listagem;

import br.com.walison.lucros.classes.Janela;
import br.com.walison.lucros.classes.modelos.Venda;

/**
 *
 * @author Walison Cecílio
 */
public class JDetalhesCompra extends javax.swing.JPanel {

    /**
     * Creates new form JDetalhesCompra
     */
    public JDetalhesCompra() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        nome2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 600));

        nome1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SEQ", "DESC PROD", "QTD", "VL UNITARIO", "VL TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(2).setMinWidth(60);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(4).setMinWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jButton1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jButton1.setText("SAIR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        nome2.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(nome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.j.setEnabled(true);
        this.j2.dispose();
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nome1;
    private javax.swing.JLabel nome2;
    // End of variables declaration//GEN-END:variables
    private Venda venda;
    private Janela j;
    private Janela j2;

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
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
     * @return the nome1
     */
    public javax.swing.JLabel getNome1() {
        return nome1;
    }

    /**
     * @return the nome2
     */
    public javax.swing.JLabel getNome2() {
        return nome2;
    }
}
