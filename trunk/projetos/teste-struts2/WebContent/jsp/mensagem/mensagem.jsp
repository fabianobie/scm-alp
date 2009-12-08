<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
	<head>
		<sj:head jqueryui="true" jquerytheme="cupertino"/>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form action="Principal" theme="simple">
			<s:if test="hasActionErrors() || hasActionMessages()">  
			<sj:dialog id="dialogErro" title="Erro" modal="true" >
				<s:actionerror/>
				<s:actionmessage/>
			</sj:dialog>
			</s:if>
			<s:submit value="Mensagem de Erro" action="Mensagem" method="acaoGerarMensagemDeErro"/>
			<br/>
			<s:submit value="Mensagem Informativa" action="Mensagem" method="acaoGerarMensagemInformativa"/>

			<hr/>
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
	</body>
</html>
