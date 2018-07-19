package main.java.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import main.java.view.login.Relogar;
import main.java.view.menu.panel.Caixa_Frame;
import main.java.view.menu.panel.NotaFiscalFrame;
import main.java.view.menu.panel.OrcamentoFrame;
import main.java.view.menu.panel.VendaFrame;
import main.java.view.menu.panel.agenda.AgendaFrame;
import main.java.view.menu.panel.cliente.ClienteFrame;
import main.java.view.menu.panel.fornecedor.FornecedoresFrame;
import main.java.view.menu.panel.funcionario.FuncionarioFrame;
import main.java.view.menu.panel.produto.ProdutoFrame;

public class MenuFrame extends JFrame {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	VendaFrame ven;

	OrcamentoFrame orc;

	ClienteFrame cli;

	ProdutoFrame pro;

	FornecedoresFrame forn;

	Caixa_Frame cai;

	AgendaFrame age;

	FuncionarioFrame usu;

	NotaFiscalFrame not;

	JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void mudapainel(JPanel painel) {

		panel_1.setBackground(Color.WHITE);

		panel_1.removeAll();
		panel_1.add(painel);
		panel_1.revalidate();
		panel_1.repaint();
	}

	public MenuFrame() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				mudapainel(age);
			}
		});

		orc = new OrcamentoFrame();

		pro = new ProdutoFrame();

		forn = new FornecedoresFrame();

		cai = new Caixa_Frame();

		usu = new FuncionarioFrame();

		not = new NotaFiscalFrame();

		cli = new ClienteFrame();

		ven = new VendaFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 460);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmImprimirctrlp = new JMenuItem("Imprimir(ctrl+p)");
		mnNewMenu.add(mntmImprimirctrlp);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exportar");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmTrocarFuncionario = new JMenuItem("Trocar Funcionario");
		mnNewMenu.add(mntmTrocarFuncionario);

		JMenu mnExibir = new JMenu("exibir");
		menuBar.add(mnExibir);

		JMenuItem mntmNewMenuItem = new JMenuItem("Agenda");
		mnExibir.add(mntmNewMenuItem);

		JMenuItem mntmVenda = new JMenuItem("Vendas");
		mnExibir.add(mntmVenda);

		JMenuItem mntmOramento = new JMenuItem("Or\u00E7amento");
		mnExibir.add(mntmOramento);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnExibir.add(mntmCliente);

		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnExibir.add(mntmProdutos);

		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mnExibir.add(mntmFornecedor);

		JMenuItem mntmCaixa = new JMenuItem("Caixa");
		mnExibir.add(mntmCaixa);

		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mnExibir.add(mntmUsuarios);

		JMenuItem mntmNotaFiscal = new JMenuItem("Nota Fiscal");
		mnExibir.add(mntmNotaFiscal);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		contentPane.add(scrollPane, BorderLayout.WEST);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		scrollPane.setViewportView(panel);

		javax.swing.AbstractButton btVendas = new JButton("");
		btVendas.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/AlterarUsuarios.png")));

		btVendas.setBackground(Color.WHITE);
		btVendas.setFont(new Font("Arial", Font.PLAIN, 12));
		btVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(ven);
			}
		});

		JButton btOrcamento = new JButton("");
		btOrcamento.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Orcamento.png")));
		btOrcamento.setBackground(Color.WHITE);
		btOrcamento.setFont(new Font("Arial", Font.PLAIN, 12));
		btOrcamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(orc);
			}
		});

		JButton btCliente = new JButton("");
		btCliente.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Cliente.png")));
		btCliente.setBackground(Color.WHITE);
		btCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(cli);
			}
		});

		JButton btProdutos = new JButton("");
		btProdutos.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Produto.png")));
		btProdutos.setBackground(Color.WHITE);
		btProdutos.setFont(new Font("Arial", Font.PLAIN, 12));
		btProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(pro);
			}
		});

		JButton btFornecedores = new JButton("");
		btFornecedores.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Fornecedor.png")));
		btFornecedores.setBackground(Color.WHITE);
		btFornecedores.setFont(new Font("Arial", Font.PLAIN, 12));
		btFornecedores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(forn);
			}
		});

		JButton btCaixa = new JButton("");
		btCaixa.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Caixa.png")));
		btCaixa.setBackground(Color.WHITE);
		btCaixa.setFont(new Font("Arial", Font.PLAIN, 12));
		btCaixa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(cai);
			}
		});

		JButton btUsuarios = new JButton("");
		btUsuarios.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Usuarios.png")));
		btUsuarios.setBackground(Color.WHITE);
		btUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
		btUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(usu);
			}
		});

		JButton btAgenda = new JButton("");
		btAgenda.setToolTipText("");
		btAgenda.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/Agenda.png")));

		btAgenda.setFont(new Font("Arial", Font.PLAIN, 12));
		btAgenda.setBackground(Color.WHITE);
		btAgenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(age);
			}
		});

		JButton btNotaFiscal = new JButton("");
		btNotaFiscal.setEnabled(false);
		btNotaFiscal.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/NotaFiscal.png")));
		btNotaFiscal.setBackground(Color.WHITE);
		btNotaFiscal.setFont(new Font("Arial", Font.PLAIN, 12));
		btNotaFiscal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mudapainel(not);
			}
		});

		JButton btAlterarUsuario = new JButton("");
		btAlterarUsuario.setBackground(SystemColor.window);
		btAlterarUsuario.setIcon(new ImageIcon(MenuFrame.class
				.getResource("/Imagens/IconsMenu/AlterarUsuarios.png")));
		btAlterarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Relogar reload = new Relogar();
				reload.setLocationRelativeTo(reload);
				reload.setVisible(true);
				
				// Achar uma forma de derrubar o usu�rio anterior quando ouver a troca de usu�rio  
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		btOrcamento,
																		GroupLayout.PREFERRED_SIZE,
																		184,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.LEADING)
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(11)
																				.addComponent(
																						btUsuarios,
																						GroupLayout.DEFAULT_SIZE,
																						145,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(
																						btCaixa,
																						GroupLayout.DEFAULT_SIZE,
																						146,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(
																						btFornecedores,
																						0,
																						0,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(11)
																				.addComponent(
																						btProdutos,
																						GroupLayout.DEFAULT_SIZE,
																						145,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(
																						btVendas,
																						GroupLayout.DEFAULT_SIZE,
																						146,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addContainerGap()
																				.addComponent(
																						btAgenda,
																						GroupLayout.DEFAULT_SIZE,
																						146,
																						Short.MAX_VALUE))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(11)
																				.addGroup(
																						gl_panel.createParallelGroup(
																								Alignment.LEADING)
																								.addComponent(
																										btAlterarUsuario,
																										Alignment.TRAILING,
																										GroupLayout.PREFERRED_SIZE,
																										145,
																										Short.MAX_VALUE)
																								.addComponent(
																										btNotaFiscal,
																										GroupLayout.DEFAULT_SIZE,
																										145,
																										Short.MAX_VALUE)))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(11)
																				.addComponent(
																						btCliente,
																						GroupLayout.DEFAULT_SIZE,
																						183,
																						Short.MAX_VALUE))))
								.addGap(20)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(btAgenda, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(btVendas, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(btOrcamento, GroupLayout.PREFERRED_SIZE,
								60, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(btCliente, GroupLayout.PREFERRED_SIZE,
								55, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addComponent(btProdutos, GroupLayout.PREFERRED_SIZE,
								60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btFornecedores,
								GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(btCaixa, GroupLayout.PREFERRED_SIZE, 55,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btUsuarios, GroupLayout.PREFERRED_SIZE,
								60, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(btNotaFiscal, GroupLayout.PREFERRED_SIZE,
								60, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(btAlterarUsuario)
						.addContainerGap(118, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		panel_1.setLayout(new BorderLayout(0, 0));

		age = new AgendaFrame();

		contentPane.add(panel_1, BorderLayout.CENTER);

		mudapainel(age);
	}
}
