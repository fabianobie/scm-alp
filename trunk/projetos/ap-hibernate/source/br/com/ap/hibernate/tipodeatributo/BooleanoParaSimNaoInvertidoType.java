/*
 * BooleanoParaSimNaoInvertidoType.java
 * 
 * Data de criação: 31/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.tipodeatributo;

import org.hibernate.type.CharBooleanType;

/**
 * Classe responsável pela representação dos atributos do tipo "Sim" e "Não"
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
