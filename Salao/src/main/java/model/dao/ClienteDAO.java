package main.java.model.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import main.java.connection.ConnectionFactory;
import main.java.model.bean.Cliente;

public class ClienteDAO {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public void inserir(Cliente c) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO `Salao`.`Cadastro_Cliente` (`cpf_Cliente`,"
					+ " `rg_Cliente`, `nome_Cliente`, `dt_Nascimento_Cliente`, `pai_Cliente`, "
					+ "`mae_Cliente`, `sexo_Cliente`, `bairro_Cliente`, `cidade_Cliente`, "
					+ "`cep_Cliente`, `rua_Cliente`, `numero_Cliente`, `email_Cliente`, "
					+ "`telefone_Cliente`, `uf_Cliente`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, c.getCpf_Cliente());
			stmt.setInt(2, (Integer) c.getRg_Cliente());
			stmt.setString(3, c.getNome_Cliente());
			stmt.setString(4, c.getDt_Nascimento_Cliente());
			stmt.setString(5, c.getPai_Cliente());
			stmt.setString(6, c.getMae_Cliente());
			stmt.setString(7, c.getSexo_Cliente());
			stmt.setString(8, c.getBairro_Cliente());
			stmt.setString(9, c.getCidade_Cliente());
			stmt.setString(10, c.getCep_Cliente());
			stmt.setString(11, c.getRua_Cliente());
			stmt.setInt(12, c.getNumero_Cliente());
			stmt.setString(13, c.getEmail_Cliente());
			stmt.setString(14, c.getTelefone_Cliente());
			stmt.setString(15, c.getUf_Cliente());

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
