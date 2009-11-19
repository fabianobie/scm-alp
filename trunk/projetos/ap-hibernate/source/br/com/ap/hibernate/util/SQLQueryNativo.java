/*
 * SQLQueryNativo.java
 * 
 * Data de criação: 20/11/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;

/**
 * Responsável pela
 * 
 * @author adrianop
 */
public class SQLQueryNativo implements Serializable {

	private SQLQuery			query;
	private Map<String, Object>	mapaDeParametros;

	/**
	 * Retorna query.
	 * 
	 * @return SQLQuery
	 */
	public SQLQuery getQuery() {
		return query;
	}

	/**
	 * Atribui query.
	 * 
	 * @param query query
	 */
	public void setQuery(SQLQuery query) {
		this.query = query;
	}

	/**
	 * @param entityClass Classe da entidade
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.Class)
	 */
	public SQLQuery addEntity(Class<?> entityClass) {
		return getQuery().addEntity(entityClass);
	}

	/**
	 * @param alias Alias
	 * @param entityClass Classe da entidade
	 * @param lockMode lockMode
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.String, java.lang.Class,
	 *      org.hibernate.LockMode)
	 */
	public SQLQuery addEntity(String alias, Class<?> entityClass,
			LockMode lockMode) {
		return getQuery().addEntity(alias, entityClass, lockMode);
	}

	/**
	 * @param alias Alias
	 * @param entityClass Classe da entidade
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.String, java.lang.Class)
	 */
	public SQLQuery addEntity(String alias, Class<?> entityClass) {
		return getQuery().addEntity(alias, entityClass);
	}

	/**
	 * @param alias Alias
	 * @param entityName Nome da entidade
	 * @param lockMode lockMode
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.String, java.lang.String,
	 *      org.hibernate.LockMode)
	 */
	public SQLQuery addEntity(String alias, String entityName,
			LockMode lockMode) {
		return getQuery().addEntity(alias, entityName, lockMode);
	}

	/**
	 * @param alias Alias
	 * @param entityName Nome da entidade
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.String, java.lang.String)
	 */
	public SQLQuery addEntity(String alias, String entityName) {
		return getQuery().addEntity(alias, entityName);
	}

	/**
	 * @param entityName Nome da entidade
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addEntity(java.lang.String)
	 */
	public SQLQuery addEntity(String entityName) {
		return getQuery().addEntity(entityName);
	}

	/**
	 * @param alias Alias
	 * @param path Path
	 * @param lockMode lockMode
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addJoin(java.lang.String, java.lang.String,
	 *      org.hibernate.LockMode)
	 */
	public SQLQuery addJoin(String alias, String path, LockMode lockMode) {
		return getQuery().addJoin(alias, path, lockMode);
	}

	/**
	 * @param alias Alias
	 * @param path Path
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addJoin(java.lang.String, java.lang.String)
	 */
	public SQLQuery addJoin(String alias, String path) {
		return getQuery().addJoin(alias, path);
	}

	/**
	 * @param columnAlias alias da coluna
	 * @param type Tipo
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addScalar(java.lang.String,
	 *      org.hibernate.type.Type)
	 */
	public SQLQuery addScalar(String columnAlias, Type type) {
		return getQuery().addScalar(columnAlias, type);
	}

	/**
	 * @param columnAlias alias da coluna
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addScalar(java.lang.String)
	 */
	public SQLQuery addScalar(String columnAlias) {
		return getQuery().addScalar(columnAlias);
	}

	/**
	 * @param entityClass Classe da entidade
	 * @return sqlquery
	 * @throws MappingException exceção do hibernate
	 * @see org.hibernate.SQLQuery#addSynchronizedEntityClass(java.lang.Class)
	 */
	public SQLQuery addSynchronizedEntityClass(Class<?> entityClass)
			throws MappingException {
		return getQuery().addSynchronizedEntityClass(entityClass);
	}

