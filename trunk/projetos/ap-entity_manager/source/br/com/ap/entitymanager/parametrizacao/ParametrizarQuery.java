/*
 * ParametrizarQuery.java
 * 
 * Data de criação: 22/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ap.comum.constante.CaracterEspecial;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.entitymanager.parametrizacao.bindwhere.DateBindWhere;
import br.com.ap.entitymanager.parametrizacao.bindwhere.IBindWhere;
import br.com.ap.entitymanager.parametrizacao.bindwhere.SerializableBindWhere;
import br.com.ap.entitymanager.parametrizacao.bindwhere.TimeBindWhere;
import br.com.ap.entitymanager.parametrizacao.bindwhere.TimestampBindWhere;
import br.com.ap.reflexao.UtilReflexaoPropriedade;

/**
 * Classe responsável em parametrizar a Query com base nos atributos carregados
 * da Entidade.<br/> Para que um parâmetro seja definido é necessário que o
 * atributo seja um tipo comum, String, Integer, Long etc.
 * 
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public class ParametrizarQuery {
	private static ParametrizarQuery			instancia;
	private static Map<Class<?>, IBindWhere>	mapaBindWhere;

	private EntityManager						entityManager;
	private Entidade							entidade;

	/**
	 * Construtor.
	 */
	protected ParametrizarQuery() {
		// Construtor.
	}

	/**
	 * Retorna a instância da classe.
	 * 
	 * @param entityManager
	 *            Entity Manager.
	 * @param entidade
	 *            Entidade
	 * @return instância da classe.
	 */
	public static ParametrizarQuery novo(EntityManager entityManager,
			Entidade entidade) {
		instancia = new ParametrizarQuery();
		instancia.setEntidade(entidade);
		instancia.setEntityManager(entityManager);

		return instancia;
	}

	/**
	 * Retorna a query parametrizada, ou seja, contendo todos os parâmetros
	 * referêntes ao atributos da entidade.
	 * 
	 * @return Query parametrizada.
	 */
	public Query getQuery() {
		String hql = montarHQL();
		return montarQuery(hql);
	}

	/**
	 * @return entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            Atribui entityManager.
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @return entidade
	 */
	public Entidade getEntidade() {
		return entidade;
	}

	/**
	 * @param entidade
	 *            Atribui entidade.
	 */
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	/**
	 * Monta o HQL com base nos atributos da entidade com valor.
	 * 
	 * @return hql
	 */
	protected String montarHQL() {
		StringBuilder hql = getStringFactory().novoStringBuilder();
		hql.append(montarHQLFrom());
		hql.append(montarHQLWhere());

		return hql.toString();
	}

	/**
	 * Monta o HQL da clausula from.
	 * 
	 * @return hql
	 */
	protected Object montarHQLFrom() {
		StringBuilder sb = getStringFactory().novoStringBuilder();
		sb.append(getQuebraDeLinha());
		sb.append("from ").append(getNomeDaEntidade()).append(" as e ");

		return sb.toString();
	}

	/**
	 * Monta o HQL da clausula where, os parâmetros serão recuperados pelos
	 * atributos da entidade.
	 * 
	 * @return hql
	 */
	protected Object montarHQLWhere() {
		StringBuilder sb = getStringFactory().novoStringBuilder();

		Map<String, Serializable> propriedades = getMapaDePropriedadesDaEntidade();
		Set<String> chaves = propriedades.keySet();
		for (String chave : chaves) {
			Class<?> tipo = getTipoDaPropriedade(chave);
			Serializable valor = propriedades.get(chave);

			if (isTipoValido(tipo) && UtilObjeto.isReferencia(valor)) {
				IBindWhere<Serializable> i = getBindWhere(tipo);
				sb.append(i.getHQL(chave, valor));
			}
		}

		sb.trimToSize();
		if (sb.length() > 4) {
			sb.replace(0, sb.lastIndexOf(" "), "where");
		}

		return sb.toString();
	}

	/**
	 * Monta a Query com base no HQL e parametriza a query montada.
	 * 
	 * @param hql
	 * @return Query já parametrizada.
	 */
	protected Query montarQuery(String hql) {
		Query query = getEntityManager().createQuery(hql);

		Map<String, Serializable> propriedades = getMapaDePropriedadesDaEntidade();
		Set<String> chaves = propriedades.keySet();
		for (String chave : chaves) {
			Class<?> tipo = getTipoDaPropriedade(chave);
			Serializable valor = propriedades.get(chave);

			if (isTipoValido(tipo) && UtilObjeto.isReferencia(valor)) {

				IBindWhere<Serializable> i = getBindWhere(tipo);
				i.setParametro(query, chave, valor);
			}
		}

		return query;
	}

	/**
	 * Retorna o Class da propriedade solicitada.
	 * 
	 * @param propriedade
	 * @return tipo da propriedade.
	 */
	protected Class<?> getTipoDaPropriedade(String propriedade) {
		return UtilReflexaoPropriedade.getTipoDaPropriedade(entidade,
				propriedade);
	}

	/**
	 * Retorna o mapa de propriedades da entidade.
	 * 
	 * @return mapa de propriedades da entidade.
	 */
	protected Map<String, Serializable> getMapaDePropriedadesDaEntidade() {
		return (Map<String, Serializable>) UtilReflexaoPropriedade
				.getMapaDePropriedades(getEntidade());
	}

	/**
	 * Retorna o caracter de quebra de linha.
	 * 
	 * @return caracter de quebra de linha.
	 */
	protected String getQuebraDeLinha() {
		return CaracterEspecial.getQuebraComRetornoDeCarro();
	}

	/**
	 * Retorna o nome da entidade.
	 * 
	 * @return nome da entidade.
	 */
	protected String getNomeDaEntidade() {
		return UtilObjeto.getNomeSemPacote(getEntidade());
	}

	/**
	 * @return fábrica de string.
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Retorna true se o tipo solicitado for um tipo parametrizável.
	 * 
	 * @param tipoPropriedade
	 *            Tipo da propriedade.
	 * @return true se o tipo solicitado for um tipo parametrizável.
	 */
	protected boolean isTipoValido(Class<?> tipoPropriedade) {
		return getMapaBindWhere().containsKey(tipoPropriedade);
	}

	/**
	 * Retorna o IBindWhere para o tipo de propriedade solicitado.
	 * 
	 * @param tipoPropriedade
	 *            Tipo da propriedade.
	 * @return IBindWhere para o tipo de propriedade solicitado.
	 */
	protected IBindWhere getBindWhere(Class<?> tipoPropriedade) {
		return getMapaBindWhere().get(tipoPropriedade);
	}

	/**
	 * Retorna o mapeamento entre tipo de objeto e IBindWhere
	 * 
	 * @return mapaBindWhere
	 */
	protected static Map<Class<?>, IBindWhere> getMapaBindWhere() {
		if (!UtilObjeto.isReferencia(mapaBindWhere)) {
			mapaBindWhere = ColecaoFactory.getInstancia().novoHashMap();
			mapaBindWhere.put(int.class, new SerializableBindWhere());
			mapaBindWhere.put(long.class, new SerializableBindWhere());
			mapaBindWhere.put(boolean.class, new SerializableBindWhere());
			mapaBindWhere.put(byte.class, new SerializableBindWhere());
			mapaBindWhere.put(short.class, new SerializableBindWhere());
			mapaBindWhere.put(char.class, new SerializableBindWhere());
			mapaBindWhere.put(float.class, new SerializableBindWhere());
			mapaBindWhere.put(double.class, new SerializableBindWhere());
			mapaBindWhere.put(Integer.class, new SerializableBindWhere());
			mapaBindWhere.put(Long.class, new SerializableBindWhere());
			mapaBindWhere.put(Boolean.class, new SerializableBindWhere());
			mapaBindWhere.put(Byte.class, new SerializableBindWhere());
			mapaBindWhere.put(Short.class, new SerializableBindWhere());
			mapaBindWhere.put(Character.class, new SerializableBindWhere());
			mapaBindWhere.put(Float.class, new SerializableBindWhere());
			mapaBindWhere.put(Double.class, new SerializableBindWhere());
			mapaBindWhere.put(String.class, new SerializableBindWhere());
			mapaBindWhere.put(java.sql.Date.class, new DateBindWhere());
			mapaBindWhere.put(Date.class, new DateBindWhere());
			mapaBindWhere.put(Time.class, new TimeBindWhere());
			mapaBindWhere.put(Timestamp.class, new TimestampBindWhere());
			mapaBindWhere.put(BigDecimal.class, new SerializableBindWhere());
		}
		return mapaBindWhere;
	}
}
