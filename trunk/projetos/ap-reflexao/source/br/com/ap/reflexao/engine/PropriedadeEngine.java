/*
 * PropriedadeEngine.java
 * 
 * Data de cria��o: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Classe respons�vel pela manipula��o dos atributos de uma classe.
 * 
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public class PropriedadeEngine extends EngineAbstrato {

	/**
	 * Retorna o valor de uma propriedade do objeto passado por par�metro.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @return valor de uma propriedade do objeto passado por par�metro.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public <T> T get(Object objeto, String propriedade)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		T resultado = null;

		if (isReferencia(objeto) && !isVazio(propriedade)) {
			resultado = (T) PropertyUtils.getProperty(objeto, propriedade);
		}
		return resultado;
	}

	/**
	 * Retorna o valor de uma propriedade do objeto passado por par�metro. A
	 * propriedade dever� ser uma lista.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @param indice
	 *            �ndice da lista.
	 * @return valor de uma propriedade do objeto passado por par�metro.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public <T> T getEmPropriedadeIndexada(Object objeto, String propriedade,
			int indice) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		T resultado = null;

		if (isReferencia(objeto) && !isVazio(propriedade)) {
			resultado = (T) PropertyUtils.getIndexedProperty(objeto,
					propriedade, indice);
		}
		return resultado;
	}

	/**
	 * Retorna o valor de uma propriedade do objeto passado por par�metro. A
	 * propriedade dever� ser um mapa.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @param chave
	 *            Chave do mapa.
	 * @return valor de uma propriedade do objeto passado por par�metro.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public <T> T getEmPropriedadeMapeada(Object objeto, String propriedade,
			String chave) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		T resultado = null;

		if (isReferencia(objeto) && !isVazio(propriedade, chave)) {
			resultado = (T) PropertyUtils.getMappedProperty(objeto,
					propriedade, chave);
		}
		return resultado;
	}

	/**
	 * Atribui um valor � propriedade do objeto.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor ser� atribu�do.
	 * @param valor
	 *            Objeto que ser� atribu�do na propriedade.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void set(Object objeto, String propriedade, Object valor)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		if (isReferencia(objeto) && !isVazio(propriedade)) {
			PropertyUtils.setProperty(objeto, propriedade, valor);
		}
	}

	/**
	 * Atribui um objeto ao indice da lista.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor ser� atribu�do.
	 * @param indice
	 *            �ndice da lista da propriedade.
	 * @param valor
	 *            Valor que ser� adicionado na lista.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void setEmPropriedadeIndexada(Object objeto, String propriedade,
			int indice, Object valor) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		if (isReferencia(objeto) && !isVazio(propriedade)) {
			PropertyUtils
					.setIndexedProperty(objeto, propriedade, indice, valor);
		}
	}

	/**
	 * Atribui um objeto � chave do mapa.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor ser� atribu�do.
	 * @param chave
	 *            Chave do mapa.
	 * @param valor
	 *            Valor que ser� adicionado no mapa.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void setEmPropriedadeMapeada(Object objeto, String propriedade,
			String chave, Object valor) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		if (isReferencia(objeto) && !isVazio(propriedade, chave)) {
			PropertyUtils.setMappedProperty(objeto, propriedade, chave, valor);
		}
	}

	/**
	 * Retorna o tipo da propriedade solicitada.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @return tipo da propriedade solicitada.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Class<?> getTipoDaPropriedade(Object objeto, String propriedade)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Class<?> resultado = null;

		if (isReferencia(objeto) && !isVazio(propriedade)) {
			resultado = PropertyUtils.getPropertyType(objeto, propriedade);
		}
		return resultado;
	}

	/**
	 * Limpa o cache de metodos.
	 */
	public void limparCache() {
		PropertyUtils.clearDescriptors();
	}

	/**
	 * Copia as propriedades de um objeto para outro.
	 * 
	 * @param origem
	 *            Objeto de origem.
	 * @param destino
	 *            Objeto de destino.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void copiarPropriedades(Object origem, Object destino)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		if (isReferencia(origem, destino)) {
			PropertyUtils.copyProperties(destino, origem);
		}
	}

	/**
	 * Retorna o mapa de propriedades/objetos do objeto solicitado.
	 * 
	 * @param objeto
	 *            Objeto.
	 * @return Mapa contendo as propriedades e objetos.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Map<String, ?> getMapaDePropriedades(Object objeto)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map<String, ?> resultado = getColecaoFactory().novoHashMap();

		if (isReferencia(objeto)) {
			resultado = PropertyUtils.describe(objeto);
		}
		return resultado;
	}
}
