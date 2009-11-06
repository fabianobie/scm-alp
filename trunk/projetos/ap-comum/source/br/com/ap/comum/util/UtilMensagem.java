/*
 * UtilMensagem.java
 * 
 * Data de criação: 30/04/2007
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
 * Responsável pela recuperação das mensagens do properties
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
