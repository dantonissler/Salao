package main.java.connection;

import main.java.model.bean.Usuario;
import main.java.model.dao.UsuarioDAO;

public class Test {
	/**
	 * @author Danton Issler
	 */
	public static void main(String[] args) {

		System.out.println(ConnectionFactory.getConnection());
		
		Usuario use = new Usuario();
		UsuarioDAO user = new UsuarioDAO();
		
		use.setLogin("login");
		use.setSenha("senha");
		use.setTipo(1);
		
		user.insert(use);

	}
}
