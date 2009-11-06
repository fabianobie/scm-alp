/*
 * AliasToBeanResultTransformer.java
 * 
 * Data de criação: 27/01/2009
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.ResultTransformer;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.reflexao.UtilReflexaoMetodo;

/**
 * Responsável pela transformação do resultado do um sql em um TO. Essa
 * implementação consiste na mesma da classe AliasToBeanResultTransformer do
 * hibernate, a única alteração é que somente serão atribuídos os valores
 * existentes no TO.
 * 
 * @author adrianop
 */
public class AliasToBeanResultTransformer implements ResultTransformer {

	private final Class<?>   resultClass;
	private Setter[]         setters;
	private PropertyAccessor propertyAccessor;

	/**
	 * @param resultClass Classe.
	 */
	public AliasToBeanResultTransformer(Class<?> resultClass) {
		if (resultClass == null) {
			throw new IllegalArgumentException("resultClass cannot be null");
		}

		this.resultClass = resultClass;
		propertyAccessor = new ChainedPropertyAccessor(new PropertyAccessor[] {
		        PropertyAccessorFactory.getPropertyAccessor(resultClass, null),
		        PropertyAccessorFactory.getPropertyAccessor("field") });
	}

	/**
	 * @see org.hibernate.transform.ResultTransformer#transformTuple(java.lang.Object[],
	 *      java.lang.String[])
	 */
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			if (setters == null) {
				setters = new Setter[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (isExisteMetodoSet(resultClass, alias)) {
						setters[i] = propertyAccessor.getSetter(resultClass,
						        alias);
					}
				}
			}
			result = resultClass.newInstance();
			for (int i = 0; i < aliases.length; i++) {
				if (setters[i] != null) {
					setters[i].set(result, tuple[i], null);
				}
			}
		} catch (InstantiationException e) {
			throw new HibernateException("Could not instantiate resultclass: "
			        + resultClass.getName());
		} catch (IllegalAccessException e) {
			throw new HibernateException("Could not instantiate resultclass: "
			        + resultClass.getName());
		}

		return result;
	}

	/**
	 * @see org.hibernate.transform.ResultTransformer#transformList(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	public List transformList(List collection) {
		return collection;
	}

	/**
	 * Retorna true se existe o método SET para o atributo informado.
	 * 
	 * @param classe Classe
	 * @param atributo Atributo
	 * @return true se existe o método SET para o atributo informado.
	 */
	protected boolean isExisteMetodoSet(Class<?> classe, String atributo) {
		boolean resultado = false;
		if (UtilObjeto.isReferencia(classe) && !UtilString.isVazio(atributo)) {
			Class<?> parametro = UtilReflexaoMetodo.getTipoResultadoMetodoGet(
			        classe, atributo);
			resultado = UtilReflexaoMetodo.isExisteMetodoSet(classe, atributo,
			        parametro);
		}
		return resultado;
	}
}
