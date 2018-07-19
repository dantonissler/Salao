package main.java.view.menu.panel.produto;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProdutoFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisa;
	private JTable table;

	public ProdutoFrame() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JButton btCadastrar = new JButton("Cadastro");
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastroProduto cp = new CadastroProduto();
				cp.setLocationRelativeTo(cp);
				cp.setVisible(true);
			}
		});

		JButton btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btApagar = new JButton("Apagar");
		btApagar.setFont(new Font("Arial", Font.PLAIN, 12));
		btApagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btEntrada = new JButton("Estoque Entrada");

		btEntrada.setFont(new Font("Arial", Font.PLAIN, 12));

		txtPesquisa = new JTextField();
		txtPesquisa.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPesquisa.setColumns(10);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup().addGap(6).addComponent(btCadastrar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btEditar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btApagar))
								.addGroup(gl_panel.createSequentialGroup().addGap(7).addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtPesquisa)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btEntrada)
						.addContainerGap(757, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btCadastrar)
								.addComponent(btEditar).addComponent(btApagar).addComponent(btEntrada))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.SOUTH);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cod. interno", "Descri\u00E7\u00E3o ", "C\u00F3digo", "Estoque Dispon\u00EDvel",
						"pre\u00E7o", "Categoria", "Unidade", "Forne\u00E7edor principal", "Estoque min.",
						"Estique max.", "Abaixo Min.", "Repor", "Pr\u00EAmio?", "Produto Nec.",
						"Tributa\u00E7\u00E3o" }));
		scrollPane.setViewportView(table);
	}
}
