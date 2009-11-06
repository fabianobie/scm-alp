/*
 * UtilMensagemAbstrato.java 
 * 
 * Data de cria��o: 08/12/2006 
 * 
 * 
 * 
 */
package br.com.ap.comum.mensagem;

import java.text.MessageFormat;
import java.util.Properties;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata utilit�ria respons�vel pela montagem das mensagens do
 * sistema. Extenda essa classe e implemente o m�todo abstrato getProperties(),
 * esse m�todo ser� respons�vel em recuperar o properties da aplica��o.
 * 
 * @author adrianop
 */
public abstract class UtilMensagemAbstrato {

	/**
	 * Recupera uma mensagem formatada do arquivo
	 * 
	 * @param key chave da mensagem.
	 * @return mensagem formatada.
	 */
	public String getMensagem(String key) {
		return getMensagem(key);
	}

	/**
	 * Formada uma mensagem recuperada do arquivo messages.properties.
	 * 
	 * @param key chave da mensagem.
	 * @param argumentos argumentos da mensagem.
	 * @return mensagem formatada.
	 */
	public String getMensagem(String key, String... argumentos) {
		String resultado = null;
		Properties properties = getProperties();

		if (UtilString.isVazio(key)) {
			resultado = "Mensagem n�o identificada.";
		} else {
			if (UtilObjeto.isReferencia(properties)) {
				String message = properties.getProperty(key);
				if (UtilString.isVazio(message)) {
					resultado = key;
				} else {
					argumentos = substituirNuloPorVazio(argumentos);
					resultado = MessageFormat.format(message,
							(Object[]) argumentos);
				}
			} else {
				resultado = key;
			}
		}

		return resultado;
	}

	/**
	 * Retorna properties com as mensagens.
	 * 
	 * @return properties com as mensagens.
	 */
	protected abstract Properties getProperties();

	/**
	 * Retorna f�brica de IO.
	 * 
	 * @return f�brica de objetos IO
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * Altera os itens com valor nulo para vazio.
	 * 
	 * @param array Array alterado
	 * @return array
	 */
	private String[] substituirNuloPorVazio(String[] array) {
		return UtilArray.aplicarAlterador(array, new Alterador<String>() {

			public String alterar(String objeto) {
				return (UtilObjeto.isReferencia(objeto) ? objeto : "");
			}
		});
	}
}
