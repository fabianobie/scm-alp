/*
 * UtilDominioAbstrato.java
 * 
 * Data de criação: 30/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.dominio;

import java.util.List;
import java.util.Map;

import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.fabrica.BoleanoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.javabean.to.DominioTO;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que representa os domínios.
 * 
 * @author AdrianoP
 */
public abstract class UtilDominioAbstrato {

	/**
	 * Converte int para Integer.
	 * 
	 * @param integer primitivo
	 * @return Integer
	 * @see UtilConversorDeInteger#converterParaInteger(int)
	 */
	protected static Integer converterParaInteger(int integer) {
		return UtilConversorDeInteger.converterParaInteger(integer);
	}

	/**
	 * Converte Integer para int.
	 * 
	 * @param integer Integer
	 * @return int
	 * @see UtilConversorDeInteger#converterParaPrimitivo(Integer)
	 */
	protected static int converterParaInt(Integer integer) {
		return UtilConversorDeInteger.converterParaPrimitivo(integer);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto
	 * @return booleano
	 */
	protected static boolean isReferencia(Object... objeto) {
		return UtilObjeto.isReferenciaTodos(objeto);
	}

	/**
	 * Retorna true se a string estiver vazia.
	 * 
	 * @param string String
	 * @return booleano
	 */
	protected static boolean isVazio(String... string) {
		return UtilString.isVazioTodos(string);
	}

	/**
	 * Retorna novo objeto ArrayList.
	 * 
	 * @param <T> Tipo do retorno
	 * @return objeto ArrayList
	 */
	protected static <T> List<T> novoArrayList() {
		return getColecaoFactory().novoArrayList();
	}

	/**
	 * Retorna novo objeto HashMap.
	 * 
	 * @param <K> Tipo da chave
	 * @param <V> Tipo do valor
	 * @return objeto HashMap
	 */
	protected static <K, V> Map<K, V> novoHashMap() {
		return getColecaoFactory().novoHashMap();
	}

	/**
	 * Retorna novo integer.
	 * 
	 * @param valor valor
	 * @return integer
	 */
	protected static Integer novoInteger(int valor) {
		return getNumeroFactory().novoInteger(valor);
	}

	/**
	 * Retorna novo booleano.
	 * 
	 * @param valor valor
	 * @return booleano
	 */
	protected static Boolean novoBoolean(boolean valor) {
		return getBoleanoFactory().novoBoolean(valor);
	}

	/**
	 * Retorna novo domínio.
	 * 
	 * @param <K> Tipo do código.
	 * @param <D> Tipo da descrição.
	 * @param codigo Código
	 * @param descricao Descrição
	 * @return Domínio.
	 */
	protected static <K, D> DominioTO<K, D> novoDominio(K codigo, D descricao) {
		DominioTO<K, D> to = novoDominio();
		to.setCodigo(codigo);
		to.setDescricao(descricao);
		return to;
	}

	/**
	 * Retorna novo domínio.
	 * 
	 * @param <K> Tipo do código.
	 * @param <D> Tipo da descrição.
	 * @return Domínio.
	 */
	protected static <K, D> DominioTO<K, D> novoDominio() {
		return new DominioTO<K, D>();
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	protected static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna NumeroFactory.
	 * 
	 * @return NumeroFactory
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna BoleanoFactory.
	 * 
	 * @return BoleanoFactory
	 */
	protected static BoleanoFactory getBoleanoFactory() {
		return BoleanoFactory.getInstancia();
	}
}
