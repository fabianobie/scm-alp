/*
 * UtilObjeto.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.objeto;

import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilitária responsável em manipular objetos.
 * 
 * @author adrianop
 */
public final class UtilObjeto {

	/**
	 * Construtor.
	 */
	private UtilObjeto() {
		// Construtor.
	}

	/**
	 * Retorna o nome do objeto passado por parâmetro.<br>
	 * Exemplo: <br>
	 * <dd>getNome(new Integer) = java.lang.Integer<br> <dd>
	 * getNome(Integer.class) = java.lang.Integer<br> <dd>
	 * getNome(Integer[].class) = java.lang.Integer[]<br>
	 * 
	 * @param objeto Objeto validado.
	 * @return nome do objeto.
	 */
	public static String getNome(Object objeto) {
		String res = null;

		if (isReferencia(objeto)) {
			res = getNomeDoObjeto(objeto);
			res = getNomeDoArray(res, objeto);
		}
		return res;
	}

	/**
	 * Retorna o nome sem o pacote do objeto passado por parâmetro.<br>
	 * Exemplo: <br>
	 * <dd>getNome(new Integer) = Integer<br> <dd>getNome(Integer.class) =
	 * Integer<br> <dd>getNome(Integer[].class) = Integer[]<br>
	 * 
	 * @param objeto Objeto validado.
	 * @return nome do objeto.
	 */
	public static String getNomeSemPacote(Object objeto) {
		String res = getNome(objeto);

		if (isReferencia(res) && UtilString.isTemString(res, ".")) {
			res = UtilString.substring(res, res.lastIndexOf(".") + 1);
		}
		return res;
	}

	/**
	 * Retorna a classe do objeto.
	 * 
	 * @param <T> Tipo do objeto da classe.
	 * @param objeto Objeto
	 * @return Classe
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClasse(T objeto) {
		Class<T> classe = null;

		if (isReferencia(objeto)) {
			if (isClasse(objeto)) {
				classe = (Class<T>) objeto;
			} else {
				classe = (Class<T>) objeto.getClass();
			}
		}
		return classe;
	}

	/**
	 * Retorna o primeiro objeto com referência do array de objetos.
	 * 
	 * @param <T> Tipo de objeto contido no array.
	 * @param objetos Array de objetos.
	 * @return primeiro objeto com referência do array de objetos.
	 */
	public static <T> T getObjetoComReferencia(T... objetos) {
		T resultado = null;

		if (isReferencia(objetos)) {
			for (int indice = 0; indice < objetos.length
					&& !isReferencia(resultado); indice++) {
				resultado = objetos[indice];
			}
		}
		return resultado;
	}

	/**
	 * Retorna true se o objeto é uma referência.
	 * 
	 * @param objeto Objeto
	 * @return true se o objeto é uma referência.
	 */
	public static boolean isReferencia(Object objeto) {
		return (objeto != null);
	}

	/**
	 * Retorna true se o objeto é uma referência.
	 * 
	 * @param objeto1 Objeto
	 * @param objeto2 Objeto
	 * @return true se o objeto é uma referência.
	 */
	public static boolean isReferencia(Object objeto1, Object objeto2) {
		return (isReferencia(objeto1) && isReferencia(objeto2));
	}

	/**
	 * Retorna true se o objeto é uma referência.
	 * 
	 * @param objeto1 Objeto
	 * @param objeto2 Objeto
	 * @param objeto3 Objeto
	 * @return true se o objeto é uma referência.
	 */
	public static boolean isReferencia(Object objeto1, Object objeto2,
			Object objeto3) {
		return (isReferencia(objeto1, objeto2) && isReferencia(objeto3));
	}

	/**
	 * Retorna true se o objeto é uma referência.
	 * 
	 * @param objetos Objetos
	 * @return true se o objeto é uma referência.
	 */
	public static boolean isReferenciaTodos(Object... objetos) {
		boolean res = false;

		if (isReferencia(objetos)) {
			res = true;
			for (int idx = 0; idx < objetos.length && (res == true); idx++) {
				res = isReferencia(objetos[idx]);
			}
		}
		return res;
	}

	/**
	 * Retorna true se o tipo for uma coleção.
	 * 
	 * @param objeto objeto que será validado.
	 * @return true se o tipo for uma coleção.
	 */
	public static boolean isColecao(Object objeto) {
		return (objeto instanceof Collection);
	}

	/**
	 * Retorna true se o tipo for uma coleção.
	 * 
	 * @param classe Classe que será validada.
	 * @return true se o tipo for uma coleção.
	 */
	public static boolean isColecao(Class<?> classe) {
		Class<?> colecao = Collection.class;
		return (isReferencia(classe) && colecao.isAssignableFrom(classe));
	}

