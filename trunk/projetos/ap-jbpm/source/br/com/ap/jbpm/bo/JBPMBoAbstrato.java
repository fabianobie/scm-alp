/*
 * CrudBoAbstrato.java
 * 
 * Data de criação: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.arquitetura.negocio.CrudNegocioAbstrato;
import br.com.ap.arquitetura.seguranca.ControladorDeAcesso;
import br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.GroupDecorator;
import br.com.ap.jbpm.decorator.MembershipDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;
import br.com.ap.jbpm.factory.EntidadeFactory;

/**
 * BO abstrato com recursos comuns aos BO`s.
 * 
 * @author AdrianoP
 * 
 */
public abstract class JBPMBoAbstrato<T> extends CrudNegocioAbstrato<T> {

	/**
	 * Retorna novo TaskDecorator
	 * 
	 * @param tarefa Tarefa
	 * @return TaskDecorator
	 */
	protected TaskDecorator novoTaskDecorator(TaskImpl tarefa) {
		return getDecoratorFactory().novoTaskDecorator(tarefa);
	}

	/**
	 * Retorna novo deployment decorator.
	 * 
	 * @param deployment Deployment
	 * @return deployment decorator
	 */
	protected DeploymentDecorator novoDeploymentDecorator(
			DeploymentImpl deployment) {
		return getDecoratorFactory().novoDeploymentDecorator(deployment);
	}

	/**
	 * Retorna novo ProcessDefinitionDecorator
	 * 
	 * @param definicaoId ID
	 * @return ProcessDefinitionDecorator
	 */
	protected ProcessDefinitionDecorator novoProcessDefinitionDecorator(
			String definicaoId) {
		return getDecoratorFactory()
				.novoProcessDefinitionDecorator(definicaoId);
	}

	/**
	 * @return EntidadeFactory
	 */
	protected EntidadeFactory getEntidadeFactory() {
		return EntidadeFactory.getInstancia();
	}

	/**
	 * @return DecoratorFactory
	 */
	protected DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}

	/**
	 * @return estratégia de formatadores
	 */
	protected UtilEstrategiaDeFormatadores getUtilEstrategiaDeFormatadores() {
		return UtilEstrategiaDeFormatadores.getInstancia();
	}

	@Override
	protected ControladorDeAcesso novoControladorDeAcesso() {
		return null;
	}

	/**
	 * Retorna true se o grupo agregado tiver referência.
	 * 
	 * @param decorator GroupDecorator
	 * @return true se o grupo agregado tiver referência.
	 */
	protected boolean isGrupoTemReferencia(GroupDecorator decorator) {
		return isReferencia(decorator)
				&& isReferencia(decorator.getGroupImpl());
	}

	/**
	 * Retorna true se o usuário agregado tiver referência.
	 * 
	 * @param decorator UserDecorator
	 * @return true se o usuário agregado tiver referência.
	 */
	protected boolean isUsuarioTemReferencia(UserDecorator decorator) {
		return isReferencia(decorator) && isReferencia(decorator.getUserImpl());
	}

	/**
	 * Retorna true se o usuário e o grupo agregado tiverem referência.
	 * 
	 * @param decorator MembershipDecorator
	 * @return true se o usuário e o grupo agregado tiverem referência.
	 */
	protected boolean isMembershipTemReferencia(MembershipDecorator decorator) {
		return isReferencia(decorator)
				&& isReferencia(decorator.getMembershipImpl().getUser()
						.getGivenName())
				&& isReferencia(decorator.getMembershipImpl().getGroup()
						.getName());
	}
}
