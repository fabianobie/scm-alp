/*
 * UtilPrimitivo.java 
 * 
 * Data de criação: 27/10/2006 
 * 
 *  
 * 
 */
package br.com.ap.comum.objeto;

import java.util.Map;

import br.com.ap.comum.conversor.UtilConversorDeBoolean;
import br.com.ap.comum.conversor.UtilConversorDeByte;
import br.com.ap.comum.conversor.UtilConversorDeCharacter;
import br.com.ap.comum.conversor.UtilConversorDeDouble;
import br.com.ap.comum.conversor.UtilConversorDeFloat;
import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.conversor.UtilConversorDeLong;
import br.com.ap.comum.conversor.UtilConversorDeShort;
import br.com.ap.comum.fabrica.ColecaoFactory;

/**
 * Classe utilitária responsável em provê auxílio à manipulação de tipos
 * primitivos e seus respectivos wrappers.
 * 
 * @author adrianop
 */
public final class UtilPrimitivo {

	/**
	 * Mapa onde a chave a um tipo primitivo e o valor é o seu respectivo
	 * wrapper.
	 */
	private static Map<Object, Object>	mapaPrimitivoWrapper;

	/**
	 * Mapa onde a chave é um wrapper e o seu valor é o seu respectivo
	 * primitivo.
	 */
	private static Map<Object, Object>	mapaWrapperPrimitivo;

	/**
	 * Mapa dos valores default dos tipos primitivos.
	 */
	private static Map<Object, Object>	mapaValorDefault;

	/**
	 * Construtor.
	 */
	private UtilPrimitivo() {
		// Construtor.
	}

	/**
	 * Retorna true se o type passado por parâmetro for um tipo primitivo.
	 * 
	 * @param tipo String do tipo primitivo. Ex: int
	 * @return true se o type passado por parâmetro for um tipo primitivo
	 */
	public static boolean isPrimitivo(String tipo) {
		return getMapaPrimitivoWrapper().containsKey(tipo);
	}

	/**
	 * Retorna true se o type passado por parâmetro for um tipo primitivo.
	 * 
	 * @param tipo Class do tipo primitivo. Ex: int.class
	 * @return true se o type passado por parâmetro for um tipo primitivo
	 */
	public static boolean isPrimitivo(Class<?> tipo) {
		boolean res = false;
		if (UtilObjeto.isReferencia(tipo)) {
			res = tipo.isPrimitive();
		}
		return res;
	}

	/**
	 * Retorna true se o type passado por parâmetro for um wrapper.
	 * 
	 * @param tipo Class do wrapper. Ex: Integer.class
	 * @return true se o type passado por parâmetro for um wrapper
	 */
	public static boolean isWrapper(Class<?> tipo) {
		return getMapaWrapperPrimitivo().containsKey(tipo);
	}

	/**
	 * Retorna true se o type passado por parâmetro for um wrapper.
	 * 
	 * @param tipo String do wrapper. Ex: java.lang.Integer
	 * @return true se o type passado por parâmetro for um wrapper
	 */
	public static boolean isWrapper(String tipo) {
		return getMapaWrapperPrimitivo().containsKey(tipo);
	}

	/**
	 * Retorna a classe wrapper do primitivo solicitado. <br>
	 * Ex: getWrapperDoPrimitivo(Integer.class) retorna int.class.
	 * 
	 * @param tipo Class do primitivo. Ex: int.class
	 * @return o objeto Class do tipo primitivo referênte ao wrapper solicitado
	 */
	public static Class<?> getClasseWrapperDoPrimitivo(Class<?> tipo) {
		Class<?> result = null;
		if (isPrimitivo(tipo)) {
			result = (Class<?>) getMapaPrimitivoWrapper().get(tipo);
		}
		return result;
	}

	/**
	 * Retorna a classe wrapper do primitivo solicitado. <br>
	 * Ex: getWrapperDoPrimitivo(Integer.class) retorna int.class.
	 * 
	 * @param tipo String do primitivo. Ex: int
	 * @return o objeto Class do tipo primitivo referênte ao wrapper solicitado
	 */
	public static Class<?> getClasseWrapperDoPrimitivo(String tipo) {
		Class<?> result = null;
		if (isPrimitivo(tipo)) {
			result = (Class<?>) getMapaPrimitivoWrapper().get(tipo);
		}
		return result;
	}

	/**
	 * Retorna o objeto Class do tipo primitivo referênte ao wrapper solicitado.
	 * 
	 * @param tipo String do primitivo. Ex: int
	 * @return o objeto Class do tipo primitivo referênte ao wrapper solicitado
	 */
	public static Class<?> getClassePrimitivoDoWrapper(String tipo) {
		Class<?> result = null;
		if (isWrapper(tipo)) {
			result = (Class<?>) getMapaWrapperPrimitivo().get(tipo);
		}
		return result;
	}

