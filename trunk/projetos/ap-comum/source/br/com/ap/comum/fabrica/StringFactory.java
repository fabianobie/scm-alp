/*
 * StringFactory.java
 * 
 * Data de criação: 04/04/2008
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import br.com.ap.comum.string.UtilString;

/**
 * Fábrica de objetos IO.
 * 
 * @author adrianop
 */
public final class StringFactory extends FactoryAbstrata {

	private static StringFactory	instancia	= new StringFactory();

	/**
	 * Construtor.
	 */
	private StringFactory() {
		// Construtor.
	}

	/**
	 * @return instância da classe.
	 */
	public static StringFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo String.
	 * 
	 * @return novo String
	 */
	public String novaString() {
		return new String();
	}

	/**
	 * Retorna novo caracter
	 * 
	 * @param caracter Caracter
	 * @return novo caracter
	 */
	public Character novoCharacter(char caracter) {
		return new Character(caracter);
	}

	/**
	 * Retorna novo String.
	 * 
	 * @param bytes Array de bytes.
	 * @return novo String
	 */
	public String novaString(byte[] bytes) {
		return new String(bytes);
	}

	/**
	 * Retorna novo String.
	 * 
	 * @param chars Array de chars.
	 * @return novo String
	 */
	public String novaString(char[] chars) {
		return new String(chars);
	}

	/**
	 * Retorna novo String.
	 * 
	 * @param string String.
	 * @return novo String
	 */
	public String novaString(String string) {
		return new String(string);
	}

	/**
	 * Retorna novo String.
	 * 
	 * @param buffer StringBuffer.
	 * @return novo String
	 */
	public String novaString(StringBuffer buffer) {
		return new String(buffer);
	}

	/**
	 * Retorna novo String.
	 * 
	 * @param builder StringBuilder.
	 * @return novo String
	 */
	public String novaString(StringBuilder builder) {
		return new String(builder);
	}

	/**
	 * Retorna novo StringBuffer.
	 * 
	 * @return novo StringBuffer
	 */
	public StringBuffer novoStringBuffer() {
		return new StringBuffer();
	}

	/**
	 * Retorna novo StringBuffer.
	 * 
	 * @param string String
	 * @return novo StringBuffer
	 */
	public StringBuffer novoStringBuffer(String string) {
		return new StringBuffer(string);
	}

	/**
	 * Retorna novo StringBuilder.
	 * 
	 * @return novo StringBuilder
	 */
	public StringBuilder novoStringBuilder() {
		return new StringBuilder();
	}

	/**
	 * Retorna novo StringBuilder.
	 * 
	 * @param string String
	 * @return novo StringBuilder
	 */
	public StringBuilder novoStringBuilder(String string) {
		StringBuilder sb = novoStringBuilder();
		if (!UtilString.isVazio(string)) {
			sb.append(string);
		}
		return sb;
	}
}
