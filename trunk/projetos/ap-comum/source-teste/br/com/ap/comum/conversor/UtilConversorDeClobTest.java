/*
 * UtilConversorDeClobTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.constante.CaracterEspecial;
import br.com.ap.comum.conversor.UtilConversorDeClob;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeClob
 */
public class UtilConversorDeClobTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeClob# converterParaStringBuffer(java.sql.Clob)}
	 * 
	 * @throws SQLException exceção
	 * @throws SerialException exceção
	 */
	@Test
	public final void testConverterParaStringBuffer() throws SerialException,
			SQLException {
		String quebra = CaracterEspecial.getQuebraComRetornoDeCarro();
		
		String string = new String("Teste de Clob"+quebra+"Teste do Mocó");
		Clob clob = new SerialClob(string.toCharArray());

		StringBuffer sb = UtilConversorDeClob.converterParaStringBuffer(clob);
		assertNotNull(sb);
		assertEquals(string, sb.toString());
		
		sb = UtilConversorDeClob.converterParaStringBuffer(null);
		assertNotNull(sb);
		assertEquals("", sb.toString());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeClob# converterParaString(java.sql.Clob)}
	 * 
	 * @throws SQLException exceção
	 * @throws SerialException exceção
	 */
	@Test
	public final void testConverterParaString() throws SerialException,
	SQLException {
		String quebra = CaracterEspecial.getQuebraComRetornoDeCarro();
		
		String string = new String("Teste de Clob"+quebra+"Teste do Mocó");
		Clob clob = new SerialClob(string.toCharArray());
		
		String sb = UtilConversorDeClob.converterParaString(clob);
		assertNotNull(sb);
		assertEquals(string, sb);
		
		sb = UtilConversorDeClob.converterParaString(null);
		assertNotNull(sb);
		assertEquals("", sb);
	}

}
