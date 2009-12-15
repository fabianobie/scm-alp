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
 * Classe respons�vel pela gera��o de c�digo.
 * 
 * @author adriano.pamplona
 */
public class GeradorEntityPojoClass extends EntityPOJOClass {

	/**
	 * Construtor.
	 * 
	 * @param clazz Classe de persist�ncia.
	 * @param cfg Configura��o.
	 */
	public GeradorEntityPojoClass(PersistentClass clazz, Cfg2JavaTool cfg) {
		super(clazz, cfg);
	}
}
