/*
 * Mensagem.java
 * 
 * Data de criação: 24/02/2007
 * 
 *
 *
 */
package br.com.ap.reflexao.constante;

/**
 * Constantes das mensagens definidas no arquivo mensagem.properties.
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
	 * @return classe.nao.instanciada
	 */
	public static String getClasseNaoInstanciada() {
		return "classe.nao.instanciada";
	}

	/**
	 * @return metodo.nao.encontrado
	 */
	public static String getMetodoNaoEncontrado() {
		return "metodo.nao.encontrado";
	}

	/**
	 * @return acesso.negado.ao.metodo
	 */
	public static String getAcessoNegadoAoMetodo() {
		return "acesso.negado.ao.metodo";
	}

	/**
	 * @return erro.ao.invocar.metodo
	 */
	public static String getErroAoInvocarMetodo() {
		return "erro.ao.invocar.metodo";
	}

	/**
	 * @return erro
	 */
	public static String getErro() {
		return "erro";
	}

	/**
	 * @return indice.nao.encontrado.na.colecao
	 */
	public static String getIndiceNaoEncontradoNaColecao() {
		return "indice.nao.encontrado.na.colecao";
	}

	/**
	 * @return nao.foi.possivel.clonar.objeto
	 */
	public static String getNaoFoiPossivelClonarObjeto() {
		return "nao.foi.possivel.clonar.objeto";
	}

}
