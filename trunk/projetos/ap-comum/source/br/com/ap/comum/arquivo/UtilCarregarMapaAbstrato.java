/*
 * UtilCarregarMapaAbstrato.java
 * 
 * Data de cria��o: 25/06/2007
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
 * Classe respons�vel em ler um arquivo .properties e carregar um mapa com as
 * informa��es contidas no arquivo de propriedades.
 * 
 * @param <T> Tipo da origem de onde o mapa ser� criado. (Ex: properties, path
 *            de uma pasta)
 * @param <K> Tipo do objeto da chave do mapa.
 * @param <V> Tipo do objeto contido no mapa.
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public abstract class UtilCarregarMapaAbstrato<T, K, V> {

	/**
	 * Recupera um mapa com as informa��es da origem.
	 * 
	 * @param origem Origem das informa��es do mapa.
	 * @return Mapa com as informa��es contidas na origem dos dados.
	 * @throws ComumRuntimeException Exce��o comum
	 */
	public abstract Map<K, V> getMapa(T origem);

	/**
	 * Recupera um mapa com as informa��es do properties.
	 * 
	 * @param properties Properties
	 * @return Mapa com as informa��es contidas no arquivo de propriedades.
	 * @throws ComumRuntimeException Exce��o comum
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
	 * @return Objeto que ser� adicionado na chave do mapa.
	 * @throws ComumRuntimeException Exce��o comum
	 */
	protected K converterChave(String chave) throws ComumRuntimeException {
		return (K) chave;
	}

	/**
	 * Converte o valor recuperado do arquivo de propriedades.
	 * 
	 * @param valor Valor do item recuperado do arquivo de propriedades.
	 * @return Objeto que ser� adicionado no valor do mapa.
	 * @throws ComumRuntimeException Exce��o comum
	 */
	protected V converterValor(String valor) throws ComumRuntimeException {
		return (V) valor;
	}

	/**
	 * Verifica se o objeto tem refer�ncia.
	 * 
	 * @param obj objeto a ser verificado.
	 * @return true se o objeto tiver uma refer�ncia.
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
