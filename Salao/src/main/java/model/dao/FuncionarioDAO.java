package main.java.model.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import main.java.connection.ConnectionFactory;
import main.java.model.bean.Funcionario;

public class FuncionarioDAO {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public void insert(Funcionario f) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO `Salao`.`Cadastro_Funcionario` (`comissao_Servico`,"
					+ "`comissao_Venda`, `cpf_Funcionario`, `nome_Mae`, `nome_pai`, `nome_Funcionario`,"
					+ "`dt_Nacimento_Funcionario`, `salario_Funcionario`, `rg_Funcionario`, `bairro_Funcionario`,"
					+ "`cidade__Funcionario`, `cep_Funcionario`, `rua_Funcionario`, `numero_Funcionario`,"
					+ "`email_Funcionario`, `telefone_Funcionario`, `uf_Funcionario`, `sexo_Funcionario`)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
			stmt.setInt(1, f.getComissao_Servico());
			stmt.setInt(2, f.getComissao_Venda());
			stmt.setString(3, f.getCpf_Funcionario());
			stmt.setString(4, f.getNome_Mae_Funcionario());
			stmt.setString(5, f.getNome_Pai_Funcionario());
			stmt.setString(6, f.getNome_Funcionario());
			stmt.setString(7, f.getDt_Nacimento_Funcionario());
			stmt.setDouble(8, f.getSalario_Funcionario());
			stmt.setString(9, f.getRg_Funcionario());
			stmt.setString(10, f.getBairro_Funcionario());
			stmt.setString(11, f.getCidade_Funcionario());
			stmt.setString(12, f.getCep_Funcionario());
			stmt.setString(13, f.getRua_Funcionario());
			stmt.setInt(14, f.getNumero_Funcionario());
			stmt.setString(15, f.getEmail_Funcionario());
			stmt.setString(16, f.getTelefone_Funcionario());
			stmt.setString(17, f.getUf_Funcionario());
			stmt.setString(18, f.getSexo_Funcionario());

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
