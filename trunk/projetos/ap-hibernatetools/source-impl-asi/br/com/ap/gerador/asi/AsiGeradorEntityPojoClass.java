/**
 * AsiGeradorEntityPojoClass.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador.asi;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import org.hibernate.cfg.Configuration;
import org.hibernate.id.MultipleHiLoPerTableGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.KeyValue;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.SimpleValue;
import org.hibernate.mapping.SingleTableSubclass;
import org.hibernate.mapping.Table;
import org.hibernate.mapping.Value;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.util.StringHelper;

import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.gerador.GeradorEntityPojoClass;

/**
 * Classe responsável pela geração de código.
 * 
 * @author adriano.pamplona
 */
@SuppressWarnings("all")
public class AsiGeradorEntityPojoClass extends GeradorEntityPojoClass {

	private PersistentClass clazz;

	/**
	 * Construtor.
	 * 
	 * @param clazz Classe de persistência.
	 * @param cfg Configuração.
	 */
	public AsiGeradorEntityPojoClass(PersistentClass clazz, Cfg2JavaTool cfg) {
		super(clazz, cfg);
		this.clazz = clazz;
	}

	public String generateMetaColumn(Property property) {
		StringBuffer resultado = StringFactory.getInstancia().novoStringBuffer();
		String metaName = "meta-"+ property.getName();
		
		MetaAttribute meta = clazz.getMetaAttribute(metaName);
		if (meta != null) {
			String valor = meta.getValue();
			resultado.append(UtilString.trim(valor));
		}
		return resultado.toString();
	}
	
	public String generateCollectionAnnotation(Property property, Configuration cfg) {
		
		if (property.getName().equals("valores")) {
			Iterator<Column> iterator = ((org.hibernate.mapping.Set)property.getValue()).getKey().getColumnIterator();
			while (iterator.hasNext()) {
				Column c = iterator.next();
				if (c.getName().equals("ID_VALORCARAC_CS")) {
					c.setName("ID_CARACT_SERVICO");
				}
			}
			
		}
		return super.generateCollectionAnnotation(property, cfg);
	}

	public String generateAnnIdGenerator() {
		KeyValue identifier = clazz.getIdentifier();
		String strategy = null;
		Properties properties = null;
		StringBuffer wholeString = new StringBuffer( "    " );
		if ( identifier instanceof Component ) {

			wholeString.append( "@" + importType("javax.persistence.EmbeddedId") );
		}
		else if ( identifier instanceof SimpleValue ) {
			SimpleValue simpleValue = (SimpleValue) identifier;
			strategy = simpleValue.getIdentifierGeneratorStrategy();
			properties = simpleValue.getIdentifierGeneratorProperties();
			StringBuffer id = new StringBuffer().append("@").append( importType("javax.persistence.Id") ).append("\n");
			
			boolean isGenericGenerator = false; //TODO: how to handle generic now??
			if ( !"assigned".equals( strategy ) ) { 
				id.append("\t@").append( importType("javax.persistence.GeneratedValue") );
				if ( !"native".equals( strategy ) ) {
					id.append('(');
					if ( "identity".equals( strategy ) ) {
						id.append("strategy=");
						id.append( staticImport("javax.persistence.GenerationType", "IDENTITY" ) );
					}
					else if ( "sequence".equals( strategy ) ) {
						id.append("strategy=");
						id.append(importType("javax.persistence.GenerationType")).append(".SEQUENCE")
								.append( ", generator=\"generator\"" );
						buildAnnSequenceGenerator( wholeString, clazz );
					}
					else if ( MultipleHiLoPerTableGenerator.class.getName().equals( strategy ) ) {
						id.append("strategy=");
						id.append( staticImport("javax.persistence.GenerationType", "TABLE") )
								.append( ", generator=\"generator\"" );
						buildAnnTableGenerator( wholeString, properties );
					}
					else {
						isGenericGenerator = true;
						id.append( "generator=\"generator\"" );

					}
					id.append(')');
					id.append(wholeString);
					wholeString.delete(0, wholeString.length());
				}
			}
			if ( isGenericGenerator ) {
				wholeString.append( "@" + importType("org.hibernate.annotations.GenericGenerator"))
						.append( "(name=\"generator\", strategy=\"" )
						.append( strategy )
						.append( "\", " );
				wholeString.append( "parameters = {  " );
				if ( properties != null ) {
					Enumeration propNames = properties.propertyNames();
					while ( propNames.hasMoreElements() ) {
						String propertyName = (String) propNames.nextElement();
						wholeString.append( "@" + importType("org.hibernate.annotations.Parameter"))
								.append( "(name=\"" )
								.append( propertyName )
								.append( "\", " )
								.append( "value=\"" )
								.append( properties.getProperty( propertyName ) )
								.append( "\"), " );
					}
				}
				wholeString.setLength( wholeString.length() - 2 );
				wholeString.append( " } )\n" );
			}
			wholeString.append(id);
		}
		return wholeString.toString();
	}
	
