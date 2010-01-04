/*
 * UtilConversorDeFile.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.File;
import java.io.InputStream;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.fabrica.ArquivoFactory;

/**
 * Conversor de objetos do tipo short.
 * 
 * @author adrianop
 */
public final class UtilConversorDeFile extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeFile() {
		// Construtor
	}

	/**
	 * Converte para byte[].
	 * 
	 * @param arquivo Objeto que será convertido.
	 * @return byte[].
	 */
	public static byte[] converterParaBytes(File arquivo) {
		byte[] res = null;

		if (UtilArquivo.isExiste(arquivo) && !UtilArquivo.isPasta(arquivo)) {
			try {
				InputStream fis = ArquivoFactory.getInstancia().novoFileInputStream(arquivo);
				res = new byte[(int) arquivo.length()];
				fis.read(res);
			} catch (Exception e) {
				getLog().warn("Não foi possível converter o File em byte[], Erro: " + e);
			}
		}

		return res;
	}
}
