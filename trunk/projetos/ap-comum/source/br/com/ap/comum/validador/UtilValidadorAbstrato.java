/*
 * UtilValidadorAbstrato.java
 * 
 * Data de cria��o: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que representa um validadores.<br>
 * Prov� recursos comuns a todos os validadores.
 * 
 * @author adrianop
 */
public abstract class UtilValidadorAbstrato {

	/**
	 * Retorna true se o primeiro objeto for maior que o segundo objeto.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado.
	 * @param objeto1 Primeiro objeto da compara��o.
	 * @param objeto2 Segundo objeto da compara��o.
	 * @return true se o primeiro objeto for maior que o segundo objeto.
	 */
	protected static <T extends Comparable<T>> boolean isPrimeiroObjetoMaior(
			T objeto1, T objeto2) {
		boolean resultado = false;

		if (isReferencia(objeto1, objeto2)) {
			resultado = objeto1.compareTo(objeto2) > 0;
		}
		return resultado;
	}

	/**
	 * Retorna true se o primeiro objeto for maior ou igual que o segundo
	 * objeto.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado.
	 * @param objeto1 Primeiro objeto da compara��o.
	 * @param objeto2 Segundo objeto da compara��o.
	 * @return true se o primeiro objeto for maior ou igual que o segundo
	 *         objeto.
	 */
	protected static <T extends Comparable<T>> boolean isPrimeiroObjetoMaiorOuIgual(
			T objeto1, T objeto2) {
		boolean resultado = false;

		if (isReferencia(objeto1, objeto2)) {
			resultado = objeto1.compareTo(objeto2) >= 0;
		}
		return resultado;
	}

	/**
	 * Retorna true se o primeiro objeto for maior que o segundo objeto.
	 * 
	 * @param <T> Tipo do objeto que ser� comparado.
	 * @param objeto1 Primeiro objeto da compara��o.
	 * @param objeto2 Segundo objeto da compara��o.
	 * @return true se o primeiro objeto for maior que o segundo objeto.
	 */
	protected static <T extends Comparable<T>> boolean isObjetosIguais(
			T objeto1, T objeto2) {
		boolean resultado = false;

		if (isReferencia(objeto1, objeto2)) {
			resultado = (objeto1.compareTo(objeto2) == 0);
		}
		return resultado;
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
	 * @param objeto Objeto que ser� validado.
	 * @param objeto2 Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected static boolean isReferencia(Object objeto, Object objeto2) {
		return UtilObjeto.isReferencia(objeto, objeto2);
	}

	/**
	 * @param objeto Objeto que ser� validado.
	 * @param objeto2 Objeto que ser� validado.
	 * @param objeto3 Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected static boolean isReferencia(Object objeto, Object objeto2,
			Object objeto3) {
		return UtilObjeto.isReferencia(objeto, objeto2, objeto3);
	}

	/**
	 * Retorna true se os objetos validados s�o de um tipo comparable.
	 * 
	 * @param <T> Tipo do objeto validado.
	 * @param objetos Objetos validados
	 * @return true se os objetos validados s�o de um tipo comparable.
	 */
	protected static <T> boolean isComparable(T... objetos) {
		boolean resultado = false;
		if (UtilArray.getTamanho(objetos) > 0) {
			resultado = true;
			for (int indice = 0; (indice < objetos.length)
					&& (resultado == true); indice++) {
				resultado = UtilObjeto.isComparable(objetos[indice]);

			}
		}
		return resultado;
	}

	/**
	 * Retorna DataFactory.
	 * 
	 * @return DataFactory
	 */
	protected static DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna NumeroFactory.
	 * 
	 * @return NumeroFactory
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}
}
