package main.java.view.menu.panel.agenda;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Atxy2k.CustomTextField.RestrictedTextField;
import main.java.tools.MaskFormatterNew;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadastroServico extends JDialog {
	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 *  colocar os limites dos campos;{ sendo eles o tempo
	 *         de serviço e os valores monetarios; } incerir valores no banco;
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextField txtValorReferencial;
	MaskFormatterNew mask = null;
	private JTextField txtTempo;
	private JTable table;
	private JTextField txtPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroServico dialog = new CadastroServico();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroServico() {
		setTitle("Cadastro de Sevi\u00E7o");
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		mask = new MaskFormatterNew();

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(Color.WHITE);
		btCadastrar.setForeground(Color.BLACK);
		btCadastrar.setIcon(new ImageIcon(CadastroServico.class.getResource("/Imagens/IconsCadastroFuncionario/salvar.png")));
		btCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btEditar = new JButton("Editar");
		btEditar.setBackground(Color.WHITE);
		btEditar.setForeground(Color.BLACK);
		btEditar.setIcon(new ImageIcon(CadastroServico.class.getResource("/Imagens/IconsCadastroFuncionario/editar1.png")));
		btEditar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBackground(Color.WHITE);
		btCancelar.setForeground(Color.BLACK);
		btCancelar.setIcon(new ImageIcon(CadastroServico.class.getResource("/Imagens/IconsCadastroFuncionario/cancelar1.png")));
		btCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(148)
					.addComponent(btCadastrar)
					.addGap(114)
					.addComponent(btEditar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
					.addComponent(btCancelar)
					.addGap(98))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btEditar)
						.addComponent(btCadastrar)
						.addComponent(btCancelar))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(242, 134, 125, 14);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBounds(242, 159, 125, 20);
		panel.add(txtNome);
		RestrictedTextField nomRestricted = new RestrictedTextField(txtNome);
		nomRestricted.setLimit(50);

		JLabel lblTempoEstimado = new JLabel("Tempo estimado");
		lblTempoEstimado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTempoEstimado.setBounds(403, 134, 125, 14);
		panel.add(lblTempoEstimado);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setBounds(242, 190, 125, 14);
		panel.add(lblValor);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 12));
		txtValor.setColumns(10);
		txtValor.setBounds(242, 215, 125, 20);
		panel.add(txtValor);

		JLabel lblValorReferencial = new JLabel("Valor Referencial");
		lblValorReferencial.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValorReferencial.setBounds(403, 190, 125, 14);
		panel.add(lblValorReferencial);

		txtValorReferencial = new JTextField();
		txtValorReferencial.setFont(new Font("Arial", Font.PLAIN, 12));
		txtValorReferencial.setColumns(10);
		txtValorReferencial.setBounds(403, 215, 125, 20);
		panel.add(txtValorReferencial);

		JLabel lblCadastroDeServio = new JLabel("Cadastro de Servi\u00E7o");
		lblCadastroDeServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeServio.setFont(new Font("Arial", Font.BOLD, 25));
		lblCadastroDeServio.setBounds(0, 0, 777, 65);
		panel.add(lblCadastroDeServio);

		txtTempo = new JTextField();
		txtTempo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTempo.setBounds(403, 160, 125, 20);
		panel.add(txtTempo);
		txtTempo.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 767, 202);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Tempo Estimado", "Valor", "Valor Refencial" }));
		scrollPane.setViewportView(table);

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPesquisar.setBounds(10, 282, 125, 20);
		panel.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 257, 125, 14);
		panel.add(lblNewLabel);
	}
}
