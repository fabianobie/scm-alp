/*
 * UtilConversorDeString.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.constante.Booleano;
import br.com.ap.comum.constante.pattern.PatternDeData;
import br.com.ap.comum.numerico.UtilNumero;
import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo String.
 * 
 * @author adrianop
 */
public final class UtilConversorDeString extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeString() {
		// Construtor
	}

	/**
	 * Converte S ou N para booleano.
	 * 
	 * @param string String validada.
	 * @return true se a string for S.
	 */
	public static boolean converterSimNaoParaBooleano(String string) {
		boolean res = false;

		if (!isVazio(string)
				&& UtilString.isTemString(string, Booleano.getSim())) {
			res = true;
		}
		return res;
	}

	/**
	 * Converte uma string em um BigDecimal.
	 * 
	 * @param valor O valor que se deseja converter
	 * @param precisao O valor da precisão das casas decimais
	 * @return O bigDecimal com a precisão desejada
	 */
	public static BigDecimal converterParaBigDecimal(String valor, int precisao) {

		BigDecimal bigDecimal = null;
		String valorSemMascara = UtilString.remover(valor, "[.,]");
		if (UtilNumero.isInteiro(valorSemMascara)) {
			bigDecimal = getNumeroFactory().novoBigDecimal(valorSemMascara,
					precisao);
		}
		return bigDecimal;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static int converterParaInt(String string) {
		Integer res = converterParaInteger(string);

		if (!isReferencia(res)) {
			res = (Integer) getValorDefault(Integer.class);
		}
		return res.intValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Integer converterParaInteger(String string) {
		Integer res = null;

		if (!isVazio(string)) {
			try {
				res = getNumeroFactory().novoInteger(string);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "Integer"));
			}
		}
		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static long converterParaLong(String string) {
		Long res = converterParaLongWrapper(string);

		if (!isReferencia(res)) {
			res = (Long) getValorDefault(Long.class);
		}
		return res.longValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Long converterParaLongWrapper(String string) {
		Long res = null;

		if (!isVazio(string)) {
			try {
				res = getNumeroFactory().novoLong(string);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "Long"));
			}
		}
		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static boolean converterParaBoolean(String string) {
		Boolean res = converterParaBooleanWrapper(string);

		if (!isReferencia(res)) {
			res = (Boolean) getValorDefault(Boolean.class);
		}
		return res.booleanValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertida.
	 * @return tipo Boolean.
	 */
	public static Boolean converterParaBooleanWrapper(String string) {
		Boolean res = null;

		if (!isVazio(string)) {
			res = getBoleanoFactory().novoBoolean(string);
		}

		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static byte converterParaByte(String string) {
		Byte res = converterParaByteWrapper(string);

		if (!isReferencia(res)) {
			res = (Byte) getValorDefault(Byte.class);
		}
		return res.byteValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Byte converterParaByteWrapper(String string) {
		Byte result = null;

		if (!isVazio(string)) {
			try {
				result = getNumeroFactory().novoByte(string);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "byte"));
			}
		}
		return result;
	}

	/**
	 * Converte uma string em um byte[].
	 * 
	 * @param string String que será convertida
	 * @return array de bytes
	 */
	public static byte[] converterParaByteArray(String string) {
		return UtilString.getBytes(string);
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static short converterParaShort(String string) {
		Short res = converterParaShortWrapper(string);

		if (!isReferencia(res)) {
			res = (Short) getValorDefault(Short.class);
		}
		return res.shortValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Short converterParaShortWrapper(String string) {
		Short res = null;

		if (!isVazio(string)) {
			try {
				res = getNumeroFactory().novoShort(string);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "Short"));
			}
		}
		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static char converterParaChar(String string) {
		Character res = converterParaCharacter(string);

		if (!isReferencia(res)) {
			res = (Character) getValorDefault(Character.class);
		}
		return res.charValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo wrapper
	 */
	public static Character converterParaCharacter(String string) {
		Character res = null;

		if (!isVazio(string)) {
			try {
				char _char = string.charAt(0);
				res = new Character(_char);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "Character"));
			}
		}
		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static float converterParaFloat(String string) {
		Float res = converterParaFloatWrapper(string);

		if (!isReferencia(res)) {
			res = (Float) getValorDefault(Float.class);
		}
		return res.floatValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo wrapper.
	 */
	public static Float converterParaFloatWrapper(String string) {
		Float res = null;

		if (!isVazio(string)) {
			try {
				res = getNumeroFactory().novoFloat(string);
			} catch (NumberFormatException e) {
				getLog().warn(getMensagemErroDeConversao(string, "Float"));
			}
		}
		return res;
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo primitivo.
	 */
	public static double converterParaDouble(String string) {
		return converterParaDoubleWrapper(string).doubleValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param string String que será convertida.
	 * @return tipo wrapper.
	 */
	public static Double converterParaDoubleWrapper(String string) {
		Double res = (Double) getValorDefault(Double.class);

		if (!isVazio(string)) {
			res = parseDeNumeroFormatoEstrangeiro(string);
			res = parseDeNumeroFormatoBrasileiro(res, string);
		}
		return res;
	}

	/**
	 * Converte uma string em um Reader.
	 * 
	 * @param string String que será convertida
	 * @return Reader
	 */
	public static Reader converterParaReader(String string) {
		return UtilString.getReader(string);
	}

	/**
	 * Converte a string no formato definido para um date.
	 * 
	 * @param string String que será convertida.
	 * @param pattern Padrão em que a string se encontra.
	 * @return Objeto Date
	 */
	public static Date converterParaData(String string, String pattern) {
		return parseDeData(string, pattern);
	}

	/**
	 * Converte a string no formato dd/MM/yyyy para um date.
	 * 
	 * @param string String no formato dd/MM/yyyy
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyy(String string) {
		String pattern = PatternDeData.getddMMyyyy();
		return parseDeData(string, pattern);
	}

	/**
	 * Converte a string no formato dd/MM/yyyy hh:mm para um date.
	 * 
	 * @param string String no formato dd/MM/yyyy hh:mm.
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyyEspacohhmm(String string) {
		String pattern = PatternDeData.getddMMyyyyEspacohhmm();
		return parseDeData(string, pattern);
	}

	/**
	 * Converte a string no formato dd/MM/yyyy HH:mm para um date.
	 * 
	 * @param string String no formato dd/MM/yyyy HH:mm.
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyyEspacoHHmm(String string) {
		String pattern = PatternDeData.getddMMyyyyEspacoHHmm();
		return parseDeData(string, pattern);
	}

	/**
	 * Converte a string no formato dd/MM/yyyy hh:mm:ss para um date.
	 * 
	 * @param value String no formato dd/MM/yyyy hh:mm:ss.
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyyEspacohhmmss(String value) {
		String pattern = PatternDeData.getddMMyyyyEspacohhmmss();
		return parseDeData(value, pattern);
	}

	/**
	 * Converte a string no formato dd/MM/yyyy HH:mm:ss para um date.
	 * 
	 * @param value String no formato dd/MM/yyyy HH:mm:ss.
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyyEspacoHHmmss(String value) {
		String pattern = PatternDeData.getddMMyyyyEspacoHHmmss();
		return parseDeData(value, pattern);
	}

	/**
	 * Converte a string no formato yyyyMMdd para um date.
	 * 
	 * @param valor String no formato yyyyMMdd
	 * @return Objeto Date
	 */
	public static Date converterParaData_padraoIBM(String valor) {
		String pattern = PatternDeData.getPadraoIBM();
		return parseDeData(valor, pattern);
	}

	/**
	 * Converte a string no formato DB2 para um date.
	 * 
	 * @param valor String no formato DB2
	 * @return Objeto Date
	 */
	public static Date converterParaData_padraoDB2(String valor) {
		String pattern = PatternDeData.getPadraoDB2();
		return parseDeData(valor, pattern);
	}

	/**
	 * Converte a string no formato dd.MM.yyyy.
	 * 
	 * @param valor String no formato dd.MM.yyyy
	 * @return Objeto Date
	 */
	public static Date converterParaData_ddMMyyyySeparadoPorPonto(String valor) {
		String pattern = PatternDeData.getddMMyyyySeparadoPorPonto();
		return parseDeData(valor, pattern);
	}

	/**
	 * Converte a string no formato definido para um time.
	 * 
	 * @param hora String que será convertida.
	 * @param pattern Padrão em que a string se encontra.
	 * @return Objeto Time
	 */
	public static Time converterParaTime(String hora, String pattern) {
		Time res = null;

		Date data = parseDeHora(hora, pattern);
		if (isReferencia(data)) {
			res = getDataFactory().novoTime(data.getTime());
		}

		return res;
	}

	/**
	 * Converter uma string no formato hh:mm:ss em um Time.
	 * 
	 * @param hora String no formato hh:mm:ss.
	 * @return Time.
	 */
	public static Time converterParaTime_hhmmss(String hora) {
		Time res = null;

		String pattern = PatternDeData.gethhmmss();
		Date data = parseDeHora(hora, pattern);
		if (isReferencia(data)) {
			res = getDataFactory().novoTime(data.getTime());
		}
		return res;
	}

	/**
	 * Converter uma string no formato hh:mm em um Time.
	 * 
	 * @param hora String no formato hh:mm.
	 * @return Time.
	 */
	public static Time converterParaTime_hhmm(String hora) {
		Time res = null;

		String pattern = PatternDeData.gethhmm();
		Date date = parseDeHora(hora, pattern);
		if (isReferencia(date)) {
			res = getDataFactory().novoTime(date.getTime());
		}
		return res;
	}

	/**
	 * Converter uma string no formato HH:mm em um Time.
	 * 
	 * @param hora String no formato hh:mm.
	 * @return Time.
	 */
	public static Time converterParaTime_HHmm(String hora) {
		Time res = null;

		String pattern = PatternDeData.getHHmm();
		Date date = parseDeHora(hora, pattern);
		if (isReferencia(date)) {
			res = getDataFactory().novoTime(date.getTime());
		}
		return res;
	}

	/**
	 * Converte a string no formato definido para um timestamp.
	 * 
	 * @param string String que será convertida.
	 * @param pattern Padrão em que a string se encontra.
	 * @return Objeto Timestamp
	 */
	public static Timestamp converterParaTimestamp(String string,
			String pattern) {
		Timestamp res = null;

		Date data = parseDeData(string, pattern);
		if (isReferencia(data)) {
			res = getDataFactory().novoTimestamp(data.getTime());
		}

		return res;
	}

	/**
	 * Converter uma string no formato dd/MM/yyyy hh:mm:ss em um Timestamp.
	 * 
	 * @param string String no formato dd/MM/yyyy hh:mm:ss.
	 * @return Timestamp.
	 */
	public static Timestamp converterParaTimestamp_ddMMyyyyEspacohhmmss(
			String string) {
		Timestamp res = null;

		String pattern = PatternDeData.getddMMyyyyEspacoHHmmss();
		Date date = parseDeData(string, pattern);
		if (isReferencia(string)) {
			res = getDataFactory().novoTimestamp(date.getTime());
		}
		return res;
	}

	/**
	 * Converter uma string no formato dd/MM/yyyy hh:mm em um Timestamp.
	 * 
	 * @param string String no formato dd/MM/yyyy hh:mm.
	 * @return Timestamp.
	 */
	public static Timestamp converterParaTimestamp_ddMMyyyyEspacohhmm(
			String string) {
		Timestamp res = null;

		String pattern = PatternDeData.getddMMyyyyEspacoHHmm();
		Date date = parseDeData(string, pattern);
		if (isReferencia(string)) {
			res = getDataFactory().novoTimestamp(date.getTime());
		}
		return res;
	}
}
