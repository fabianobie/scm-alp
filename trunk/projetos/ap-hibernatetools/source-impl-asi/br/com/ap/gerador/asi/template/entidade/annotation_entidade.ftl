<#if ejb3?if_exists>
<#if pojo.isComponent()>
@${pojo.importType("javax.persistence.Embeddable")}
<#else>
@${pojo.importType("javax.persistence.Entity")}
@${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}"<#if clazz.table.schema?exists>schema="${clazz.table.schema}"</#if><#if clazz.table.catalog?exists>catalog="${clazz.table.catalog}"</#if>)
@${pojo.importType("org.jboss.seam.annotations.AutoCreate")}
@${pojo.importType("org.jboss.seam.annotations.Name")}(name="${pojo.obterNomePadraoJava()?trim}")
@${pojo.importType("org.jboss.seam.annotations.Scope.Scope")}(${pojo.importType("org.jboss.seam.ScopeType")}.CONVERSATION)
<#assign uniqueConstraint=pojo.generateAnnTableUniqueConstraint()>
<#if uniqueConstraint?has_content>
    , uniqueConstraints = ${uniqueConstraint} 
</#if>
</#if>
</#if>