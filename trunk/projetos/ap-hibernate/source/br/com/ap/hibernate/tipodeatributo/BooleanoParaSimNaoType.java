/*
 * BooleanoParaSimNaoType.java
 * 
 * Data de criação: 31/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.tipodeatributo;

import org.hibernate.type.CharBooleanType;

/**
 * Classe responsável pela representação dos atributos do tipo "Sim" e "Não".
 * 
 * @author adrianop
 */
public class BooleanoParaSimNaoType extends CharBooleanType {
	
	/**
	 * Retorna o valor "S" correspondente ao valor "true".
	 * 
	 * @return "S"
	 */
	@Override
	protected final String getTrueString() {
		return "S";
	}

	/**
	 * Retorna o valor "N" correspondente ao valor "false".
	 * 
	 * @return "N"
	 */
	@Override
	protected final String getFalseString() {
		return "N";
	}
}
