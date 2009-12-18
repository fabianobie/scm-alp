/**
 * ExceptionHandlerAction.java
 *
 * Data: 20/11/2009
 */
package teste.action.formdinamico;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class FormDinamicoAction extends ActionSupport {
	private Map	mapa;

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
	
	public void setMapaInteger(String chave, Object valor) {
		getMapa().put(chave, valor);
	}
	
	public Integer getMapaInteger(String chave) {
		return (Integer) getMapa().get(chave);
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
	public Map getMapa() {
		if (mapa == null) {
			mapa = new HashMap();
		}
		return mapa;
	}

	/**
	 * @param mapa Atribui mapa.
	 */
	public void setMapa(Map mapa) {
		this.mapa = mapa;
	}

	/**
	 * @param mapa Atribui mapa.
	 */
	public void setMapa(String key, Object value) {
		System.out.println("XXXXXXXXXXXXXXXXXXX");
		getMapa().put(key, value);
	}
	
}
