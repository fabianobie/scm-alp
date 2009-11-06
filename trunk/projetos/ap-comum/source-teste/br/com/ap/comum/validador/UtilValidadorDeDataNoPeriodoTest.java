/*
 * UtilValidadorDeDataNoPeriodoTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.validador.UtilValidadorDeDataNoPeriodo;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDataNoPeriodo
 */
public class UtilValidadorDeDataNoPeriodoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDataNoPeriodo#validar(java.util.Date, java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date data = DataFactory.getInstancia().novoDate(5, 5, 2005);
		Date dataInicial = DataFactory.getInstancia().novoDate(1, 1, 2005);
		Date dataFinal = DataFactory.getInstancia().novoDate(30, 8, 2005);

		boolean res = UtilValidadorDeDataNoPeriodo.validar(data, dataInicial,
				dataFinal);
		assertTrue(res);

		res = UtilValidadorDeDataNoPeriodo
				.validar(data, dataFinal, dataInicial);
		assertFalse(res);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDataNoPeriodo#validarNoAno(java.util.Date, int, int)}.
	 */
	@Test
	public final void testValidarNoAno() {
		Date data = DataFactory.getInstancia().novoDate(5, 5, 2005);

		int anoInicial = 1900;
		int anoFinal = 2500;

		boolean res = UtilValidadorDeDataNoPeriodo.validarNoAno(data,
				anoInicial, anoFinal);
		assertTrue(res);

		data = DataFactory.getInstancia().novoDate(5, 5, 2600);
		res = UtilValidadorDeDataNoPeriodo.validarNoAno(data, anoInicial,
				anoFinal);
		assertFalse(res);
	}

}
