package main.java.view.menu.panel.funcionario;

import javax.swing.JButton;
import javax.swing.JDialog;

import Atxy2k.CustomTextField.RestrictedTextField;
import main.java.model.bean.Funcionario;
import main.java.model.dao.FuncionarioDAO;
import main.java.tools.MaskFormatterNew;
import main.java.tools.Mensagens;
import main.java.tools.StringDocumentUpperCase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadastroFuncionario extends JDialog {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtNomePai;
	private JTextField txtNomeMae;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEmail;
	MaskFormatterNew mask = null;
	private JTextField txtUf;
	StringDocumentUpperCase tec;
	private JTextField txtCs;
	private JTextField txtCv;
	private JTextField txtRg;
	private JTextField txtNumero;
	private String sexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroFuncionario dialog = new CadastroFuncionario();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroFuncionario() {
		setTitle("Cadastro de Funcionario");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));

		mask = new MaskFormatterNew();
		tec = new StringDocumentUpperCase();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel Imagem = new JLabel("");
		Imagem.setHorizontalAlignment(SwingConstants.CENTER);
		Imagem.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/Imagens/IconsCadastroFuncionario/c1.png")));
		Imagem.setBounds(545, 0, 106, 86);
		panel.add(Imagem);

		JLabel label = new JLabel("Informa\u00E7\u00F5es Pessoais");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(37, 76, 286, 65);
		panel.add(label);

		JLabel label_1 = new JLabel("Endere\u00E7o");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(460, 76, 275, 65);
		panel.add(label_1);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeCompleto.setBounds(35, 187, 125, 14);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBounds(35, 212, 125, 20);
		panel.add(txtNome);
		RestrictedTextField nomRestricted = new RestrictedTextField(txtNome);
		nomRestricted.setLimit(50);

		JLabel label_3 = new JLabel("Data de Nascimento");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(196, 187, 125, 14);
		panel.add(label_3);

		JFormattedTextField txtDataNasc = new JFormattedTextField(mask.Mascara("##/##/####"));
		txtDataNasc.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataNasc.setBounds(196, 212, 125, 20);
		panel.add(txtDataNasc);
		
		JFormattedTextField txtCep = new JFormattedTextField(mask.Mascara("#####.####"));
		txtCep.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCep.setBounds(610, 325, 125, 20);
		panel.add(txtCep);
		
		JFormattedTextField ftfNumero = new JFormattedTextField(mask.Mascara("######"));
		ftfNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfNumero.setBounds(612, 306, 125, 20);

		JLabel label_16 = new JLabel("E-mail");
		label_16.setFont(new Font("Arial", Font.PLAIN, 12));
		label_16.setBounds(610, 360, 122, 14);
		panel.add(label_16);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(607, 384, 125, 20);
		panel.add(txtEmail);
		RestrictedTextField emailRestricted = new RestrictedTextField(txtEmail);
		emailRestricted.setLimit(200);

		JFormattedTextField txtCpf = new JFormattedTextField(mask.Mascara("###.###.###-##"));
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCpf.setBounds(35, 381, 125, 20);
		panel.add(txtCpf);

		JFormattedTextField txtTelefone = new JFormattedTextField(mask.Mascara("(##)#####-####"));
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTelefone.setBounds(460, 381, 125, 20);
		panel.add(txtTelefone);

		JLabel label_4 = new JLabel("Nome Pai");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(35, 243, 125, 14);
		panel.add(label_4);

		txtNomePai = new JTextField();
		txtNomePai.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomePai.setColumns(10);
		txtNomePai.setBounds(35, 268, 125, 20);
		panel.add(txtNomePai);
		RestrictedTextField npRestricted = new RestrictedTextField(txtNomePai);
		npRestricted.setLimit(50);

		JLabel label_5 = new JLabel("Nome M\u00E3e");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(196, 243, 125, 14);
		panel.add(label_5);

		txtNomeMae = new JTextField();
		txtNomeMae.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeMae.setColumns(10);
		txtNomeMae.setBounds(196, 268, 125, 20);
		panel.add(txtNomeMae);
		RestrictedTextField nmRestricted = new RestrictedTextField(txtNomeMae);
		nmRestricted.setLimit(250);

		JLabel label_6 = new JLabel("Comiss\u00E3o Venda");
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(196, 299, 125, 14);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Comiss\u00E3o Servi\u00E7o");
		label_7.setFont(new Font("Arial", Font.PLAIN, 12));
		label_7.setBounds(35, 299, 125, 14);
		panel.add(label_7);

		JLabel label_8 = new JLabel("CPF");
		label_8.setFont(new Font("Arial", Font.PLAIN, 12));
		label_8.setBounds(35, 355, 125, 14);
		panel.add(label_8);

		JLabel label_9 = new JLabel("RG");
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(196, 355, 125, 14);
		panel.add(label_9);

		JLabel label_10 = new JLabel("Telefone");
		label_10.setFont(new Font("Arial", Font.PLAIN, 12));
		label_10.setBounds(460, 355, 125, 14);
		panel.add(label_10);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCep.setBounds(610, 299, 125, 14);
		panel.add(lblCep);

		txtRua = new JTextField();
		txtRua.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRua.setColumns(10);
		txtRua.setBounds(460, 273, 125, 20);
		panel.add(txtRua);
		RestrictedTextField ruaRestricted = new RestrictedTextField(txtRua);
		ruaRestricted.setLimit(100);

		JLabel label_12 = new JLabel("Rua");
		label_12.setFont(new Font("Arial", Font.PLAIN, 12));
		label_12.setBounds(460, 249, 125, 14);
		panel.add(label_12);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(460, 212, 125, 20);
		panel.add(txtCidade);
		RestrictedTextField cidRestricted = new RestrictedTextField(txtCidade);
		cidRestricted.setLimit(100);

		JLabel label_13 = new JLabel("Cidade");
		label_13.setFont(new Font("Arial", Font.PLAIN, 12));
		label_13.setBounds(460, 187, 125, 14);
		panel.add(label_13);

		JLabel label_14 = new JLabel("Bairro");
		label_14.setFont(new Font("Arial", Font.PLAIN, 12));
		label_14.setBounds(610, 187, 125, 14);
		panel.add(label_14);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(610, 212, 125, 20);
		panel.add(txtBairro);
		RestrictedTextField baiRestricted = new RestrictedTextField(txtBairro);
		baiRestricted.setLimit(100);

		JLabel label_15 = new JLabel("N\u00FAmero");
		label_15.setFont(new Font("Arial", Font.PLAIN, 12));
		label_15.setBounds(610, 248, 125, 14);
		panel.add(label_15);

		

		JLabel lblCadastroDeFuncionario = new JLabel("Cadastro de Funcionario");
		lblCadastroDeFuncionario.setFont(new Font("Arial", Font.BOLD, 25));
		lblCadastroDeFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFuncionario.setBounds(0, 0, 794, 65);
		panel.add(lblCadastroDeFuncionario);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUf.setBounds(460, 299, 125, 14);
		panel.add(lblUf);

		txtUf = new JTextField();
		txtUf.setBounds(460, 326, 125, 20);
		panel.add(txtUf);
		txtUf.setColumns(10);
		RestrictedTextField ufRestricted = new RestrictedTextField(txtUf);
		ufRestricted.setLimit(2);
		ufRestricted.setOnlyText(true);
		txtUf.setDocument(tec);

		txtCs = new JTextField();
		txtCs.setBounds(35, 324, 125, 20);
		panel.add(txtCs);
		txtCs.setColumns(10);
		RestrictedTextField csRestricted = new RestrictedTextField(txtCs);
		csRestricted.setLimit(2);
		csRestricted.setOnlyNums(true);

		txtCv = new JTextField();
		txtCv.setBounds(196, 324, 125, 20);
		panel.add(txtCv);
		txtCv.setColumns(10);
		RestrictedTextField cvRestricted = new RestrictedTextField(txtCv);
		cvRestricted.setLimit(2);
		cvRestricted.setOnlyNums(true);

		txtRg = new JTextField();
		txtRg.setBounds(196, 380, 125, 20);
		panel.add(txtRg);
		txtRg.setColumns(10);
		RestrictedTextField rgRestricted = new RestrictedTextField(txtRg);
		rgRestricted.setLimit(10);
		rgRestricted.setOnlyNums(true);

		txtNumero = new JTextField();
		txtNumero.setBounds(610, 269, 125, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		RestrictedTextField numRestricted = new RestrictedTextField(txtNumero);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(35, 410, 46, 14);
		panel.add(lblSexo);
		
		JComboBox<Object> cbSexo = new JComboBox<Object>();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino"}));
		if(cbSexo.getSelectedItem() == "Feminino")
			sexo = "f";
		else
			sexo = "m";
		cbSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		cbSexo.setBounds(35, 432, 125, 20);
		panel.add(cbSexo);
		
				JPanel panel_1 = new JPanel();
				getContentPane().add(panel_1, BorderLayout.SOUTH);
				
						
				
						JButton btEdtar = new JButton("Editar");
						btEdtar.setBackground(Color.WHITE);
						btEdtar.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/Imagens/IconsCadastroFuncionario/editar1.png")));
						btEdtar.setFont(new Font("Arial", Font.PLAIN, 12));
						
								JButton btAdicionaruser = new JButton("Adiconar Usuario");
								btAdicionaruser.setBackground(Color.WHITE);
								btAdicionaruser.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/Imagens/IconsCadastroFuncionario/salvarok.png")));
								btAdicionaruser.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										CadastroUsuario cu = new CadastroUsuario();
										cu.setLocationRelativeTo(cu);
										cu.setVisible(true);
									}
								});
								btAdicionaruser.setFont(new Font("Arial", Font.PLAIN, 12));
								
										JButton Cadastrar = new JButton("Cadastrar");
										Cadastrar.setBackground(Color.WHITE);
										Cadastrar.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/Imagens/IconsCadastroFuncionario/salvar.png")));
										Cadastrar.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent arg0) {
												
												Funcionario f = new Funcionario();
												FuncionarioDAO fdao = new FuncionarioDAO();
												
												f.setNome_Funcionario(txtNome.getText());
												f.setRg_Funcionario((txtRg.getText()));
												f.setCpf_Funcionario(txtCpf.getText());
												f.setNome_Pai_Funcionario(txtNomePai.getText());
												f.setNome_Mae_Funcionario(txtNomeMae.getText());
												f.setDt_Nacimento_Funcionario(txtDataNasc.getText());
												f.setSexo_Funcionario(sexo);
												f.setBairro_Funcionario(txtBairro.getText());
												f.setRua_Funcionario(txtRua.getText());
												f.setCep_Funcionario(txtCep.getText());
												f.setCidade_Funcionario(txtCidade.getText());
												f.setEmail_Funcionario(txtEmail.getText());
												f.setUf_Funcionario(txtUf.getText());
												f.setTelefone_Funcionario(txtTelefone.getText());
												f.setNumero_Funcionario(Integer.parseInt(txtNumero.getText()));
												fdao.insert(f);

												txtNomeMae.setText("");
												txtBairro.setText("");
												txtCidade.setText("");
												txtEmail.setText("");
												txtNome.setText("");
												txtNomePai.setText("");
												txtNumero.setText("");
												txtRg.setText("");
												txtRua.setText("");
												txtUf.setText("");
												txtCs.setText("");
												txtCv.setText("");
											}
										});
										Cadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
										
										JButton btCancelar = new JButton("Cancelar");
										btCancelar.setBackground(Color.WHITE);
										btCancelar.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/Imagens/IconsCadastroFuncionario/cancelar1.png")));
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
										gl_panel_1.setHorizontalGroup(
											gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addGap(69)
													.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
													.addGap(48)
													.addComponent(btEdtar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
													.addGap(45)
													.addComponent(btAdicionaruser, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
													.addContainerGap(25, Short.MAX_VALUE))
										);
										gl_panel_1.setVerticalGroup(
											gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addContainerGap(34, Short.MAX_VALUE)
													.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
														.addComponent(Cadastrar)
														.addComponent(btEdtar)
														.addComponent(btCancelar)
														.addComponent(btAdicionaruser))
													.addGap(25))
										);
										panel_1.setLayout(gl_panel_1);
		numRestricted.setLimit(6);
		
	}
}
