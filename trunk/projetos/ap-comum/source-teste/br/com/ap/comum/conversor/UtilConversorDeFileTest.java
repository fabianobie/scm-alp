/*
 * UtilConversorDeFileTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeFile
 */
public class UtilConversorDeFileTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFile#converterParaArrayDeBytes(java.io.File)}.
	 */
	@Test
	public final void testConverterParaArrayDeBytes() {
		URL url = UtilConversorDeFileTest.class.getResource("./UtilConversorDeFileTest.class");
		String path = url.getPath();
		path = UtilString.substituirString(path, "bin", "source-teste");
		path = UtilString.substituirString(path, ".class", ".java");
		File file = new File(path);

		byte[] bytes = UtilConversorDeFile.converterParaArrayDeBytes(file);
		assertNotNull(bytes);
		
		bytes = UtilConversorDeFile.converterParaArrayDeBytes(null);
		assertNull(bytes);
		
	}

}
