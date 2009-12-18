<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}${var_sufixo_classe}.java
 * 
 * Data de cria��o: ${date?string("dd/MM/yyyy")}
 */
${pojo.getPackageDeclaration()}

<#assign entidade>${var_pacote_entidade}.${pojo.getDeclarationName()}</#assign>
<#assign classbody>
/**
 * Interface para persist�ncia do objeto ${pojo.getDeclarationName()}
 * 
 * @author Hibernatetools
 */
public interface ${pojo.getDeclarationName()}${var_sufixo_classe} extends ${pojo.importType("${var_superinterface}")}<${pojo.importType("${entidade}")}> {
	// interface
}
</#assign>
${pojo.generateImports()}
${classbody}