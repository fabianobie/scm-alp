/*
 * Acao.java
 * 
 * Data de cria��o: 30/04/2007
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.constante;

import br.com.ap.comum.fabrica.NumeroFactory;

/**
 * Classe que representa o tipo de a��o que � solicitada ao banco de dados. A
 * a��o pode ser de altera��o, inclus�o, exclus�o ou consulta.
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
	 * @return a��o de altera��o.
	 */
	public static Integer getAlteracao() {
		return novoInteger(1);
	}

	/**
	 * @return a��o de inclus�o.
	 */
	public static Integer getInclusao() {
		return novoInteger(2);
	}

	/**
	 * @return a��o de exclus�o.
	 */
	public static Integer getExclusao() {
		return novoInteger(3);
	}

	/**
	 * @return a��o de consulta.
	 */
	public static Integer getConsulta() {
		return novoInteger(4);
	}

	/**
	 * Retorna o integer do int.
	 * 
	 * @return n�mero que ser� convertido
	 */
	private static Integer novoInteger(int numero) {
		return getNumeroFactory().novoInteger(numero);
	}

	/**
	 * @return f�brica de n�mero.
	 */
	private static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}
}
