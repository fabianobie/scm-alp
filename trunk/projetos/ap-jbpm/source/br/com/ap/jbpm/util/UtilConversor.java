/*
 * UtilConversor.java
 * 
 * Data de cria��o: 04/12/2009
 */
package br.com.ap.jbpm.util;

import java.util.Collection;

import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.factory.ConversorFactory;

/**
 * Classe utilit�ria respons�vel por conversoes diversas.
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
	 * Converte cole��o de task em cole��o de taskdecorator.
	 * 
	 * @param tasks cole��o de task
	 * @return cole��o de taskdecorator
	 */
	public static Collection<TaskDecorator> converter(Collection<TaskImpl> tasks) {
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
