/*
 * UtilMensagem.java
 * 
 * Data de criação: 23/02/2007
 * 
 *
 *
 */
package br.com.ap.reflexao.util;

import java.util.Properties;

import br.com.ap.comum.mensagem.UtilMensagemAbstrato;
import br.com.ap.reflexao.constante.Arquivo;

/**
 * Classe responsável em recuperar as mensagens do properties.
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
