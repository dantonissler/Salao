package main.java.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

import main.java.connection.ConnectionFactory;
import main.java.model.bean.Usuario;

public class UsuarioDAO {
	private boolean acesso = false;

	/**
	 * @author Danton Issler
	 * @throws SQLException
	 */

	public void insert(Usuario u) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO `usuario`(`login`, `senha`, `tipo_Usuario`) "
					+ "VALUES (?,?,?)");

			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setInt(3, u.getTipo());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void acessarSistema(String login, String senha) throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		Statement mt = null;
		ResultSet rs = null;

		try {
			mt = con.createStatement();
			rs = mt.executeQuery(
					"SELECT login, senha FROM `Usuario` where login = '" + login + "'and senha = '" + senha + "';");

			if (rs.next())
				acesso = true;
			else
				JOptionPane.showMessageDialog(null, "Usuario ou senha incoreto!");

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, rs, mt);
		}
	}

	public boolean getAcesso() {
		return acesso;
	}
	
	public ArrayList<Usuario> read() {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Usuario> usuarios = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM `Salao`.`Usuario`;");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId_Usuario(rs.getInt("id_Usuario"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				user.setTipo(rs.getInt("tipo_Usuario"));
				user.setId_Funcionario(rs.getInt("id_Funcionario"));
				usuarios.add(user);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return usuarios;
	}
}
