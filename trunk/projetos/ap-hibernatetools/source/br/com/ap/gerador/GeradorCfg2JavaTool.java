/**
 * GeradorCfg2JavaTool.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador;

import org.hibernate.mapping.Component;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.pojo.POJOClass;

/**
 * Classe responsável em prover os recursos de objeto para o contexto dos
 * freemarker.
 * 
 * @author adriano.pamplona
 */
public class GeradorCfg2JavaTool extends Cfg2JavaTool {

	/**
	 * @see org.hibernate.tool.hbm2x.Cfg2JavaTool#getPOJOClass(org.hibernate.mapping.PersistentClass)
	 */
	@Override
	public POJOClass getPOJOClass(PersistentClass comp) {
		return new GeradorEntityPojoClass(comp, this);
	}

	/**
	 * @see org.hibernate.tool.hbm2x.Cfg2JavaTool#getPOJOClass(org.hibernate.mapping.Component)
	 */
	@Override
	public POJOClass getPOJOClass(Component comp) {
		return new GeradorComponentPojoClass(comp, this);
	}

}
