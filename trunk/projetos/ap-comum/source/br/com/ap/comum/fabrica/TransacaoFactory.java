/*
 * TransacaoFactory.java
 * 
 * Data de cria��o: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.sql.Connection;

import br.com.ap.comum.transacao.Transacao;
import br.com.ap.comum.transacao.TransacaoJDBC;

/**
 * F�brica de objetos controladores de transa��o.
 * 
 * @author adrianop
 */
public final class TransacaoFactory extends FactoryAbstrata {

	private static TransacaoFactory	instancia	= new TransacaoFactory();

	/**
	 * Construtor.
	 */
	private TransacaoFactory() {
		// Construtor.
	}

	/**
	 * Retorna inst�ncia do objeto. Padr�o singleton.
	 * 
	 * @return inst�ncia do objeto.
	 */
	public static TransacaoFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna uma ITransacao do tipo JDBC.
	 * 
	 * @param conexao Conex�o com o banco de dados.
	 * @return ITransacao
	 */
	public Transacao<Connection> novaTransacaoJDBC(Connection conexao) {
		Transacao<Connection> transacao = new TransacaoJDBC();
		transacao.setConexao(conexao);

		return transacao;
	}
}
