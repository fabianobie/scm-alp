/*
 * UtilMensagem.java
 * 
 * Data de criação: 23/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util;

import java.util.Properties;

import br.com.ap.arquitetura.constante.Arquivo;
import br.com.ap.comum.mensagem.UtilMensagemAbstrato;

/**
 * Responsável pela recuperação das mensagens do properties mensagem.properties.
 * 
 * @author adrianop
 * @see br.com.ap.comum.mensagem.UtilMensagemAbstrato
 */
public final class UtilMensagem extends UtilMensagemAbstrato {

	private static UtilMensagem instancia = new UtilMensagem();

	/**
	 * Construtor.
	 */
	private UtilMensagem() {
		// Construtor.
	}

	/**
	 * Retorna instância única do objeto. Padrão singleton
	 * 
	 * @return instância do objeto.
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
