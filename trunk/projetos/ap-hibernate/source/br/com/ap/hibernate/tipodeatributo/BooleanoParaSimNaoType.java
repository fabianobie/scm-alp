/*
 * BooleanoParaSimNaoType.java
 * 
 * Data de cria��o: 31/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.tipodeatributo;

import org.hibernate.type.CharBooleanType;

/**
 * Classe respons�vel pela representa��o dos atributos do tipo "Sim" e "N�o".
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
