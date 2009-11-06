/*
 * Mensagem.java
 * 
 * Data de criação: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml.constante;

/**
 * Mensagens mapeadas no arquivo mensagem-xml.properties.
 * 
 * @author AdrianoP
 */
public final class Mensagem {

	/**
	 * Construtor.
	 */
	private Mensagem() {
		//Construtor
	}
	
	/**
	 * Retorna erro.
	 * 
	 * @return erro
	 */
	public static String getErro() {
		return "erro";
	}

	/**
	 * Retorna parser.nao.efetuado.
	 * 
	 * @return parser.nao.efetuado
	 */
	public static String getParserNaoEfetuado() {
		return "parser.nao.efetuado";
	}

	/**
	 * Retorna erro.ao.criar.transformer.
	 * 
	 * @return erro.ao.criar.transformer
	 */
	public static String getErroAoCriarTransformer() {
		return "erro.ao.criar.transformer";
	}

	/**
	 * Retorna erro.ao.aplicar.transformacao.
	 * 
	 * @return erro.ao.aplicar.transformacao
	 */
	public static String getErroAoAplicarTransformacao() {
		return "erro.ao.aplicar.transformacao";
	}
}
