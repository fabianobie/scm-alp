/*
 * UsuarioTO.java
 * 
 * Data de criação: 25/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * @author AdrianoP
 */
public class UsuarioTO implements Serializable {

	private int		identidade;

	private String	nome;

	private String	data;

	private double	peso;

	/**
	 * Construtor.
	 */
	public UsuarioTO() {
		// construtor.
	}

	/**
	 * Construtor.
	 * 
	 * @param identidade Identidade
	 * @param nome Nome
	 * @param data Data
	 * @param peso Peso
	 */
	public UsuarioTO(int identidade, String nome, String data, double peso) {
		setIdentidade(identidade);
		setNome(nome);
		setData(data);
		setPeso(peso);
	}

	/**
	 * @return Returns the identidade.
	 */
	public int getIdentidade() {
		return identidade;
	}

	/**
	 * @param identidade The identidade to set.
	 */
	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data The data to set.
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return Returns the peso.
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso The peso to set.
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

}
