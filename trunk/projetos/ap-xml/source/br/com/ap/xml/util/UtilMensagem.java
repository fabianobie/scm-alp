/*
 * UtilMensagem.java
 * 
 * Data de cria��o: 30/04/2007
 *
 * 
 *
 */
package br.com.ap.xml.util;

import java.util.Properties;

import br.com.ap.comum.mensagem.UtilMensagemAbstrato;
import br.com.ap.xml.constante.Constante;

/**
 * Respons�vel pela recupera��o das mensagens do properties
 * mensagem-xml.properties.
 * 
 * @author adrianop
 * @see UtilMensagemAbstrato
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
	String arquivo = Constante.getPathArquivoMensagemProperties();
	return getArquivoFactory().novoProperties(arquivo);
    }
}
