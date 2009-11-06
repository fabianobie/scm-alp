/*
 * UtilArray.java
 * 
 * Data de criação: 24/02/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.array;

import java.lang.reflect.Array;

import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.objeto.UtilPrimitivo;
import br.com.ap.comum.string.UtilString;

/**
 * Classe responsável em manipular arrays.
 * 
 * @author AdrianoP
 */
public final class UtilArray {

	/**
	 * Construtor.
	 */
	private UtilArray() {
		// Construtor.
	}

	/**
	 * Retorna true se o tipo do objeto for um array.
	 * 
	 * @param tipo tipo do objeto.
	 * @return true se o tipo do objeto for um array.
	 */
	public static boolean isArray(Object tipo) {
		boolean res = false;

		if (isReferencia(tipo)) {
			Class<?> classe = UtilObjeto.getClasse(tipo);
			res = classe.isArray();
		}
		return res;
	}

	/**
	 * Retorna true (é um array) se a string tiver sufixo "[]".
	 * 
	 * @param tipo tipo validado.
	 * @return true se o tipo for um tipo de array.
	 */
	public static boolean isArray(String tipo) {
		String sufixo = Constante.getSufixoArray();
		return (!isVazio(tipo) && tipo.endsWith(sufixo));
	}

	/**
	 * Retorna true se o array estiver vazio.
	 * 
	 * @param array Array validado
	 * @return true se o array estiver vazio.
	 */
	public static boolean isVazio(Object[] array) {
		return (isReferencia(array) && array.length == 0);
	}

	/**
	 * Recupera Array de um tipo array passado por parâmetro. O array criado tem
	 * por padrão tamanho 10.
	 * 
	 * @param <T> Tipo do array
	 * @param tipo tipo do array. Ex: java.lang.String[]
	 * @return Objeto de um tipo array.
	 * @throws ClassNotFoundException Classe não encontrada
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] novaInstanciaDeArray(String tipo)
			throws ClassNotFoundException {

		return (T[]) novaInstanciaDeArray(tipo, 10);
	}

	/**
	 * Recupera Array de um tipo array passado por parâmetro.
	 * 
	 * @param <T> Tipo do array
	 * @param tipo tipo do array. Ex: java.lang.String[]
	 * @param tamanho dimensão do array criado
	 * @return Objeto de um tipo array.
	 * @throws ClassNotFoundException classe não encontrada
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] novaInstanciaDeArray(String tipo, int tamanho)
			throws ClassNotFoundException {
		T[] res = null;

		if (!isVazio(tipo) && isArray(tipo)) {
			Class<?> result = Class.forName(getTipoDoArray(tipo));
			res = (T[]) Array.newInstance(result, tamanho);
		}
		return res;
	}

	/**
	 * Recupera Array de um tipo array passado por parâmetro.
	 * 
	 * @param <T> Tipo do array
	 * @param tipo tipo do array.
	 * @return Objeto de um tipo array.
	 * @throws ClassNotFoundException classe não encontrada
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] novaInstanciaDeArray(Class<?> tipo)
			throws ClassNotFoundException {
		T[] objeto = null;
		if (isArray(tipo)) {
			tipo = getTipoDoArray(tipo);
			if (UtilPrimitivo.isPrimitivo(tipo)) {
				tipo = UtilPrimitivo.getClasseWrapperDoPrimitivo(tipo);
			}
			String nome = UtilObjeto.getNome(tipo);
			nome += Constante.getSufixoArray();
			objeto = (T[]) novaInstanciaDeArray(nome, 10);
		}
		return objeto;
	}

	/**
	 * Cria o class de um tipo array passado por parâmetro.
	 * 
	 * @param tipo tipo do array. Ex: java.lang.String[]
	 * @return Class de um tipo array.
	 * @throws ClassNotFoundException classe não encontrada
	 */
	public static Class<?> novaClasseDeArray(String tipo)
			throws ClassNotFoundException {
		Object res = null;
		if (isArray(tipo)) {
			res = novaInstanciaDeArray(tipo);
		}
		return (res != null ? res.getClass() : null);
	}

