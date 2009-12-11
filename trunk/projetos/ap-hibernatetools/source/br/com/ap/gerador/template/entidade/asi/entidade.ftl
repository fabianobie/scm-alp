<#setting locale="pt_BR">
/*
 * ${pojo.getDeclarationName()}.java
 * 
 * Data de criação: ${date?string("dd/MM/yyyy")}
 */
${pojo.getPackageDeclaration()}
<#assign superclasse_interface>
<#if pojo.getShortName().endsWith("Id")>
<#if !var_superclasse.equals("")>extends ${pojo.importType("${var_superclasse}")} </#if>implements ${pojo.importType("java.io.Serializable")} {
<#else>
<#if !var_superclasse.equals("")>extends ${pojo.importType("${var_superclasse}")} </#if><#if !var_superinterface.equals("")>implements ${pojo.importType("${var_superinterface}")}</#if> {
</#if> 
</#assign>

<#assign classbody>
/**
 * Classe que representa a entidade persistente <code>${pojo.getDeclarationName()}</code>.
 *
 * @author Hibernatetools
 */
<#include "annotation_entidade.ftl"/>
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} ${superclasse_interface}
<#include "atributos.ftl"/>
<#include "metodos.ftl"/>
<#include "metodo_tostring.ftl"/>
<#include "metodo_equals_hashcode.ftl"/>
<#include "extra.ftl"/>
}
</#assign>
${pojo.generateImports()}
${classbody}
${pojo.class}
