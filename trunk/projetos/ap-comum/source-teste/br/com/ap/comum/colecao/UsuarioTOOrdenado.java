/*
 * UsuarioTOOrdenado.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

/**
 * @author AdrianoP
 *
 */
public class UsuarioTOOrdenado extends UsuarioTO implements Comparable<UsuarioTO> {

	/**
	 * Construtor.
	 * 
	 * @param identidade Identidade
	 * @param nome Nome
	 * @param data Data
	 * @param peso Peso
	 */
	public UsuarioTOOrdenado(int identidade, String nome, String data, double peso) {
		super(identidade, nome, data, peso);
	}

	/**
	 * @param o UsuarioTO
	 * @return resultado da comparação
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(UsuarioTO o) {
		int resultado = 0;
		
		if (o instanceof UsuarioTOOrdenado) {
			UsuarioTOOrdenado to = (UsuarioTOOrdenado) o;
			Integer identidade0 = new Integer(getIdentidade());
			Integer identidade1 = new Integer(to.getIdentidade());
			
			resultado = identidade0.compareTo(identidade1);
		}
		return resultado;
	}

}
