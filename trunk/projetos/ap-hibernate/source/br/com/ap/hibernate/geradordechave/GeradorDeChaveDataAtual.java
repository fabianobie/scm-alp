/*
 * GeradorDeChaveDataAtual.java
 * 
 * Data de cria��o: 31/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.geradordechave;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import br.com.ap.comum.fabrica.DataFactory;

/**
 * Gerador de chave prim�ria para o objetos do tipo date. A gera��o da chave �
 * efetuada no momento da inclus�o. A especifica��o sugere que esta classe seja
 * thread-safe.
 * 
 * @author adrianop
 */
public class GeradorDeChaveDataAtual implements IdentifierGenerator {
	private Date dataAtual;

	/**
	 * Construtor.
	 */
	public GeradorDeChaveDataAtual() {
		// Construtor.
	}

	/**
	 * @see IdentifierGenerator#generate(SessionImplementor, Object)
	 */
	public Serializable generate(SessionImplementor sessao, Object objeto)
	        throws HibernateException {

		synchronized (dataAtual) {
			dataAtual = getDataFactory().novoDate();
			return dataAtual;
		}
	}

	/**
	 * @return f�brica de data.
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

}
