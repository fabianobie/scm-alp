/*
 * ElementoTO.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.Serializable;

import org.w3c.dom.Element;

/**
 * Classe que representa um elemento XML.
 * 
 * @author adrianop
 */
public class ElementoTO implements Serializable {
	private String	nome;
	private Element	elemento;

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            Atribui nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return elemento
	 */
	public Element getElemento() {
		return elemento;
	}

	/**
	 * @param elemento
	 *            Atribui elemento.
	 */
	public void setElemento(Element elemento) {
		this.elemento = elemento;
	}
}
