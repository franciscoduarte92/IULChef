/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quasar.IULChef.presentationLayer;

import java.util.Calendar;

import org.quasar.IULChef.businessLayer.CalendarDate;
import org.quasar.IULChef.businessLayer.Compra;
import org.quasar.IULChef.businessLayer.Empregado;
import org.quasar.IULChef.businessLayer.Entidade;
import org.quasar.IULChef.businessLayer.Fornecedor;
import org.quasar.IULChef.businessLayer.Produto;
import org.quasar.IULChef.businessLayer.ProdutoSimples;
import org.quasar.IULChef.businessLayer.Restaurante;
import org.quasar.IULChef.persistenceLayer.Database;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

/**
 *
 * @author terroma
 */
public class IULChef_ComprarIngrediente extends javax.swing.JDialog {

	private Empregado empregado;
	private Restaurante restaurante;
	private Fornecedor fornecedor;
	private ProdutoSimples produto;
	private JComboBox jComboBoxNomeProduto;
	/**
	 * Creates new form IULChef_ComprarIngrediente
	 * @param restaurante 
	 * @param empregado 
	 */
	public IULChef_ComprarIngrediente(Empregado empregado, Restaurante restaurante) {
		this.empregado = empregado;
		this.restaurante = restaurante;
		initComponents();
		this.setTitle("Comprar Ingrediente");
		preencheComboBox();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocation(450, 350);
	}




	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabelFornecedor = new javax.swing.JLabel();
		jLabelNcFornecedor = new javax.swing.JLabel();
		jLabelProduto = new javax.swing.JLabel();
		jLabelNomeProduto = new javax.swing.JLabel();
		jTextFieldQuantidade = new javax.swing.JTextField();
		jLabelQuantidade = new javax.swing.JLabel();
		jTextFieldPreco = new javax.swing.JTextField();
		jLabelPreco = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButtonVoltar = new javax.swing.JButton();
		jComboBoxFornecedores = new javax.swing.JComboBox();
		jComboBoxNomeProduto = new JComboBox();

		jLabelFornecedor.setText("Fornecedor");

		jLabelNcFornecedor.setText("Nome:");

		jLabelProduto.setText("Produto");

		jLabelNomeProduto.setText("Nome:");

		jLabelQuantidade.setText("Quantidade:");

		jLabelPreco.setText("Preço:");

		jButton1.setText("Comprar Ingrediente");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButtonVoltar.setText("Voltar");
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
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
																.addComponent(jLabelNcFornecedor)
																.addComponent(jLabelQuantidade)
																.addComponent(jLabelPreco))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																		.addComponent(jTextFieldPreco, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
																		.addComponent(jComboBoxFornecedores, 0, 182, Short.MAX_VALUE)
																		.addGroup(jPanel1Layout.createSequentialGroup()
																				.addComponent(jTextFieldQuantidade, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
																				.addPreferredGap(ComponentPlacement.RELATED))
																				.addGroup(jPanel1Layout.createSequentialGroup()
																						.addComponent(jComboBoxNomeProduto, 0, 182, Short.MAX_VALUE)
																						.addPreferredGap(ComponentPlacement.RELATED)))))
																						.addGap(6))
																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addComponent(jButtonVoltar)
																								.addContainerGap())
																								.addComponent(jLabelNomeProduto, Alignment.LEADING)))
																								.addGroup(jPanel1Layout.createSequentialGroup()
																										.addGap(106)
																										.addComponent(jLabelProduto)
																										.addContainerGap(121, Short.MAX_VALUE))
																										.addGroup(jPanel1Layout.createSequentialGroup()
																												.addGap(98)
																												.addComponent(jLabelFornecedor)
																												.addContainerGap(108, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(4)
						.addComponent(jLabelFornecedor)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabelNcFornecedor)
								.addComponent(jComboBoxFornecedores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(8)
								.addComponent(jLabelProduto)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jLabelNomeProduto)
										.addComponent(jComboBoxNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jLabelQuantidade)
												.addComponent(jTextFieldQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(12)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabelPreco)
														.addComponent(jTextFieldPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jButtonVoltar)
														.addContainerGap())
				);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
				);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	@SuppressWarnings("unchecked")
	private void preencheComboBox() {
		for (Entidade e : Fornecedor.allInstances()) {
			jComboBoxFornecedores.addItem(e.nome());
		}
		for(Produto p : ProdutoSimples.allInstances()){
			jComboBoxNomeProduto.addItem(p.nome());
		}
	}

	private Fornecedor getSelectedFornecedor(){
		for (Entidade e : Fornecedor.allInstances()) {
			if(jComboBoxFornecedores.getSelectedItem().toString()==e.nome())
				return fornecedor =  (Fornecedor) e;
		}
		return null;
	}

	private ProdutoSimples getSelectedProduto(){
		for (Produto p : ProdutoSimples.allInstances()) {
			if(jComboBoxNomeProduto.getSelectedItem().toString()==p.nome())
				return produto =  (ProdutoSimples) p;
		}
		return null;
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		int quantidadeComprasAnt = Compra.allInstances().size();
		empregado.ComprarIngredientes(restaurante, getSelectedFornecedor(), getSelectedProduto(), Integer.parseInt(jTextFieldQuantidade.getText()), Double.parseDouble(jTextFieldPreco.getText()), new CalendarDate(Calendar.DAY_OF_MONTH,Calendar.MONTH, Calendar.YEAR));
		if(Compra.allInstances().size()>quantidadeComprasAnt){
			JOptionPane.showMessageDialog(this, "Compra efetuada com sucesso!");
		}else{
			JOptionPane.showMessageDialog(this, "Nao foi possivel efetuar compra!");
		}
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
		dispose();
	}//GEN-LAST:event_jButtonVoltarActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonVoltar;
	private javax.swing.JComboBox jComboBoxFornecedores;
	private javax.swing.JLabel jLabelFornecedor;
	private javax.swing.JLabel jLabelNcFornecedor;
	private javax.swing.JLabel jLabelNomeProduto;
	private javax.swing.JLabel jLabelPreco;
	private javax.swing.JLabel jLabelProduto;
	private javax.swing.JLabel jLabelQuantidade;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextFieldPreco;
	private javax.swing.JTextField jTextFieldQuantidade;
}
