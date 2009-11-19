/*
 * GeradorDeChaveCondicionalParaSequence.java
 * 
 * Data de criação: 31/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.geradordechave;

import java.io.Serializable;

import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.metadata.ClassMetadata;

import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Gerador de chave primária que só utiliza a sequence do banco de dados se o ID
 * não for informado.
 * 
 * @author adrianop
 */
public class GeradorDeChaveCondicionalParaSequence extends SequenceGenerator {

	/**
	 * Construtor.
	 */
	public GeradorDeChaveCondicionalParaSequence() {
		// Construtor.
	}

	/**
	 * @see org.hibernate.id.SequenceGenerator#generate(org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SessionImplementor sessao, Object objeto)
			throws HibernateException {
		
		Serializable resultado = getIdentificadorDaEntidade(sessao, objeto);
		if (!UtilObjeto.isReferencia(resultado)) {
			resultado = super.generate(sessao, objeto);
		}
		return resultado;
	}
	
	/**
	 * Retorna o identificador da entidade.
	 * 
	 * @param sessao Implementação da sessão atual.
	 * @param entidade Entidade.
	 * @return Valor da chave da entidade.
	 */
	protected Serializable getIdentificadorDaEntidade(SessionImplementor sessao,
			Object entidade) {
		
		SessionFactoryImplementor factory = sessao.getFactory();
		Class<?> classe = entidade.getClass();
		ClassMetadata metadata = factory.getClassMetadata(classe);
		EntityMode entityMode = sessao.getEntityMode();

		return metadata.getIdentifier(entidade, entityMode);
	}
}
