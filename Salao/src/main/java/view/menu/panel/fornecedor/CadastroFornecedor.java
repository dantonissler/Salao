package main.java.view.menu.panel.fornecedor;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import main.java.tools.MaskFormatterNew;
import javax.swing.ImageIcon;

public class CadastroFornecedor extends JDialog {
	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 * 		incerir valores no banco
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeEmpresa;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtEmail;
	MaskFormatterNew mask = null;
	private JFormattedTextField ftfTelefone;
	private JTextField txtUF;
	private JTextField txtNomeAtendente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroFornecedor dialog = new CadastroFornecedor();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroFornecedor() {
		setTitle("Cadastro de Fornecedor");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		mask = new MaskFormatterNew();
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel label = new JLabel("Informa\u00E7\u00F5es Pessoais");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				label.setBounds(37, 123, 286, 65);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Endere\u00E7o");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				label.setBounds(462, 123, 272, 65);
				panel.add(label);
			}
			{
				JLabel lblNome = new JLabel("Nome da Empresa");
				lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
				lblNome.setBounds(37, 245, 125, 14);
				panel.add(lblNome);
			}
			{
				txtNomeEmpresa = new JTextField();
				txtNomeEmpresa.setFont(new Font("Arial", Font.PLAIN, 12));
				txtNomeEmpresa.setColumns(10);
				txtNomeEmpresa.setBounds(37, 270, 125, 20);
				panel.add(txtNomeEmpresa);
			}
			{
				JLabel lblNomeAtendente = new JLabel("Nome do Atendente");
				lblNomeAtendente.setFont(new Font("Arial", Font.PLAIN, 12));
				lblNomeAtendente.setBounds(198, 245, 125, 14);
				panel.add(lblNomeAtendente);
			}
			{
				JLabel lblCnpj = new JLabel("CNPJ");
				lblCnpj.setFont(new Font("Arial", Font.PLAIN, 12));
				lblCnpj.setBounds(37, 307, 125, 14);
				panel.add(lblCnpj);
			}
			{
				JLabel label = new JLabel("Telefone");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(462, 413, 125, 14);
				panel.add(label);
			}
			{
				JLabel lblUf = new JLabel("UF");
				lblUf.setFont(new Font("Arial", Font.PLAIN, 12));
				lblUf.setBounds(462, 357, 125, 14);
				panel.add(lblUf);
			}
			{
				txtRua = new JTextField();
				txtRua.setFont(new Font("Arial", Font.PLAIN, 12));
				txtRua.setColumns(10);
				txtRua.setBounds(462, 331, 125, 20);
				panel.add(txtRua);
			}
			{
				JLabel label = new JLabel("Rua");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(462, 307, 125, 14);
				panel.add(label);
			}
			{
				JTextField txtCidade = new JTextField();
				txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
				txtCidade.setColumns(10);
				txtCidade.setBounds(462, 270, 125, 20);
				panel.add(txtCidade);
			}
			{
				JLabel label = new JLabel("Cidade");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(462, 245, 125, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Bairro");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(612, 245, 125, 14);
				panel.add(label);
			}
			{
				txtBairro = new JTextField();
				txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
				txtBairro.setColumns(10);
				txtBairro.setBounds(612, 270, 125, 20);
				panel.add(txtBairro);
			}
			{
				JLabel label = new JLabel("N\u00FAmero");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(612, 306, 125, 14);
				panel.add(label);
			}
			{
				JFormattedTextField ftfNumero = new JFormattedTextField(mask.Mascara("#######"));
				ftfNumero.setFont(new Font("Arial", Font.PLAIN, 12));
				ftfNumero.setBounds(612, 327, 125, 20);
				panel.add(ftfNumero);
			}
			{
				JLabel label = new JLabel("E-mail");
				label.setFont(new Font("Arial", Font.PLAIN, 12));
				label.setBounds(612, 418, 122, 14);
				panel.add(label);
			}
			{
				txtEmail = new JTextField();
				txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
				txtEmail.setColumns(10);
				txtEmail.setBounds(609, 442, 125, 20);
				panel.add(txtEmail);
			}
			{
				JFormattedTextField ftfCNPJ = new JFormattedTextField(mask.Mascara("##.###.###/####-##"));
				ftfCNPJ.setFont(new Font("Arial", Font.PLAIN, 12));
				ftfCNPJ.setBounds(37, 331, 125, 20);
				panel.add(ftfCNPJ);
			}
			{
				ftfTelefone = new JFormattedTextField(mask.Mascara("(##)#####-####"));
				ftfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
				ftfTelefone.setBounds(462, 439, 125, 20);
				panel.add(ftfTelefone);
			}
			{
				JLabel lblCadastroFornecedor = new JLabel("Cadastro de Fornecedor");
				lblCadastroFornecedor.setFont(new Font("Arial", Font.BOLD, 25));
				lblCadastroFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
				lblCadastroFornecedor.setBounds(0, 0, 784, 82);
				panel.add(lblCadastroFornecedor);
			}
			{
				JLabel lblCep = new JLabel("Cep");
				lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
				lblCep.setBounds(612, 357, 125, 14);
				panel.add(lblCep);
			}
			{
				JFormattedTextField ftfCep = new JFormattedTextField(mask.Mascara("#####.####"));
				ftfCep.setFont(new Font("Arial", Font.PLAIN, 12));
				ftfCep.setBounds(612, 383, 125, 20);
				panel.add(ftfCep);
			}
			{
				txtUF = new JTextField();
				txtUF.setBounds(462, 382, 125, 20);
				panel.add(txtUF);
				txtUF.setColumns(10);
			}
			{
				txtNomeAtendente = new JTextField();
				txtNomeAtendente.setBounds(198, 271, 125, 20);
				panel.add(txtNomeAtendente);
				txtNomeAtendente.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			JButton btCadastrar = new JButton("Cadastrar");
			btCadastrar.setIcon(new ImageIcon(CadastroFornecedor.class.getResource("/Imagens/cadastro de funcionario/salvar.png")));
			btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
			JButton btEditar = new JButton("Editar");
			btEditar.setIcon(new ImageIcon(CadastroFornecedor.class.getResource("/Imagens/cadastro de funcionario/editar1.png")));
			btEditar.setFont(new Font("Arial", Font.PLAIN, 12));
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon(CadastroFornecedor.class.getResource("/Imagens/cadastro de funcionario/cancelar1.png")));
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addGap(111).addComponent(btCadastrar).addGap(125)
							.addComponent(btEditar).addGap(192).addComponent(btnCancelar).addGap(149)));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup().addGap(7).addComponent(btnCancelar))
									.addGroup(gl_panel.createSequentialGroup().addContainerGap()
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(btEditar).addComponent(btCadastrar))))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
		}
	}

}
