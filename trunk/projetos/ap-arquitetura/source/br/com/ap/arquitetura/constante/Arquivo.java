/*
 * Arquivo.java
 * 
 * Data de criação: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.constante;

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
		//Construtor
	}
	
	/**
	 * Retorna o path do arquivo mensagem-infra.properties.
	 * 
	 * @return path do arquivo mensagem-infra.properties.
	 */
	public static String getPathArquivoMensagemProperties() {
		return "/br/com/politec/infra/resource/mensagem-infra.properties";
	}
}
