/**
 * ComentarioComponentUI.java
 *
 * Data: 19/01/2010
 */
package teste.component;

import java.io.IOException;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * @author adriano.pamplona
 * 
 */
public class ComentarioComponentUI extends HtmlOutputText {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		final ResponseWriter writer = context.getResponseWriter();
		
		writer.write("<!--[if IE]>");
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		final ResponseWriter writer = context.getResponseWriter();
		
		writer.write("<![endif]-->");
	}
}
