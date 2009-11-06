/*
 * BoleanoFactory.java
 * 
 * Data de cria��o: 21/09/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

/**
 * F�brica de objetos usados para manipula��o de booleanos.<br>
 * Padr�o Factory Method e Singleton.
 * 
 * @author AdrianoP
 */
public final class BoleanoFactory extends FactoryAbstrata {
	private static BoleanoFactory	instancia	= new BoleanoFactory();

	/**
	 * Construtor.
	 */
	private BoleanoFactory() {
		// Construtor.
	}

	/**
	 * @return inst�ncia da classe.
	 */
	public static BoleanoFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo booleano.
	 * 
	 * @param booleano valor Booleano
	 * @return novo booleano
	 */
	public Boolean novoBoolean(boolean booleano) {
		return new Boolean(booleano);
	}

	/**
	 * Retorna novo booleano.
	 * 
	 * @param booleano valor Booleano
	 * @return novo booleano
	 */
	public Boolean novoBoolean(String booleano) {
		return new Boolean(booleano);
	}

}
