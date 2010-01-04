/**
 * DownloadFileAction.java
 *
 * Data: 04/01/2010
 */
package teste.action.downloadfile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 *
 */
public class DownloadFileAction extends ActionSupport {
	private InputStream arquivo;
	private String texto;
	
	public String acaoCarregarDownloadFile() {
		return "download-file";
	}
	
	public String acaoDownload() {
		byte[] bytes = getTexto().getBytes();
		InputStream is = new ByteArrayInputStream(bytes);
		setArquivo(is);
		return "download";
	}

	/**
	 * @return retorna arquivo.
	 */
	public InputStream getArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo Atribui arquivo.
	 */
	public void setArquivo(InputStream arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @return retorna texto.
	 */
	public String getTexto() {
		if (texto == null) {
			texto = "";
		}
		return texto;
	}

	/**
	 * @param texto Atribui texto.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
