/**
 * ExceptionHandlerAction.java
 *
 * Data: 20/11/2009
 */
package teste.action.formdinamico;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class FormDinamicoAction extends ActionSupport {
	private Map<String, Object>	mapa;
	private File				doc;
	private String				docFileName;
	private String				docContentType;

	/**
	 * @return form-dinamico
	 */
	public String acaoCarregarFormDinamico() {
		getMapa().put("string", "didi teste");
		return "form-dinamico";
	}

	/**
	 * @return form-dinamico-resultado
	 */
	public String acaoResultado() {
		System.out.println(getMapa());
		return "form-dinamico-resultado";
	}

	@Override
	public String getText(String aTextName) {
		if (aTextName != null && aTextName.indexOf(Object.class.getName()) > -1) {
			aTextName = "";
		}
		return super.getText(aTextName);
	}

	/**
	 * @return retorna mapa.
	 */
	public Map<String, Object> getMapa() {
		if (mapa == null) {
			mapa = new HashMap<String, Object>();
		}
		return mapa;
	}

	/**
	 * @param mapa Atribui mapa.
	 */
	public void setMapa(Map<String, Object> mapa) {
		this.mapa = mapa;
	}

	/**
	 * @return retorna doc.
	 */
	public File getDoc() {
		return doc;
	}

	/**
	 * @param doc Atribui doc.
	 */
	public void setDoc(File doc) {
		this.doc = doc;
	}

	/**
	 * @return retorna docFileName.
	 */
	public String getDocFileName() {
		return docFileName;
	}

	/**
	 * @param docFileName Atribui docFileName.
	 */
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	/**
	 * @return retorna docContentType.
	 */
	public String getDocContentType() {
		return docContentType;
	}

	/**
	 * @param docContentType Atribui docContentType.
	 */
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

}
