/*
 * BooleanoParaSimNaoInvertidoType.java
 * 
 * Data de cria��o: 31/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.tipodeatributo;

import org.hibernate.type.CharBooleanType;

/**
 * Classe respons�vel pela representa��o dos atributos do tipo "Sim" e "N�o"
 * invertido.
 * 
 * @author adrianop
 */
public class BooleanoParaSimNaoInvertidoType extends CharBooleanType {
	
	/**
	 * Retorna o valor "N" correspondente ao valor "true".
	 * 
	 * @return "N"
	 */
	@Override
	protected final String getTrueString() {
		return "N";
	}

	/**
	 * Retorna o valor "S" correspondente ao valor "false".
	 * 
	 * @return "S"
	 */
	@Override
	protected final String getFalseString() {
		return "S";
	}
}
