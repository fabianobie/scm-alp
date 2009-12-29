/**
 * AsiGeradorEntityPojoClass.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.mapping.Component;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;

import br.com.ap.gerador.GeradorComponentPojoClass;

/**
 * Classe respons�vel pela gera��o de c�digo das entidades de pk.
 * 
 * @author adriano.pamplona
 */
@SuppressWarnings("all")
public class AsiGeradorComponentPojoClass extends GeradorComponentPojoClass {
	private Component	component;

	public AsiGeradorComponentPojoClass(Component component, Cfg2JavaTool cfg) {
		super(component, cfg);
		this.component = component;
	}
}
