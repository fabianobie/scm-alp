/*
 * IFormatador.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.io.Serializable;

import br.com.ap.comum.excecao.FormatadorException;

/**
 * Interface dos formatadores de instância.
 * 
 * @param <T> Tipo do objeto que será formatado.
 * @author AdrianoP
 */
public interface IFormatador<T extends Object> extends Serializable {

	/**
	 * Formata o objeto passado por parâmetro e retorna a string formatada.
	 * 
	 * @param objeto Objeto que será formatado.
	 * @return String formatada.
	 * @throws FormatadorException Exceção de formatação
	 */
	public String formatar(T objeto) throws FormatadorException;

}
