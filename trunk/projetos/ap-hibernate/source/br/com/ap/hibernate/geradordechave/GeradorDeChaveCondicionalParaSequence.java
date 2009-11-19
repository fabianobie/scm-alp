/*
 * GeradorDeChaveCondicionalParaSequence.java
 * 
 * Data de cria��o: 31/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
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
 * Gerador de chave prim�ria que s� utiliza a sequence do banco de dados se o ID
 * n�o for informado.
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
	 * @param sessao Implementa��o da sess�o atual.
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