	/**
	 * Retorna true se o tipo for um Comparable.
	 * 
	 * @param objeto Objeto que será validado.
	 * @return true se o tipo for um Comparable.
	 */
	public static boolean isComparable(Object objeto) {
		return (objeto instanceof Comparable<?>);
	}

	/**
	 * Retorna true se o tipo for um Comparable.
	 * 
	 * @param classe Classe que será validada.
	 * @return true se o tipo for um Comparable.
	 */
	public static boolean isComparable(Class<?> classe) {
		Class<?> colecao = Comparable.class;
		return (isReferencia(classe) && colecao.isAssignableFrom(classe));
	}

	/**
	 * Retorna true se o tipo for um mapa.
	 * 
	 * @param objeto objeto que será validado.
	 * @return true se o tipo for um mapa.
	 */
	public static boolean isMapa(Object objeto) {
		return (objeto instanceof Map);
	}

	/**
	 * Retorna true se o tipo for um mapa.
	 * 
	 * @param classe Classe que será validada.
	 * @return true se o tipo for um mapa.
	 */
	public static boolean isMapa(Class<?> classe) {
		Class<?> mapa = Map.class;
		return (isReferencia(classe) && mapa.isAssignableFrom(classe));
	}

	/**
	 * Retorna true se o objeto for uma classe.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for uma classe.
	 */
	public static boolean isClasse(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Class));
	}

	/**
	 * Retorna true se o objeto for um integer.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um integer
	 */
	public static boolean isInteger(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Integer));
	}

	/**
	 * Retorna true se o objeto for um long.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um long
	 */
	public static boolean isLong(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Long));
	}

	/**
	 * Retorna true se o objeto for um Boolean.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Boolean
	 */
	public static boolean isBoolean(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Boolean));
	}

	/**
	 * Retorna true se o objeto for um Byte.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Byte
	 */
	public static boolean isByte(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Byte));
	}

	/**
	 * Retorna true se o objeto for um Short.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Short
	 */
	public static boolean isShort(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Short));
	}

	/**
	 * Retorna true se o objeto for um Character.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Character
	 */
	public static boolean isCharacter(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Character));
	}

	/**
	 * Retorna true se o objeto for um Float.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Float
	 */
	public static boolean isFloat(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Float));
	}

	/**
	 * Retorna true se o objeto for um Double.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Double
	 */
	public static boolean isDouble(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Double));
	}

	/**
	 * Retorna true se o objeto for um String.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um String
	 */
	public static boolean isString(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof String));
	}

	/**
	 * Retorna true se o objeto for um Date.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Date
	 */
	public static boolean isDate(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Date));
	}

	/**
	 * Retorna true se o objeto for um java.sql.Date.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um java.sql.Date
	 */
	public static boolean isSqlDate(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof java.sql.Date));
	}

	/**
	 * Retorna true se o objeto for um Time.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Time
	 */
	public static boolean isTime(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Time));
	}

	/**
	 * Retorna true se o objeto for um Timestamp.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Timestamp
	 */
	public static boolean isTimestamp(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Timestamp));
	}

	/**
	 * Retorna true se o objeto for um Reader.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto for um Reader
	 */
	public static boolean isReader(Object objeto) {
		return (isReferencia(objeto) && (objeto instanceof Reader));
	}

	/**
	 * Retorna true se o objeto for um big decimal
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for um big decimal
	 */
	public static boolean isBigDecimal(Object objeto) {
		return (objeto instanceof BigDecimal);
	}

	/**
	 * Retorna true se o objeto for do tipo informado.
	 * 
	 * @param objeto Objeto validado.
	 * @param tipo Tipo desejado
	 * @return true se o objeto for do tipo informado.
	 */
	public static boolean isObjetoDoTipo(Object objeto, Class<?> tipo) {
		boolean res = false;

		if (isReferencia(objeto, tipo)) {
			Class<?> classe = getClasse(objeto);
			res = tipo.isAssignableFrom(classe);
		}
		return res;
	}

	/**
	 * Retorna o nome de um objeto que é um array.
	 * 
	 * @param nome Nome validado.
	 * @param objeto Array
	 * @return Nome do array
	 */
	private static String getNomeDoArray(String nome, Object objeto) {
		String res = nome;

		if (UtilString.isVazio(nome) && isReferencia(objeto)
				&& isArray(objeto)) {
			res = UtilArray.getString(getClasse(objeto));
		}
		return res;
	}

	/**
	 * Retorna o nome de um objeto que é um Object.
	 * 
	 * @param objeto Objeto
	 * @return Nome do objeto
	 */
	private static String getNomeDoObjeto(Object objeto) {
		String res = null;

		if (isReferencia(objeto) && !isArray(objeto)) {
			res = getClasse(objeto).getName();
		}
		return res;
	}

	/**
	 * Retorna true se o objeto for um array.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for um array.
	 */
	private static boolean isArray(Object objeto) {
		return UtilArray.isArray(objeto);
	}

}
