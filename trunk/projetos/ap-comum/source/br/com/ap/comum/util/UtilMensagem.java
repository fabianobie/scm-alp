/*
 * UtilMensagem.java
 * 
 * Data de cria��o: 30/04/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import java.util.Properties;

import br.com.ap.comum.constante.Arquivo;
import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.mensagem.UtilMensagemAbstrato;

/**
 * Respons�vel pela recupera��o das mensagens do properties
 * mensagem-generico.properties.
 * 
 * @author adrianop
 * @see br.com.ap.comum.mensagem.UtilMensagemAbstrato
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
	@Override
	protected Properties getProperties() {
		String arquivo = Arquivo.getPathArquivoMensagemProperties();
		return getArquivoFactory().novoProperties(arquivo);
	}

	/**
	 * Retorna a mensagem mapeada no properties.
	 * 
	 * @param decorrido Tempo decorrido
	 * @param sugerido Tempo sugerido
	 * @return mensagem mapeada no properties.
	 */
	public String getTempoDeResposta(int decorrido, int sugerido) {
		String chave = Mensagem.getTempoDeResposta();
		String arg0 = String.valueOf(decorrido);
		String arg1 = String.valueOf(sugerido);

		return getMensagem(chave, arg0, arg1);
	}
}
