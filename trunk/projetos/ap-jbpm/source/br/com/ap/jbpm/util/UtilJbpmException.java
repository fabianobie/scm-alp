/**
 * UtilJbpmException.java
 *
 * Data: 07/01/2010
 */
package br.com.ap.jbpm.util;

import org.jbpm.api.JbpmException;
import org.jbpm.pvm.internal.identity.impl.UserImpl;

import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * @author adriano.pamplona
 *
 */
public class UtilJbpmException {

	public static JbpmException novaAcessoNaoPermitidoATarefa(TaskDecorator task) {
		String mensagem = getUtilMensagem().getAcessoNaoPermitidoATarefa(task);
		return novaJbpmException(mensagem);
		
	}

	private static UtilMensagem getUtilMensagem() {
		return UtilMensagem.getInstancia();
	}

	private static JbpmException novaJbpmException(String mensagem) {
		return new JbpmException(mensagem);
	}

	public static JbpmException novaUsuarioSemAcessoATarefa(TaskDecorator task,
			UserImpl user) {
		String mensagem = getUtilMensagem().getUsuarioSemAcessoATarefa(task, user);
		return novaJbpmException(mensagem);
	}
}
