/*
 * UtilMensagem.java
 * 
 * Data de criação: 30/04/2007
 *
 * 
 *
 */
package br.com.ap.xml.util;

import java.util.Properties;

import br.com.ap.comum.mensagem.UtilMensagemAbstrato;
import br.com.ap.xml.constante.Constante;

/**
 * Responsável pela recuperação das mensagens do properties
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
	String arquivo = Constante.getPathArquivoMensagemProperties();
	return getArquivoFactory().novoProperties(arquivo);
    }
}
