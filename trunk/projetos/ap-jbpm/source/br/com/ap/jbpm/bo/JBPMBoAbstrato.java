/*
 * CrudBoAbstrato.java
 * 
 * Data de criação: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import org.jbpm.api.Deployment;
import org.jbpm.api.task.Task;

import br.com.ap.arquitetura.negocio.CrudNegocioAbstrato;
import br.com.ap.arquitetura.seguranca.ControladorDeAcesso;
import br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
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
	protected TaskDecorator novoTaskDecorator(Task tarefa) {
		return getDecoratorFactory().novoTaskDecorator(tarefa);
	}

	/**
	 * Retorna novo deployment decorator.
	 * 
	 * @param deployment Deployment
	 * @return deployment decorator
	 */
	protected DeploymentDecorator novoDeploymentDecorator(Deployment deployment) {
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
}
