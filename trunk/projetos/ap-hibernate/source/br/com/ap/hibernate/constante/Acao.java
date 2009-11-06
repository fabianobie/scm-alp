/*
 * Acao.java
 * 
 * Data de criação: 30/04/2007
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.constante;

import br.com.ap.comum.fabrica.NumeroFactory;

/**
 * Classe que representa o tipo de ação que é solicitada ao banco de dados. A
 * ação pode ser de alteração, inclusão, exclusão ou consulta.
 * 
 * @author adrianop
 */
public final class Acao {

	/**
	 * Construtor.
	 */
	private Acao() {
		// Construtor
	}

	/**
	 * @return ação de alteração.
	 */
	public static Integer getAlteracao() {
		return novoInteger(1);
	}

	/**
	 * @return ação de inclusão.
	 */
	public static Integer getInclusao() {
		return novoInteger(2);
	}

	/**
	 * @return ação de exclusão.
	 */
	public static Integer getExclusao() {
		return novoInteger(3);
	}

	/**
	 * @return ação de consulta.
	 */
	public static Integer getConsulta() {
		return novoInteger(4);
	}

	/**
	 * Retorna o integer do int.
	 * 
	 * @return número que será convertido
	 */
	private static Integer novoInteger(int numero) {
		return getNumeroFactory().novoInteger(numero);
	}

	/**
	 * @return fábrica de número.
	 */
	private static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}
}
