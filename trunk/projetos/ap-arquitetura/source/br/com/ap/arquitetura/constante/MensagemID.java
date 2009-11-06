/*
 * MensagemID.java
 * 
 * Data de criação: 26/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.constante;

/**
 * Constantes das mensagens mapeadas no arquivo mensagem.properties.
 * 
 * @author adrianop
 */
public final class MensagemID {

	/**
	 * Construtor.
	 */
	private MensagemID() {
		// Construtor.
	}

	/**
	 * Retorna jndi.name.nao.encontrado.
	 * 
	 * @return jndi.name.nao.encontrado
	 */
	public static String getJndiNameNaoEncontrado() {
		return "jndi.name.nao.encontrado";
	}

	/**
	 * Retorna conexao.nao.efetuada.
	 * 
	 * @return conexao.nao.efetuada
	 */
	public static String getConexaoNaoEfetuada() {
		return "conexao.nao.efetuada";
	}

	/**
	 * Retorna erro.ao.criar.contexto.
	 * 
	 * @return erro.ao.criar.contexto
	 */
	public static String getErroAoCriarContexto() {
		return "erro.ao.criar.contexto";
	}

	/**
	 * Retorna erro.ao.imprimir.tag.
	 * 
	 * @return erro.ao.imprimir.tag
	 */
	public static String getErroAoImprimirTag() {
		return "erro.ao.imprimir.tag";
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

	/**
	 * Retorna profile.inexistente.
	 * 
	 * @return profile.inexistente
	 */
	public static String getProfileInexistente() {
		return "profile.inexistente";
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
	 * Retorna erro.ao.criar.objeto.
	 * 
	 * @return erro.ao.criar.objeto
	 */
	public static String getErroAoCriarObjeto() {
		return "erro.ao.criar.objeto";
	}

}
