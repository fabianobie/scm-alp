/*
 * ExemploAuditoriaInterceptor.java
 * 
 * Data de criação: 05/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.interceptor;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.type.Type;

import teste.entidade.Campo;
import teste.entidade.Tabela;
import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * @author adrianop
 */
public class ExemploAuditoriaInterceptor extends
		AuditoriaAnnotationInterceptorAbstrato {

	/**
	 * @see br.com.ap.hibernate.interceptor.AuditoriaAnnotationInterceptorAbstrato#doMontarEntidadeDeAuditoria(java.lang.Object,
	 *      java.lang.Object, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T extends Entidade> T doMontarEntidadeDeAuditoria(
			Object entidade, Object entidadeAntiga, Serializable acao) {

		Table table = getAnotacaoDeTabela(entidade);

		Tabela tabela = new Tabela();
		tabela.setTabela(table.name());
		tabela.setAcao((Integer) acao);
		tabela.setData(getDataFactory().novoTimestamp());
		tabela.setUsuario("didi");

		Class<?> classe = entidade.getClass();
		Field[] fields = classe.getDeclaredFields();
		if (!UtilArray.isVazio(fields)) {

			Collection<Campo> campos = getColecaoFactory().novoArrayList();
			for (Field field : fields) {
				String atributo = field.getName();
				Column column = getAnotacaoDeColumn(entidade, atributo, field);

				if (isReferencia(column)) {
					Object valor = getValorDaPropriedadeDoPOJO(entidade, atributo);
					Type tipo = getTipoDaPropriedadeDoPOJO(entidade, atributo);
	
					Object valorAnterior = getValorDaPropriedadeDoPOJO(
							entidadeAntiga, atributo);
	
					Campo c = new Campo();
					c.setTabela(tabela);
					c.setNome(column.name());
					c.setValorAnterior(formatar(valorAnterior, tipo
							.getReturnedClass()));
					c.setValorPosterior(formatar(valor, tipo.getReturnedClass()));
					campos.add(c);
				}
			}
			tabela.setCampos(campos);
		}

		return (T) tabela;
	}

	/**
	 * Retorna a anotação de Column da entidade solicitada. A anotação será
	 * recuperada do atributo ou do método GET.
	 * 
	 * @param entidade Entidade
	 * @param atributo Atributo usado para recuperar o método GET.
	 * @param field Atributo da classe.
	 * @return Anotação Column
	 */
	protected Column getAnotacaoDeColumn(Object entidade, String atributo,
			Field field) {
		Column anotacao = field.getAnnotation(Column.class);
		
		if (!isReferencia(anotacao)) {
			anotacao = getAnotacaoDeMetodoGet(entidade, atributo, Column.class);
		}
		return anotacao;
	}
}
