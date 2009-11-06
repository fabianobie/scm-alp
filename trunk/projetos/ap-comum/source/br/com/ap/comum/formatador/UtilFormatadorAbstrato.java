/*
 * UtilFormatadorAbstrato.java
 * 
 * Data de cria��o: 28/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import br.com.ap.comum.excecao.UtilExcecao;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe abstrata que representa um formatador.<br>
 * Prov� recursos comuns a todos os formatadores.
 * 
 * @author adrianop
 */
public abstract class UtilFormatadorAbstrato {

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
	 * Formata uma string de acordo com o pattern passado por par�metro.
	 * 
	 * @param string String que ser� formatada.
	 * @param pattern Pattern usado na formata��o.
	 * @return String formatada.
	 */
	protected static String formatarString(String string, String pattern) {
		JFormattedTextField format = novoJFormattedTextField(pattern);
		format.setText(string);
		return format.getText();
	}

	/**
	 * Formata uma data de acordo com o pattern passado por par�metro.
	 * 
	 * @param data Dtaa que ser� formatada.
	 * @param pattern Pattern usado na formata��o.
	 * @return String da data formatada.
	 */
	protected static String formatarData(Date data, String pattern) {
		String res = null;

		if (isReferencia(data) && !isVazio(pattern)) {
			res = novoSimpleDateFormat(pattern).format(data);
		}
		return res;
	}

	/**
	 * Formata um n�mero.
	 * 
	 * @param number n�mero que ser� formatado.
	 * @return String do n�mero formatado
	 */
	protected static String formatarNumero(Number number) {
		String res = null;

		if (isReferencia(number)) {
			res = novoNumberFormat().format(number);
		}
		return res;
	}

	/**
	 * Formata um n�mero real.
	 * 
	 * @param number n�mero que ser� formatado.
	 * @return String do n�mero formatado
	 */
	protected static String formatarReal(Number number) {
		String result = null;

		if (isReferencia(number)) {
			result = novoDecimalFormat().format(number);
		}
		return result;
	}

	/**
	 * Formata um n�mero real.
	 * 
	 * @param number n�mero que ser� formatado.
	 * @param casasDecimais quantidade de casas decimais.
	 * @return String do n�mero formatado
	 */
	protected static String formatarReal(Number number, int casasDecimais) {
		String result = null;

		if (isReferencia(number)) {
			result = novoDecimalFormat(casasDecimais).format(number);
		}
		return result;
	}

	/**
	 * Retorna o separador de decimal.
	 * 
	 * @return separador de decimal
	 */
	protected static String getSeparadorDecimal() {
		char separador = novoDecimalFormatSymbols().getDecimalSeparator();
		return String.valueOf(separador);
	}

	/**
	 * @return f�brica de cole��o
	 */
	protected static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo DecimalFormatSymbols.
	 * 
	 * @return inst�ncia do DecimalFormatSymbols
	 */
	private static DecimalFormatSymbols novoDecimalFormatSymbols() {
		return novoDecimalFormat().getDecimalFormatSymbols();
	}

	/**
	 * Retorna a inst�ncia SimpleDateFormat.
	 * 
	 * @param pattern pattern da formata��o.
	 * @return inst�ncia de SimpleDateFormat.
	 */
	private static SimpleDateFormat novoSimpleDateFormat(String pattern) {
		return getDataFactory().novoSimpleDateFormat(pattern);
	}

	/**
	 * Retorna a inst�ncia de JFormattedTextField usada na formata��o de
	 * Strings.
	 * 
	 * @param pattern patterna usado na formata��o.
	 * @return inst�ncia de JFormattedTextField.
	 */
	private static JFormattedTextField novoJFormattedTextField(String pattern) {
		return new JFormattedTextField(novoMaskFormatter(pattern));
	}

	/**
	 * Retorna inst�ncia de MaskFormatter do pattern passado por par�metro.
	 * 
	 * @param pattern pattern da m�scara.
	 * @return inst�ncia de MaskFormatter.
	 */
	private static MaskFormatter novoMaskFormatter(String pattern) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(pattern);
		} catch (ParseException e) {
			getLog().warn("Erro de parser, erro: "+ UtilExcecao.getMensagem(e));
		}
		return formatter;
	}

	/**
	 * Retorna novo NumberFormat.
	 * 
	 * @return novo NumberFormat.
	 */
	private static DecimalFormat novoDecimalFormat() {
		return getNumeroFactory().novoDecimalFormat();
	}

	/**
	 * Retorna novo NumberFormat.
	 * 
	 * @param casasDecimais Quantidade de casas decimais.
	 * @return novo NumberFormat.
	 */
	private static DecimalFormat novoDecimalFormat(int casasDecimais) {
		return getNumeroFactory().novoDecimalFormat(casasDecimais);
	}

	/**
	 * Retorna novo DecimalFormat.
	 * 
	 * @return novo DecimalFormat.
	 */
	private static NumberFormat novoNumberFormat() {
		return getNumeroFactory().novoNumberFormat();
	}

	/**
	 * @return inst�ncia de DataFactory.
	 */
	protected static DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * @return inst�ncia da f�brica de string
	 */
	protected static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @return inst�ncia de NumeroFactory.
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna a inst�ncia do log.
	 * 
	 * @return log
	 */
	protected static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
