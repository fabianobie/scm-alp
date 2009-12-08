<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
	<head>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form action="Principal" theme="simple">
			<s:actionerror/>
			
			<s:submit value="Erro de Negócio" action="Excecao" method="acaoGerarBusinessException"/>
			<br/>
			<s:submit value="Erro de Sistema" action="Excecao" method="acaoGerarSystemException"/>

			<hr/>
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
		
	</body>
</html>
