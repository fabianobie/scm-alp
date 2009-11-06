/*
 * BoleanoFactory.java
 * 
 * Data de criação: 21/09/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

/**
 * Fábrica de objetos usados para manipulação de booleanos.<br>
 * Padrão Factory Method e Singleton.
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
	 * @return instância da classe.
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
