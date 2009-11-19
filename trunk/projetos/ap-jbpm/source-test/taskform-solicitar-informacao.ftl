<@s.form action="Atividade" method="POST" enctype="multipart/form-data" theme="simple">
	<@s.hidden name="form.taskId"/>
	<fieldset>
		<label style="width:100%" for="dataSolicitacao">
			Data da Solicita&ccedil;&atilde;o:
			<@s.textfield id="dataSolicitacao" name="parametros['dataSolicitacao']" readonly="true"/>
		</label>	
		<label style="width:100%" for="duracao">
			Dura&ccedil;&atilde;o:
			<@s.textfield id="duracao" name="parametros['duracao']" readonly="true"/> (dias)
		</label>		
		<label style="width:100%" for="informacao">
			Informa&ccedil;&atilde;o:
			<@s.textfield id="informacao" name="parametros['informacao']"/>
		</label>		
	</fieldset>
	<p class="form-legenda">
		<em>*</em> Campo obrigat&oacute;rio
	</p>
	<p class="form-barra-botoes-fim-fluxo">
		<@s.submit value="Cancelar" action="Atividade" method="acaoCancelar" cssClass="form-button"/>
		<@s.submit value="Salvar" action="Atividade" method="acaoSalvar" cssClass="form-button"/>
		<@s.submit value="Enviar" action="Atividade" method="acaoEnviar" cssClass="form-button"/>
	</p>
</@s.form>