	/**
	 * @param entityName Nome da entidade
	 * @return sqlquery
	 * @throws MappingException exceção do hibernate
	 * @see org.hibernate.SQLQuery#addSynchronizedEntityName(java.lang.String)
	 */
	public SQLQuery addSynchronizedEntityName(String entityName)
			throws MappingException {
		return getQuery().addSynchronizedEntityName(entityName);
	}

	/**
	 * @param querySpace QuerySpace
	 * @return sqlquery
	 * @see org.hibernate.SQLQuery#addSynchronizedQuerySpace(java.lang.String)
	 */
	public SQLQuery addSynchronizedQuerySpace(String querySpace) {
		return getQuery().addSynchronizedQuerySpace(querySpace);
	}

	/**
	 * @return inteiro
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#executeUpdate()
	 */
	public int executeUpdate() throws HibernateException {
		return getQuery().executeUpdate();
	}

	/**
	 * @return array de string
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#getNamedParameters()
	 */
	public String[] getNamedParameters() throws HibernateException {
		return getQuery().getNamedParameters();
	}

	/**
	 * @return sql
	 * @see org.hibernate.Query#getQueryString()
	 */
	public String getQueryString() {
		return getQuery().getQueryString();
	}

	/**
	 * @return aliases
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#getReturnAliases()
	 */
	public String[] getReturnAliases() throws HibernateException {
		return getQuery().getReturnAliases();
	}

	/**
	 * @return tipos
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#getReturnTypes()
	 */
	public Type[] getReturnTypes() throws HibernateException {
		return getQuery().getReturnTypes();
	}

	/**
	 * @param <T> Tipo do objeto do iterador.
	 * @return iterator
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#iterate()
	 */
	@SuppressWarnings("unchecked")
    public <T> Iterator<T> iterate() throws HibernateException {
		return getQuery().iterate();
	}

	/**
	 * @param <T> Tipo do objeto da lista
	 * @return lista
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#list()
	 */
	@SuppressWarnings("unchecked")
    public <T> List<T> list() throws HibernateException {
		return getQuery().list();
	}

	/**
	 * @return scroll
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#scroll()
	 */
	public ScrollableResults scroll() throws HibernateException {
		return getQuery().scroll();
	}

	/**
	 * @param scrollMode Scrol
	 * @return scroll
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#scroll(org.hibernate.ScrollMode)
	 */
	public ScrollableResults scroll(ScrollMode scrollMode)
			throws HibernateException {
		return getQuery().scroll(scrollMode);
	}

	/**
	 * @param position Posição
	 * @param number Numero
	 * @return query
	 * @see org.hibernate.Query#setBigDecimal(int, java.math.BigDecimal)
	 */
	public Query setBigDecimal(int position, BigDecimal number) {
		armazenarParametro(position, number);
		return getQuery().setBigDecimal(position, number);
	}

	/**
	 * @param name Nome
	 * @param number Numero
	 * @return query
	 * @see org.hibernate.Query#setBigDecimal(java.lang.String,
	 *      java.math.BigDecimal)
	 */
	public Query setBigDecimal(String name, BigDecimal number) {
		armazenarParametro(name, number);
		return getQuery().setBigDecimal(name, number);
	}

	/**
	 * @param position Posição
	 * @param number Numero
	 * @return query
	 * @see org.hibernate.Query#setBigInteger(int, java.math.BigInteger)
	 */
	public Query setBigInteger(int position, BigInteger number) {
		armazenarParametro(position, number);
		return getQuery().setBigInteger(position, number);
	}

