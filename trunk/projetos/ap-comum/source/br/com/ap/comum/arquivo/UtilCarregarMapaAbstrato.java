/*
 * UtilCarregarMapaAbstrato.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import br.com.ap.comum.excecao.ComumRuntimeException;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe responsável em ler um arquivo .properties e carregar um mapa com as
 * informações contidas no arquivo de propriedades.
 * 
 * @param <T> Tipo da origem de onde o mapa será criado. (Ex: properties, path
 *            de uma pasta)
 * @param <K> Tipo do objeto da chave do mapa.
 * @param <V> Tipo do objeto contido no mapa.
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public abstract class UtilCarregarMapaAbstrato<T, K, V> {

	/**
	 * Recupera um mapa com as informações da origem.
	 * 
	 * @param origem Origem das informações do mapa.
	 * @return Mapa com as informações contidas na origem dos dados.
	 * @throws ComumRuntimeException Exceção comum
	 */
	public abstract Map<K, V> getMapa(T origem);

	/**
	 * Recupera um mapa com as informações do properties.
	 * 
	 * @param properties Properties
	 * @return Mapa com as informações contidas no arquivo de propriedades.
	 * @throws ComumRuntimeException Exceção comum
	 */
	public Map<K, V> getMapa(Properties properties) {
		Map<K, V> mapa = getColecaoFactory().novoHashMap();

		if (isReferencia(properties)) {
			Enumeration<Object> chaves = properties.keys();
			while (chaves.hasMoreElements()) {
				String chave = (String) chaves.nextElement();
				String valor = properties.getProperty(chave);

				mapa.put(converterChave(chave), converterValor(valor));
			}
		}
		return mapa;
	}

	/**
	 * Converte a chave recuperada do arquivo de propriedades.
	 * 
	 * @param chave Chave do item recuperado do arquivo de propriedades.
	 * @return Objeto que será adicionado na chave do mapa.
	 * @throws ComumRuntimeException Exceção comum
	 */
	protected K converterChave(String chave) throws ComumRuntimeException {
		return (K) chave;
	}

	/**
	 * Converte o valor recuperado do arquivo de propriedades.
	 * 
	 * @param valor Valor do item recuperado do arquivo de propriedades.
	 * @return Objeto que será adicionado no valor do mapa.
	 * @throws ComumRuntimeException Exceção comum
	 */
	protected V converterValor(String valor) throws ComumRuntimeException {
		return (V) valor;
	}

	/**
	 * Verifica se o objeto tem referência.
	 * 
	 * @param obj objeto a ser verificado.
	 * @return true se o objeto tiver uma referência.
	 */
	protected boolean isReferencia(Object obj) {
		return UtilObjeto.isReferencia(obj);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String a ser validada.
	 * @return true se a string for vazia.
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