	/**
	 * Retorna o objeto Class do tipo primitivo referênte ao wrapper solicitado.
	 * 
	 * @param tipo Classe do wrapper. Ex: Integer.class
	 * @return o objeto Class do tipo primitivo referênte ao wrapper solicitado
	 */
	public static Class<?> getClassePrimitivoDoWrapper(Class<?> tipo) {
		Class<?> result = null;
		if (isWrapper(tipo)) {
			result = (Class<?>) getMapaWrapperPrimitivo().get(tipo);
		}
		return result;
	}

	/**
	 * Retorna o nome da classe wrapper do tipo primitivo solicitado. <br>
	 * Ex: getWrapperString("int") retorna 'java.lang.Integer'.
	 * 
	 * @param tipo String do tipo primitivo. Ex: int
	 * @return o nome da classe wrapper do tipo primitivo solicitado
	 */
	public static String getNomeDaClasseDoWrapper(String tipo) {
		String typeString = null;

		if (isPrimitivo(tipo)) {
			Class<?> wrapper = getClasseWrapperDoPrimitivo(tipo);
			if (UtilObjeto.isReferencia(wrapper)) {
				typeString = wrapper.getName();
			}
		}

		return typeString;
	}

	/**
	 * Retorna o tipo alternativo ao solicitado, ou seja, se for passado como
	 * parâmetro um int.class será retornado Integer.class, ou vice-versa.
	 * 
	 * @param tipo tipo primitivo ou wrapper.
	 * @return tipo alternativo ao passado por parâmetro.
	 */
	public static Class<?> getTipoAlternativo(Class<?> tipo) {
		Class<?> result = null;

		if (isPrimitivo(tipo)) {
			result = getClasseWrapperDoPrimitivo(tipo);
		} else if (isWrapper(tipo)) {
			result = getClassePrimitivoDoWrapper(tipo);
		}

		return result;
	}

	/**
	 * Retorna valor default do tipo primitivo passado por parâmetro.
	 * 
	 * @param type tipo primitivo. Ex: int.class
	 * @return valor default do tipo primitivo passado por parâmetro
	 */
	public static Object getValorDefault(Class<?> type) {
		Object result = null;
		if (isPrimitivo(type) || isWrapper(type)) {
			result = getMapaValorDefault().get(type);
		}
		return result;
	}

	/**
	 * Retorna valor default do tipo Byte.
	 * 
	 * @return valor default do tipo Byte.
	 */
	public static byte getValorDefaultByte() {
		Object objeto = getValorDefault(Byte.class);
		return UtilConversorDeByte.converterParaPrimitivo((Byte) objeto);
	}

	/**
	 * Retorna valor default do tipo Short.
	 * 
	 * @return valor default do tipo Short.
	 */
	public static short getValorDefaultShort() {
		Object objeto = getValorDefault(Short.class);
		return UtilConversorDeShort.converterParaPrimitivo((Short) objeto);
	}

	/**
	 * Retorna valor default do tipo int.
	 * 
	 * @return valor default do tipo int.
	 */
	public static int getValorDefaultInt() {
		Object objeto = getValorDefault(Integer.class);
		return UtilConversorDeInteger.converterParaPrimitivo((Integer) objeto);
	}

	/**
	 * Retorna valor default do tipo long.
	 * 
	 * @return valor default do tipo long.
	 */
	public static long getValorDefaultLong() {
		Object objeto = getValorDefault(Long.class);
		return UtilConversorDeLong.converterParaPrimitivo((Long) objeto);
	}

	/**
	 * Retorna valor default do tipo Char.
	 * 
	 * @return valor default do tipo Char.
	 */
	public static char getValorDefaultChar() {
		Object objeto = getValorDefault(Character.class);
		return UtilConversorDeCharacter
				.converterParaPrimitivo((Character) objeto);
	}

	/**
	 * Retorna valor default do tipo float.
	 * 
	 * @return valor default do tipo float.
	 */
	public static float getValorDefaultFloat() {
		Object objeto = getValorDefault(Float.class);
		return UtilConversorDeFloat.converterParaPrimitivo((Float) objeto);
	}

	/**
	 * Retorna valor default do tipo double.
	 * 
	 * @return valor default do tipo double.
	 */
	public static double getValorDefaultDouble() {
		Object objeto = getValorDefault(Double.class);
		return UtilConversorDeDouble.converterParaPrimitivo((Double) objeto);
	}

	/**
	 * Retorna valor default do tipo boolean.
	 * 
	 * @return valor default do tipo boolean.
	 */
	public static boolean getValorDefaultBoolean() {
		Object objeto = getValorDefault(Boolean.class);
		return UtilConversorDeBoolean.converterParaPrimitivo((Boolean) objeto);
	}

