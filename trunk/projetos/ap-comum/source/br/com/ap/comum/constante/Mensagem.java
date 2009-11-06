/*
 * Mensagem.java
 * 
 * Data de criação: 25/06/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.constante;

/**
 * Constantes das mensagens definidas no arquivo mensagem-generico.properties.
 * 
 * @author AdrianoP
 */
public final class Mensagem {

	/**
	 * Construtor.
	 */
	private Mensagem() {
		// Construtor.
	}

	/**
	 * Retorna erro.ao.criar.instancia.
	 * 
	 * @return erro.ao.criar.instancia
	 */
	public static String getErroAoCriarInstancia() {
		return "erro.ao.criar.instancia";
	}

	/**
	 * Retorna erro.
	 * 
	 * @return erro
	 */
	public static String getErro() {
		return "erro";
	}

	/**
	 * Retorna erro.ao.criar.o.statement.
	 * 
	 * @return erro.ao.criar.o.statement
	 */
	public static String getErroAoCriarOStatement() {
		return "erro.ao.criar.o.statement";
	}

	/**
	 * Retorna erro.ao.invocar.sql.
	 * 
	 * @return erro.ao.invocar.sql
	 */
	public static String getErroAoInvocarSQL() {
		return "erro.ao.invocar.sql";
	}

	/**
	 * Retorna erro.ao.recuperar.a.coluna.do.callable.
	 * 
	 * @return erro.ao.recuperar.a.coluna.do.callable
	 */
	public static String getErroAoRecuperarAColunaDoCallable() {
		return "erro.ao.recuperar.a.coluna.do.callable";
	}

	/**
	 * Retorna erro.ao.recuperar.a.coluna.do.resultset.
	 * 
	 * @return erro.ao.recuperar.a.coluna.do.resultset
	 */
	public static String getErroAoRecuperarAColunaDoResultSet() {
		return "erro.ao.recuperar.a.coluna.do.resultset";
	}

	/**
	 * Retorna erro.ao.ir.ao.proximo.registro.do.resultset.
	 * 
	 * @return erro.ao.ir.ao.proximo.registro.do.resultset
	 */
	public static String getErroAoIrAoProximoRegistroDoResultset() {
		return "erro.ao.ir.ao.proximo.registro.do.resultset";
	}

	/**
	 * Retorna erro.ao.recuperar.o.metadata.
	 * 
	 * @return erro.ao.recuperar.o.metadata
	 */
	public static String getErroAoRecuperarOMetadata() {
		return "erro.ao.recuperar.o.metadata";
	}

	/**
	 * Retorna erro.ao.recuperar.a.quantidade.de.colunas.do.registro.
	 * 
	 * @return erro.ao.recuperar.a.quantidade.de.colunas.do.registro
	 */
	public static String getErroAoRecuperarAQuantidadeDeColunasDoRegistro() {
		return "erro.ao.recuperar.a.quantidade.de.colunas.do.registro";
	}

	/**
	 * Retorna erro.ao.recuperar.o.nome.da.coluna.do.registro.
	 * 
	 * @return erro.ao.recuperar.o.nome.da.coluna.do.registro
	 */
	public static String getErroAoRecuperarONomeDaColunaDoRegistro() {
		return "erro.ao.recuperar.o.nome.da.coluna.do.registro";
	}

	/**
	 * Retorna erro.ao.recuperar.o.tipo.da.coluna.do.registro.
	 * 
	 * @return erro.ao.recuperar.o.tipo.da.coluna.do.registro
	 */
	public static String getErroAoRecuperarOTipoDaColunaDoRegistro() {
		return "erro.ao.recuperar.o.tipo.da.coluna.do.registro";
	}

	/**
	 * Retorna tempo.de.resposta.
	 * 
	 * @return tempo.de.resposta
	 */
	public static String getTempoDeResposta() {
		return "tempo.de.resposta";
	}
	
	/**
	 * Retorna conexao.nao.definida.
	 * 
	 * @return conexao.nao.definida
	 */
	public static String getConexaoNaoDefinida() {
		return "conexao.nao.definida";
	}
	
	/**
	 * Retorna transacao.nao.iniciada.
	 * 
	 * @return transacao.nao.iniciada
	 */
	public static String getTransacaoNaoIniciada() {
		return "transacao.nao.iniciada";
	}
	
	/**
	 * Retorna erro.ao.efetuar.o.commit.
	 * 
	 * @return erro.ao.efetuar.o.commit
	 */
	public static String getErroAoEfetuarOCommit() {
		return "erro.ao.efetuar.o.commit";
	}
	
	/**
	 * Retorna erro.ao.efetuar.o.rollback.
	 * 
	 * @return erro.ao.efetuar.o.rollback
	 */
	public static String getErroAoEfetuarORollback() {
		return "erro.ao.efetuar.o.rollback";
	}
}
