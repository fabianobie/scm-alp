/**
 * MapaInterceptor.java
 *
 * Data: 14/12/2009
 */
package teste.action.formdinamico;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author adriano.pamplona
 *
 */
public class MapaInterceptor extends AbstractInterceptor {

	/**
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		return invocation.invoke();
	}

}
