/*
 * Arquivo.java
 * 
 * Data de criação: 30/04/2007
 *
 * 
 *
 */
package br.com.ap.reflexao.constante;

/**
 * Classe contendo as constantes que referenciam arquivos de alguma forma.
 * 
 * @author adrianop
 */
public final class Arquivo {

	/**
	 * Construtor.
	 */
	private Arquivo() {
		// Construtor
	}

	/**
	 * Retorna o path do arquivo mensagem-reflexao.properties.
	 * 
	 * @return path do arquivo mensagem-reflexao.properties.
	 */
	public static String getPathArquivoMensagemProperties() {
		return "/br/com/ap/reflexao/recurso/mensagem-reflexao.properties";
	}
}
