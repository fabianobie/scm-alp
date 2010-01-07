/**
 * UtilMensagem.java
 *
 * Data: 07/01/2010
 */
package br.com.ap.jbpm.util;

import java.util.Properties;

import org.jbpm.pvm.internal.identity.impl.UserImpl;

import br.com.ap.comum.mensagem.UtilMensagemAbstrato;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.util.constante.Arquivo;
import br.com.ap.jbpm.util.constante.Mensagem;

/**
 * @author adriano.pamplona
 * 
 */
public class UtilMensagem extends UtilMensagemAbstrato {
	private static UtilMensagem	instancia	= new UtilMensagem();

	/**
	 * Construtor.
	 */
	private UtilMensagem() {
		// Construtor.
	}

	/**
	 * Retorna instância única do objeto. Padrão singleton
	 * 
	 * @return instância do objeto.
	 */
	public static UtilMensagem getInstancia() {
		return instancia;
	}

	/**
	 * @see br.com.ap.comum.mensagem.UtilMensagemAbstrato#getProperties()
	 */
	protected Properties getProperties() {
		String arquivo = Arquivo.getPathArquivoMensagemProperties();
		return getArquivoFactory().novoProperties(arquivo);
	}
	
	/**
	 * @param task Tarefa
	 * @return acesso.nao.permitido.a.tarefa
	 */
	public String getAcessoNaoPermitidoATarefa(TaskDecorator task) {
		return getMensagem(Mensagem.getAcessoNaoPermitidoATarefa(), task.getId());
	}

	public String getUsuarioSemAcessoATarefa(TaskDecorator task, UserImpl user) {
		String taskId = task.getId();
		String userId = user.getId();
		return getMensagem(Mensagem.getUsuarioSemAcessoATarefa(), taskId, userId);
	}
}
