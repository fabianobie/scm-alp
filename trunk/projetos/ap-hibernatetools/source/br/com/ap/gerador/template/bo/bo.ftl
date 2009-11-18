<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}Bo.java
 * 
 * Data de criação: ${date?string("dd/MM/yyyy")}
 */
${pojo.getPackageDeclaration()}

<#assign entidade>${var_pacote_entidade}.${pojo.getDeclarationName()}</#assign>
<#assign var_atributo_entidade>${pojo.getDeclarationName()?substring(0, 1)?lower_case}${pojo.getDeclarationName()?substring(1)}</#assign>
<#assign dao>${var_pacote_dao}.${pojo.getDeclarationName()}Dao</#assign>
<#assign classbody>
/**
 * Classe para encapsulamento da regra de negocio do objeto ${pojo.getDeclarationName()}.
 * 
 * @author Hibernatetools
 */
<#if ejb3>
@${pojo.importType("org.springframework.stereotype.Component")}
</#if>
public class ${pojo.getDeclarationName()}Bo extends ${pojo.importType("${var_superclasse}")}<${pojo.importType("${entidade}")}> {
	
	@${pojo.importType("javax.annotation.Resource")}(name = "${var_atributo_entidade}DaoImpl")
	private ${pojo.getDeclarationName()}Dao	dao;
	
	/**
	 * Construtor default para rentringir a criação desta classe somente a este
	 * pacote.
	 */
	${pojo.getDeclarationName()}Bo() {
		// Construtor default
	}
	
	/**
	 * @see br.jus.stj.alp01.arquitetura.negocio.bo.BO#getDao()
	 */
	@Override
	protected ${pojo.importType("${var_pacote_dao}.${pojo.getDeclarationName()}Dao")} getDao() {
		return dao;
	}
}
</#assign>
import ${entidade};
${pojo.generateImports()}
${classbody}