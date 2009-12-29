<#if ejb3?if_exists>
	<#assign anotacao_classe>
		<#if pojo.isComponent()>
@${pojo.importType("javax.persistence.Embeddable")}
		<#else>
@${pojo.importType("javax.persistence.Entity")}
@${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}"<#if clazz.table.schema?exists>, schema="${clazz.table.schema}"</#if><#if clazz.table.catalog?exists>, catalog="${clazz.table.catalog}"</#if><#if uniqueConstraint?has_content>, uniqueConstraints = ${pojo.generateAnnTableUniqueConstraint()}</#if>)
		</#if>
	</#assign>
${anotacao_classe?trim}
</#if>