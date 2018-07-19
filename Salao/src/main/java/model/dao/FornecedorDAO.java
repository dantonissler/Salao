package main.java.model.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import main.java.connection.ConnectionFactory;
import main.java.model.bean.Fornecedor;

public class FornecedorDAO {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public void create(Fornecedor f) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("INSERT INTO `Salao`.`Cadastro_Fornecedor` (`cnpj_Fornecedor`, `nome_Fornecedor`,"
							+ "`nome_Empresa`, `bairro_Fornecedor`, `cidade_Fornecedor`, `cep__Fornecedor`, `rua_Fornecedor`,"
							+ "`numero_Fornecedor`, `email_Fornecedor`, `telefone_Fornecedor`, `uf_Fornecedor`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, f.getCnpj_Fornecedor());
			stmt.setString(2, f.getNome_Fornecedor());
			stmt.setString(3, f.getNome_Empresa());
			stmt.setString(4, f.getBairro_Fornecedor());
			stmt.setString(5, f.getCidade_Fornecedor());
			stmt.setString(6, f.getCep_Fornecedor());
			stmt.setString(7, f.getRua_Fornecedor());
			stmt.setInt(8, f.getNumero_Fornecedor());
			stmt.setString(9, f.getEmail_Fornecedor());
			stmt.setString(10, f.getTelefone_Fornecedor());
			stmt.setString(11, f.getUf_Fornecedor());

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
