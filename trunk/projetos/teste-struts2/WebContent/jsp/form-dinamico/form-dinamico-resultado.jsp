<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags"%>
<html>
	<head>
		<sj:head compressed="true"/>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form action="FormDinamico" theme="simple">
			String: <s:property value="mapa['string']"/>
			<br/>
			Arquivo: <s:property value="docFileName"/>
			<hr/>
			<s:submit method="acaoCarregarFormDinamico" value="Voltar" />
		</s:form>
	</body>
</html>