	/**
	 * Retorna mapPrimitiveWrapper.
	 * 
	 * @return Map
	 */
	private static Map<Object, Object> getMapaPrimitivoWrapper() {
		if (mapaPrimitivoWrapper == null) {
			mapaPrimitivoWrapper = getColecaoFactory().novoHashMap();
			mapaPrimitivoWrapper.put("byte", Byte.class);
			mapaPrimitivoWrapper.put("short", Short.class);
			mapaPrimitivoWrapper.put("int", Integer.class);
			mapaPrimitivoWrapper.put("long", Long.class);
			mapaPrimitivoWrapper.put("float", Float.class);
			mapaPrimitivoWrapper.put("double", Double.class);
			mapaPrimitivoWrapper.put("char", Character.class);
			mapaPrimitivoWrapper.put("boolean", Boolean.class);

			mapaPrimitivoWrapper.put(byte.class, Byte.class);
			mapaPrimitivoWrapper.put(short.class, Short.class);
			mapaPrimitivoWrapper.put(int.class, Integer.class);
			mapaPrimitivoWrapper.put(long.class, Long.class);
			mapaPrimitivoWrapper.put(float.class, Float.class);
			mapaPrimitivoWrapper.put(double.class, Double.class);
			mapaPrimitivoWrapper.put(char.class, Character.class);
			mapaPrimitivoWrapper.put(boolean.class, Boolean.class);
		}

		return mapaPrimitivoWrapper;
	}

	/**
	 * Retorna mapPrimitiveDefaultValue.
	 * 
	 * @return Map
	 */
	private static Map<Object, Object> getMapaValorDefault() {
		if (mapaValorDefault == null) {
			mapaValorDefault = getColecaoFactory().novoHashMap();

			mapaValorDefault.put("byte", new Byte("0"));
			mapaValorDefault.put("short", new Short("0"));
			mapaValorDefault.put("int", new Integer(0));
			mapaValorDefault.put("long", new Long(0));
			mapaValorDefault.put("float", new Float(0));
			mapaValorDefault.put("double", new Double(0.0));
			mapaValorDefault.put("char", new Character('\u0000'));
			mapaValorDefault.put("boolean", new Boolean(false));

			mapaValorDefault.put(byte.class, new Byte("0"));
			mapaValorDefault.put(short.class, new Short("0"));
			mapaValorDefault.put(int.class, new Integer(0));
			mapaValorDefault.put(long.class, new Long(0));
			mapaValorDefault.put(float.class, new Float(0));
			mapaValorDefault.put(double.class, new Double(0.0));
			mapaValorDefault.put(char.class, new Character('\u0000'));
			mapaValorDefault.put(boolean.class, new Boolean(false));

			mapaValorDefault.put(Byte.class, new Byte("0"));
			mapaValorDefault.put(Short.class, new Short("0"));
			mapaValorDefault.put(Integer.class, new Integer(0));
			mapaValorDefault.put(Long.class, new Long(0));
			mapaValorDefault.put(Float.class, new Float(0));
			mapaValorDefault.put(Double.class, new Double(0.0));
			mapaValorDefault.put(Character.class, new Character('\u0000'));
			mapaValorDefault.put(Boolean.class, new Boolean(false));
		}

		return mapaValorDefault;
	}

	/**
	 * Retorna mapWrapperPrimitive.
	 * 
	 * @return Map
	 */
	private static Map<Object, Object> getMapaWrapperPrimitivo() {
		if (mapaWrapperPrimitivo == null) {
			mapaWrapperPrimitivo = getColecaoFactory().novoHashMap();
			mapaWrapperPrimitivo.put(Byte.class, byte.class);
			mapaWrapperPrimitivo.put(Short.class, short.class);
			mapaWrapperPrimitivo.put(Integer.class, int.class);
			mapaWrapperPrimitivo.put(Long.class, long.class);
			mapaWrapperPrimitivo.put(Float.class, float.class);
			mapaWrapperPrimitivo.put(Double.class, double.class);
			mapaWrapperPrimitivo.put(Character.class, char.class);
			mapaWrapperPrimitivo.put(Boolean.class, boolean.class);

			mapaWrapperPrimitivo.put("java.lang.Byte", byte.class);
			mapaWrapperPrimitivo.put("java.lang.Short", short.class);
			mapaWrapperPrimitivo.put("java.lang.Integer", int.class);
			mapaWrapperPrimitivo.put("java.lang.Long", long.class);
			mapaWrapperPrimitivo.put("java.lang.Float", float.class);
			mapaWrapperPrimitivo.put("java.lang.Double", double.class);
			mapaWrapperPrimitivo.put("java.lang.Character", char.class);
			mapaWrapperPrimitivo.put("java.lang.Boolean", boolean.class);
		}

		return mapaWrapperPrimitivo;
	}

	/**
	 * @return instância de ColecaoFactory.
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
