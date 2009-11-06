/*
 * UtilCarregarMapaDeObjetos.java
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
import br.com.ap.comum.util.UtilComumRuntimeException;

/**
 * Classe utilit�ria respons�vel em ler o arquivo de propriedades em um mapa. O
 * properties � composto pela chave do tipo string e o valor do tipo path de
 * objeto, quando o properties for lido o valor ser� inst�nciado como objeto.<br>
 * Exemplo de um arquivo .properties<br>
 * <dd>integer=ap.com.ap.Integer<br> <dd>long=ap.com.ap.Long
 * 
 * @param <V> Tipo do objeto contido no valor do mapa.
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public class UtilCarregarMapaDeObjetos<V> extends
		UtilCarregarMapaAbstrato<Properties, String, V> {

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#getMapa(java.lang.Object)
	 */
	@Override
	public Map<String, V> getMapa(Properties origem) {
		Map<String, V> mapa = getColecaoFactory().novoHashMap();

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

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#converterValor(java.lang.String)
	 */
	@Override
	protected V converterValor(String valor) throws ComumRuntimeException {
		V instancia = null;
		try {
			Class<?> classe = Class.forName(valor);
			instancia = (V) classe.newInstance();
		} catch (Exception e) {
			throw UtilComumRuntimeException.erroAoCriarInstancia(valor);
		}
		return instancia;
	}
}
