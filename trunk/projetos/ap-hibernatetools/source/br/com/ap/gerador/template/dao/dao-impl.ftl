<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}${var_sufixo_classe}.java
 * 
 * Data de criação: ${date?string("dd/MM/yyyy")}
 */
${pojo.getPackageDeclaration()}

<#assign entidade>${var_pacote_entidade}.${pojo.getDeclarationName()}</#assign>
<#assign dao>${var_pacote_interface_dao}.${pojo.getDeclarationName()}${var_sufixo_dao_interface}</#assign>
<#assign classbody>
/**
 * Interface para persistência do objeto ${pojo.getDeclarationName()}
 * 
 * @author Hibernatetools
 */
<#if ejb3>
@${pojo.importType("org.springframework.stereotype.Repository")}
</#if>
public class ${pojo.getDeclarationName()}${var_sufixo_classe} extends ${pojo.importType("${var_superclasse}")}<${pojo.importType("${entidade}")}>
		implements ${pojo.importType("${dao}")} {
	// classe
}
</#assign>
${pojo.generateImports()}
${classbody}