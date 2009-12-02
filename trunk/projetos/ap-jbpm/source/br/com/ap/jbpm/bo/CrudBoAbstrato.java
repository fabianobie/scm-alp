/*
 * CrudBoAbstrato.java
 * 
 * Data de criação: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.io.Serializable;
import java.util.Collection;

import org.jbpm.api.Deployment;
import org.jbpm.api.task.Task;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
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
public abstract class CrudBoAbstrato<T extends Object> implements CrudDao<T> {

	@Override
	public void alterar(T arg0) {
		getDao().alterar(arg0);
	}

	@Override
	public Collection<T> consultar() {
		return getDao().consultar();
	}

	@Override
	public Collection<T> consultar(T arg0) {
		return getDao().consultar(arg0);
	}

	@Override
	public void excluir(T arg0) {
		getDao().excluir(arg0);
	}

	@Override
	public void excluirTodos(Collection<T> arg0) {
		getDao().excluirTodos(arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Serializable> R incluir(T arg0) {
		return (R) getDao().incluir(arg0);
	}

	@Override
	public T obter(Serializable arg0) {
		return getDao().obter(arg0);
	}

	@Override
	public T obter(T arg0) {
		return getDao().obter(arg0);
	}

	@Override
	public void salvar(T arg0) {
		getDao().salvar(arg0);
	}

	/**
	 * @return DAO
	 */
	protected abstract CrudDao<T> getDao();

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
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objetos Objetos validados.
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param strings Strings validadas.
	 * @return true se a string for vazia.
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}
	
	/**
	 * @return estratégia de formatadores
	 */
	protected UtilEstrategiaDeFormatadores getUtilEstrategiaDeFormatadores() {
		return UtilEstrategiaDeFormatadores.getInstancia();
	}

	/**
	 * @return fábrica de coleção.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