	/**
	 * Retorna o tipo do array. Ex: se o tipo for java.lang.Integer[] será
	 * retornado java.lang.Integer.
	 * 
	 * @param tipo Array
	 * @return tipo do array
	 */
	public static Class<?> getTipoDoArray(Class<?> tipo) {
		Class<?> res = null;

		if (isReferencia(tipo)) {
			res = tipo.getComponentType();
			while (isArray(res)) {
				res = res.getComponentType();
			}
		}

		return res;
	}

	/**
	 * Retorna a string representativa do array. Exemplo: se for enviado
	 * java.lang.Integer será retornado java.lang.Integer[].
	 * 
	 * @param tipo Tipo do array.
	 * @return String representativa de array.
	 */
	public static String getString(Class<?> tipo) {
		String res = null;

		if (isArray(tipo)) {
			tipo = getTipoDoArray(tipo);
			res = tipo.getName();
			res += Constante.getSufixoArray();
		}

		return res;
	}

	/**
	 * Retorna o elemento do índice solicitado.
	 * 
	 * @param <T> Tipo do objeto contido no array.
	 * @param array Array
	 * @param indice Índice
	 * @return elemento do índice solicitado.
	 */
	public static <T> T getElementoDoIndice(T[] array, int indice) {
		T resultado = null;

		if (!isVazio(array) && indice >= 0 && indice < array.length) {
			resultado = array[indice];
		}
		return resultado;
	}

	/**
	 * Retorna o Tamanho do array.
	 * 
	 * @param <T> Tipo do objeto que compôe o array.
	 * @param array Array
	 * @return Tamanho do array.
	 */
	public static <T> int getTamanho(T[] array) {
		return (UtilObjeto.isReferencia(array) ? array.length : 0);
	}

	/**
	 * Retorna true se o tipo do array for um byte.
	 * 
	 * @param array Array validado
	 * @return true se o tipo do array for um byte.
	 */
	public static boolean isTipoArrayByte(Object array) {
		boolean res = false;

		if (isArray(array)) {
			Class<?> tipo = UtilObjeto.getClasse(array);
			tipo = getTipoDoArray(tipo);
			res = (tipo.isAssignableFrom(Byte.class) || tipo
					.isAssignableFrom(byte.class));
		}
		return res;
	}

	/**
	 * Aplica um alterador em cada objeto do array.
	 * 
	 * @param <T> Tipo do objeto que compôe o array.
	 * @param array Array de objetos.
	 * @param alterador Alterador de objetos
	 * @return Coleção com os objetos alterados.
	 */
	public static <T> T[] aplicarAlterador(T[] array, Alterador<T> alterador) {
		if (isReferencia(array, alterador)) {
			for (int indice = 0; indice < array.length; indice++) {
				array[indice] = alterador.alterar(array[indice]);
			}
		}

		return array;
	}

	/**
	 * Recupera a String do tipo do array passado por parâmetro.<br>
	 * Ex: Se passar java.lang.String[], retornará java.lang.String
	 * 
	 * @param tipo tipo do array.
	 * @return String do tipo passado por parâmetro.
	 */
	private static String getTipoDoArray(String tipo) {
		String res = null;

		if (isArray(tipo)) {
			res = UtilString.substring(tipo, 0, tipo.length() - 2);

			if (UtilPrimitivo.isPrimitivo(res)) {
				res = UtilPrimitivo.getNomeDaClasseDoWrapper(res);
			}
		}

		return res;
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String validada
	 * @return true se a string for vazia.
	 */
	private static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto1 Objeto validado.
	 * @param objeto2 Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto1, Object objeto2) {
		return UtilObjeto.isReferencia(objeto1, objeto2);
	}
}
