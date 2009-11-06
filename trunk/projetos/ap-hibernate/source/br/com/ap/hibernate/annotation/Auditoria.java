/*
 * Auditoria.java
 * 
 * Data de cria��o: 01/01/2008
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anota��o das configura��es necess�rias � Auditoria da biblioteca.
 * 
 * @author adrianop
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditoria {

	/**
	 * @return true se for auditar o processo de altera��o da entidade.
	 */
	public boolean alteracao() default false;

	/**
	 * @return true se for auditar o processo de exclus�o da entidade.
	 */
	public boolean exclusao() default false;

	/**
	 * @return true se for auditar o processo de consulta da entidade.
	 */
	public boolean consulta() default false;

	/**
	 * @return true se for auditar o processo de inclus�o da entidade.
	 */
	public boolean inclusao() default false;

	/**
	 * @return campos que ser�o auditados.
	 */
	public String[] campos() default {};

}
