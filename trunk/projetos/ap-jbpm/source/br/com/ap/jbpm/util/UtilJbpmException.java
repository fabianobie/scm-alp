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
 * Classe responsável pela criação das exceções.
 * 
 * @author adriano.pamplona
 */
public class UtilJbpmException {

	/**
	 * Exceção de acesso não permitido à tarefa.
	 * 
	 * @param task Tarefa.
	 * @return exceção
	 */
	public static JbpmException novaAcessoNaoPermitidoATarefa(TaskDecorator task) {
		String mensagem = UtilMensagem.getAcessoNaoPermitidoATarefa(task);
		return novaJbpmException(mensagem);

	}

	/**
	 * Exceção de usuário sem acesso à tarefa.
	 * 
	 * @param task Tarefa.
	 * @param user Usuário.
	 * @return exceção
	 */
	public static JbpmException novaUsuarioSemAcessoATarefa(TaskDecorator task,
			UserImpl user) {
		String mensagem = UtilMensagem.getUsuarioSemAcessoATarefa(task, user);
		return novaJbpmException(mensagem);
	}

	/**
	 * @param mensagem Mensagem de exceção
	 * @return exceção
	 */
	private static JbpmException novaJbpmException(String mensagem) {
		return new JbpmException(mensagem);
	}
}
