/*
 * UtilComparadorAbstrato.java
 * 
 * Data de cria��o: 28/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que representa um comparador.<br>
 * Prov� recursos comuns a todos os comparadores.
 * 
 * @param <T> Tipo do objeto que ser� comparado.
 * @author AdrianoP
 */
public abstract class UtilComparadorAbstrato<T> {

	/**
	 * Retorna maior resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado. (Dever� ser do tipo
	 *            Comparable)
	 * @param array Array de objetos que ser�o comparados.
	 * @return Maior resultado da compara��o.
	 */
	protected static <T extends Comparable<T>> T getMaior(T[] array) {
		T res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMaior(res, array[i]);
				}
			}
		}
		return res;
	}

	/**
	 * Retorna maior resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado. (Dever� ser do tipo
	 *            Comparable)
	 * @param array Array de objetos que ser�o comparados.
	 * @return Maior resultado da compara��o.
	 */
	protected static <T extends Number> T getMaior(T[] array) {
		T res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMaior(res, array[i]);
				}
			}
		}
		return res;
	}

	/**
	 * Retorna maior resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param array Array de objetos que ser�o comparados.
	 * @return Maior resultado da compara��o.
	 */
	protected static String getMaior(String[] array) {
		String res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMaior(res, array[i]);
				}
			}
		}
		return res;
	}

	/**
	 * Retorna maior resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado. (Dever� ser do tipo
	 *            Comparable)
	 * @param array Array de objetos que ser�o comparados.
	 * @return Maior resultado da compara��o.
	 */
	protected static <T extends Number> T getMenor(T[] array) {
		T res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMenor(res, array[i]);
				}
			}
		}
		return res;
	}

	/**
	 * Retorna menor resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado. (Dever� ser do tipo
	 *            Comparable)
	 * @param array Array de objetos que ser�o comparados.
	 * @return Menor resultado da compara��o.
	 */
	protected static <T extends Comparable<T>> T getMenor(T[] array) {
		T res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMenor(res, array[i]);
				}
			}
		}
		return res;
	}

	/**
	 * Retorna maior resultado passado por par�metro. O crit�rio de maioridade
	 * ser� feita usando compara��o, sendo assim, todos os objetos que ser�o
	 * comparados dever�o implementar Comparable.
	 * 
	 * @param array Array de objetos que ser�o comparados.
	 * @return Maior resultado da compara��o.
	 */
	protected static String getMenor(String[] array) {
		String res = null;

		if (UtilArray.isArray(array)) {
			res = UtilArray.getElementoDoIndice(array, 0);
			if (UtilArray.getTamanho(array) > 1) {
				for (int i = 1; i < UtilArray.getTamanho(array); i++) {
					res = getMenor(res, array[i]);
				}
			}
		}
		return res;

	}

	/**
	 * @param string String que ser� validada.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazio(String)
	 */
	protected static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * @param string1 String que ser� validada.
	 * @param string2 String que ser� validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String)
	 */
	protected static boolean isVazio(String string1, String string2) {
		return UtilString.isVazio(string1, string2);
	}

	/**
	 * @param string1 String que ser� validada.
	 * @param string2 String que ser� validada.
	 * @param string3 String que ser� validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String, String)
	 */
	protected static boolean isVazio(String string1, String string2,
			String string3) {
		return UtilString.isVazio(string1, string2, string3);
	}

	/**
	 * @param objeto Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * @param objeto0 Objeto que ser� validado.
	 * @param objeto1 Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object, Object)
	 */
	protected static boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}

	/**
	 * Converte um primitivo em um integer.
	 * 
	 * @param _int Primitivo que ser� convertido.
	 * @return integer
	 */
	protected static Integer converterParaInteger(int _int) {
		return UtilConversorDeInteger.converterParaInteger(_int);
	}

	/**
	 * Retorna true se o objeto passado por par�metro � um tipo do tipo
	 * Comparable.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto passado por par�metro � um tipo do tipo
	 *         Comparable.
	 */
	private static boolean isComparable(Object objeto) {
		return UtilObjeto.isComparable(objeto);
	}

	/**
	 * Retorna o tamanho da string.
	 * 
	 * @param string String contada.
	 * @return tamanho da string.
	 */
	private static int getTamanho(String string) {
		return UtilString.getTamanho(string);
	}

	/**
	 * Compara os dois objetos e retorna o maior objeto dos dois passados por
	 * par�metro.
	 * 
	 * @param <T> Tipo do objeto.
	 * @param objeto0 Objeto prim�rio
	 * @param objeto1 Objeto secund�rio
	 * @return Maior objeto resultado da compara��o.
	 */
	@SuppressWarnings("unchecked")
	private static <T> T getMaior(T objeto0, T objeto1) {
		T resultado = null;

		if (isReferencia(objeto0, objeto1)) {
			if (isComparable(objeto0) && isComparable(objeto1)) {
				Comparable<T> c = (Comparable<T>) objeto0;
				resultado = (c.compareTo(objeto1) > 0 ? objeto0 : objeto1);
			}
		} else {
			resultado = UtilObjeto.getObjetoComReferencia(objeto0, objeto1);
		}
		return resultado;
	}

	/**
	 * Compara os dois objetos e retorna o menor objeto dos dois passados por
	 * par�metro.
	 * 
	 * @param <T> Tipo do objeto.
	 * @param objeto0 Objeto prim�rio
	 * @param objeto1 Objeto secund�rio
	 * @return Menor objeto resultado da compara��o.
	 */
	@SuppressWarnings("unchecked")
	private static <T> T getMenor(T objeto0, T objeto1) {
		T resultado = null;

		if (isReferencia(objeto0, objeto1)) {
			if (isComparable(objeto0) && isComparable(objeto1)) {
				Comparable<T> c = (Comparable<T>) objeto0;
				resultado = (c.compareTo(objeto1) < 0 ? objeto0 : objeto1);
			}
		} else {
			resultado = UtilObjeto.getObjetoComReferencia(objeto0, objeto1);
		}
		return resultado;
	}

	/**
	 * Compara os dois objetos e retorna o menor objeto dos dois passados por
	 * par�metro.
	 * 
	 * @param objeto0 Objeto prim�rio
	 * @param objeto1 Objeto secund�rio
	 * @return Menor objeto resultado da compara��o.
	 */
	private static String getMaior(String objeto0, String objeto1) {
		String resultado = null;

		if (isReferencia(objeto0, objeto1)) {
			resultado = (getTamanho(objeto0) > getTamanho(objeto1) ? objeto0
					: objeto1);
		} else {
			resultado = UtilObjeto.getObjetoComReferencia(objeto0, objeto1);
		}
		return resultado;
	}

	/**
	 * Compara os dois objetos e retorna o menor objeto dos dois passados por
	 * par�metro.
	 * 
	 * @param objeto0 Objeto prim�rio
	 * @param objeto1 Objeto secund�rio
	 * @return Menor objeto resultado da compara��o.
	 */
	private static String getMenor(String objeto0, String objeto1) {
		String resultado = null;

		if (isReferencia(objeto0, objeto1)) {
			resultado = (getTamanho(objeto0) < getTamanho(objeto1) ? objeto0
					: objeto1);
		} else {
			resultado = UtilObjeto.getObjetoComReferencia(objeto0, objeto1);
		}
		return resultado;
	}
}
