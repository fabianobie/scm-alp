<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC
      "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
          "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping package="${pacote}">

<#list namedQueries as namedQuery>
	<query name="${namedQuery.name}">
		${namedQuery.query}
	</query>
	
</#list>
</hibernate-mapping>