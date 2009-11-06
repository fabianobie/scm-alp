/*
 * TipoDeDocumento.java
 * 
 * Data de criação: 10/09/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

/**
 * Classe de constantes dos tipos de documento existente.
 * 
 * @author AdrianoP
 */
public final class TipoDeDocumento {

	/**
	 * Construtor.
	 */
	private TipoDeDocumento() {
		// Construtor.
	}

	/**
	 * Retorna o tipo de documento PDF.
	 * 
	 * @return application/pdf
	 */
	public static String getPDF() {
		return "application/pdf";
	}

	/**
	 * Retorna o tipo de arquivo no formato texto ASCII.
	 * 
	 * @return text/plain
	 */
	public static String getTexto() {
		return "text/plain";
	}

	/**
	 * Retorna o tipo de arquivo no formato HTML.
	 * 
	 * @return text/html
	 */
	public static String getHTML() {
		return "text/html";
	}

	/**
	 * Retorna o tipo de arquivo no formato GIF.
	 * 
	 * @return Image/gif
	 */
	public static String getGIF() {
		return "Image/gif";
	}

	/**
	 * Retorna o tipo de arquivo no formato JPEG.
	 * 
	 * @return Image/jpeg
	 */
	public static String getJPEG() {
		return "Image/jpeg";
	}

	/**
	 * Retorna o tipo de arquivo no formato ZIP.
	 * 
	 * @return application/zip
	 */
	public static String getZIP() {
		return "application/zip";
	}
}
