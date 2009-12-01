<@s.form action="CriarCaso" method="POST" enctype="multipart/form-data" theme="simple">
	<@s.hidden name="processDefinitionDecorator.id"/>
	<fieldset>
		<label style="width:100%" for="dataSolicitacao">
			Descri&ccedil;&atilde;o:
			<@s.textfield id="descricao" name="mapaVariable['descricao']"/>
		</label>	
	</fieldset>
	<p class="form-legenda">
		<em>*</em> Campo obrigat&oacute;rio
	</p>
	<p class="form-barra-botoes-fim-fluxo">
		<@s.submit value="Enviar" action="CriarCaso" method="acaoEnviar" cssClass="form-button"/>
	</p>
</@s.form>

