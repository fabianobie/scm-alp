/**
 * GeradorEntityPojoClass.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador;

import org.hibernate.mapping.Component;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.pojo.ComponentPOJOClass;

/**
 * Classe responsável pela geração de código dos componentes.
 * 
 * @author adriano.pamplona
 */
public class GeradorComponentPojoClass extends ComponentPOJOClass {

	/**
	 * Construtor.
	 * 
	 * @param clazz Classe de persistência.
	 * @param cfg Configuração.
	 */
	public GeradorComponentPojoClass(Component component, Cfg2JavaTool cfg) {
		super(component, cfg);
	}

	
}
