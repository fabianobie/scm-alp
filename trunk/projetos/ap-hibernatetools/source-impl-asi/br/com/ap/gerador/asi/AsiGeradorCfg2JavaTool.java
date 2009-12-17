/**
 * AsiGeradorCfg2JavaTool.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2x.pojo.POJOClass;

import br.com.ap.gerador.GeradorCfg2JavaTool;

/**
 * Classe responsável em prover os recursos de objeto para o contexto dos
 * freemarker.
 * 
 * @author adriano.pamplona
 */
public class AsiGeradorCfg2JavaTool extends GeradorCfg2JavaTool {

	/**
	 * @see org.hibernate.tool.hbm2x.Cfg2JavaTool#getPOJOClass(org.hibernate.mapping.PersistentClass)
	 */
	@Override
	public POJOClass getPOJOClass(PersistentClass comp) {		
		return new AsiGeradorEntityPojoClass(comp, this);
	}

}
