/*
 * UtilMensagem.java
 * 
 * Data de cria��o: 23/02/2007
 * 
 *
 *
 */
package br.com.ap.reflexao.util;

import java.util.Properties;

import br.com.ap.comum.mensagem.UtilMensagemAbstrato;
import br.com.ap.reflexao.constante.Arquivo;

/**
 * Classe respons�vel em recuperar as mensagens do properties.
 * 
 * @author AdrianoP
 */
public final class UtilMensagem extends UtilMensagemAbstrato {
	private static UtilMensagem	instancia	= new UtilMensagem();

	/**
	 * Construtor.
	 */
	private UtilMensagem() {
		// Construtor.
	}

	/**
	 * Retorna inst�ncia �nica do objeto. Padr�o singleton
	 * 
	 * @return inst�ncia do objeto.
	 */
	public static UtilMensagem getInstancia() {
		return instancia;
	}

	/**
	 * @see br.com.ap.comum.mensagem.UtilMensagemAbstrato#getProperties()
	 */
	protected Properties getProperties() {
		String arquivo = Arquivo.getPathArquivoMensagemProperties();
		return getArquivoFactory().novoProperties(arquivo);
	}
}