	private void buildAnnSequenceGenerator(StringBuffer wholeString, PersistentClass clazz) {
		String sequenceName = "";
		Value identifierProperty = clazz.getIdentifierProperty().getValue();
		if (identifierProperty instanceof SimpleValue) {
			SimpleValue sv = (SimpleValue)identifierProperty;
			Properties properties = sv.getIdentifierGeneratorProperties();
			if (properties != null) {
				sequenceName = properties.getProperty("sequence");
			}
		}
		if (UtilString.isVazio(sequenceName)) {
			sequenceName = getNomeTabela();
			if (UtilString.isVazio(sequenceName)) {
				sequenceName = getNomeEntidade(clazz);
			} else {
				sequenceName = UtilString.maiuscula(sequenceName);
			}
			sequenceName = "SQ_"+ sequenceName;
		}
		wholeString.append("\n\t@" + importType("javax.persistence.SequenceGenerator") + "(name=\"generator\", sequenceName=\"" )
				.append(sequenceName)
				.append( "\")" );
		//TODO HA does not support initialValue and allocationSize
		wholeString.append( "\n    " );
	}

	private void buildAnnTableGenerator(StringBuffer wholeString, Properties properties) {
		wholeString.append( "@" + importType("javax.persistence.TableGenerator") + "(name=\"generator\", table=\"" )
				.append( properties.getProperty( "generatorTableName", "hibernate_sequences" ) )
				.append("\"");
		if ( ! isPropertyDefault( PersistentIdentifierGenerator.CATALOG, properties ) ) {
			wholeString.append(", catalog=\"")
				.append( properties.getProperty( PersistentIdentifierGenerator.CATALOG, "") );
		}
		if ( ! isPropertyDefault( PersistentIdentifierGenerator.SCHEMA, properties ) ) {
			wholeString.append(", schema=\"")
				.append( properties.getProperty( PersistentIdentifierGenerator.SCHEMA, "") );
		}
		if (! isPropertyDefault( MultipleHiLoPerTableGenerator.PK_VALUE_NAME, properties ) ) {
			wholeString.append(", pkColumnValue=\"")
					.append(properties.getProperty( MultipleHiLoPerTableGenerator.PK_VALUE_NAME, "" ) ).append("\"");
		}
		if ( ! isPropertyDefault( MultipleHiLoPerTableGenerator.MAX_LO, properties, "50" ) ) {
			wholeString.append(", allocationSize=")
					.append(properties.getProperty( MultipleHiLoPerTableGenerator.MAX_LO, "50" ) );
		}
		if (! isPropertyDefault( MultipleHiLoPerTableGenerator.PK_COLUMN_NAME, properties ) ) {
			wholeString.append(", pkColumnName=\"")
					.append( properties.getProperty( MultipleHiLoPerTableGenerator.PK_COLUMN_NAME, "" ) )
					.append( "\"");
		}
		if (! isPropertyDefault( MultipleHiLoPerTableGenerator.VALUE_COLUMN_NAME, properties ) ) {
			wholeString.append( ", valueColumnName=\"")
					.append( properties.getProperty( MultipleHiLoPerTableGenerator.VALUE_COLUMN_NAME, "" ) )
					.append("\"");
		}
		wholeString.append( ")\n    " );
	}

