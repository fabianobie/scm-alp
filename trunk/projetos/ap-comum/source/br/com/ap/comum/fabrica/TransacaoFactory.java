/*
 * TransacaoFactory.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.sql.Connection;

import br.com.ap.comum.transacao.Transacao;
import br.com.ap.comum.transacao.TransacaoJDBC;

/**
 * Fábrica de objetos controladores de transação.
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
	 * Retorna instância do objeto. Padrão singleton.
	 * 
	 * @return instância do objeto.
	 */
	public static TransacaoFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna uma ITransacao do tipo JDBC.
	 * 
	 * @param conexao Conexão com o banco de dados.
	 * @return ITransacao
	 */
	public Transacao<Connection> novaTransacaoJDBC(Connection conexao) {
		Transacao<Connection> transacao = new TransacaoJDBC();
		transacao.setConexao(conexao);

		return transacao;
	}
}
