package main.java.tools;

import javax.swing.JOptionPane;

public class Mensagens {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private final String titulo;

	public Mensagens(String titulo) {
		this.titulo = titulo;
	}

	public void alerta(String texto) {
		JOptionPane.showMessageDialog(null, texto, this.titulo, JOptionPane.WARNING_MESSAGE);
	}

	public void informação(String texto) {
		JOptionPane.showMessageDialog(null, texto, this.titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public void erro(String texto) {
		JOptionPane.showMessageDialog(null, texto, this.titulo, JOptionPane.ERROR_MESSAGE);
	}

	public int pergunta(String texto) {
		return JOptionPane.showConfirmDialog(null, texto, this.titulo, JOptionPane.YES_NO_OPTION);
	}
}
