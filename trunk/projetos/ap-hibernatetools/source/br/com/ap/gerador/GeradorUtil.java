/**
 * GeradorUtil.java
 *
 * Data: 17/12/2009
 */
package br.com.ap.gerador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Any;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.ToOne;
import org.hibernate.mapping.Value;
import org.hibernate.tool.hbm2x.pojo.AnnotationBuilder;
import org.hibernate.tool.hbm2x.pojo.BasicPOJOClass;
import org.hibernate.tool.hbm2x.pojo.ComponentPOJOClass;
import org.hibernate.tool.hbm2x.pojo.EntityPOJOClass;
import org.hibernate.util.StringHelper;

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
	
	public String substituirCaracteresEspeciais(String string) {
		//string = UtilString.substituirString(string, "<", "&lt;");
		//string = UtilString.substituirString(string, ">", "&gt;");
		return string;
	}
	
	public String generateManyToOneAnnotation(EntityPOJOClass pojo, Property property) {
		StringBuffer buffer = new StringBuffer(AnnotationBuilder.createAnnotation( pojo.importType("javax.persistence.ManyToOne") )
				.addAttribute( "cascade", pojo.getCascadeTypes(property))
				.addAttribute( "fetch", pojo.getFetchType(property))
				.getResult());
		buffer.append(pojo.getHibernateCascadeTypeAnnotation(property));
		return buffer.toString();
	}
	public String generateManyToOneAnnotation(ComponentPOJOClass pojo, Property property) {
		StringBuffer buffer = new StringBuffer(AnnotationBuilder.createAnnotation( pojo.importType("javax.persistence.ManyToOne") )
				.addAttribute( "cascade", getCascadeTypes(pojo, property))
				.addAttribute( "fetch", getFetchType(pojo, property))
				.getResult());
		buffer.append(getHibernateCascadeTypeAnnotation(pojo, property));
		return buffer.toString();
	}
	
	public String getCascadeTypes(ComponentPOJOClass pojo, Property property) {
		property.setCascade("all");
		StringTokenizer st =  new StringTokenizer( property.getCascade(), ", ", false );
		String cascadeType = null;
		StringBuffer cascade = new StringBuffer();
		while ( st.hasMoreElements() ) {
			String element = ( (String) st.nextElement() ).toLowerCase();
			if ( "persist".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".PERSIST").append(", ");
			}
			else if ( "merge".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".MERGE").append(", ");
			}
			else if ( "delete".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".REMOVE").append(", ");
			}
			else if ( "refresh".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".REFRESH").append(", ");
			}
			else if ( "all".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".ALL").append(", ");
			}
		}
		if ( cascade.length() >= 2 ) {
			cascade.setLength( cascade.length() - 2 );
		}
		return cascade.toString();
	}
	
	public String getFetchType(ComponentPOJOClass pojo, Property property) {
		Value value = property.getValue();
		String fetchType = pojo.importType( "javax.persistence.FetchType");
		boolean lazy = false;
		if ( value instanceof ToOne ) {
			lazy = ( (ToOne) value ).isLazy();
		}
		else if ( value instanceof Collection ) {
			lazy = ( (Collection) value ).isLazy();
		}
		else {
			//we're not collection neither *toone so we are looking for property fetching
			lazy = property.isLazy();
		}
		if ( lazy ) {
			return fetchType + "." + "LAZY";
		}
		else {
			return fetchType + "." + "EAGER";
		}
	}
	
	public String getHibernateCascadeTypeAnnotation(ComponentPOJOClass pojo, Property property) {
		StringTokenizer st =  new StringTokenizer( property.getCascade(), ", ", false );
		String cascadeType = null;
		StringBuffer cascade = new StringBuffer();
		while ( st.hasMoreElements() ) {
			String element = ( (String) st.nextElement() ).toLowerCase();
			if ( "all-delete-orphan".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".ALL").append(", ")
						.append( cascadeType ).append(".DELETE_ORPHAN").append(", ");
			}
			else if ( "delete-orphan".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".DELETE_ORPHAN").append(", ");
			}
			else if ( "save-update".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".SAVE_UPDATE").append(", ");
			}
			else if ( "replicate".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".REPLICATE").append(", ");
			}
			else if ( "lock".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".LOCK").append(", ");
			}
			else if ( "evict".equals( element ) ) {
				if (cascadeType == null) cascadeType = pojo.importType( "org.hibernate.annotations.CascadeType");
				cascade.append( cascadeType ).append(".EVICT").append(", ");
			}
		}
		if ( cascade.length() >= 2 ) {
			String hibernateCascade = pojo.importType("org.hibernate.annotations.Cascade");
			cascade.insert(0, "@" + hibernateCascade + "( {");
			cascade.setLength( cascade.length() - 2 );
			cascade.append("} )");
		}
		return cascade.toString();
	}

	public String generateJoinColumnsAnnotation(EntityPOJOClass pojo, Property property, Configuration cfg) {
		return pojo.generateJoinColumnsAnnotation(property, cfg);
	}
	
	public String generateJoinColumnsAnnotation(ComponentPOJOClass pojo, Property property, Configuration cfg) {
		boolean insertable = property.isInsertable();
		boolean updatable = property.isUpdateable();
		Value value = property.getValue();
		int span;
		Iterator columnIterator;
		Iterator referencedColumnsIterator = null;
		if (value != null && value instanceof Collection) {
			Collection collection = (Collection) value;
			span = collection.getKey().getColumnSpan();
			columnIterator = collection.getKey().getColumnIterator();
		}
		else {
			span = property.getColumnSpan();
			columnIterator = property.getColumnIterator();
		}

		if(property.getValue() instanceof ToOne) {
			String referencedEntityName = ((ToOne)property.getValue()).getReferencedEntityName();
			PersistentClass target = cfg.getClassMapping(referencedEntityName);
			if(target!=null) {
				referencedColumnsIterator = target.getKey().getColumnIterator();
			}
		}

		StringBuffer annotations = new StringBuffer( "    " );
		if ( span == 1 ) {
				Selectable selectable = (Selectable) columnIterator.next();
				buildJoinColumnAnnotation(pojo, selectable, null, annotations, insertable, updatable );
		}
		else {
			Iterator columns = columnIterator;
			annotations.append("@").append( pojo.importType("javax.persistence.JoinColumns") ).append("( { " );
			buildArrayOfJoinColumnAnnotation( pojo, columns, referencedColumnsIterator, annotations, insertable, updatable );
			annotations.append( " } )" );
		}
		return annotations.toString();
	}
	
	private void buildJoinColumnAnnotation(ComponentPOJOClass pojo,
			Selectable selectable, Selectable referencedColumn, StringBuffer annotations, boolean insertable, boolean updatable
	) {
		if ( selectable.isFormula() ) {
			//TODO not supported by HA
		}
		else {
			Column column = (Column) selectable;
			annotations.append("@").append( pojo.importType("javax.persistence.JoinColumn") )
					.append("(name=\"" ).append( column.getName() ).append( "\"" );
					//TODO handle referenced column name, this is a hard one
			        if(referencedColumn!=null) {
			         annotations.append(", referencedColumnName=\"" ).append( referencedColumn.getText() ).append( "\"" );
			        }

					appendCommonColumnInfo(annotations, column, insertable, updatable);
			//TODO support secondary table
			annotations.append( ")" );
		}
	}
	
	protected void appendCommonColumnInfo(StringBuffer annotations, Column column, boolean insertable, boolean updatable) {
		if(column.isUnique()) {
				annotations.append( ", unique=" ).append( column.isUnique() );
		}
		if(!column.isNullable()) {
				annotations.append( ", nullable=" ).append( column.isNullable() );
		}
		
		if(!insertable) {
				annotations.append( ", insertable=" ).append( insertable );
		}
		
		if(!updatable) {
				annotations.append( ", updatable=" ).append( updatable );
		}
		
		String sqlType = column.getSqlType();
		if ( StringHelper.isNotEmpty( sqlType ) ) {
			annotations.append( ", columnDefinition=\"" ).append( sqlType ).append( "\"" );
		}
				
	}
	
	private void buildArrayOfJoinColumnAnnotation(ComponentPOJOClass pojo,
			Iterator columns, Iterator referencedColumnsIterator, StringBuffer annotations, boolean insertable,
			boolean updatable
	) {
		while ( columns.hasNext() ) {
			Selectable selectable = (Selectable) columns.next();
            Selectable referencedColumn = null;
            if(referencedColumnsIterator!=null) {
            	referencedColumn = (Selectable) referencedColumnsIterator.next();
            }

			if ( selectable.isFormula() ) {
				//TODO formula in multicolumns not supported by annotations
				//annotations.append("/* TODO formula in multicolumns not supported by annotations */");
			}
			else {
				annotations.append( "\n        " );
				buildJoinColumnAnnotation( pojo, selectable, referencedColumn, annotations, insertable, updatable );
				annotations.append( ", " );
			}
		}
		annotations.setLength( annotations.length() - 2 );
	}
	
	public String ajustarImplements(String extendz, String implementation) {
		if (!UtilString.isVazio(implementation)) {
			implementation = UtilString.trim(implementation);
			implementation = UtilString.remover(implementation, Serializable.class.getName());
			if (implementation.startsWith(",")) {
				implementation = implementation.substring(1);
			}
			if (implementation.endsWith(",")) {
				implementation = implementation.substring(0, implementation.length()-1);
			}
			implementation = UtilString.trim(implementation);
			if (implementation.equalsIgnoreCase("implements")) {
				implementation = "";
			}
		}
		
		if (UtilString.isVazio(extendz) && UtilString.isVazio(implementation)) {
			implementation = "implements java.io.Serializable";
		}
		return implementation;
	}
}
