/*
 * ConversorDeStringParaCharacterTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaCharacter
 */
public class ConversorDeStringParaCharacterTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaCharacter#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Character> c = getConversorFactory()
				.novoConversorDeStringParaCharacter();
		String param = getStringFactory().novaString("A");

		Character res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Character.class);
		assertNotNull(res);
		assertEquals(getStringFactory().novoCharacter('A'), res);

		res = c.converter(null);
		assertNull(res);
	}

}
