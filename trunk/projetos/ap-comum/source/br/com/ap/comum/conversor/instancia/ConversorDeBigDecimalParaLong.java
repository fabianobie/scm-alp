/*
 * ConversorDeBigDecimalParaLong.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import br.com.ap.comum.conversor.UtilConversorDeBigDecimal;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de BigDecimal para Long.
 * 
 * @author adrianop
 */
public class ConversorDeBigDecimalParaLong extends
		ConversorAbstrato<BigDecimal, Long> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Long converter(BigDecimal objeto) throws ConversorException {
		Long res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeBigDecimal.converterParaLongWrapper(objeto);
		}

		return res;
	}

}
