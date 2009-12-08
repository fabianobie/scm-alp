<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
	<head>
		<title>Teste Struts2</title>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.validate.1.6.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.metadata.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.validate.messages-1.6.js"></script>
		<style type="text/css">
			label.error {
				border: 1px solid red;
				color: red;
				font-weight: bold;
				padding: 3px;
				background-color: #99CCFF;
				margin: 6px 0;
				width: 120px;
				text-align: center;
			}
		</style>
		<script type="text/javascript">
			$.validator.setDefaults({
				submitHandler: function() {
					alert("Enviado");
					return true;
				}
			});

			$("#form1").validate({
				errorLabelContainer: $("#formulario div.error")
			});
		</script>
	</head>
	<body>
		<s:form id="formulario" action="JQuery">
			<s:label value="Nome" for="txtNome"/>
			<s:textfield id="txtNome" cssClass="{required:true}"/>
			<br/>
			<s:submit value="Enviar" method="acaoCarregarValidacao"/>
			<div class="error"></div>
		</s:form>
	</body>
</html>
