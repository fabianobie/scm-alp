/*
 * ConversorDeDoubleParaBigDecimal.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import br.com.ap.comum.conversor.UtilConversorDeDouble;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de double para BigDecimal.
 * 
 * @author adrianop
 */
public class ConversorDeDoubleParaBigDecimal extends
		ConversorAbstrato<Double, BigDecimal> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public BigDecimal converter(Double objeto) throws ConversorException {
		BigDecimal res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeDouble.converterParaBigDecimal(objeto);
		}

		return res;
	}

}
