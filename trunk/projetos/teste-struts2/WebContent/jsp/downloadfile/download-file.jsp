<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags"%>
<html>
	<head>
		<sx:head />
		<title>Teste Struts2</title>
	</head>
	
	<body>
		<div style="width:99%; height:98%; background-color: white; position: absolute; display:none ;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5;" id="indicador-carregando">
			<img src="imagem/carregando.gif" style="position:fixed; left:50%; top: 50%;margin-top: -35px; margin-left: -75px;"/>
		</div>
		<s:form action="DownloadFile" theme="simple" method="post">
			<s:url id="urldownload" action="DownloadFile" method="acaoDownload">
				<s:param name="texto">teste do didi</s:param>
			</s:url>
			<sx:a href="%{urldownload}" indicator="indicador-carregando">Download</sx:a>
			<hr/>
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
	</body>
</html>
