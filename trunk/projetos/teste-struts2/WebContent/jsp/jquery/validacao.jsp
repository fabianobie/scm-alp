<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags"%>

<html>
<head>
	<title>Teste Struts2</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery.validate.1.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery.validate.messages-1.6.js"></script>
	<style type="text/css">
	
	</style>

	<script type="text/javascript">
		$.validator.setDefaults( {
			submitHandler : function() {
				alert("Enviado");
			}
		});
	
		$(document).ready(function() {
			$("#formulario").validate({
				rules: {
					txtNome:{required:true},
					txtData:{required:true, date:true}
				}
			});
		});
	</script>
</head>
<body>
	<s:form id="formulario" action="JQuery" theme="simple">
		<s:label value="Nome (obrigatório)" for="txtNome"/>
		<s:textfield name="txtNome"/>
		<br/>
		<s:label value="Nascimento (data)" for="txtData"/>
		<s:textfield name="txtData"/>
		<br/>
		<s:submit value="Enviar"/>
	</s:form>
	<hr/>
</body>
</html>
