/*
 * Auditoria.java
 * 
 * Data de criação: 01/01/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação das configurações necessárias à Auditoria da biblioteca.
 * 
 * @author adrianop
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditoria {

	/**
	 * @return true se for auditar o processo de alteração da entidade.
	 */
	public boolean alteracao() default false;

	/**
	 * @return true se for auditar o processo de exclusão da entidade.
	 */
	public boolean exclusao() default false;

	/**
	 * @return true se for auditar o processo de consulta da entidade.
	 */
	public boolean consulta() default false;

	/**
	 * @return true se for auditar o processo de inclusão da entidade.
	 */
	public boolean inclusao() default false;

	/**
	 * @return campos que serão auditados.
	 */
	public String[] campos() default {};

}
