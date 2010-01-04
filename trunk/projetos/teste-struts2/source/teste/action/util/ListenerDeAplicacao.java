/**
 * ListenerDeAplicacao.java
 *
 * Data: 04/01/2010
 */
package teste.action.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author adriano.pamplona
 *
 */
public class ListenerDeAplicacao implements ServletContextListener {

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent contexto) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent contexto) {
		contexto.getServletContext().getRealPath(".");
	}

}
