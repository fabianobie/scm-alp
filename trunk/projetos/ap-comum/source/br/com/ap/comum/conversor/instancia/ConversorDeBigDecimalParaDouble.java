/*
 * ConversorDeBigDecimalParaDouble.java
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
 * Conversor de BigDecimal para Double.
 * 
 * @author adrianop
 */
public class ConversorDeBigDecimalParaDouble extends
		ConversorAbstrato<BigDecimal, Double> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Erro de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Double converter(BigDecimal objeto) throws ConversorException {
		Double res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeBigDecimal.converterParaDoubleWrapper(objeto);
		}

		return res;
	}
}
