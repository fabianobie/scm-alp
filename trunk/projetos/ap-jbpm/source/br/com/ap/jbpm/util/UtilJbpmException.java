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
 * Classe respons�vel pela cria��o das exce��es.
 * 
 * @author adriano.pamplona
 */
public class UtilJbpmException {

	/**
	 * Exce��o de acesso n�o permitido � tarefa.
	 * 
	 * @param task Tarefa.
	 * @return exce��o
	 */
	public static JbpmException novaAcessoNaoPermitidoATarefa(TaskDecorator task) {
		String mensagem = UtilMensagem.getAcessoNaoPermitidoATarefa(task);
		return novaJbpmException(mensagem);

	}

	/**
	 * Exce��o de usu�rio sem acesso � tarefa.
	 * 
	 * @param task Tarefa.
	 * @param user Usu�rio.
	 * @return exce��o
	 */
	public static JbpmException novaUsuarioSemAcessoATarefa(TaskDecorator task,
			UserImpl user) {
		String mensagem = UtilMensagem.getUsuarioSemAcessoATarefa(task, user);
		return novaJbpmException(mensagem);
	}

	/**
	 * @param mensagem Mensagem de exce��o
	 * @return exce��o
	 */
	private static JbpmException novaJbpmException(String mensagem) {
		return new JbpmException(mensagem);
	}
}