	private boolean isPropertyDefault(String property, Properties properties) {
		return StringHelper.isEmpty( properties.getProperty( property ) );
	}

	private boolean isPropertyDefault(String property, Properties properties, String defaultValue) {
		String propertyValue = properties.getProperty( property );
		return propertyValue != null && propertyValue.equals( defaultValue );
	}


	protected String getNomeEntidade(PersistentClass clazz) {
		String nome = clazz.getEntityName();
		nome = UtilString.substring(nome, nome.lastIndexOf(".")+1);
		return UtilString.maiuscula(nome);
	}
	
	protected String getNomeTabela() {
		String resultado = null;
		
		if (UtilObjeto.isReferencia(meta) && (meta instanceof RootClass)) {
			RootClass rootClass = (RootClass) meta;
			Table tabela = rootClass.getTable();
			resultado = tabela.getName();
		}
		return resultado;
	}
	
	public String obterNomePadraoJava() {
		String nome = clazz.getEntityName();
		nome = UtilString.substring(nome, nome.lastIndexOf(".")+1);
		String prefixo = String.valueOf(nome.charAt(0));
		String sufixo = nome.substring(1);
		prefixo = prefixo.toLowerCase();
		return prefixo + sufixo;
	}
	
	/**
	 * Method getGetterSignature.
	 *
	 * @return String
	 */
	public String getGetterSignature(Property p) {
		return super.getGetterSignature(p);
//		
//		String prefix = "get";
//		String tipo = c2j.getJavaTypeName( p, false);
//		
//		if (tipo.equalsIgnoreCase("boolean") || tipo.equals(Boolean.class.getName())) {
//			prefix = "is";
//		}
//		return prefix + beanCapitalize( p.getName() );
	}

	@Override
	public String[] getCascadeTypes(Property property) {
		StringTokenizer st =  new StringTokenizer( property.getCascade(), ", ", false );
		String cascadeType = null;
		StringBuffer cascade = new StringBuffer();
		while ( st.hasMoreElements() ) {
			String element = ( (String) st.nextElement() ).toLowerCase();
			if ( "persist".equals( element ) ) {
				if (cascadeType == null) cascadeType = importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".PERSIST").append(", ");
			}
			else if ( "merge".equals( element ) ) {
				if (cascadeType == null) cascadeType = importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".MERGE").append(", ");
			}
			else if ( "delete".equals( element ) ) {
				if (cascadeType == null) cascadeType = importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".REMOVE").append(", ");
			}
			else if ( "refresh".equals( element ) ) {
				if (cascadeType == null) cascadeType = importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".REFRESH").append(", ");
			}
			else if ( "all".equals( element ) || "none".equals( element )) {
				if (cascadeType == null) cascadeType = importType( "javax.persistence.CascadeType");
				cascade.append( cascadeType ).append(".ALL").append(", ");
			}
		}
		if ( cascade.length() >= 2 ) {
			cascade.setLength( cascade.length() - 2 );
		}
		return cascade.toString().split(", ");
	}
	
	public String generateDiscriminatorValue() {
		StringBuilder resultado = new StringBuilder();
		if (clazz instanceof SingleTableSubclass) {
			resultado.append("@");
			resultado.append(importType("javax.persistence.DiscriminatorValue"));
			resultado.append("(value=\"");
			resultado.append(clazz.getDiscriminatorValue());
			resultado.append("\")");
		}
		return resultado.toString();
	}
}
