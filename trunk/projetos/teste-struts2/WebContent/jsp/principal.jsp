<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<s:form>
			<s:a action="Excecao" method="acaoCarregarExcecao">Tratamento de exceções</s:a>
			<br/>
			<s:a action="Mensagem" method="acaoCarregarMensagem">Mensagens</s:a>
			<br/>
			<s:a action="JQuery" method="acaoCarregarMascara">JQuery Mascaras</s:a>
			<br/>
			<s:a action="JQuery" method="acaoCarregarValidacao">JQuery Validação</s:a>
			<br/>
			<s:a action="Validacao" method="acaoCarregarValidacao">Struts Validação - NOK</s:a>
			<br/>
			<s:a action="FormDinamico" method="acaoCarregarFormDinamico">Form Dinâmico</s:a>
			<br/>
			<s:a action="DownloadFile" method="acaoCarregarDownloadFile">Download de Arquivo</s:a>
		</s:form>
	</body>
</html>
