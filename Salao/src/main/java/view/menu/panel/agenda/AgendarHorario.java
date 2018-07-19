package main.java.view.menu.panel.agenda;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

public class AgendarHorario extends JDialog {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgendarHorario dialog = new AgendarHorario();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgendarHorario() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
	}

}
