<#foreach property in pojo.getAllPropertiesIterator()>
	<#include "annotation_atributo.ftl"/>
<#if property.equals(clazz.identifierProperty)>
	${pojo.getFieldModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} id<#if pojo.hasFieldInitializor(property, jdk5)> = ${pojo.getFieldInitialization(property, jdk5)}</#if>;
<#else>
	${pojo.getFieldModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} ${property.name}<#if pojo.hasFieldInitializor(property, jdk5)> = ${pojo.getFieldInitialization(property, jdk5)}</#if>;
</#if>

</#foreach>