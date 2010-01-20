/**
 * GeradorEntityPojoClass.java
 *
 * Data: 11/12/2009
 */
package br.com.ap.gerador;

import java.io.Serializable;
import java.util.List;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.pojo.EntityPOJOClass;

import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.string.UtilString;

/**
 * Classe responsável pela geração de código.
 * 
 * @author adriano.pamplona
 */
public class GeradorEntityPojoClass extends EntityPOJOClass {
	@SuppressWarnings("unused")
	private PersistentClass clazz;
	
	/**
	 * Construtor.
	 * 
	 * @param clazz Classe de persistência.
	 * @param cfg Configuração.
	 */
	public GeradorEntityPojoClass(PersistentClass clazz, Cfg2JavaTool cfg) {
		super(clazz, cfg);
		this.clazz = clazz;
	}


	@Override
	public String getExtendsDeclaration() {
		String resultado = StringFactory.getInstancia().novaString();
		String extendz = getExtends();
		if (!UtilString.isVazio(extendz)) {
			resultado = "extends " + importType(extendz);
		}
		return resultado;
	}
	
	@Override
	public String getImplementsDeclaration() {
		String resultado = StringFactory.getInstancia().novaString();
		String implementz = getImplements();
		String extendz = getExtends();
		if (!UtilString.isVazio(extendz)) {
			implementz = UtilString.remover(implementz, Serializable.class.getName());
		}
		implementz = UtilString.trim(implementz);
		
		if (!UtilString.isVazio(implementz)) {
			resultado = "implements " + importType(implementz);
		}
		
//		if (UtilString.isVazio(extendz, resultado)) {
//			resultado = "implements " + importType("java.io.Serializable");
//		}
		return resultado;
	}
	
	@Override
	public String importType(String classe) {
		StringBuffer resultado = StringFactory.getInstancia().novoStringBuffer();
		
		if (UtilString.isTemString(classe, ",")) {
			List<String> classes = UtilString.split(classe, ",");
			for (String classeTemp : classes) {
				classeTemp = UtilString.trim(classeTemp);
				resultado.append(super.importType(classeTemp)).append(",");
			}
			
			if (resultado.length() > 1) {
				resultado.deleteCharAt(resultado.length()-1);
			}
		} else {
			resultado.append(super.importType(classe));
		}
		return resultado.toString();
	}

	
}
