package main.java.model.bean;

public class Produto {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private int id_produto;
	private String nome_Produto;
	private String descricao_Produto;
	private int qtd_Produto;
	private double valor_Produto;

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_Produto() {
		return nome_Produto;
	}

	public void setNome_Produto(String nome_Produto) {
		this.nome_Produto = nome_Produto;
	}

	public String getDescricao_Produto() {
		return descricao_Produto;
	}

	public void setDescricao_Produto(String descricao_Produto) {
		this.descricao_Produto = descricao_Produto;
	}

	public int getQtd_Produto() {
		return qtd_Produto;
	}

	public void setQtd_Produto(int qtd_Produto) {
		this.qtd_Produto = qtd_Produto;
	}

	public double getValor_Produto() {
		return valor_Produto;
	}

	public void setValor_Produto(double valor_Produto) {
		this.valor_Produto = valor_Produto;
	}
}
