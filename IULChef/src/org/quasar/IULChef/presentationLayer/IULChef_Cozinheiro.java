/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quasar.IULChef.presentationLayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JOptionPane;

import org.quasar.IULChef.businessLayer.CalendarDate;
import org.quasar.IULChef.businessLayer.Empregado;
import org.quasar.IULChef.businessLayer.Restaurante;
import org.quasar.IULChef.persistenceLayer.Database;

/**
 *
 * @author terroma
 */
public class IULChef_Cozinheiro extends javax.swing.JFrame {

    private Empregado empregado;
	private Restaurante restaurante;
	/**
     * Creates new form IULChef_Cozinheiro
     * @param restaurante 
     * @param empregado 
     */
    public IULChef_Cozinheiro(Empregado empregado, Restaurante restaurante) {
    	this.empregado = empregado;
    	this.restaurante = restaurante;
        initComponents();
        this.setTitle("Cozinheiro");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				Database.close();
				new IULChef_Login();
            }
		});

        jPanel1 = new javax.swing.JPanel();
        jButtonEliminarDevolucoes = new javax.swing.JButton();
        jButtonInventario = new javax.swing.JButton();
        jButtonNovoProdutoComposto = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        jButtonEliminarDevolucoes.setText("Eliminar Devolu��es");
        jButtonEliminarDevolucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarDevolucoesActionPerformed(evt);
            }
        });

        jButtonInventario.setText("Fazer Iventario");
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });

        jButtonNovoProdutoComposto.setText("Novo Produto Composto");
        jButtonNovoProdutoComposto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoProdutoCompostoActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarDevolucoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovoProdutoComposto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonEliminarDevolucoes, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovoProdutoComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVoltar)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarDevolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarDevolucoesActionPerformed
        empregado.EliminarDevolucoes();
        JOptionPane.showMessageDialog(this, "Foram eliminados todos os pedidos devolvidos!");
    }//GEN-LAST:event_jButtonEliminarDevolucoesActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
    	empregado.FazerInventario(new CalendarDate(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR));
        JOptionPane.showMessageDialog(this, "Invent�rio criado com sucesso!");
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonNovoProdutoCompostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoProdutoCompostoActionPerformed
    	new IULChef_NovoProdutoComposto();
    }//GEN-LAST:event_jButtonNovoProdutoCompostoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminarDevolucoes;
    private javax.swing.JButton jButtonInventario;
    private javax.swing.JButton jButtonNovoProdutoComposto;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
