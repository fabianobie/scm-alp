/*
 * UtilConversorDeBytesTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.File;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeBytes
 */
public class UtilConversorDeBytesTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFile#converterParaBytes(java.io.File)}.
	 */
	@Test
	public final void testConverterParaBytes() {
		String texto = "teste de exemplo";
		
		File file = UtilConversorDeBytes.converterParaFile("teste.txt", texto.getBytes());
		assertNotNull(file);
		assertTrue(file.exists());
		file.delete();
		
	}

}
