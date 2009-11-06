/*
 * UtilExcecao.java
 * 
 * Data de cria��o: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

import br.com.ap.comum.constante.CaracterEspecial;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilit�ria respons�vel em manipular exce��es.
 * 
 * @author adrianop
 */
public final class UtilExcecao {

	/**
	 * Construtor.
	 */
	private UtilExcecao() {
		// construtor
	}

	/**
	 * Retorna o texto do stacktrace da exce��o.
	 * 
	 * @param e Exce��o
	 * @return texto do stacktrace.
	 */
	public static String getStackStrace(Throwable e) {
		StringBuilder builder = getStringFactory().novoStringBuilder();

		if (UtilObjeto.isReferencia(e)) {
			String quebra = CaracterEspecial.getQuebraComRetornoDeCarro();

			for (StackTraceElement st : e.getStackTrace()) {
				builder.append(st.toString()).append(quebra);
			}
		}
		return builder.toString();
	}

	/**
	 * Retorna a mensagem de erro da exce��o.
	 * 
	 * @param e Exce��o
	 * @return mensagem de erro da exce��o.
	 */
	public static String getMensagem(Throwable e) {
		String mensagem = null;

		if (UtilObjeto.isReferencia(e)) {
			mensagem = e.getMessage();
			if (UtilString.isVazio(mensagem)) {
				mensagem = e.toString();
			}
		}
		return mensagem;
	}

	/**
	 * @return f�brica de string.
	 */
	private static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}
}
