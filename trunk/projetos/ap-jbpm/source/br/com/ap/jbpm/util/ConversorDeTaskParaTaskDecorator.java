/*
 * ConversorDeTaskParaTaskDecorator.java
 * 
 * Data de criação: 03/12/2009
 */
package br.com.ap.jbpm.util;

import org.jbpm.api.task.Task;

import br.com.ap.comum.conversor.instancia.ConversorAbstrato;
import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;

/**
 * Conversor de Task para TaskDecorator.
 * 
 * @author AdrianoP
 */
public class ConversorDeTaskParaTaskDecorator extends ConversorAbstrato<Task, TaskDecorator> {

	@Override
	public TaskDecorator converter(Task task) throws ConversorException {
		return getDecoratorFactory().novoTaskDecorator(task);
	}

	/**
	 * @return DecoratorFactory
	 */
	protected DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}

}
