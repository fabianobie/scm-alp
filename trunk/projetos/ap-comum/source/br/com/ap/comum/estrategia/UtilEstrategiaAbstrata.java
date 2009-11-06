/*
 * UtilEstrategiaAbstrata.java
 * 
 * Data de criação: 30/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.estrategia;

import java.util.Map;

import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe que implementa a estrutura necessária para manipulação de estratégias.
 * 
 * @param <K> Tipo do objeto da chave do mapa de estratégias.
 * @param <V> Tipo do objeto do objeto do mapa de estratégias.
 * @author adrianop
 */
public abstract class UtilEstrategiaAbstrata<K, V> {

	private Map<K, V>	mapaDeEstrategias;

	/**
	 * Adiciona uma estratégia no mapa.
	 * 
	 * @param chave Chave da estratégia.
	 * @param valor Objeto que representa a estratégia.
	 */
	public void adicionar(K chave, V valor) {
		if (isReferencia(chave, valor)) {
			getMapaDeEstrategias().put(chave, valor);
		}
	}

	/**
	 * Altera uma estratégia do mapa.
	 * 
	 * @param chave Chave da estratégia.
	 * @param valor Objeto que representa a estratégia.
	 */
	public void alterar(K chave, V valor) {
		adicionar(chave, valor);
	}

	/**
	 * Remove uma estratégia do mapa.
	 * 
	 * @param chave Chave da estratégia.
	 * @return Estratégia removida.
	 */
	public V remover(K chave) {
		V valor = null;
		if (isExiste(chave)) {
			valor = getMapaDeEstrategias().remove(chave);
		}
		return valor;
	}

	/**
	 * Retorna a estratégia solicitada.
	 * 
	 * @param chave Chave da estratégia que deseja recuperar.
	 * @return estratégia solicitada.
	 */
	public V recuperar(K chave) {
		V estrategia = null;
		if (!isReferencia(chave) || !isExiste(chave)) {
			estrategia = getEstrategiaPadrao();
		} else {
			estrategia = getMapaDeEstrategias().get(chave);
		}
		return estrategia;
	}

	/**
	 * Retorna true se a chave da estratégia existir.
	 * 
	 * @param chave Chave da estratégia
	 * @return true se a chave da estratégia existir.
	 */
	public boolean isExiste(K chave) {
		return getMapaDeEstrategias().containsKey(chave);
	}

	/**
	 * Retorna o mapa de estratégias.
	 * 
	 * @return mapaDeEstrategias
	 */
	public Map<K, V> getMapaDeEstrategias() {
		if (!isReferencia(mapaDeEstrategias)) {
			mapaDeEstrategias = carregarDadosDaEstrategia();
		}
		return mapaDeEstrategias;
	}

	/**
	 * Carrega o mapa de estratégia.
	 * 
	 * @return mapa de estratégia.
	 */
	protected abstract Map<K, V> carregarDadosDaEstrategia();

	/**
	 * @return estratégia padrão.
	 */
	protected abstract V getEstrategiaPadrao();

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}

	/**
	 * Retorna true se o objeto estiver vazio.
	 * 
	 * @param string String validado
	 * @return true se o objeto estiver vazio.
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * @return fábrica de objetos IO.
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}
}
