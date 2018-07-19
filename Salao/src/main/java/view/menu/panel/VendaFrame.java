package main.java.view.menu.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class VendaFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public VendaFrame() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JButton button = new JButton("Vender");

		JButton button_1 = new JButton("Trocar ou Devolver");

		JButton button_2 = new JButton("Cancelar");

		JButton button_3 = new JButton("Imprimir recibo");

		JButton button_4 = new JButton("Selecione um cliente");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel label = new JLabel("Produto");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("Quantidade");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel label_2 = new JLabel("Pre\u00E7o");

		JLabel label_3 = new JLabel("Total");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JButton button_5 = new JButton("Lan\u00E7ar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 1200, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(button).addGap(18)
												.addComponent(button_1)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(button_2)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_3))
										.addGroup(gl_panel.createSequentialGroup().addGap(10).addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING).addComponent(button_4).addGroup(
														gl_panel.createSequentialGroup().addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																		402, GroupLayout.PREFERRED_SIZE)
																.addComponent(label))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(textField_1,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(label_1))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(textField_2,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(label_2))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_3)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addComponent(textField_3,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(button_5)))))))
						.addContainerGap(431, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 118, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(button)
								.addComponent(button_1).addComponent(button_2).addComponent(button_3))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_4).addGap(4)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(label).addComponent(label_2).addComponent(label_3))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button_5))
						.addContainerGap(14, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		JButton button_6 = new JButton("Observa\u00E7\u00E3o (F4)");

		JButton button_7 = new JButton("Desconto (F5)");

		JLabel label_4 = new JLabel("Total = $0.00");
		label_4.setFont(new Font("Arial", Font.PLAIN, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 1200, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(476).addComponent(button_6)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(button_7).addGap(318)
						.addComponent(label_4).addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 40, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(5)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(button_6).addComponent(button_7))
										.addComponent(label_4))));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	}
}
