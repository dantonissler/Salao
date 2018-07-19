package main.java.view.menu.panel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrcamentoFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTable table;

	public OrcamentoFrame() {
		setSize(1200, 700);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JButton btnNewButton = new JButton("Novo");
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Apagar");
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Imprimir");
		panel.add(btnNewButton_3);

		JButton btnNewButton_7 = new JButton("Aprovar");
		panel.add(btnNewButton_7);

		JButton btnNewButton_6 = new JButton("Recusar");
		panel.add(btnNewButton_6);

		JButton btnNewButton_5 = new JButton("Vender");
		panel.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Enviar por e-mail");
		panel.add(btnNewButton_4);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1200, 677);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {},
						new String[] { "N\u00FAmero", "Criado em", "Situa\u00E7\u00E3o", "Situa\u00E7\u00E3o em",
								"Total Final", "Cliente", "Valido at\u00E9", "Num. Venda", "Total", "Desconto",
								"Funcion\u00E1rio" }));
		scrollPane.setViewportView(table);
	}
}
