package main.java.model.bean;

import java.sql.Date;

public class Servico {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	private int id_Servico;
	private String nome_Servico;
	private Date duracao_Servico;
	private double valor_Servico;
	private double valor_referencia;

	public int getId_Servico() {
		return id_Servico;
	}

	public void setId_Servico(int id_Servico) {
		this.id_Servico = id_Servico;
	}

	public String getNome_Servico() {
		return nome_Servico;
	}

	public void setNome_Servico(String nome_Servico) {
		this.nome_Servico = nome_Servico;
	}

	public Date getDuracao_Servico() {
		return duracao_Servico;
	}

	public void setDuracao_Servico(Date duracao_Servico) {
		this.duracao_Servico = duracao_Servico;
	}

	public double getValor_Servico() {
		return valor_Servico;
	}

	public void setValor_Servico(double valor_Servico) {
		this.valor_Servico = valor_Servico;
	}

	public double getValor_referencia() {
		return valor_referencia;
	}

	public void setValor_referencia(double valor_referencia) {
		this.valor_referencia = valor_referencia;
	}

}
