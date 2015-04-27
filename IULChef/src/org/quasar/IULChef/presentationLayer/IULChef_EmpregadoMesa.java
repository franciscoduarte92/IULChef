/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quasar.IULChef.presentationLayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.quasar.IULChef.businessLayer.Empregado;
import org.quasar.IULChef.businessLayer.Entidade;
import org.quasar.IULChef.businessLayer.Fornecedor;
import org.quasar.IULChef.businessLayer.Mesa;
import org.quasar.IULChef.businessLayer.Produto;
import org.quasar.IULChef.businessLayer.ProdutoSimples;
import org.quasar.IULChef.businessLayer.Restaurante;
import org.quasar.IULChef.persistenceLayer.Database;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author terroma
 */
public class IULChef_EmpregadoMesa extends javax.swing.JFrame {

    private Empregado empregado;
	private Restaurante restaurante;
	private IULChef_PassarFatura painelPassarFatura;
	private IULChef_FazerPedido painelFazerPedido;
	/**
     * Creates new form IULChef_swing
     * @param restaurante 
     * @param empregado 
     */
    public IULChef_EmpregadoMesa(Empregado empregado, Restaurante restaurante) {
    	this.empregado = empregado;
    	this.restaurante = restaurante;
        initComponents();
        this.setTitle("Empregado de Mesa");
        setLocation(450,350);
        setSize(279, 197);
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
        jButtonPassarFatura = new javax.swing.JButton();
        jButtonPedido = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        jButtonPassarFatura.setText("Passar Fatura");
        jButtonPassarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassarFaturaActionPerformed(evt);
            }
        });

        jButtonPedido.setText("Fazer Pedido");
        jButtonPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Logout");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButtonPedido, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        				.addComponent(jButtonPassarFatura, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addGap(0, 75, Short.MAX_VALUE)
        					.addComponent(jButtonVoltar)))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jButtonPassarFatura, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButtonPedido, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jButtonVoltar)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(78, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonPassarFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassarFaturaActionPerformed
        painelPassarFatura = new IULChef_PassarFatura(empregado,restaurante);
        painelPassarFatura.setVisible(true);
    }//GEN-LAST:event_jButtonPassarFaturaActionPerformed

    private void jButtonPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoActionPerformed
    	painelFazerPedido = new IULChef_FazerPedido(empregado,restaurante);
    	painelFazerPedido.setVisible(true);
    }//GEN-LAST:event_jButtonPedidoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
    	dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed
    private javax.swing.JButton jButtonPassarFatura;
    private javax.swing.JButton jButtonPedido;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
