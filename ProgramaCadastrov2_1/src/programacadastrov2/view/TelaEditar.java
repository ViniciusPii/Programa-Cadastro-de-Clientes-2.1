/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacadastrov2.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import programacadastrov2.bean.Pessoas;
import programacadastrov2.bean.PessoasMetodos;

/**
 *
 * @author Pii
 */
public class TelaEditar extends javax.swing.JFrame {

    /**
     * Creates new form TelaEditar
     */
    public TelaEditar() {
        initComponents();
        setLocationRelativeTo(null);
        lerTabela();
    }

    PessoasMetodos pmt = new PessoasMetodos();
    TelaEditar2 te2 = new TelaEditar2();

    public void lerTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jDadosEditar.getModel();
        modelo.setNumRows(0);

        for (Pessoas p : pmt.listarTodos()) {

            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getTelefone(), p.getCelular(), p.getEstadoCivil()});

        }
    }

    public void buscar(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) jDadosEditar.getModel();
        modelo.setNumRows(0);

        for (Pessoas p : pmt.pesquisar(nome)) {

            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getTelefone(), p.getCelular(), p.getEstadoCivil()});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDadosEditar = new javax.swing.JTable();
        btnvoltar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnEditar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jDadosEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "Celular", "Estado Civil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jDadosEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDadosEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDadosEditarMouseEntered(evt);
            }
        });
        jDadosEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDadosEditarKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jDadosEditar);

        btnvoltar.setText("Voltar");
        btnvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoltarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar2.setText("Editar");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar2)
                    .addComponent(btnvoltar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarActionPerformed
        this.dispose();
        TelaCadastro tc = new TelaCadastro();
        tc.setVisible(true);
    }//GEN-LAST:event_btnvoltarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed

        try {
            TelaEditar2.txtIdEditar.setText(String.valueOf(jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 0)));
            TelaEditar2.txtNomeEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 1));
            TelaEditar2.txtTelefoneEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 2));
            TelaEditar2.txtCelularEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 3));
            TelaEditar2.cbEstadoCivilEditar.setSelectedItem((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 4));

            te2.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "SELECIONE UMA LINHA!!!");
        }

    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void jDadosEditarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDadosEditarKeyReleased

    }//GEN-LAST:event_jDadosEditarKeyReleased

    private void jDadosEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDadosEditarMouseClicked
        if (evt.getClickCount() == 2) {

            TelaEditar2.txtIdEditar.setText(String.valueOf(jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 0)));
            TelaEditar2.txtNomeEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 1));
            TelaEditar2.txtTelefoneEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 2));
            TelaEditar2.txtCelularEditar.setText((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 3));
            TelaEditar2.cbEstadoCivilEditar.setSelectedItem((String) jDadosEditar.getValueAt(jDadosEditar.getSelectedRow(), 4));

            te2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jDadosEditarMouseClicked

    private void jDadosEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDadosEditarMouseEntered

    }//GEN-LAST:event_jDadosEditarMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnvoltar;
    private javax.swing.JTable jDadosEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
