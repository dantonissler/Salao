package main.java.view.menu.panel.cliente;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Atxy2k.CustomTextField.RestrictedTextField;
import main.java.model.bean.Cliente;
import main.java.model.dao.ClienteDAO;
import main.java.tools.MaskFormatterNew;
import main.java.tools.Mensagens;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadastroCliente extends JDialog {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 *         está exibindo um erro se clicar em cadastrar sem preencher os campos.
	 */

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtNomePai;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtRG;
	private JTextField txtRua;
	private JTextField txtEmail;
	private JTextField txtNumero;
	MaskFormatterNew mask;
	private JTextField txtUF;
	private String sexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroCliente dialog = new CadastroCliente();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroCliente() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);

		mask = new MaskFormatterNew();

		txtNome = new JTextField();
		txtNome.setLocation(37, 207);
		txtNome.setSize(125, 20);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		RestrictedTextField nomRestricted = new RestrictedTextField(txtNome);
		nomRestricted.setLimit(50);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CadastroCliente.class.getResource("/Imagens/IconsCadastroCliente/5.jpg")));
		label_2.setBounds(510, 11, 71, 84);
		getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\danto\\OneDrive\\My Doments\\Imagens da Sara\\cadastro de cliente\\5.jpg"));
		label_1.setBounds(510, 11, 73, 84);
		getContentPane().add(label_1);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtNomePai = new JTextField();
		txtNomePai.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomePai.setBounds(37, 262, 125, 20);
		getContentPane().add(txtNomePai);
		txtNomePai.setColumns(10);
		RestrictedTextField npRestricted = new RestrictedTextField(txtNomePai);
		npRestricted.setLimit(50);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBackground(Color.WHITE);
		btCancelar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/Imagens/IconsCadastroCliente/cancelar1.png")));
		btCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Mensagens ms = new Mensagens("Alerta");
				int resposta = ms.pergunta("Deseja fechar o programa? As informações não seram salvas!");
				if (resposta == 0) {
					setVisible(false);
				}
			}
		});
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btCancelar.setBounds(409, 529, 112, 23);
		getContentPane().add(btCancelar);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setBounds(458, 207, 125, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		RestrictedTextField cidRestricted = new RestrictedTextField(txtCidade);
		cidRestricted.setLimit(50);

		JTextField txtNomeMae = new JTextField();
		txtNomeMae.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeMae.setBounds(37, 317, 125, 20);
		getContentPane().add(txtNomeMae);
		txtNomeMae.setColumns(10);
		RestrictedTextField nmRestricted = new RestrictedTextField(txtNomeMae);
		nmRestricted.setLimit(50);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(37, 182, 125, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome do Pai");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 237, 125, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(224, 237, 125, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(458, 182, 125, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Data Nascimento");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(37, 348, 125, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Nome da M\u00E3e");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(37, 293, 125, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(458, 354, 125, 14);
		getContentPane().add(lblNewLabel_6);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairro.setBounds(608, 207, 122, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		RestrictedTextField bairroRestricted = new RestrictedTextField(txtBairro);
		bairroRestricted.setLimit(100);

		txtRG = new JTextField();
		txtRG.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRG.setBounds(224, 207, 125, 20);
		RestrictedTextField rgRestricted = new RestrictedTextField(txtRG);
		rgRestricted.setLimit(10);
		rgRestricted.setOnlyNums(true);
		getContentPane().add(txtRG);
		txtRG.setColumns(10);

		txtRua = new JTextField();
		txtRua.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRua.setBounds(458, 262, 125, 20);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);
		RestrictedTextField ruaRestricted = new RestrictedTextField(txtRua);
		ruaRestricted.setLimit(100);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setBounds(605, 379, 125, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		RestrictedTextField emailRestricted = new RestrictedTextField(txtEmail);
		emailRestricted.setLimit(200);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNumero.setBounds(608, 262, 122, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		RestrictedTextField nunRestricted = new RestrictedTextField(txtNumero);
		nunRestricted.setLimit(6);

		JLabel lblNewLabel_7 = new JLabel("Bairro");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(608, 182, 122, 14);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("RG");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(224, 182, 125, 14);
		getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Rua");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(458, 238, 125, 14);
		getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("UF");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(458, 293, 125, 14);
		getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Sexo");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(224, 293, 125, 14);
		getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("E-mail");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(608, 355, 122, 14);
		getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("N\u00FAmero");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(608, 237, 122, 14);
		getContentPane().add(lblNewLabel_13);

		JComboBox<Object> cbSexo = new JComboBox<Object>();
		cbSexo.setModel(new DefaultComboBoxModel<Object>(new String[] { "Feminino", "Masculino" }));
		if(cbSexo.getSelectedItem() == "Feminino")
			sexo = "f";
		else
			sexo = "m";
		cbSexo.setBounds(224, 319, 125, 20);
		getContentPane().add(cbSexo);

		JFormattedTextField txtDataNacs = new JFormattedTextField(mask.Mascara("##/##/####"));
		txtDataNacs.setColumns(5);
		txtDataNacs.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataNacs.setToolTipText("");
		txtDataNacs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtDataNacs.setBounds(37, 373, 125, 20);
		getContentPane().add(txtDataNacs);

		JLabel lblNewLabel_14 = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(37, 106, 312, 65);
		getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Endere\u00E7o");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_15.setBounds(458, 106, 272, 65);
		getContentPane().add(lblNewLabel_15);

		JFormattedTextField txtCep = new JFormattedTextField(mask.Mascara("#####.###"));
		txtCep.setBounds(608, 318, 125, 20);
		getContentPane().add(txtCep);

		JFormattedTextField txtCPF = new JFormattedTextField(mask.Mascara("###.###.###-##"));
		txtCPF.setBounds(224, 263, 125, 20);
		getContentPane().add(txtCPF);

		JLabel lblNewLabel_16 = new JLabel("Cadastro de Cliente");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_16.setBounds(0, 0, 785, 96);
		getContentPane().add(lblNewLabel_16);

		JLabel label = new JLabel("Cep");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(605, 292, 125, 14);
		getContentPane().add(label);

		JFormattedTextField txtTelefone = new JFormattedTextField(mask.Mascara("(##)#####-####"));
		txtTelefone.setBounds(458, 379, 125, 20);
		getContentPane().add(txtTelefone);

		txtUF = new JTextField();
		txtUF.setBounds(458, 318, 125, 20);
		getContentPane().add(txtUF);
		txtUF.setColumns(10);
		RestrictedTextField ufRestricted = new RestrictedTextField(txtUF);
		ufRestricted.setLimit(2);
		ufRestricted.setOnlyText(true);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(Color.WHITE);
		btCadastrar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/Imagens/IconsCadastroCliente/salvar.png")));
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO cdao = new ClienteDAO();
				c.setNome_Cliente(txtNome.getText());
				c.setRg_Cliente(Integer.parseInt(txtRG.getText()));
				c.setCpf_Cliente(txtCPF.getText());
				c.setPai_Cliente(txtNomePai.getText());
				c.setMae_Cliente(txtNomeMae.getText());
				c.setDt_Nascimento_Cliente(txtDataNacs.getText());
				c.setSexo_Cliente(sexo);
				c.setBairro_Cliente(txtBairro.getText());
				c.setRua_Cliente(txtRua.getText());
				c.setCep_Cliente(txtCep.getText());
				c.setCidade_Cliente(txtCidade.getText());
				c.setEmail_Cliente(txtEmail.getText());
				c.setUf_Cliente(txtUF.getText());
				c.setTelefone_Cliente(txtTelefone.getText());
				c.setNumero_Cliente(Integer.parseInt(txtNumero.getText()));
				cdao.inserir(c);

				txtCep.setText("");
				txtCPF.setText("");
				txtDataNacs.setText("");
				txtNomeMae.setText("");
				txtTelefone.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEmail.setText("");
				txtNome.setText("");
				txtNomePai.setText("");
				txtNumero.setText("");
				txtRG.setText("");
				txtRua.setText("");
				txtUF.setText("");
			}
		});
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btCadastrar.setBounds(135, 527, 112, 23);
		getContentPane().add(btCadastrar);
		
		getRootPane().setDefaultButton(btCadastrar);
	}
}
