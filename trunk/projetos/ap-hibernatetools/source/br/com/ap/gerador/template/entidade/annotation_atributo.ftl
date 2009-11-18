<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
	${pojo.generateAnnIdGenerator()?replace("@", "\n\t@")?trim}
<#--	@${pojo.importType("javax.persistence.Id")} -->
<#--	@${pojo.importType("javax.persistence.GeneratedValue")} -->
</#if>
</#if>
<#if c2h.isManyToOne(property)>
	${pojo.generateManyToOneAnnotation(property).trim()}
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isCollection(property)>
	${pojo.generateCollectionAnnotation(property, cfg).trim()}
<#else>
<#assign anotacoes_de_coluna>
<#if !pojo.generateBasicAnnotation(property).trim().equals("")>${pojo.generateBasicAnnotation(property)}</#if>
<#if !pojo.generateAnnColumnAnnotation(property).trim().equals("")>${pojo.generateAnnColumnAnnotation(property)}</#if>
</#assign>
	${anotacoes_de_coluna?trim}
</#if>
</#if>