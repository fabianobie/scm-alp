/*
 * UtilConversorDeTimeTest.java
 * 
 * Data de criação: 02/08/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeTime;
import br.com.ap.comum.data.UtilData;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeTime
 */
public class UtilConversorDeTimeTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeTime#converterParaDate(java.sql.Time)}.
	 */
	@Test
	public final void testConverterParaDate() {
		Time t = getDataFactory().novoTime(13, 06, 15);
		Date d = UtilConversorDeTime.converterParaDate(t);
		assertNotNull(d);
		assertTrue((UtilObjeto.isObjetoDoTipo(d, Date.class)));
		assertEquals(UtilData.getHoraNoFormatoDe12(t), UtilData
				.getHoraNoFormatoDe12(d));
	}

}
