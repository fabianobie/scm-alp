<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts2-jquery-tags"%>

<html>
	<head>
		<title>Teste Struts2</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/stylesheet/formulario.css" />

		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.maskedinput-1.2.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.alphanumeric-0.1.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.price_format.1.3.js"></script>
		<script type="text/javascript">
			jQuery(function($){
				jQuery(".mask-data").mask("99/99/9999");
				jQuery(".mask-hora-min").mask("99:99");
			    jQuery(".mask-hora-min-seg").mask("99:99:99");
			    jQuery(".mask-timestamp").mask("99/99/9999 99:99");
			    jQuery(".mask-alpha").alpha();
			    jQuery(".mask-number").numeric();
			    jQuery(".mask-moeda").priceFormat({
					prefix: "",
				    centsSeparator: ",",
				    thousandsSeparator: "."
				});
				jQuery(".mask-cnpj").mask("99.999.999/9999-99");
				jQuery(".mask-cpf").mask("999.999.999-99"); 
				jQuery(".mask-rg").mask("9.999.999"); 
				jQuery(".mask-telefone").mask("9999-9999");
			    jQuery(".mask-ddd-telefone").mask("(99) 9999-9999");
			    jQuery(".mask-cep").mask("99999-999");
			});
		</script>
	</head>
	
	<body>
		<s:form action="Principal" theme="simple">
			<s:label value="Data" for="txtData"/>
			<s:textfield id="txtData" cssClass="txt-data mask-data"/>
			<br/>
			<s:label value="Hora/Minuto" for="txtHoraMinuto"/>
			<s:textfield id="txtHoraMinuto" cssClass="txt-hora-min mask-hora-min"/>
			<br/>
			<s:label value="Hora/Minuto/Segundo" for="txtHoraMinutoSegundo"/>
			<s:textfield id="txtHoraMinutoSegundo" cssClass="txt-hora-min-seg mask-hora-min-seg"/>
			<br/>
			<s:label value="Timestamp" for="txtTimestamp"/>
			<s:textfield id="txtTimestamp" cssClass="txt-timestamp mask-timestamp"/>
			<br/>
			<s:label value="Alpha" for="txtAlpha"/>
			<s:textfield id="txtAlpha" cssClass="txt-alpha mask-alpha"/>
			<br/>
			<s:label value="Number" for="txtNumber"/>
			<s:textfield id="txtNumber" cssClass="txt-number mask-number"/>
			<br/>
			<s:label value="Moeda" for="txtMoeda"/>
			<s:textfield id="txtMoeda" cssClass="txt-moeda mask-moeda"/>
			<br/>
			<s:label value="CNPJ" for="txtCNPJ"/>
			<s:textfield id="txtCNPJ" cssClass="txt-cnpj mask-cnpj"/>
			<br/>
			<s:label value="CPF" for="txtCPF"/>
			<s:textfield id="txtCPF" cssClass="txt-cpf mask-cpf"/>
			<br/>
			<s:label value="RG" for="txtRG"/>
			<s:textfield id="txtRG" cssClass="txt-rg mask-rg"/>
			<br/>
			<s:label value="Telefone" for="txtTelefone"/>
			<s:textfield id="txtTelefone" cssClass="txt-telefone mask-telefone"/>
			<br/>
			<s:label value="Telefone DDD" for="txtTelefoneDDD"/>
			<s:textfield id="txtTelefoneDDD" cssClass="txt-ddd-telefone mask-ddd-telefone"/>
			<br/>
			<s:label value="CEP" for="txtCEP"/>
			<s:textfield id="txtCEP" cssClass="txt-cep mask-cep"/>

			<hr/>
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
		
	</body>
</html>
