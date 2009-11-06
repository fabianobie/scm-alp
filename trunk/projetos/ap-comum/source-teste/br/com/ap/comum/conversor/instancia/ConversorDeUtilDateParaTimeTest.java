/*
 * ConversorDeUtilDateParaTimeTest.java
 * 
 * Data de criação: Jul 3, 2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * @author adrianop
 */
public class ConversorDeUtilDateParaTimeTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTime#
	 * 		converter(java.util.Date)}.
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Date, Time> c = getConversorFactory()
				.novoConversorDeUtilDateParaTime();

		Date dt = new Date();
		Time ts = new Time(dt.getTime());
		Time resultado = c.converter(dt);
		assertEquals(c.getTipoDeOrigem(), Date.class);
		assertEquals(c.getTipoDeDestino(), Time.class);
		assertNotNull(resultado);
		assertEquals(resultado, ts);

		resultado = c.converter(null);
		assertNull(resultado);
	}

}
