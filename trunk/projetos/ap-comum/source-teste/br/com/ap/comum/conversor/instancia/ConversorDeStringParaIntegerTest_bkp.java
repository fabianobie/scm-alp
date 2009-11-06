/*
 * ConversorDeStringParaIntegerTest.java
 * 
 * Data de criação: 21/04/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.conversor.instancia;

import junit.framework.TestCase;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaInteger;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.instancia.
 *      ConversorDeStringParaInteger
 */
public class ConversorDeStringParaIntegerTest_bkp extends TestCase {

	/**
	 * Test method for
	 * 'br.com.ap.comum.conversor.instancia.ConversorDeStringParaInteger.converter(Object)'
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	public void testConverter() throws ConversorException {
		IConversor<String, Integer> conversor = null;
		conversor = new ConversorDeStringParaInteger();

		String string = "25";
		Integer resultado = conversor.converter(string);
		assertEquals(conversor.getTipoDeOrigem(), String.class);
		assertEquals(conversor.getTipoDeDestino(), Integer.class);
		assertNotNull(resultado);
		assertEquals(new Integer(25), resultado);

		resultado = conversor.converter(null);
		assertNull(resultado);
	}

}
