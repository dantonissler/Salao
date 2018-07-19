package main.java.view.menu.panel.funcionario;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;
import main.java.model.bean.Usuario;
import main.java.model.dao.UsuarioDAO;
import main.java.tools.Mensagens;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastroUsuario extends JDialog {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 *         Problema ao preencher a tabela
	 */

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtPesquisar;
	private int tipouser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroUsuario dialog = new CadastroUsuario();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	DefaultTableModel modelo = new DefaultTableModel();

	// public void readJTable() {
	// modelo = (DefaultTableModel) table.getModel();
	// UsuarioDAO udao = new UsuarioDAO();
	// modelo.setNumRows(0);
	//
	// for (Usuario u : udao.read()) {
	// String tipo;
	// if(u.getTipo() == 1)
	// tipo = "Us\u00FAario";
	// else
	// tipo = "Administrador";
	//
	// modelo.addRow(new Object[] { u.getLogin(), u.getTipo(), tipo});
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public CadastroUsuario() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 5, 0, new Color(0, 0, 0)));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 311, 784, 180);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Login", "tipo", "Nome" }));
		scrollPane.setViewportView(table);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		txtLogin.setBounds(341, 128, 125, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		RestrictedTextField logRestricted = new RestrictedTextField(txtLogin);
		logRestricted.setLimit(30);
		logRestricted.setOnlyAlphaNumeric(true);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSenha.setBounds(341, 184, 125, 20);
		panel.add(txtSenha);
		RestrictedTextField senRestricted = new RestrictedTextField(txtSenha);
		senRestricted.setLimit(45);
		senRestricted.setOnlyAlphaNumeric(true);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(341, 100, 125, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(341, 159, 125, 14);
		panel.add(lblNewLabel_1);

		JComboBox<Object> cbTipo = new JComboBox<Object>();
		cbTipo.setModel(new DefaultComboBoxModel<Object>(new String[] { "Us\u00FAario", "Administrador" }));
		cbTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		cbTipo.setBounds(341, 240, 125, 20);
		panel.add(cbTipo);
		if (cbTipo.getSelectedItem() == "Us\u00FAario") {
			tipouser = 1;
		} else {
			tipouser = 2;
		}

		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(341, 215, 125, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cadastro de Us\u00FAario");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_3.setBounds(0, 0, 784, 89);
		panel.add(lblNewLabel_3);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(20, 281, 125, 20);
		panel.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(20, 261, 125, 14);
		panel.add(lblPesquisar);

		JComboBox<Object> cbFuncionario = new JComboBox<Object>();
		cbFuncionario.setFont(new Font("Arial", Font.PLAIN, 12));
		cbFuncionario.setBounds(613, 129, 130, 20);
		panel.add(cbFuncionario);

		JLabel lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFuncionario.setBounds(613, 101, 130, 14);
		panel.add(lblFuncionario);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/Imagens/cadastro de funcionario/salvar.png")));
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO userdao = new UsuarioDAO();
				Usuario user = new Usuario();

				user.setLogin(txtLogin.getText());
				user.setSenha(txtSenha.getText());
				user.setTipo(tipouser);

				userdao.insert(user);
			}
		});
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btEditar = new JButton("Editar");
		btEditar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/Imagens/cadastro de funcionario/editar1.png")));
		btEditar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/Imagens/cadastro de funcionario/cancelar1.png")));
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mensagens can = new Mensagens("Cancelar Cadastro");
				int resposta = can.pergunta("Deseja cancelar o cadastro");
				if (resposta == 0) {
					setVisible(false);
				}
			}
		});
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(141, Short.MAX_VALUE)
										.addComponent(btCadastrar, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)
										.addGap(150)
										.addComponent(btEditar, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)
										.addGap(150).addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)
										.addGap(73)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btCancelar)
								.addComponent(btCadastrar).addComponent(btEditar))
						.addContainerGap(30, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
	}
}
