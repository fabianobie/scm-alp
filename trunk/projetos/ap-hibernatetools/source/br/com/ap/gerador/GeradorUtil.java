/**
 * GeradorUtil.java
 *
 * Data: 17/12/2009
 */
package br.com.ap.gerador;

import org.hibernate.mapping.Component;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;

import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilitária do gerador.
 * 
 * @author adriano.pamplona
 * 
 */
public class GeradorUtil {

	/**
	 * Gera anotações extras para um atributo.
	 * 
	 * @param clazz PersistentClass
	 * @param property Property
	 * @return anotações extras para um atributo.
	 */
	public String generateMetaColumn(PersistentClass clazz, Property property) {
		StringBuffer resultado = getStringFactory().novoStringBuffer();
		String metaName = "meta-" + property.getName();

		MetaAttribute meta = clazz.getMetaAttribute(metaName);
		if (UtilObjeto.isReferencia(meta)) {
			String valor = meta.getValue();
			resultado.append(UtilString.trim(valor));
		}
		return resultado.toString();
	}

	/**
	 * Gera anotações extras para um atributo.
	 * 
	 * @param component Component
	 * @param property Property
	 * @return anotações extras para um atributo.
	 */
	public String generateMetaColumn(Component component, Property property) {
		StringBuffer resultado = getStringFactory().novoStringBuffer();
		String metaName = "meta-" + property.getName();

		MetaAttribute meta = component.getMetaAttribute(metaName);
		if (UtilObjeto.isReferencia(meta)) {
			String valor = meta.getValue();
			resultado.append(UtilString.trim(valor));
		}
		return resultado.toString();
	}

	/**
	 * @return StringFactory
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}
}
