package main.java.view.menu.panel.funcionario;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioFrame extends JPanel {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;

	public FuncionarioFrame() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JButton button = new JButton("Apagar Usuario");

		button.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton button_1 = new JButton("Editar Usu\u00E1rio");

		button_1.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnCadastroDeFuncionario = new JButton("Cadastro de Usuario");

		btnCadastroDeFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionario cf = new CadastroFuncionario();
				cf.setLocationRelativeTo(cf);
				cf.setVisible(true);
			}
		});
		btnCadastroDeFuncionario.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(btnCadastroDeFuncionario)
						.addGap(19).addComponent(button_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(34).addComponent(button, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(711, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastroDeFuncionario).addGroup(gl_panel
								.createParallelGroup(Alignment.BASELINE).addComponent(button_1).addComponent(button)))
				.addContainerGap()));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
	}
}
