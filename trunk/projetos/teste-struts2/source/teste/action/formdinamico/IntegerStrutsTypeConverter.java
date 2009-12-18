/**
 * IntegerStrutsTypeConverter.java
 *
 * Data: 14/12/2009
 */
package teste.action.formdinamico;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * @author adriano.pamplona
 *
 */
public class IntegerStrutsTypeConverter extends StrutsTypeConverter {

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("conversor - convertFromString");
		return null;
	}

	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("conversor - convertToString");
		return null;
	}

}
