/*
 * UtilFormatadorDeReal.java
 * Data: 26/01/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.numerico.UtilNumero;
import br.com.ap.comum.string.UtilString;

/**
 * Formatador de real.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeReal extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeReal() {
		// Construtor.
	}

	/**
	 * Formata um real.
	 * 
	 * @param real Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(Number real) {
		return formatarReal(real);
	}

	/**
	 * Formata um real com as casas decimais definidas.
	 * 
	 * @param real Real que será formatado.
	 * @param casasDecimais Quantidade de casas decimais.
	 * @return String formatada.
	 */
	public static String formatar(Number real, int casasDecimais) {
		return formatarReal(real, casasDecimais);
	}

	/**
	 * Formata um real.
	 * 
	 * @param real Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(double real) {
		return formatar(getNumeroFactory().novoDouble(real));
	}

	/**
	 * Formata um real.
	 * 
	 * @param real Real que será formatado.
	 * @param casasDecimais Quantidade de casas decimais.
	 * @return String formatada.
	 */
	public static String formatar(double real, int casasDecimais) {
		return formatar(getNumeroFactory().novoDouble(real), casasDecimais);
	}

	/**
	 * Adiciona a vírgula na string passada por parâmetro.
	 * 
	 * @param valor String que receberá a vírgula de casa decimal.
	 * @param casasDecimais Posição da vírgula.
	 * @return String formatada
	 */
	public static String formatar(String valor, int casasDecimais) {

		valor = UtilString.removerPrefixo(valor, "0");
		int tamanho = UtilString.getTamanho(valor);

		if (UtilNumero.isReal(valor) && casasDecimais > 0
				&& tamanho > casasDecimais) {

			int posicao = tamanho - casasDecimais;
			StringBuilder builder = getStringFactory().novoStringBuilder();
			builder.append(valor);
			builder.insert(posicao, getSeparadorDecimal());

			valor = builder.toString();
		}
		return valor;
	}

	/**
	 * Formata um real para monetário.
	 * 
	 * @param real Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatarParaMonetario(double real) {
		String valor = formatar(real);
		if (!isVazio(valor)) {
			valor = Constante.getPrefixoMonetario() + " " + valor;
		}
		return valor;
	}

	/**
	 * Formata um real para monetário.
	 * 
	 * @param real Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatarParaMonetario(Number real) {
		String valor = formatarReal(real);
		if (!isVazio(valor)) {
			valor = Constante.getPrefixoMonetario() + " " + valor;
		}
		return valor;
	}

	/**
	 * Formata um real para monetário sem o prefixo da moeda.
	 * 
	 * @param real Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatarParaMonetarioSemPrefixo(Number real) {
		return formatarReal(real);
	}

}
