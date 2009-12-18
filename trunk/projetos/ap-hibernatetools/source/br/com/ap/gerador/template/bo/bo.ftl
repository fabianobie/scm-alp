<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}${var_sufixo_classe}.java
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
public class ${pojo.getDeclarationName()}${var_sufixo_classe} extends ${pojo.importType("${var_superclasse}")}<${pojo.importType("${entidade}")}> {
	
	@${pojo.importType("javax.annotation.Resource")}(name = "${var_atributo_entidade}DaoImpl")
	private ${pojo.getDeclarationName()}${var_sufixo_classe_dao} crudDao;
	
	/**
	 * Construtor default para rentringir a criação desta classe somente a este
	 * pacote.
	 */
	${pojo.getDeclarationName()}${var_sufixo_classe}() {
		// Construtor padrão
	}
	
	@Override
	protected ${pojo.importType("${var_pacote_dao}.${pojo.getDeclarationName()}${var_sufixo_classe_dao}")} getCrudDao() {
		return crudDao;
	}
}
</#assign>
${pojo.generateImports()}
${classbody}