/*
 * GeradorDeChaveDataAtual.java
 * 
 * Data de criação: 31/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.geradordechave;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import br.com.ap.comum.fabrica.DataFactory;

/**
 * Gerador de chave primária para o objetos do tipo date. A geração da chave é
 * efetuada no momento da inclusão. A especificação sugere que esta classe seja
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
	 * @return fábrica de data.
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

}
