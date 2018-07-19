package main.java.model.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import main.java.connection.ConnectionFactory;
import main.java.model.bean.Servico;

public class ServicoDAO {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public void create(Servico s) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO `Salao`.`Cadastro_Servico` (`nome_Servico`, `duracao_Servico`, `valor_Servico`,"
							+ " `valor_Referencia`) VALUES (?, ?, ?, ?);");

			stmt.setString(1, s.getNome_Servico());
			stmt.setDate(2, s.getDuracao_Servico());
			stmt.setDouble(3, s.getValor_Servico());
			stmt.setDouble(4, s.getValor_referencia());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
