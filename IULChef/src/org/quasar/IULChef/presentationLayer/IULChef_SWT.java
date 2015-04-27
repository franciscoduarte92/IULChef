package org.quasar.IULChef.presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class IULChef_SWT {

	private JFrame frmEmpregadosDeMesa;
	private JTextField txtNome;
	private JTextField txtNc;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * @wbp.nonvisual location=168,161
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IULChef_SWT window = new IULChef_SWT();
					window.frmEmpregadosDeMesa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IULChef_SWT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmpregadosDeMesa = new JFrame();
		frmEmpregadosDeMesa.setTitle("Empregados de Mesa");
		frmEmpregadosDeMesa.setBounds(100, 100, 812, 451);
		frmEmpregadosDeMesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPassarFatura = new JButton("Passar Fatura");
		
		JButton button = new JButton("Pedido");
		
		JLabel lblCliente = new JLabel("Cliente");
		
		JLabel lblMesa = new JLabel("Mesa");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblNc = new JLabel("NC:");
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setColumns(10);
		
		txtNc = new JTextField();
		txtNc.setText("NC");
		txtNc.setColumns(10);
		
		JLabel lblNr = new JLabel("Nr:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblFatura = new JLabel("Fatura");
		
		JLabel lblProduto = new JLabel("Produto");
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		
		JLabel lblNr_1 = new JLabel("Nr:");
	
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNr_2 = new JLabel("Nr:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_4 = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frmEmpregadosDeMesa.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(32)
									.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(169)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPassarFatura)
									.addGap(95)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNome)
												.addComponent(lblNc))))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(59)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(lblFatura)
											.addGap(40)
											.addComponent(lblNome_1)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblNr_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnLogout)
														.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(28)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNr)
														.addComponent(lblProduto))
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
															.addComponent(lblQuantidade)
															.addGap(17))
														.addGroup(groupLayout.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNr_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(251)
							.addComponent(lblCliente)
							.addGap(167)
							.addComponent(lblMesa)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCliente)
								.addComponent(lblMesa))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome)
								.addComponent(lblNr)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNc)
								.addComponent(txtNc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPassarFatura, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(13)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNr_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome_1)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNr_2)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFatura)
								.addComponent(lblProduto)
								.addComponent(lblQuantidade))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLogout)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(86)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmEmpregadosDeMesa.getContentPane().setLayout(groupLayout);
	}
}
