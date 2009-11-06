/*
 * ConversorDeStringParaBigDecimalSemPrecisao.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de string para BigDecimal.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaBigDecimalSemPrecisao extends
		ConversorAbstrato<String, BigDecimal> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public BigDecimal converter(String objeto) throws ConversorException {
		BigDecimal res = null;

		if (isReferencia(objeto)) {
			int precisao = getPrecisao();
			res = UtilConversorDeString.converterParaBigDecimal(objeto,
					precisao);
		}

		return res;
	}

	/**
	 * @return precis�o.
	 */
	protected int getPrecisao() {
		return 0;
	}
}
