/*
 * UtilComparadorDePrimeiroObjetoNaoNulo.java
 * 
 * Data de cria��o: 11/12/2008
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

/**
 * Respons�vel pela recupera��o do primeiro objeto n�o nulo.
 * 
 * @author adrianop
 */
public class UtilComparadorDePrimeiroObjetoNaoNulo extends
		UtilComparadorAbstrato<Object> {

	/**
	 * Retorna o primeiro objeto com refer�ncia.
	 * 
	 * @param <T> Tipo do objeto
	 * @param objetos Objetos
	 * @return maior data.
	 */
	public static <T extends Object> T comparar(T... objetos) {
		T objeto = null;

		if (isReferencia(objetos)) {
			for (int indice = 0; indice < objetos.length
					&& !isReferencia(objeto); indice++) {
				objeto = objetos[indice];
			}
		}
		return objeto;
	}
}
