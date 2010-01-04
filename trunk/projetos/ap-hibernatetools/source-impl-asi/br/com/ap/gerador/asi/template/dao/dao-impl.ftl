<#assign entidade>${var_pacote_entidade}.${pojo.getDeclarationName()}</#assign>
<#assign dao>${pojo.getDeclarationName()}${var_sufixo_classe}</#assign>
<#setting locale="pt_BR">
/*
 * ${dao}.java
 * 
 * Data de cria��o: ${date?string("dd/MM/yyyy")}
 */
package ${var_pacote_dao};

<#assign classbody>
/**
 * Interface para persist�ncia do objeto ${pojo.getDeclarationName()}
 * 
 * @author Hibernatetools
 */
public class ${dao} extends ${pojo.importType("${var_superclasse}")}<${pojo.importType("${entidade}")}, ${pojo.importType("${entidade}")}, ${pojo.importType("${entidade}")}> {
	// classe
}
</#assign>
${pojo.generateImports()}
${classbody}