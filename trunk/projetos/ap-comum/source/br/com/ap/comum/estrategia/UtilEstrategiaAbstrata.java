/*
 * UtilEstrategiaAbstrata.java
 * 
 * Data de cria��o: 30/06/2008
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
 * Classe que implementa a estrutura necess�ria para manipula��o de estrat�gias.
 * 
 * @param <K> Tipo do objeto da chave do mapa de estrat�gias.
 * @param <V> Tipo do objeto do objeto do mapa de estrat�gias.
 * @author adrianop
 */
public abstract class UtilEstrategiaAbstrata<K, V> {

	private Map<K, V>	mapaDeEstrategias;

	/**
	 * Adiciona uma estrat�gia no mapa.
	 * 
	 * @param chave Chave da estrat�gia.
	 * @param valor Objeto que representa a estrat�gia.
	 */
	public void adicionar(K chave, V valor) {
		if (isReferencia(chave, valor)) {
			getMapaDeEstrategias().put(chave, valor);
		}
	}

	/**
	 * Altera uma estrat�gia do mapa.
	 * 
	 * @param chave Chave da estrat�gia.
	 * @param valor Objeto que representa a estrat�gia.
	 */
	public void alterar(K chave, V valor) {
		adicionar(chave, valor);
	}

	/**
	 * Remove uma estrat�gia do mapa.
	 * 
	 * @param chave Chave da estrat�gia.
	 * @return Estrat�gia removida.
	 */
	public V remover(K chave) {
		V valor = null;
		if (isExiste(chave)) {
			valor = getMapaDeEstrategias().remove(chave);
		}
		return valor;
	}

	/**
	 * Retorna a estrat�gia solicitada.
	 * 
	 * @param chave Chave da estrat�gia que deseja recuperar.
	 * @return estrat�gia solicitada.
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
	 * Retorna true se a chave da estrat�gia existir.
	 * 
	 * @param chave Chave da estrat�gia
	 * @return true se a chave da estrat�gia existir.
	 */
	public boolean isExiste(K chave) {
		return getMapaDeEstrategias().containsKey(chave);
	}

	/**
	 * Retorna o mapa de estrat�gias.
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
	 * Carrega o mapa de estrat�gia.
	 * 
	 * @return mapa de estrat�gia.
	 */
	protected abstract Map<K, V> carregarDadosDaEstrategia();

	/**
	 * @return estrat�gia padr�o.
	 */
	protected abstract V getEstrategiaPadrao();

	/**
	 * Retorna true se o objeto tiver refer�ncia.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto tiver refer�ncia.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto tiver refer�ncia.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @return true se o objeto tiver refer�ncia.
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
	 * @return f�brica de objetos IO.
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}
}
