/*
 * IConversor.java
 * 
 * Data de cria��o: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.io.Serializable;

import br.com.ap.comum.excecao.ConversorException;

/**
 * Interface dos comparadores de inst�ncia.
 * 
 * @param <O> Objeto de or�gem
 * @param <D> Objeto de destino
 * @author AdrianoP
 */
public interface IConversor<O, D> extends Serializable {

	/**
	 * Converte o objeto passado por par�metro em um outro objeto.
	 * 
	 * @param objeto Objeto que ser� convertido.
	 * @return Novo objeto.
	 * @throws ConversorException Erro de convers�o
	 */
	public D converter(O objeto) throws ConversorException;

	/**
	 * Retorna o tipo do objeto recebido pelo conversor.
	 * 
	 * @return tipo do objeto recebido pelo conversor
	 */
	public Class<O> getTipoDeOrigem();

	/**
	 * Retorna o tipo do objeto resultado da convers�o.
	 * 
	 * @return tipo do objeto resultado da convers�o
	 */
	public Class<D> getTipoDeDestino();
}
