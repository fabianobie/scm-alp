<#if ejb3?if_exists>
<#if pojo.isComponent()>
@${pojo.importType("javax.persistence.Embeddable")}
<#else>
@${pojo.importType("javax.persistence.Entity")}
<#if clazz.table.schema?exists>
@${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}", schema="${clazz.table.schema}")
</#if><#if clazz.table.catalog?exists>
@${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}", catalog="${clazz.table.catalog}")
</#if>
<#assign uniqueConstraint=pojo.generateAnnTableUniqueConstraint()>
<#if uniqueConstraint?has_content>
    , uniqueConstraints = ${uniqueConstraint} 
</#if>
</#if>
</#if>