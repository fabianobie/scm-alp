/**
 * GeradorEntityPojoClass.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.pojo.EntityPOJOClass;

/**
 * Classe responsável pela geração de código.
 * 
 * @author adriano.pamplona
 */
public class GeradorEntityPojoClass extends EntityPOJOClass {

	/**
	 * Construtor.
	 * 
	 * @param clazz Classe de persistência.
	 * @param cfg Configuração.
	 */
	public GeradorEntityPojoClass(PersistentClass clazz, Cfg2JavaTool cfg) {
		super(clazz, cfg);
	}
}
