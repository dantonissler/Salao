package main.java.view.menu.panel.agenda;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AgendaFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable TbAgenda;
	private JTable TbDevedores;

	/**
	 * Create the panel.
	 */
	public AgendaFrame() {
		setLayout(new BorderLayout(0, 0));
		setSize(1200, 700);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBackground(Color.WHITE);
		calendar.getMonthChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 12));
		calendar.getYearChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 12));
		calendar.setBounds(347, 11, 282, 209);
		panel.add(calendar);

		JLabel label = new JLabel("Agenda");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 383, 52, 14);
		panel.add(label);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(361, 377, 149, 20);
		panel.add(dateChooser);

		JLabel label_1 = new JLabel("Devedores");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(708, 383, 75, 14);
		panel.add(label_1);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBounds(866, 380, 123, 20);
		textField.setText("Pesquisa");
		textField.setColumns(10);
		panel.add(textField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(708, 405, 380, 245);
		panel.add(scrollPane);

		TbDevedores = new JTable();
		TbDevedores.setFont(new Font("Arial", Font.PLAIN, 12));
		TbDevedores.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Cliente", "Valor", "Data vencimento" }));
		scrollPane.setViewportView(TbDevedores);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 405, 500, 245);
		panel.add(scrollPane_1);

		TbAgenda = new JTable();
		TbAgenda.setFont(new Font("Arial", Font.PLAIN, 12));
		TbAgenda.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Funcion\u00E1rio", "Cliente", "Hor\u00E1rio de inicio", "horario de saida", "tempo" }));
		TbAgenda.getColumnModel().getColumn(2).setPreferredWidth(91);
		TbAgenda.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane_1.setViewportView(TbAgenda);

		JButton btnReceber = new JButton("Receber");
		btnReceber.setFont(new Font("Arial", Font.PLAIN, 12));
		btnReceber.setBounds(999, 379, 89, 23);
		panel.add(btnReceber);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.NORTH);

		JButton btCadastroServico = new JButton("Cadastrar Servi\u00E7o");

		btCadastroServico.setFont(new Font("Arial", Font.PLAIN, 12));
		btCadastroServico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroServico cp = new CadastroServico();
				cp.setLocationRelativeTo(cp);
				cp.setVisible(true);
			}
		});

		JButton btnAgendarHorario = new JButton("Agendar hor\u00E1rio");

		btnAgendarHorario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendarHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(btnAgendarHorario, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btCadastroServico, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(880, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(5)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAgendarHorario, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btCadastroServico, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
	}
}
