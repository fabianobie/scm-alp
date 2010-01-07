/*
 * Mensagem.java
 * 
 * Data de criação: 07/01/2010
 */
package br.com.ap.jbpm.util.constante;

/**
 * Constantes das mensagens definidas no arquivo mensagem-jbpm.properties.
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
	 * @return acesso.nao.permitido.a.tarefa
	 */
	public static String getAcessoNaoPermitidoATarefa() {
		return "acesso.nao.permitido.a.tarefa";
	}

	/**
	 * @return usuario.sem.acesso.a.tarefa
	 */
	public static String getUsuarioSemAcessoATarefa() {
		return "usuario.sem.acesso.a.tarefa";
	}
}
