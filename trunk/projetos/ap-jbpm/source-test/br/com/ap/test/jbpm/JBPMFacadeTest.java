/**
 * JBPMFacadeTest.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.test.jbpm;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.facade.JBPMFacade;
import br.com.ap.jbpm.facade.JBPMFacadeImpl;

/**
 * @author adriano.pamplona
 *
 */
public class JBPMFacadeTest extends TestCase {
	private static ClassPathXmlApplicationContext contexto;
	
	public void testPublicar() {
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/deploy/process.jpdl.xml");
		decorator.setClasspathImagem("br/com/ap/test/jbpm/deploy/process.png");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-start.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-conferir-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-informacao.ftl");
		
		decorator = getJBPMFacade().publicar(decorator);
		System.out.println(decorator.getId());
	}
	
	/**
	 * @return JBPMFacade
	 */
	protected JBPMFacade getJBPMFacade() {
		return (JBPMFacade) getContexto().getBean(JBPMFacadeImpl.class.getSimpleName());
	}
	
	/**
	 * @return ClassPathXmlApplicationContext
	 */
	private ClassPathXmlApplicationContext getContexto() {
		if (contexto == null) {
			contexto = new ClassPathXmlApplicationContext("ap-jbpm-application-context.xml");
		}
		return contexto;
	}
}
