package main.java.view.menu.panel.cliente;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ClienteFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTable table;

	public ClienteFrame() {
		setLayout(new BorderLayout(0, 0));
		setSize(1200, 700);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JButton btCadastroCliente = new JButton("Cadastro Cliente");

		btCadastroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btCadastroCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cc = new CadastroCliente();
				cc.setLocationRelativeTo(cc);
				cc.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("Trocar ou devolver");

		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_3 = new JButton("Cancelar");

		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_4 = new JButton("Imprimir recibo");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_5 = new JButton("Editar");

		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(btCadastroCliente)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_5)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_2)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_3)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_4,
										GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(549, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btCadastroCliente)
						.addComponent(btnNewButton_5).addComponent(btnNewButton_2).addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1190, 363);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "RG", "idade", "Nome Pai", "Nome M\u00E3e", "Sexo", "UF", "Cidade", "Cep",
						"Bairro", "Rua", "N\u00FAmero", "Telefone", "E-mail" }));

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "Exibir: vendas do caixa atual",
				"Exibir: Todas as vendas", "Mostrar vendas canceladas" }));
		comboBox.setBounds(432, 11, 196, 20);
		panel_1.add(comboBox);
	}

	public static void main(String[] args) {
		ClienteFrame c = new ClienteFrame();
		JFrame j = new JFrame();
		j.getContentPane().add(c);
		j.setVisible(true);
	}
}
