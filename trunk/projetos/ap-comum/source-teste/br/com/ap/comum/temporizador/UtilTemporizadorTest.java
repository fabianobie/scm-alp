/*
 * TemporizadorTest.java
 * 
 * Data de criação: 24/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.temporizador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.temporizador.UtilTemporizador;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilTemporizador
 */
public class UtilTemporizadorTest extends TesteAbstrato {

	/**
	 * Teste da classe
	 */
	@Test
	public void testMain() {
		UtilTemporizador t = UtilTemporizador.novaInstancia(5);

		t.iniciar();
		UtilArquivo.getColecaoDeFile(".");
		t.finalizar();

		// t.validar();
		t.log();
	}

}
