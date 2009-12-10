<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" 	uri="/struts-tags"%>
<%@ taglib prefix="sx" 	uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" 	uri="/struts2-jquery-tags"%>
<html>
	<head>
		<sj:head compressed="true"/>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form theme="simple" validate="true">
			<s:actionmessage cssStyle="color:green"/>
			<s:actionerror cssStyle="color:red"/>
			<s:label value="Nome (obrigatório)" for="txtNome"/>
			<s:textfield name="txtNome"/>
			<br/>
			<s:label value="Nascimento (data)" for="txtData"/>
			<s:textfield name="txtData"/>
			<br/>
			<s:submit value="Enviar" action="Validacao" method="acaoEnviar"/>
			<hr/>
			<s:submit value="Voltar" action="Principal" method="acaoCarregarPrincipal"/>
		</s:form>
	</body>
</html>
