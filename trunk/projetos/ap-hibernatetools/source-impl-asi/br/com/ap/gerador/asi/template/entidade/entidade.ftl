<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}.java
 * 
 * Data de criação: ${date?string("dd/MM/yyyy")}
 */
${pojo.getPackageDeclaration()}

<#assign classbody>
/**
 * Classe que representa a entidade persistente <code>${pojo.getDeclarationName()}</code>.
 *
 * @author Hibernatetools
 */
<#assign anotacoes>
	${util.generateMetaExtraClasse(clazz)}
	<#include "annotation_entidade.ftl"/>
</#assign>
${anotacoes?trim}
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} ${pojo.getExtendsDeclaration()} ${util.ajustarImplements(pojo.getExtendsDeclaration(), pojo.getImplementsDeclaration())} {

<#include "atributos.ftl"/>
<#include "metodos.ftl"/>
<#include "metodo_tostring.ftl"/>
<#include "metodo_equals_hashcode.ftl"/>
<#include "extra.ftl"/>
}
</#assign>
${pojo.generateImports()}
${classbody}
