package main.java.view.menu.panel.fornecedor;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FornecedoresFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JButton btCadastar;

	public FornecedoresFrame() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		btCadastar = new JButton("Novo");

		btCadastar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroFornecedor cf = new CadastroFornecedor();
				cf.setLocationRelativeTo(cf);
				cf.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("Editar");

		JButton btnNewButton = new JButton("Apagar");

		JButton btnNewButton_1 = new JButton("Imprimir");

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(btCadastar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_2)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(916, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 45,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btCadastar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Endere\u00E7o", "Bairro", "Cidade", "UF", "CEP" }));
		scrollPane.setViewportView(table);
	}
}
