<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags"%>
<html>
	<head>
		<sj:head compressed="true"/>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form action="FormDinamico" theme="simple" method="post">
			String <s:textfield name="mapa['string']" value="%{getText(mapa['string'])}"/>
			<br/>
			Integer <s:textfield name="mapa['integer']" value="%{getText(mapa['integer'])}"/>
			<br/>
			Arquivo <s:file name="doc"/>

			<hr/>
			<s:submit method="acaoResultado" value="Enviar" />
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
	</body>
</html>
