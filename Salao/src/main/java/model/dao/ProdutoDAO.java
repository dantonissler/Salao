package main.java.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import main.java.connection.ConnectionFactory;
import main.java.model.bean.Produto;

public class ProdutoDAO {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public void insert(Produto p) {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO Cadastro_Produto(nome_produto, Descricao_produto, qtd_produto, valor_produto) VALUES(?,?,?,?)");
			stmt.setString(1, p.getNome_Produto());
			stmt.setString(2, p.getDescricao_Produto());
			stmt.setInt(3, p.getQtd_Produto());
			stmt.setDouble(4, p.getValor_Produto());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public ArrayList<Produto> read() {

		Connection con = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Produto> produtos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Cadastro_Produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId_produto(rs.getInt("id_produto"));
				produto.setNome_Produto(rs.getString("nome_Produto"));
				produto.setDescricao_Produto(rs.getString("descricao_Produto"));
				produto.setQtd_Produto(rs.getInt("qtd_Produto"));
				produto.setValor_Produto(rs.getDouble("valor_Produto"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return produtos;
	}
}
