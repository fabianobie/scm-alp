/*
 * UtilConversorDeClob.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import br.com.ap.comum.constante.CaracterEspecial;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos to tipo Clob.
 * 
 * @author adrianop
 */
public final class UtilConversorDeClob extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeClob() {
		// Construtor
	}

	/**
	 * Converte para o tipo string.
	 * 
	 * @param clob Objeto Clob que será convertido.
	 * @return String.
	 */
	public static String converterParaString(Clob clob) {
		return UtilString.getString(converterParaStringBuffer(clob));
	}

	/**
	 * Converte para o tipo stringbuffer.
	 * 
	 * @param clob Objeto Clob que será convertido.
	 * @return StringBuffer.
	 */
	public static StringBuffer converterParaStringBuffer(Clob clob) {
		StringBuffer resultado = getStringFactory().novoStringBuffer();

		if (isReferencia(clob)) {
			try {
				Reader r = clob.getCharacterStream();
				BufferedReader br = getArquivoFactory().novoBufferedReader(r);
				String linha = null;
				while (isReferencia(linha = br.readLine())) {
					adicionarLinha(resultado, linha);
				}
			} catch (SQLException e) {
				getLog().warn("Não foi possível recuperar o valor do Clob", e);
			} catch (IOException e) {
				getLog().warn("Erro ao ler string do Clob", e);
			}

		}
		return resultado;
	}

	/**
	 * Adiciona a linha no StringBuffer.
	 * 
	 * @param resultado StringBuffer.
	 * @param linha Linha recuperada do Clob.
	 */
	private static void adicionarLinha(StringBuffer resultado, String linha) {
		if (!isVazio(linha)) {
			String quebra = CaracterEspecial.getQuebraComRetornoDeCarro();
			
			if (resultado.length() > 0) {
				resultado.append(quebra);
			}
			resultado.append(linha);
		}
	}

	/**
	 * @return fábrica de objetos IO
	 */
	private static ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

}
