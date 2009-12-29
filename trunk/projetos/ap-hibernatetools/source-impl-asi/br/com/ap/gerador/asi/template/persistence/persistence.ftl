<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd"
	version="1.0">

	<persistence-unit name="PU" transaction-type="RESOURCE_LOCAL">
    	<provider>org.hibernate.ejb.HibernatePersistence</provider>
<#list classes as classe>
		<class>${classe.name}</class>
</#list>
    </persistence-unit>
</persistence>
