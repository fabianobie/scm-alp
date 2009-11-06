/*
 * IConversor.java
 * 
 * Data de criação: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.io.Serializable;

import br.com.ap.comum.excecao.ConversorException;

/**
 * Interface dos comparadores de instância.
 * 
 * @param <O> Objeto de orígem
 * @param <D> Objeto de destino
 * @author AdrianoP
 */
public interface IConversor<O, D> extends Serializable {

	/**
	 * Converte o objeto passado por parâmetro em um outro objeto.
	 * 
	 * @param objeto Objeto que será convertido.
	 * @return Novo objeto.
	 * @throws ConversorException Erro de conversão
	 */
	public D converter(O objeto) throws ConversorException;

	/**
	 * Retorna o tipo do objeto recebido pelo conversor.
	 * 
	 * @return tipo do objeto recebido pelo conversor
	 */
	public Class<O> getTipoDeOrigem();

	/**
	 * Retorna o tipo do objeto resultado da conversão.
	 * 
	 * @return tipo do objeto resultado da conversão
	 */
	public Class<D> getTipoDeDestino();
}
