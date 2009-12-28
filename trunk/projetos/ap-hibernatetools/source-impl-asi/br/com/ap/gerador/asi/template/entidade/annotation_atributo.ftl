<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
	${pojo.generateAnnIdGenerator()?trim}
</#if>
</#if>
<#if c2h.isManyToOne(property)>
	${pojo.generateManyToOneAnnotation(property).trim()}
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isOneToOne(property)>
	${pojo.generateOneToOneAnnotation(property, cfg).trim()}
<#elseif c2h.isCollection(property)>
	${pojo.generateCollectionAnnotation(property, cfg).trim()}
<#elseif util.isAny(property)>
	${util.generateAny(pojo, property).trim()}
<#else>
<#assign anotacoes_de_coluna>
<#if !pojo.generateBasicAnnotation(property).trim().equals("")>${pojo.generateBasicAnnotation(property)}</#if>
<#if !pojo.generateAnnColumnAnnotation(property).trim().equals("")>${pojo.generateAnnColumnAnnotation(property)}</#if>
	${util.generateMetaColumn(clazz, property)}

</#assign>
	${anotacoes_de_coluna?trim}
</#if>
</#if>
