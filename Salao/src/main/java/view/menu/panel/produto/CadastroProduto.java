package main.java.view.menu.panel.produto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Atxy2k.CustomTextField.RestrictedTextField;
import main.java.model.bean.Produto;
import main.java.model.dao.ProdutoDAO;
import main.java.tools.MaskFormatterNew;
import main.java.tools.Mensagens;
import main.java.tools.StringDocumentUpperCase;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class CadastroProduto extends JDialog {
	/**
	 * @author Danton Issler
	 * 
	 *         Achar uma forma de fazer o valor monetario
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtQtd;
	private JTextField txtDesc;
	private JTextField txtPreco;
	StringDocumentUpperCase tecla;
	MaskFormatterNew mask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroProduto dialog = new CadastroProduto();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	DefaultTableModel modelo = new DefaultTableModel();

	public void readJTable() {
		modelo = (DefaultTableModel) table.getModel();
		ProdutoDAO pdao = new ProdutoDAO();
		modelo.setNumRows(0);

		for (Produto p : pdao.read()) {
			modelo.addRow(new Object[] { p.getId_produto(), p.getNome_Produto(), p.getQtd_Produto(),
					p.getValor_Produto(), p.getValor_Produto(), p.getDescricao_Produto() });
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroProduto() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(null);
		mask = new MaskFormatterNew();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 231, 784, 234);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Indentificador", "Nome", "Quantidade", "Preco", "Descri\u00E7\u00E3o" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		readJTable();
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));

		txtQtd = new JTextField();
		txtQtd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		txtQtd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtQtd.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtd.setBounds(251, 103, 125, 20);
		getContentPane().add(txtQtd);
		txtQtd.setColumns(10);
		RestrictedTextField qtdRestricted = new RestrictedTextField(txtQtd);
		qtdRestricted.setOnlyNums(true);

		JLabel lblNewLabel = new JLabel("Nome Novo Produto");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(71, 80, 121, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(251, 80, 86, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o\r\n");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(411, 80, 69, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(580, 80, 86, 14);
		getContentPane().add(lblNewLabel_3);

		JFormattedTextField txtNome = new JFormattedTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setBounds(67, 104, 125, 20);
		getContentPane().add(txtNome);
		RestrictedTextField nomRestricted = new RestrictedTextField(txtNome);
		nomRestricted.setLimit(50);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Produto p = new Produto();
				ProdutoDAO dao = new ProdutoDAO();

				p.setNome_Produto(txtNome.getText());
				p.setQtd_Produto(Integer.parseInt(txtQtd.getText()));
				p.setValor_Produto(Double.parseDouble(txtPreco.getText()));
				p.setDescricao_Produto(txtDesc.getText());
				dao.insert(p);

				txtDesc.setText("");
				txtQtd.setText("");
				txtNome.setText("");
				txtPreco.setText("");

				readJTable();
			}
		});
		btCadastrar.setBounds(168, 505, 121, 23);
		getContentPane().add(btCadastrar);

		JButton btCancelar = new JButton("Cancelar");

		btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mensagens can = new Mensagens("Sair");
				int resposta = can.pergunta("Deseja encerar a seção?");
				if (resposta == 0) {
					setVisible(false);
				}
			}
		});
		btCancelar.setBounds(551, 505, 105, 23);
		getContentPane().add(btCancelar);

		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btAtualizar.setBounds(355, 505, 105, 23);
		getContentPane().add(btAtualizar);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDesc.setBounds(580, 103, 125, 20);
		getContentPane().add(txtDesc);
		txtDesc.setColumns(10);
		RestrictedTextField descRestricted = new RestrictedTextField(txtDesc);
		descRestricted.setLimit(250);

		txtPreco = new JTextField(); // Falta tratar esté campo para sair valor
										// monetario
		txtPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtPreco.setBounds(411, 104, 125, 20);
		getContentPane().add(txtPreco);
		txtPreco.setColumns(10);

		JLabel lblCadastroDeProduto = new JLabel("Cadastro de Produto");
		lblCadastroDeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProduto.setFont(new Font("Arial", Font.BOLD, 25));
		lblCadastroDeProduto.setBounds(98, 0, 568, 69);
		getContentPane().add(lblCadastroDeProduto);
	}
}
