/*
 * UtilConversorAbstrato.java
 * 
 * Data de criação: 12/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;

import br.com.ap.comum.data.UtilData;
import br.com.ap.comum.fabrica.BoleanoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.objeto.UtilPrimitivo;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe abstrata que representa um conversor.<br>
 * Provê recursos comuns a todos os conversores.
 * 
 * @author adrianop
 */
public abstract class UtilConversorAbstrato {

	/**
	 * Converte uma string no formato definido pelo pattern em um Date.
	 * 
	 * @param stringData String da data.
	 * @param pattern Formato da data.
	 * @return Objeto do tipo Date.
	 */
	protected static Date parseDeData(String stringData, String pattern) {
		return UtilData.parse(stringData, pattern);
	}

	/**
	 * Converte uma string no formato definido pelo pattern em um Date.
	 * 
	 * @param stringData String da data.
	 * @param pattern Formato da data.
	 * @return Objeto do tipo Date.
	 */
	protected static Date parseDeHora(String stringData, String pattern) {
		return UtilData.parse(stringData, pattern, true);
	}

	/**
	 * Efetua o parser de uma string para double.
	 * 
	 * @param string String no formato estrangeiro. Ex: 35.44.
	 * @return Double
	 */
	protected static Double parseDeNumeroFormatoEstrangeiro(String string) {
		Double res = null;
		try {
			res = new Double(string);
		} catch (NumberFormatException e) {
			getLog().warn(getMensagemErroDeConversao(string, "Double"));
		}
		return res;
	}

	/**
	 * Efetua o parser da string para double.
	 * 
	 * @param res Double já montado.
	 * @param string String no formato brasileiro. Ex: 35,44.
	 * @return Double
	 */
	protected static Double parseDeNumeroFormatoBrasileiro(Double res,
			String string) {
		if (!isReferencia(res)) {
			try {
				Number number = novoDecimalFormat().parse(string);
				res = getNumeroFactory().novoDouble(number.doubleValue());
			} catch (ParseException e) {
				res = (Double) getValorDefault(Double.class);
			}
		}
		return res;
	}

	/**
	 * @param string String que será validada.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazio(String)
	 */
	protected static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * @param string1 String que será validada.
	 * @param string2 String que será validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String)
	 */
	protected static boolean isVazio(String string1, String string2) {
		return UtilString.isVazio(string1, string2);
	}

	/**
	 * @param string1 String que será validada.
	 * @param string2 String que será validada.
	 * @param string3 String que será validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String, String)
	 */
	protected static boolean isVazio(String string1, String string2,
			String string3) {
		return UtilString.isVazio(string1, string2, string3);
	}

	/**
	 * @param objeto Objeto que será validado.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna o valor default do tipo passado por parâmetro.
	 * 
	 * @param tipo Tipo de objeto.
	 * @return valor default do tipo passado por parâmetro.
	 * @see UtilPrimitivo#getValorDefault(Class)
	 */
	protected static Object getValorDefault(Class<?> tipo) {
		return UtilPrimitivo.getValorDefault(tipo);
	}

	/**
	 * Retorna a instância da fábrica de número.
	 * 
	 * @return NumeroFactory
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * @return fábrica de coleção
	 */
	protected static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo BoleanoFactory.
	 * 
	 * @return BoleanoFactory
	 */
	protected static BoleanoFactory getBoleanoFactory() {
		return BoleanoFactory.getInstancia();
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
	 * Retorna StringFactory.
	 * 
	 * @return StringFactory
	 */
	protected static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @param valor valor usado para criar o inteiro.
	 * @return novo integer
	 */
	protected static Integer novoInteger(int valor) {
		return getNumeroFactory().novoInteger(valor);
	}

	/**
	 * @param valor valor usado para criar o short.
	 * @return novo short
	 */
	protected static Short novoShort(short valor) {
		return getNumeroFactory().novoShort(valor);
	}

	/**
	 * @param valor valor usado para criar o long.
	 * @return novo long
	 */
	protected static Long novoLong(long valor) {
		return getNumeroFactory().novoLong(valor);
	}

	/**
	 * @param valor valor usado para criar o float.
	 * @return novo float
	 */
	protected static Float novoFloat(float valor) {
		return getNumeroFactory().novoFloat(valor);
	}

	/**
	 * @param valor valor usado para criar o double.
	 * @return novo double
	 */
	protected static Double novoDouble(double valor) {
		return getNumeroFactory().novoDouble(valor);
	}

	/**
	 * @return log
	 */
	protected static LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * Retorna novo NumberFormat.
	 * 
	 * @return novo NumberFormat.
	 */
	protected static DecimalFormat novoDecimalFormat() {
		return getNumeroFactory().novoDecimalFormat();
	}

	/**
	 * Retorna a mensagem de erro.
	 * 
	 * @param valor Valor que está sendo convertido.
	 * @param tipo Tipo.
	 * @return mensagem de erro de conversão.
	 */
	protected static String getMensagemErroDeConversao(String valor,
			String tipo) {
		String mensagem = "Não foi possível converter o valor \"{0}\" para o tipo \"{1}\"";
		return MessageFormat.format(mensagem, valor, tipo);
	}
}
