/**
 * GeradorUtil.java
 *
 * Data: 17/12/2009
 */
package br.com.ap.gerador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Any;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.tool.hbm2x.pojo.BasicPOJOClass;

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
		if (clazz.getNodeName().equals("ItemContrato") && property.getName().equals("servicoMaterial")) {
			System.out.println("foi");
		}
		StringBuffer resultado = getStringFactory().novoStringBuffer();
		String metaName = "meta-" + property.getName();

		MetaAttribute meta = property.getMetaAttribute(metaName);
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
	 * Gera anotações extras para um atributo.
	 * 
	 * @param clazz PersistentClass
	 * @return anotações extras para um atributo.
	 */
	public String generateMetaExtraClasse(PersistentClass clazz) {
		StringBuffer resultado = getStringFactory().novoStringBuffer();

		MetaAttribute meta = clazz.getMetaAttribute("extra-classe");
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
	 * @return anotações extras para um atributo.
	 */
	public String generateMetaExtraClasse(Component component) {
		StringBuffer resultado = getStringFactory().novoStringBuffer();
		
		MetaAttribute meta = component.getMetaAttribute("extra-classe");
		if (UtilObjeto.isReferencia(meta)) {
			String valor = meta.getValue();
			resultado.append(UtilString.trim(valor));
		}
		return resultado.toString();
	}

	/**
	 * Retorna true se o mapeamento for do tipo Any.
	 * 
	 * @param property Propriedade
	 * @return true se o mapeamento for do tipo Any.
	 */
	public boolean isAny(Property property) {
		return (property.getValue()!=null) && (property.getValue() instanceof Any);
	}
	
	/**
	 * Gera as anotações para um mapeamento do tipo 'any'.
	 * @param pojo Pojo
	 * @param property Propriedade
	 * @return anotações para um mapeamento 'any'
	 */
	@SuppressWarnings("unchecked")
	public String generateAny(BasicPOJOClass pojo, Property property) {
		StringBuilder resultado = new StringBuilder();
		
		if (isAny(property)) {
			pojo.importType("org.hibernate.annotations.Any");
			pojo.importType("org.hibernate.annotations.AnyMetaDef");
			pojo.importType("org.hibernate.annotations.MetaValue");
			pojo.importType("javax.persistence.JoinColumn");
			
			Any any = (Any) property.getValue();
			List<Column> columns = new ArrayList<Column>();
			Iterator<Column> iterator = any.getColumnIterator();
			while (iterator.hasNext()) {
				columns.add(iterator.next());
			}
			Column metaColumn = columns.get(0);
			Column joinColumn = columns.get(1);
			Map<String, String> mapaMetaValues = any.getMetaValues();
			Iterator<String> metaValues = mapaMetaValues.keySet().iterator();
			
			resultado.append("@Any(metaColumn = @Column(name = \"").append(metaColumn.getName()).append("\"))\n");
			resultado.append("\t@AnyMetaDef(idType = \""+ any.getIdentifierType() +"\", metaType = \""+ any.getMetaType() +"\", metaValues = {\n");
			while (metaValues.hasNext()) {
				String metaValue = metaValues.next();
				resultado.append("\t\t@MetaValue(targetEntity = "+ mapaMetaValues.get(metaValue) +".class, value = \""+ metaValue +"\")");
				resultado.append(",\n");
			}
			resultado.deleteCharAt(resultado.length()-1);
			resultado.deleteCharAt(resultado.length()-1);
			resultado.append("})\n");
			resultado.append("\t@JoinColumn(name=\""+ joinColumn.getName() +"\")\n");
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
