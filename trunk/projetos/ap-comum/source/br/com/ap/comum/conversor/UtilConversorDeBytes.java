/*
 * UtilConversorDeBytes.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.fabrica.ArquivoFactory;

/**
 * Conversor de objetos to tipo array de bytes.
 * 
 * @author adrianop
 */
public final class UtilConversorDeBytes extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeBytes() {
		// Construtor
	}

	/**
	 * Converter
	 * 
	 * @param _byte Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static File converterParaFile(String path, byte[] bytes) {
		File res = null;

		if (isReferencia(bytes)) {
			res = getArquivoFactory().novoFile(path);
			OutputStream fos = (FileOutputStream) getArquivoFactory()
					.novoFileOutputStream(res);
			UtilArquivo.escrever(fos, bytes);
		}

		return res;
	}

	/**
	 * @return fábrica de arquivos.
	 */
	protected static ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

}
