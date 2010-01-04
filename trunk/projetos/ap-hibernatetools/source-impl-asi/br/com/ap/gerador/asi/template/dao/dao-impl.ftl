<#assign entidade>${var_pacote_entidade}.${pojo.getDeclarationName()}</#assign>
<#assign dao>${pojo.getDeclarationName()}${var_sufixo_classe}</#assign>
<#setting locale="pt_BR">
/*
 * ${dao}.java
 * 
 * Data de criação: ${date?string("dd/MM/yyyy")}
 */
package ${var_pacote_dao};

<#assign classbody>
/**
 * Interface para persistência do objeto ${pojo.getDeclarationName()}
 * 
 * @author Hibernatetools
 */
public class ${dao} extends ${pojo.importType("${var_superclasse}")}<${pojo.importType("${entidade}")}, ${pojo.importType("${entidade}")}, ${pojo.importType("${entidade}")}> {
	// classe
}
</#assign>
${pojo.generateImports()}
${classbody}