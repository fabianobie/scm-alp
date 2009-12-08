<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
	<head>
		<title>Teste Struts2</title>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.maskedinput-1.2.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.alphanumeric-0.1.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.price_format.1.3.js"></script>
		<script type="text/javascript">
			jQuery(function($){
				jQuery(".mask-data").mask("99/99/9999");
				jQuery(".mask-hora-min").mask("99:99");
			    jQuery(".mask-hora-min-seg").mask("99:99:99");
			    jQuery(".mask-timeStamp").mask("99/99/9999 99:99");
			    jQuery(".mask-alpha").alpha();
			    jQuery(".mask-number").numeric();
			    jQuery('.mask-moeda').priceFormat({
					prefix: '',
				    centsSeparator: ',',
				    thousandsSeparator: '.'
				});
				jQuery(".mask-cnpj").mask("99.999.999/9999-99");
				jQuery(".mask-cpf").mask("999.999.999-99"); 
				jQuery(".mask-rg").mask("9.999.999"); 
				jQuery(".mask-telefone").mask("9999-9999");
			    jQuery(".mask-telefone-ddd").mask("(99) 9999-9999");
			    jQuery(".mask-cep").mask("99999-999");
			});
		</script>
	</head>
	
	<body>
		<s:form action="Principal" theme="simple">
			<s:label value="Data" for="txtData"/>
			<s:textfield id="txtData" cssClass="mask-data"/>
			<br/>
			<s:label value="Hora/Minuto" for="txtHoraMinuto"/>
			<s:textfield id="txtHoraMinuto" cssClass="mask-hora-min"/>
			<br/>
			<s:label value="Hora/Minuto/Segundo" for="txtHoraMinutoSegundo"/>
			<s:textfield id="txtHoraMinutoSegundo" cssClass="mask-hora-min-seg"/>
			<br/>
			<s:label value="Timestamp" for="txtTimeStamp"/>
			<s:textfield id="txtTimeStamp" cssClass="mask-timeStamp"/>
			<br/>
			<s:label value="Alpha" for="txtAlpha"/>
			<s:textfield id="txtAlpha" cssClass="mask-alpha"/>
			<br/>
			<s:label value="Number" for="txtNumber"/>
			<s:textfield id="txtNumber" cssClass="mask-number"/>
			<br/>
			<s:label value="Moeda" for="txtMoeda"/>
			<s:textfield id="txtMoeda" cssClass="mask-moeda"/>
			<br/>
			<s:label value="CNPJ" for="txtCNPJ"/>
			<s:textfield id="txtCNPJ" cssClass="mask-cnpj"/>
			<br/>
			<s:label value="CPF" for="txtCPF"/>
			<s:textfield id="txtCPF" cssClass="mask-cpf"/>
			<br/>
			<s:label value="RG" for="txtRG"/>
			<s:textfield id="txtRG" cssClass="mask-rg"/>
			<br/>
			<s:label value="Telefone" for="txtTelefone"/>
			<s:textfield id="txtTelefone" cssClass="mask-telefone"/>
			<br/>
			<s:label value="Telefone DDD" for="txtTelefoneDDD"/>
			<s:textfield id="txtTelefoneDDD" cssClass="mask-telefone-ddd"/>
			<br/>
			<s:label value="CEP" for="txtCEP"/>
			<s:textfield id="txtCEP" cssClass="mask-cep"/>

			<hr/>
			<s:submit action="Principal" method="acaoCarregarPrincipal" value="Voltar" />
		</s:form>
		
	</body>
</html>
