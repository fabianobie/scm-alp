/**
 * Arquivo.java
 *
 * Data: 07/01/2010
 */
package br.com.ap.jbpm.util.constante;

/**
 * Classe contendo as constantes que referenciam arquivos.
 * 
 * @author adrianop
 */
public class Arquivo {
	
	/**
	 * Construtor.
	 */
	private Arquivo() {
		// Construtor
	}

	/**
	 * Retorna o path do arquivo mensagem-jbpm.properties.
	 * 
	 * @return path do arquivo mensagem-jbpm.properties.
	 */
	public static String getPathArquivoMensagemProperties() {
		return "/br/com/ap/jbpm/util/recurso/mensagem-jbpm.properties";
	}
}
