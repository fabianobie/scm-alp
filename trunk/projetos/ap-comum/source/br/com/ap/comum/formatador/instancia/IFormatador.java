/*
 * IFormatador.java
 * 
 * Data de cria��o: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.io.Serializable;

import br.com.ap.comum.excecao.FormatadorException;

/**
 * Interface dos formatadores de inst�ncia.
 * 
 * @param <T> Tipo do objeto que ser� formatado.
 * @author AdrianoP
 */
public interface IFormatador<T extends Object> extends Serializable {

	/**
	 * Formata o objeto passado por par�metro e retorna a string formatada.
	 * 
	 * @param objeto Objeto que ser� formatado.
	 * @return String formatada.
	 * @throws FormatadorException Exce��o de formata��o
	 */
	public String formatar(T objeto) throws FormatadorException;

}
