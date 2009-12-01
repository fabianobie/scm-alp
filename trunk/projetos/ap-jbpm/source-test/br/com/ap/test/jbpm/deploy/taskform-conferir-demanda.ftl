<@s.form action="Atividade" method="POST" enctype="multipart/form-data" theme="simple">
	<@s.hidden name="taskDecorator.id"/>
	<fieldset>
		<label style="width:100%" for="dataSolicitacao">
			Data da Solicita&ccedil;&atilde;o:
			<@s.textfield id="dataSolicitacao" name="mapaVariable['dataSolicitacao']" readonly="true"/>
		</label>	
		<label style="width:100%" for="duracao">
			Dura&ccedil;&atilde;o:
			<@s.textfield id="duracao" name="mapaVariable['duracao']" readonly="true"/> (dias)
		</label>		
		<label style="width:100%" for="informacao">
			Informa&ccedil;&atilde;o:
			<@s.textfield id="informacao" name="mapaVariable['informacao']" readonly="true"/>
		</label>		
		<label style="width:100%" for="selectAceitar">
			Aceitar? 
			<@s.select list="%{#@java.util.HashMap@{'FinalizarSolicitacao':'SIM', 'MaisInformacao':'NÃO'}}" 
				name="form.transitionTo" 
				cssStyle="width:100%"
				headerKey="0"
				headerValue="<< Selecione >>"/>
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
