/*
 * ConversorDeBigDecimalParaInteger.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import br.com.ap.comum.conversor.UtilConversorDeBigDecimal;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de BigDecimal para Integer.
 * 
 * @author adrianop
 */
public class ConversorDeBigDecimalParaInteger extends
		ConversorAbstrato<BigDecimal, Integer> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Integer converter(BigDecimal objeto) throws ConversorException {
		Integer res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeBigDecimal.converterParaInteger(objeto);
		}

		return res;
	}

}
