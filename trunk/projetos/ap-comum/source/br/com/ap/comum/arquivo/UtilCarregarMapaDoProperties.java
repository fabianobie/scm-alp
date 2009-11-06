/*
 * UtilCarregarMapaDoProperties.java
 * 
 * Data de criação: 27/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Classe utilitária responsável em carregar o texto de todos os arquivos de uma
 * pasta definida. O mapa é composto pelo nome do arquivo como chave e o texto
 * do arquivo como valor da chave do mapa.<br>
 * 
 * @param <K> Tipo do objeto da chave do mapa.
 * @param <V> Tipo do objeto contido no mapa.
 * @author adrianop
 */
public class UtilCarregarMapaDoProperties<K, V> extends
		UtilCarregarMapaAbstrato<Properties, K, V> {

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#getMapa(java.lang.Object)
	 */
	@Override
	public Map<K, V> getMapa(Properties origem) {
		Map<K, V> mapa = getColecaoFactory().novoHashMap();

		if (isReferencia(origem)) {
			Enumeration<Object> chaves = origem.keys();
			while (chaves.hasMoreElements()) {
				String chave = (String) chaves.nextElement();
				String valor = origem.getProperty(chave);

				mapa.put(converterChave(chave), converterValor(valor));
			}
		}
		return mapa;
	}

}
