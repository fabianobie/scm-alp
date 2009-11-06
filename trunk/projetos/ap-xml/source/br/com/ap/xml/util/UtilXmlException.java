/*
 * UtilXmlException.java
 * 
 * Data de criação: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml.util;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import br.com.ap.comum.excecao.ExceptionAbstrato;
import br.com.ap.comum.excecao.UtilExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.xml.constante.Mensagem;
import br.com.ap.xml.excecao.XmlException;

/**
 * Classe responsável em resolver as exceções do sistema e retornar as exceções
 * tipadas.
 * 
 * @author AdrianoP
 */
public final class UtilXmlException extends UtilExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilXmlException() {
		// Construtor
	}

	/**
	 * @param e Exceção
	 * @return XmlException
	 */
	public static XmlException erro(Throwable e) {
		String chave = Mensagem.getErro();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e Throwable
	 * @return XmlException
	 */
	public static XmlException parserNaoEfetuado(Throwable e) {
		String chave = Mensagem.getParserNaoEfetuado();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e Exceção
	 * @return XmlException
	 */
	public static XmlException erroAoCriarTransformer(
	        TransformerConfigurationException e) {
		String chave = Mensagem.getErroAoCriarTransformer();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e Exceção
	 * @return XmlException
	 */
	public static XmlException erroAoAplicarTransformacao(TransformerException e) {
		String chave = Mensagem.getErroAoAplicarTransformacao();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * Converte uma exceção.
	 * 
	 * @param e Exceção
	 * @return XmlException
	 */
	private static XmlException converter(ExceptionAbstrato e) {
		XmlException excecao = new XmlException(e);
		getLog().error("Ocorreu um Erro", excecao);

		return excecao;
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
