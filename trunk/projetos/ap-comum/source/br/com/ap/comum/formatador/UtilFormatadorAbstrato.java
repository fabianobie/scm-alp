/*
 * UtilFormatadorAbstrato.java
 * 
 * Data de criação: 28/08/2007
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
 * Provê recursos comuns a todos os formatadores.
 * 
 * @author adrianop
 */
public abstract class UtilFormatadorAbstrato {

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
	 * Formata uma string de acordo com o pattern passado por parâmetro.
	 * 
	 * @param string String que será formatada.
	 * @param pattern Pattern usado na formatação.
	 * @return String formatada.
	 */
	protected static String formatarString(String string, String pattern) {
		JFormattedTextField format = novoJFormattedTextField(pattern);
		format.setText(string);
		return format.getText();
	}

	/**
	 * Formata uma data de acordo com o pattern passado por parâmetro.
	 * 
	 * @param data Dtaa que será formatada.
	 * @param pattern Pattern usado na formatação.
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
	 * Formata um número.
	 * 
	 * @param number número que será formatado.
	 * @return String do número formatado
	 */
	protected static String formatarNumero(Number number) {
		String res = null;

		if (isReferencia(number)) {
			res = novoNumberFormat().format(number);
		}
		return res;
	}

	/**
	 * Formata um número real.
	 * 
	 * @param number número que será formatado.
	 * @return String do número formatado
	 */
	protected static String formatarReal(Number number) {
		String result = null;

		if (isReferencia(number)) {
			result = novoDecimalFormat().format(number);
		}
		return result;
	}

	/**
	 * Formata um número real.
	 * 
	 * @param number número que será formatado.
	 * @param casasDecimais quantidade de casas decimais.
	 * @return String do número formatado
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
	 * @return fábrica de coleção
	 */
	protected static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo DecimalFormatSymbols.
	 * 
	 * @return instância do DecimalFormatSymbols
	 */
	private static DecimalFormatSymbols novoDecimalFormatSymbols() {
		return novoDecimalFormat().getDecimalFormatSymbols();
	}

	/**
	 * Retorna a instância SimpleDateFormat.
	 * 
	 * @param pattern pattern da formatação.
	 * @return instância de SimpleDateFormat.
	 */
	private static SimpleDateFormat novoSimpleDateFormat(String pattern) {
		return getDataFactory().novoSimpleDateFormat(pattern);
	}

	/**
	 * Retorna a instância de JFormattedTextField usada na formatação de
	 * Strings.
	 * 
	 * @param pattern patterna usado na formatação.
	 * @return instância de JFormattedTextField.
	 */
	private static JFormattedTextField novoJFormattedTextField(String pattern) {
		return new JFormattedTextField(novoMaskFormatter(pattern));
	}

	/**
	 * Retorna instância de MaskFormatter do pattern passado por parâmetro.
	 * 
	 * @param pattern pattern da máscara.
	 * @return instância de MaskFormatter.
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
	 * @return instância de DataFactory.
	 */
	protected static DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * @return instância da fábrica de string
	 */
	protected static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @return instância de NumeroFactory.
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna a instância do log.
	 * 
	 * @return log
	 */
	protected static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
