/*
 * UtilConversor.java
 * 
 * Data de criação: 04/12/2009
 */
package br.com.ap.jbpm.util;

import java.util.Collection;

import org.jbpm.api.task.Task;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.factory.ConversorFactory;

/**
 * Classe utilitária responsável por conversoes diversas.
 * 
 * @author AdrianoP
 */
public final class UtilConversor {

	/**
	 * Construtor.
	 */
	private UtilConversor() {
		// Construtor
	}

	/**
	 * Converte coleção de task em coleção de taskdecorator.
	 * 
	 * @param tasks coleção de task
	 * @return coleção de taskdecorator
	 */
	public static Collection<TaskDecorator> converter(Collection<Task> tasks) {
		ConversorDeTaskParaTaskDecorator conversor = getConversorFactory()
				.novoConversorDeTaskParaTaskDecorator();

		return UtilColecao.aplicarConversor(tasks, conversor);
	}

	/**
	 * @return ConversorFactory
	 */
	private static ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}
}
