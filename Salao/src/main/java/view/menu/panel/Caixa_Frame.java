package main.java.view.menu.panel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class Caixa_Frame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;

	JPanel painelAlteravel = new JPanel();

	public Caixa_Frame() {

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});

		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setToolTipText("");
		add(tabbedPane, BorderLayout.CENTER);

		JPanel CaixaAtual = new JPanel();
		CaixaAtual.setToolTipText("");
		tabbedPane.addTab("Caixa Atual", null, CaixaAtual, null);
		CaixaAtual.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		CaixaAtual.add(panel_3, BorderLayout.NORTH);

		JButton btnNewButton_1 = new JButton("Fechar Caixa");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_2 = new JButton("Ver Total");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_3 = new JButton("Adicionar Dinheiro");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_4 = new JButton("Retirar Dinheiro");
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_5 = new JButton("Configurar");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(btnNewButton_1).addGap(18)
						.addComponent(btnNewButton_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_3).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_4).addPreferredGap(ComponentPlacement.RELATED, 682, Short.MAX_VALUE)
						.addComponent(btnNewButton_5).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(5)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_5)
								.addComponent(btnNewButton_2).addComponent(btnNewButton_3).addComponent(btnNewButton_4)
								.addComponent(btnNewButton_1))));
		panel_3.setLayout(gl_panel_3);

		JTabbedPane tabbedPane_1 = new JTabbedPane(SwingConstants.TOP);
		CaixaAtual.add(tabbedPane_1, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Transa\u00E7\u00F5es do Caixa Atual", null, panel, null);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Contador de C\u00E9dulas", null, panel_1, null);

		JPanel CaixasAnteriores = new JPanel();
		CaixasAnteriores.setToolTipText("");
		tabbedPane.addTab("Caixas Anteriores", null, CaixasAnteriores, null);
		CaixasAnteriores.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		CaixasAnteriores.add(panel_6, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Ver Detalhes");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_8 = new JButton("Totalizar Pedidos");
		btnNewButton_8.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_9 = new JButton("Corrigir");
		btnNewButton_9.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_10 = new JButton("Relatorio");
		btnNewButton_10.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap().addComponent(btnNewButton).addGap(18)
						.addComponent(btnNewButton_8).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_9).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_10).addContainerGap(803, Short.MAX_VALUE)));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_6.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_8).addComponent(btnNewButton_9)
								.addComponent(btnNewButton_10))));
		panel_6.setLayout(gl_panel_6);

		JScrollPane scrollPane = new JScrollPane();
		CaixasAnteriores.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column", "New column", "New column", "New column",
						"New column" }));
		scrollPane.setViewportView(table);

		JPanel ConferirMeioPagamento = new JPanel();
		ConferirMeioPagamento.setToolTipText("");
		tabbedPane.addTab("Conferir Meio de Pagamento", null, ConferirMeioPagamento, null);
		ConferirMeioPagamento.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		ConferirMeioPagamento.add(panel_7, BorderLayout.NORTH);

		JButton btnNewButton_11 = new JButton("Exportar");
		btnNewButton_11.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_12 = new JButton("Editar");
		btnNewButton_12.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnNewButton_13 = new JButton("Imprimir");
		btnNewButton_13.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addGap(25).addComponent(btnNewButton_12)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_13)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_11).addGap(891)));
		gl_panel_7
				.setVerticalGroup(
						gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_7.createSequentialGroup().addGap(5)
										.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNewButton_12).addComponent(btnNewButton_13)
												.addComponent(btnNewButton_11))));
		panel_7.setLayout(gl_panel_7);

		JScrollPane scrollPane_1 = new JScrollPane();
		ConferirMeioPagamento.add(scrollPane_1, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Caixa", "N.Tran", "Data", "Meio de Pagamento", "Valor" }));
		table_1.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_1);
	}
}