	/**
	 * @param name Nome
	 * @param number Numero
	 * @return query
	 * @see org.hibernate.Query#setBigInteger(java.lang.String,
	 *      java.math.BigInteger)
	 */
	public Query setBigInteger(String name, BigInteger number) {
		armazenarParametro(name, number);
		return getQuery().setBigInteger(name, number);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setBinary(int, byte[])
	 */
	public Query setBinary(int position, byte[] val) {
		armazenarParametro(position, val);
		return getQuery().setBinary(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setBinary(java.lang.String, byte[])
	 */
	public Query setBinary(String name, byte[] val) {
		armazenarParametro(name, val);
		return getQuery().setBinary(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setBoolean(int, boolean)
	 */
	public Query setBoolean(int position, boolean val) {
		armazenarParametro(position, val);
		return getQuery().setBoolean(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setBoolean(java.lang.String, boolean)
	 */
	public Query setBoolean(String name, boolean val) {
		armazenarParametro(name, val);
		return getQuery().setBoolean(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setByte(int, byte)
	 */
	public Query setByte(int position, byte val) {
		armazenarParametro(position, val);
		return getQuery().setByte(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setByte(java.lang.String, byte)
	 */
	public Query setByte(String name, byte val) {
		armazenarParametro(name, val);
		return getQuery().setByte(name, val);
	}

	/**
	 * @param cacheable boleano
	 * @return query
	 * @see org.hibernate.Query#setCacheable(boolean)
	 */
	public Query setCacheable(boolean cacheable) {
		return getQuery().setCacheable(cacheable);
	}

	/**
	 * @param cacheMode CacheMode
	 * @return query
	 * @see org.hibernate.Query#setCacheMode(org.hibernate.CacheMode)
	 */
	public Query setCacheMode(CacheMode cacheMode) {
		return getQuery().setCacheMode(cacheMode);
	}

	/**
	 * @param cacheRegion Região de cache
	 * @return query
	 * @see org.hibernate.Query#setCacheRegion(java.lang.String)
	 */
	public Query setCacheRegion(String cacheRegion) {
		return getQuery().setCacheRegion(cacheRegion);
	}

	/**
	 * @param position Posição
	 * @param calendar Calendar
	 * @return query
	 * @see org.hibernate.Query#setCalendar(int, java.util.Calendar)
	 */
	public Query setCalendar(int position, Calendar calendar) {
		armazenarParametro(position, calendar);
		return getQuery().setCalendar(position, calendar);
	}

	/**
	 * @param name Nome
	 * @param calendar Calendar
	 * @return query
	 * @see org.hibernate.Query#setCalendar(java.lang.String,
	 *      java.util.Calendar)
	 */
	public Query setCalendar(String name, Calendar calendar) {
		armazenarParametro(name, calendar);
		return getQuery().setCalendar(name, calendar);
	}

	/**
	 * @param position Posição
	 * @param calendar Calendar
	 * @return query
	 * @see org.hibernate.Query#setCalendarDate(int, java.util.Calendar)
	 */
	public Query setCalendarDate(int position, Calendar calendar) {
		armazenarParametro(position, calendar);
		return getQuery().setCalendarDate(position, calendar);
	}

	/**
	 * @param name Nome
	 * @param calendar Calendar
	 * @return query
	 * @see org.hibernate.Query#setCalendarDate(java.lang.String,
	 *      java.util.Calendar)
	 */
	public Query setCalendarDate(String name, Calendar calendar) {
		armazenarParametro(name, calendar);
		return getQuery().setCalendarDate(name, calendar);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setCharacter(int, char)
	 */
	public Query setCharacter(int position, char val) {
		armazenarParametro(position, val);
		return getQuery().setCharacter(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setCharacter(java.lang.String, char)
	 */
	public Query setCharacter(String name, char val) {
		armazenarParametro(name, val);
		return getQuery().setCharacter(name, val);
	}

	/**
	 * @param comment Comentário
	 * @return query
	 * @see org.hibernate.Query#setComment(java.lang.String)
	 */
	public Query setComment(String comment) {
		return getQuery().setComment(comment);
	}

	/**
	 * @param position Posição
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setDate(int, java.util.Date)
	 */
	public Query setDate(int position, Date date) {
		armazenarParametro(position, date);
		return getQuery().setDate(position, date);
	}

	/**
	 * @param name Nome
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setDate(java.lang.String, java.util.Date)
	 */
	public Query setDate(String name, Date date) {
		armazenarParametro(name, date);
		return getQuery().setDate(name, date);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setDouble(int, double)
	 */
	public Query setDouble(int position, double val) {
		armazenarParametro(position, val);
		return getQuery().setDouble(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setDouble(java.lang.String, double)
	 */
	public Query setDouble(String name, double val) {
		armazenarParametro(name, val);
		return getQuery().setDouble(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setEntity(int, java.lang.Object)
	 */
	public Query setEntity(int position, Object val) {
		armazenarParametro(position, val);
		return getQuery().setEntity(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setEntity(java.lang.String, java.lang.Object)
	 */
	public Query setEntity(String name, Object val) {
		armazenarParametro(name, val);
		return getQuery().setEntity(name, val);
	}

	/**
	 * @param fetchSize FetchSize
	 * @return query
	 * @see org.hibernate.Query#setFetchSize(int)
	 */
	public Query setFetchSize(int fetchSize) {
		return getQuery().setFetchSize(fetchSize);
	}

	/**
	 * @param firstResult FirstResult
	 * @return query
	 * @see org.hibernate.Query#setFirstResult(int)
	 */
	public Query setFirstResult(int firstResult) {
		return getQuery().setFirstResult(firstResult);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setFloat(int, float)
	 */
	public Query setFloat(int position, float val) {
		armazenarParametro(position, val);
		return getQuery().setFloat(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setFloat(java.lang.String, float)
	 */
	public Query setFloat(String name, float val) {
		armazenarParametro(name, val);
		return getQuery().setFloat(name, val);
	}

	/**
	 * @param flushMode FlushMode
	 * @return query
	 * @see org.hibernate.Query#setFlushMode(org.hibernate.FlushMode)
	 */
	public Query setFlushMode(FlushMode flushMode) {
		return getQuery().setFlushMode(flushMode);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setInteger(int, int)
	 */
	public Query setInteger(int position, int val) {
		armazenarParametro(position, val);
		return getQuery().setInteger(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setInteger(java.lang.String, int)
	 */
	public Query setInteger(String name, int val) {
		armazenarParametro(name, val);
		return getQuery().setInteger(name, val);
	}

	/**
	 * @param position Posição
	 * @param locale Locale
	 * @return query
	 * @see org.hibernate.Query#setLocale(int, java.util.Locale)
	 */
	public Query setLocale(int position, Locale locale) {
		armazenarParametro(position, locale);
		return getQuery().setLocale(position, locale);
	}

	/**
	 * @param name Nome
	 * @param locale Locale
	 * @return query
	 * @see org.hibernate.Query#setLocale(java.lang.String, java.util.Locale)
	 */
	public Query setLocale(String name, Locale locale) {
		armazenarParametro(name, locale);
		return getQuery().setLocale(name, locale);
	}

	/**
	 * @param alias Alias
	 * @param lockMode lockMode
	 * @return query
	 * @see org.hibernate.Query#setLockMode(java.lang.String,
	 *      org.hibernate.LockMode)
	 */
	public Query setLockMode(String alias, LockMode lockMode) {
		return getQuery().setLockMode(alias, lockMode);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setLong(int, long)
	 */
	public Query setLong(int position, long val) {
		armazenarParametro(position, val);
		return getQuery().setLong(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setLong(java.lang.String, long)
	 */
	public Query setLong(String name, long val) {
		armazenarParametro(name, val);
		return getQuery().setLong(name, val);
	}

	/**
	 * @param maxResults Máximo de resultados
	 * @return query
	 * @see org.hibernate.Query#setMaxResults(int)
	 */
	public Query setMaxResults(int maxResults) {
		return getQuery().setMaxResults(maxResults);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @param type Tipo
	 * @return query
	 * @see org.hibernate.Query#setParameter(int, java.lang.Object,
	 *      org.hibernate.type.Type)
	 */
	public Query setParameter(int position, Object val, Type type) {
		armazenarParametro(position, val);
		return getQuery().setParameter(position, val, type);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameter(int, java.lang.Object)
	 */
	public Query setParameter(int position, Object val)
			throws HibernateException {
		armazenarParametro(position, val);
		return getQuery().setParameter(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @param type Tipo
	 * @return query
	 * @see org.hibernate.Query#setParameter(java.lang.String, java.lang.Object,
	 *      org.hibernate.type.Type)
	 */
	public Query setParameter(String name, Object val, Type type) {
		armazenarParametro(name, val);
		return getQuery().setParameter(name, val, type);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameter(java.lang.String, java.lang.Object)
	 */
	public Query setParameter(String name, Object val)
			throws HibernateException {
		armazenarParametro(name, val);
		return getQuery().setParameter(name, val);
	}

	/**
	 * @param <T> Tipo do objeto da coleção
	 * @param name Nome
	 * @param vals Valores
	 * @param type Tipo
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameterList(java.lang.String,
	 *      java.util.Collection, org.hibernate.type.Type)
	 */
	public <T> Query setParameterList(String name, Collection<T> vals, Type type)
			throws HibernateException {
		armazenarParametro(name, vals);
		return getQuery().setParameterList(name, vals, type);
	}

	/**
	 * @param <T> Tipo do objeto da coleção 
	 * @param name Nome
	 * @param vals Valores
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameterList(java.lang.String,
	 *      java.util.Collection)
	 */
	public <T> Query setParameterList(String name, Collection<T> vals)
			throws HibernateException {
		armazenarParametro(name, vals);
		return getQuery().setParameterList(name, vals);
	}

	/**
	 * @param name Nome
	 * @param vals Valores
	 * @param type Tipo
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameterList(java.lang.String,
	 *      java.lang.Object[], org.hibernate.type.Type)
	 */
	public Query setParameterList(String name, Object[] vals, Type type)
			throws HibernateException {
		armazenarParametro(name, vals);
		return getQuery().setParameterList(name, vals, type);
	}

	/**
	 * @param name Nome
	 * @param vals Valores
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameterList(java.lang.String,
	 *      java.lang.Object[])
	 */
	public Query setParameterList(String name, Object[] vals)
			throws HibernateException {
		armazenarParametro(name, vals);
		return getQuery().setParameterList(name, vals);
	}

	/**
	 * @param values Valores
	 * @param types Tipo
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setParameters(java.lang.Object[],
	 *      org.hibernate.type.Type[])
	 */
	public Query setParameters(Object[] values, Type[] types)
			throws HibernateException {

		if (isTamanhosIguais(values, types)) {
			for (int indice = 0; indice < values.length; indice++) {
				armazenarParametro(values[indice], types[indice]);
			}
		}
		return getQuery().setParameters(values, types);
	}

	/**
	 * @param <T0> Tipo do objeto da chave do mapa
	 * @param <T1> Tipo do objeto adicionado no mapa
	 * @param bean Objeto
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setProperties(java.util.Map)
	 */
	public <T0, T1> Query setProperties(Map<T0, T1> bean) throws HibernateException {
		return getQuery().setProperties(bean);
	}

	/**
	 * @param bean Objeto
	 * @return query
	 * @throws HibernateException exceção hibernate
	 * @see org.hibernate.Query#setProperties(java.lang.Object)
	 */
	public Query setProperties(Object bean) throws HibernateException {
		return getQuery().setProperties(bean);
	}

	/**
	 * @param readOnly Ready Only
	 * @return query
	 * @see org.hibernate.Query#setReadOnly(boolean)
	 */
	public Query setReadOnly(boolean readOnly) {
		return getQuery().setReadOnly(readOnly);
	}

	/**
	 * @param name Nome
	 * @return query
	 * @see org.hibernate.SQLQuery#setResultSetMapping(java.lang.String)
	 */
	public SQLQuery setResultSetMapping(String name) {
		return getQuery().setResultSetMapping(name);
	}

	/**
	 * @param transformer ResultTransformer
	 * @return query
	 * @see org.hibernate.Query#setResultTransformer(org.hibernate.transform.ResultTransformer)
	 */
	public Query setResultTransformer(ResultTransformer transformer) {
		return getQuery().setResultTransformer(transformer);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setSerializable(int, java.io.Serializable)
	 */
	public Query setSerializable(int position, Serializable val) {
		armazenarParametro(position, val);
		return getQuery().setSerializable(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setSerializable(java.lang.String,
	 *      java.io.Serializable)
	 */
	public Query setSerializable(String name, Serializable val) {
		armazenarParametro(name, val);
		return getQuery().setSerializable(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setShort(int, short)
	 */
	public Query setShort(int position, short val) {
		armazenarParametro(position, val);
		return getQuery().setShort(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setShort(java.lang.String, short)
	 */
	public Query setShort(String name, short val) {
		armazenarParametro(name, val);
		return getQuery().setShort(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setString(int, java.lang.String)
	 */
	public Query setString(int position, String val) {
		armazenarParametro(position, val);
		return getQuery().setString(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setString(java.lang.String, java.lang.String)
	 */
	public Query setString(String name, String val) {
		armazenarParametro(name, val);
		return getQuery().setString(name, val);
	}

	/**
	 * @param position Posição
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setText(int, java.lang.String)
	 */
	public Query setText(int position, String val) {
		armazenarParametro(position, val);
		return getQuery().setText(position, val);
	}

	/**
	 * @param name Nome
	 * @param val Valor
	 * @return query
	 * @see org.hibernate.Query#setText(java.lang.String, java.lang.String)
	 */
	public Query setText(String name, String val) {
		armazenarParametro(name, val);
		return getQuery().setText(name, val);
	}

	/**
	 * @param position Posição
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setTime(int, java.util.Date)
	 */
	public Query setTime(int position, Date date) {
		armazenarParametro(position, date);
		return getQuery().setTime(position, date);
	}

	/**
	 * @param name Nome
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setTime(java.lang.String, java.util.Date)
	 */
	public Query setTime(String name, Date date) {
		armazenarParametro(name, date);
		return getQuery().setTime(name, date);
	}

	/**
	 * @param timeout Tempo
	 * @return query
	 * @see org.hibernate.Query#setTimeout(int)
	 */
	public Query setTimeout(int timeout) {
		return getQuery().setTimeout(timeout);
	}

	/**
	 * @param position Posição
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setTimestamp(int, java.util.Date)
	 */
	public Query setTimestamp(int position, Date date) {
		armazenarParametro(position, date);
		return getQuery().setTimestamp(position, date);
	}

	/**
	 * @param name Nome
	 * @param date Data
	 * @return query
	 * @see org.hibernate.Query#setTimestamp(java.lang.String, java.util.Date)
	 */
	public Query setTimestamp(String name, Date date) {
		armazenarParametro(name, date);
		return getQuery().setTimestamp(name, date);
	}

	/**
	 * @return resultado
	 * @throws HibernateException exceção do hibernate
	 * @see org.hibernate.Query#uniqueResult()
	 */
	public Object uniqueResult() throws HibernateException {
		return getQuery().uniqueResult();
	}

	/**
	 * Armazena o parâmetro para uso posterior.
	 * 
	 * @param <T0> Tipo do objeto
	 * @param <T1> Tipo do objeto 
	 * @param posicao Posição
	 * @param valor Valor
	 */
	protected <T0 extends Object, T1 extends Object> void armazenarParametro(T0 posicao, T1 valor) {
		String chave = UtilString.getString(posicao);
		getMapaDeParametros().put(chave, valor);
	}

	/**
	 * Retorna true se os dois arrays forem de tamanhos iguais.
	 * 
	 * @param <T0> Tipo do objeto que compõe o array0
	 * @param <T1> Tipo do objeto que compõe o array1
	 * @param array0 Array0
	 * @param array1 Array1
	 * @return true se os dois arrays forem de tamanhos iguais.
	 */
	protected <T0 extends Object, T1 extends Object> boolean isTamanhosIguais(
			T0[] array0, T1[] array1) {
		return UtilObjeto.isReferenciaTodos(array0, array1)
				&& UtilValidadorDeNumerosIguais.validar(array0.length,
						array1.length);
	}

	/**
	 * Retorna mapaDeParametros.
	 * 
	 * @return Mapa
	 */
	protected Map<String, Object> getMapaDeParametros() {
		if (!UtilObjeto.isReferencia(mapaDeParametros)) {
			mapaDeParametros = getColecaoFactory().novoHashMap();
		}
		return mapaDeParametros;
	}

	/**
	 * @return fábrica de coleção
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
