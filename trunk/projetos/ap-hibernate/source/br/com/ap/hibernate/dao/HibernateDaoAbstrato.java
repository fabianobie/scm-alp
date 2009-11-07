/*
 * HibernateDaoAbstrato.java
 * 
 * Data de criação: 20/03/2009
 */
package br.com.ap.hibernate.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;

import br.com.ap.arquitetura.dao.DAO;
import br.com.ap.arquitetura.holder.PaginacaoHolder;
import br.com.ap.comum.calculadores.UtilSomadoresDeNumero;
import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.estrategia.UtilEstrategiaDeConversores;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.javabean.entidade.ExclusaoLogica;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.hibernate.holder.HibernateHolder;
import br.com.ap.hibernate.util.SQLQueryNativo;
import br.com.ap.hibernate.util.UtilCriarQueryDeCount;
import br.com.ap.hibernate.util.fabrica.HibernateFactory;
import br.com.ap.reflexao.UtilReflexaoConstrutor;
import br.com.ap.reflexao.UtilReflexaoGeneric;
import br.com.ap.reflexao.UtilReflexaoPropriedade;

/**
 * Classe responsável pela persistência usando hibernate.
 * 
 * @param <T>
 *            Tipo do objeto tratado pela DAO
 * @author AdrianoP
 */
public class HibernateDaoAbstrato<T extends Entidade> implements DAO<T> {

	private SessionFactory	sessionFactory;
	private Session			session;
	
	/**
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            Atribui o SessionFactory do hibernate
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return Session
	 */
	protected Session getSession() {
		if (!UtilObjeto.isReferencia(session)) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	/**
	 * Efetua o load da entidade caso esta não seja uma entidade persistente.
	 * 
	 * @param entidade
	 *            Entidade que será carregada como persistente.
	 */
	protected void carregarEntidadePersistente(T entidade) {

		if (isReferencia(entidade) && !isPersistente(entidade)) {
			registrarAcaoDeConsulta();
			Serializable pk = entidade.getIdentificador();
			getSession().load(entidade, pk);
		}
	}

	/**
	 * Retorna true se a entidade for persistente.
	 * 
	 * @param entidade
	 *            Entidade validada.
	 * @return true se a entidade for persistente.
	 */
	protected boolean isPersistente(T entidade) {
		return (getSession().contains(entidade));
	}

	/**
	 * Configura a paginação para o criterio informado.<br/>
	 * As configurações de paginação são definidas no PaginacaoHolder.
	 * 
	 * @param criteria
	 *            Critério de consulta.
	 * @see PaginacaoHolder
	 */
	protected void configurarPaginacao(Criteria criteria) {
		Integer pagina = PaginacaoHolder.getNumeroPagina();
		Integer regsPag = PaginacaoHolder.getLimiteRegistro();

		if (isReferencia(criteria) && !isZero(regsPag)) {
			Integer total = getQuantidadeTotalDeRegistros(criteria);

			if (pagina == null || pagina.intValue() < 1) {
				pagina = new Integer(1);
			}

			double calculo = Math.ceil((double) total.intValue() / regsPag.intValue());
			int numeroPag = new Double(calculo).intValue();
			if (numeroPag < pagina.intValue()) {
				pagina = numeroPag;
			}

			if ((total.intValue() > regsPag.intValue())) {
				int inicio = (pagina.intValue() * regsPag.intValue()) - regsPag.intValue();
				criteria.setFirstResult(inicio);
				criteria.setMaxResults(regsPag);
			}

			PaginacaoHolder.setTotalRegistros(total);
			PaginacaoHolder.setNumeroPagina(pagina);
		}
	}

	/**
	 * Configura a paginação para a query informada.<br/>
	 * As configurações de paginação são definidas no PaginacaoHolder.
	 * 
	 * @param query
	 *            Query de consulta.
	 * @see PaginacaoHolder
	 */
	protected void configurarPaginacao(Query query) {
		Integer pagina = PaginacaoHolder.getNumeroPagina();
		Integer regsPag = PaginacaoHolder.getLimiteRegistro();

		if (isReferencia(query) && !isZero(regsPag)) {
			Integer total = getQuantidadeTotalDeRegistros(query);

			if (pagina == null || pagina.intValue() < 1) {
				pagina = new Integer(1);
			}

			double calculo = Math.ceil((double) total.intValue() / regsPag.intValue());
			int numeroPag = new Double(calculo).intValue();
			if (numeroPag < pagina.intValue()) {
				pagina = numeroPag;
			}

			if ((total.intValue() > regsPag.intValue())) {
				int inicio = (pagina.intValue() * regsPag.intValue()) - regsPag.intValue();
				query.setFirstResult(inicio);
				query.setMaxResults(regsPag);
			}

			PaginacaoHolder.setTotalRegistros(total);
			PaginacaoHolder.setNumeroPagina(pagina);
		}
	}

	/**
	 * Configura a paginação para a query informada.<br/>
	 * As configurações de paginação são definidas no PaginacaoHolder.
	 * 
	 * @param query
	 *            Query de consulta.
	 * @see PaginacaoHolder
	 */
	protected void configurarPaginacao(SQLQueryNativo query) {
		Integer pagina = PaginacaoHolder.getNumeroPagina();
		Integer regsPag = PaginacaoHolder.getLimiteRegistro();

		if (isReferencia(query) && !isZero(regsPag)) {
			Integer total = getQuantidadeTotalDeRegistros(query);

			if (pagina == null || pagina.intValue() < 1) {
				pagina = new Integer(1);
			}

			double calculo = Math.ceil((double) total.intValue() / regsPag.intValue());
			int numeroPag = new Double(calculo).intValue();
			if (numeroPag < pagina.intValue()) {
				pagina = numeroPag;
			}

			if ((total.intValue() > regsPag.intValue())) {
				int inicio = (pagina.intValue() * regsPag.intValue()) - regsPag.intValue();
				query.setFirstResult(inicio);
				query.setMaxResults(regsPag);
			}

			PaginacaoHolder.setTotalRegistros(total);
			PaginacaoHolder.setNumeroPagina(pagina);
		}
	}

	/**
	 * Efetua a consulta de um criteria.
	 * 
	 * @param criteria
	 *            Critéria que será executada.
	 * @return Coleção de entidades.
	 */
	@SuppressWarnings("unchecked")
	protected Collection<T> consultar(Criteria criteria) {
		registrarAcaoDeConsulta();
		configurarPaginacao(criteria);
		Collection<T> colecao = criteria.list();
		return colecao;
	}

	/**
	 * Efetua a consulta de uma query.
	 * 
	 * @param query
	 *            Query que será executada.
	 * @return Coleção de entidades.
	 */
	@SuppressWarnings("unchecked")
	protected Collection<T> consultar(Query query) {
		registrarAcaoDeConsulta();
		configurarPaginacao(query);
		Collection<T> colecao = query.list();
		return colecao;
	}

	/**
	 * Efetua a consulta de uma query.
	 * 
	 * @param <O>
	 *            Tipo de objeto retornado.
	 * @param query
	 *            Query que será executada.
	 * @return Coleção de entidades.
	 */
	protected <O> Collection<O> consultar(SQLQueryNativo query) {
		registrarAcaoDeConsulta();
		configurarPaginacao(query);
		Collection<O> colecao = query.list();
		return colecao;
	}

	/**
	 * Efetua a consulta de um hql.
	 * 
	 * @param hql
	 *            HQL que será executado.
	 * @return Coleção de entidades.
	 */
	protected Collection<T> consultar(String hql) {
		Query query = novaQuery(hql);
		return consultar(query);
	}

	/**
	 * Efetua a consulta de uma query definida no arquivo XML. A query
	 * identificada pelo ID informado será recuperado do XML e executada.
	 * 
	 * @param identificador
	 *            HQL que será executado.
	 * @return Coleção de entidades.
	 */
	protected Collection<T> consultarQueryPeloID(String identificador) {
		Collection<T> resultado = getColecaoFactory().novoArrayList();

		if (!isVazio(identificador)) {
			Query query = getQuery(identificador);
			resultado = consultar(query);
		}
		return resultado;
	}

	/**
	 * Executa um update ou delete na query passada por parâmetro.
	 * 
	 * @param query
	 *            Query
	 * @return quantidade de registros afetados.
	 */
	protected int executar(Query query) {
		int resultado = 0;

		if (isReferencia(query)) {
			registrarAcaoDeAlteracao();
			resultado = query.executeUpdate();
		}
		return resultado;
	}

	/**
	 * Consulta uma entidade do critério passado por parâmetro.
	 * 
	 * @param criteria
	 *            Criteria que será executado.
	 * @return Entidade
	 */
	protected T obter(Criteria criteria) {
		Integer paginacao = PaginacaoHolder.getLimiteRegistro();
		PaginacaoHolder.setLimiteRegistro(null);

		Collection<T> colecao = consultar(criteria);

		PaginacaoHolder.setLimiteRegistro(paginacao);
		return UtilColecao.getElementoDoIndice(colecao, 0);
	}

	/**
	 * Consulta uma entidade da query passado por parâmetro.
	 * 
	 * @param query
	 *            Query que será executado.
	 * @return Entidade
	 */
	@SuppressWarnings("unchecked")
	protected T obter(Query query) {
		registrarAcaoDeConsulta();
		T resultado = (T) query.uniqueResult();
		return resultado;
	}

	/**
	 * Consulta uma entidade da query passado por parâmetro.
	 * 
	 * @param hql
	 *            HQL que será executado.
	 * @return Entidade
	 */
	protected T obter(String hql) {
		Integer paginacao = PaginacaoHolder.getLimiteRegistro();
		PaginacaoHolder.setLimiteRegistro(null);

		Collection<T> colecao = consultar(hql);

		PaginacaoHolder.setLimiteRegistro(paginacao);
		return UtilColecao.getElementoDoIndice(colecao, 0);
	}

	/**
	 * Retorna uma alias da consulta atual, caso o alias não exista ele será
	 * criado.
	 * 
	 * @param query
	 *            Query
	 * @param alias
	 *            Alias
	 * @return alias da consulta atual
	 */
	protected Criteria getAlias(Criteria query, String alias) {
		Criteria resultado = recuperarSubCriteria(query, alias);
		if (!isReferencia(resultado)) {
			resultado = query.createAlias(alias, alias);
		}
		return resultado;
	}

	/**
	 * Retorna o class metadata da entidade.
	 * 
	 * @return class metadata da entidade.
	 */
	protected ClassMetadata getClassMetadata() {
		Class<?> classe = getTipoDaEntidade();
		return getSessionFactory().getClassMetadata(classe);
	}

	/**
	 * @return fábrica de coleção.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna uma sub criteria da consulta atual, caso a sub criteira não
	 * exista ela será criada.
	 * 
	 * @param query
	 *            Query
	 * @param alias
	 *            Alias
	 * @return sub criteria da consulta atual
	 */
	protected Criteria getCriteria(Criteria query, String alias) {
		Criteria resultado = recuperarSubCriteria(query, alias);
		if (!isReferencia(resultado)) {
			resultado = query.createCriteria(alias, alias);
		}
		return resultado;
	}

	/**
	 * @return fábrica de número.
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param criteria
	 *            Critério da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	@SuppressWarnings( { "boxing", "unchecked" })
	protected Integer getQuantidadeTotalDeRegistros(Criteria criteria) {
		Integer resultado = getNumeroFactory().novoInteger(0);
		if (isReferencia(criteria)) {
			ResultTransformer rt = null;
			if (UtilObjeto.isObjetoDoTipo(criteria, CriteriaImpl.class)) {

				rt = ((CriteriaImpl) criteria).getResultTransformer();
				Projection pj = ((CriteriaImpl) criteria).getProjection();

				// removendo os orders para evitar erro na consulta com count
				List<CriteriaImpl.OrderEntry> orders = getColecaoFactory().novoArrayList();
				Iterator<CriteriaImpl.OrderEntry> iterator = ((CriteriaImpl) criteria)
						.iterateOrderings();
				while (iterator.hasNext()) {
					orders.add(iterator.next());
					iterator.remove();
				}

				criteria.setProjection(Projections.rowCount());
				resultado = (Integer) criteria.uniqueResult();
				criteria.setProjection(pj);

				// adicionando os orders no criteria novamente.
				for (CriteriaImpl.OrderEntry order : orders) {
					order.getCriteria().addOrder(order.getOrder());
				}
				if (isReferencia(rt)) {
					criteria.setResultTransformer(rt);
				}
			} else {
				resultado = getQuantidadeTotalDeRegistros(criteria.scroll());
			}
		}
		return resultado;
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param query
	 *            Critério da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	@SuppressWarnings("boxing")
	protected Integer getQuantidadeTotalDeRegistros(Query query) {
		Integer resultado = getNumeroFactory().novoInteger(0);
		if (isReferencia(query)) {
			Query count = UtilCriarQueryDeCount.criar(getSession(), query);

			Number total = (Number) count.uniqueResult();
			resultado = total.intValue();
		}
		return resultado;
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param query
	 *            Critério da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	@SuppressWarnings("boxing")
	protected Integer getQuantidadeTotalDeRegistros(SQLQueryNativo query) {
		Integer resultado = getNumeroFactory().novoInteger(0);
		if (isReferencia(query)) {
			SQLQueryNativo count = UtilCriarQueryDeCount.criar(getSession(), query);

			Number total = (Number) count.uniqueResult();
			resultado = total.intValue();
		}
		return resultado;
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param hql
	 *            HQL da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	protected Integer getQuantidadeTotalDeRegistros(String hql) {
		Query query = getSession().createQuery(hql);
		return getQuantidadeTotalDeRegistros(query);
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param scrollable
	 *            Critério da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	protected Integer getQuantidadeTotalDeRegistros(ScrollableResults scrollable) {
		Integer resultado = getNumeroFactory().novoInteger(0);
		if (isReferencia(scrollable)) {
			scrollable.last();

			int rowNumber = scrollable.getRowNumber();
			resultado = getNumeroFactory().novoInteger(rowNumber + 1);
		}
		return resultado;
	}

	/**
	 * Retorna nova query.
	 * 
	 * @param identificador
	 *            Identificador do HQL mapeado no arquivo XML.
	 * @return nova query.
	 */
	protected Query getQuery(String identificador) {
		return getSession().getNamedQuery(identificador);
	}

	/**
	 * @return instância da entidade tratada pela DAO.
	 */
	@SuppressWarnings("unchecked")
	protected T getInstanciaDaEntidade() {
		Class<?> tipo = getTipoDaEntidade();
		return (T) UtilReflexaoConstrutor.invocar(tipo);
	}

	/**
	 * Retorna nova query mapeado no xml.
	 * 
	 * @param identificador
	 *            SQL
	 * @return nova query.
	 */
	protected SQLQueryNativo getSQLQuery(String identificador) {
		SQLQuery query = (SQLQuery) getSession().getNamedQuery(identificador);
		return getHibernateFactory().novoSQLQueryNativo(query);
	}

	/**
	 * Retorna o tipo da entidade. O tipo é recuperado a partir do generics.
	 * 
	 * @return Classe da entidade.
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getTipoDaEntidade() {
		return (Class<T>) UtilReflexaoGeneric.getClasseDoTipo(this);
	}

	/**
	 * Retorna a estratégia de conversores.
	 * 
	 * @return estratégia de conversores.
	 */
	protected UtilEstrategiaDeConversores getUtilEstrategiaDeConversores() {
		return UtilEstrategiaDeConversores.getInstancia();
	}

	/**
	 * Retorna true se a entidade possui exclusão lógica.
	 * 
	 * @param entidade
	 *            Entidade
	 * @return true se a entidade possui exclusão lógica.
	 */
	protected boolean isEntidadeComExclusaoLogica(T entidade) {
		return UtilObjeto.isObjetoDoTipo(entidade, ExclusaoLogica.class);
	}

	/**
	 * @param objetos
	 *            Objetos que serão validados.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * @param strings
	 *            Strings que serão validadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazio(String)
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * Retorna true se a coleção estiver vazia.
	 * 
	 * @param colecao
	 *            Coleção validada
	 * @return true se a coleção estiver vazia.
	 */
	protected boolean isVazio(Collection<?> colecao) {
		return UtilColecao.isVazio(colecao);
	}

	/**
	 * Retorna true se o valor passado for zero ou nulo.
	 * 
	 * @param valor
	 *            Valor que será validado
	 * @return true se o valor passado for zero ou nulo.
	 */
	@SuppressWarnings("boxing")
	protected boolean isZero(Number valor) {
		return !isReferencia(valor) || (valor.intValue() == 0);
	}

	/**
	 * Retorna nova ordenação ASC.
	 * 
	 * @param propriedade
	 *            propriedade que será ordenada.
	 * @return ordenação ASC
	 */
	protected Order novaOrdenacaoASC(String propriedade) {
		return Order.asc(propriedade);
	}

	/**
	 * Retorna nova ordenação DESC.
	 * 
	 * @param propriedade
	 *            propriedade que será ordenada.
	 * @return ordenação DESC
	 */
	protected Order novaOrdenacaoDESC(String propriedade) {
		return Order.desc(propriedade);
	}

	/**
	 * Retorna nova query.
	 * 
	 * @param hql
	 *            HQL
	 * @return nova query.
	 */
	protected Query novaQuery(String hql) {
		return getSession().createQuery(hql);
	}

	/**
	 * Retorna novo criteria para entidade.
	 * 
	 * @return novo criteria para entidade.
	 */
	protected Criteria novoCriteria() {
		Class<T> tipo = getTipoDaEntidade();
		return getSession().createCriteria(tipo);
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @param arg1
	 *            Argumento
	 * @return critério
	 * @see Restrictions#between(String, Object, Object)
	 */
	protected Criterion novoCriterioBetween(String propriedade, Object arg0, Object arg1) {
		return Restrictions.between(propriedade, arg0, arg1);
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @return critério
	 * @see Restrictions#eq(String, Object)
	 */
	protected Criterion novoCriterioEQ(String propriedade, Object arg0) {
		return Restrictions.eq(propriedade, arg0);
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @return critério
	 * @see Restrictions#eq(String, Object)
	 */
	protected Criterion novoCriterioEQIgnoreCase(String propriedade, Object arg0) {
		SimpleExpression se = Restrictions.eq(propriedade, arg0);
		se.ignoreCase();
		return se;
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param colecao
	 *            Coleção de parâmetros
	 * @return critério
	 */
	protected Criterion novoCriterioIN(String propriedade, Collection<?> colecao) {

		Criterion criterion = null;
		if (!isVazio(colecao)) {
			Object[] array = new Object[colecao.size()];
			for (int indice = 0; indice < colecao.size(); indice++) {
				Object o = UtilColecao.getElementoDoIndice(colecao, indice);
				array[indice] = UtilReflexaoPropriedade.get(o, propriedade);
			}
			criterion = Restrictions.in(propriedade, array);
		}
		return criterion;
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @return critério
	 * @see Restrictions#like(String, Object)
	 */
	protected Criterion novoCriterioLike(String propriedade, String arg0) {
		SimpleExpression se = null;
		se = Restrictions.like(propriedade, arg0, MatchMode.ANYWHERE);
		se.ignoreCase();
		return se;
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @return critério
	 * @see Restrictions#like(String, Object)
	 */
	protected Criterion novoCriterioLikeDireita(String propriedade, String arg0) {
		SimpleExpression se = null;
		se = Restrictions.like(propriedade, arg0, MatchMode.START);
		se.ignoreCase();
		return se;
	}

	/**
	 * Retorna novo critério.
	 * 
	 * @param propriedade
	 *            Propriedade
	 * @param arg0
	 *            Argumento
	 * @return critério
	 * @see Restrictions#ne(String, Object)
	 */
	protected Criterion novoCriterioNE(String propriedade, Object arg0) {
		return Restrictions.ne(propriedade, arg0);
	}

	/**
	 * Retorna nova query.
	 * 
	 * @param sql
	 *            SQL
	 * @return nova query.
	 */
	protected SQLQueryNativo novoSQLQuery(String sql) {
		SQLQuery query = getSession().createSQLQuery(sql);
		return getHibernateFactory().novoSQLQueryNativo(query);
	}

	/**
	 * Retorna nova query da entidade.
	 * 
	 * @param sql
	 *            SQL
	 * @return nova query da entidade.
	 */
	protected SQLQueryNativo novoSQLQueryDaEntidade(String sql) {
		SQLQuery query = getSession().createSQLQuery(sql);

		Class<T> classe = getTipoDaEntidade();
		String alias = UtilObjeto.getNomeSemPacote(classe);
		query.addEntity(alias, classe);

		return getHibernateFactory().novoSQLQueryNativo(query);
	}

	/**
	 * Retorna o maior identificador da entidade. Será feita uma consulta do
	 * tipo 'select max' para obter o maior ID da entidade. É necessário que a
	 * entidade possuia um atributo identificador.
	 * 
	 * @param <R>
	 *            Tipo do objeto que será retornado. Pode ser Integer ou Long,
	 *            dependendo do tipo da entidade.
	 * @return maior identificador da entidade.
	 */
	@SuppressWarnings( { "unchecked" })
	protected <R extends Number> R obterMaiorIdentificar() {
		ClassMetadata cm = getClassMetadata();
		String propriedadePK = cm.getIdentifierPropertyName();

		Criteria criteria = novoCriteria();
		criteria.setProjection(Projections.max(propriedadePK));
		return (R) criteria.uniqueResult();
	}

	/**
	 * Retorna o próximo identificador da entidade. Será feita uma consulta do
	 * tipo 'select max + 1' para obter o próximo ID da entidade. É necessário
	 * que a entidade possuia um atributo identificador.
	 * 
	 * @return maior identificador da entidade.
	 */
	@SuppressWarnings("boxing")
	protected Long obterProximoIdentificar() {
		return UtilSomadoresDeNumero.somar(obterMaiorIdentificar(), 1);
	}

	/**
	 * Remove o registro de ação. A ação é registrada no HibernateHolder.
	 * 
	 * @see HibernateHolder
	 */
	protected void removerAcaoSolicitada() {
		HibernateHolder.removerAcao();
	}

	/**
	 * Retorna o criterio principal do criterio informado, caso o criterio
	 * informado seja uma subcriteria, será recuperado o criterio pai até chegar
	 * ao criterio principal
	 * 
	 * @param query
	 *            Criterio
	 * @return criterio principal.
	 */
	private Criteria getCriteriaPrincipal(Criteria query) {
		Criteria resultado = query;
		Class<?> subcriteria = CriteriaImpl.Subcriteria.class;

		while (UtilObjeto.isObjetoDoTipo(resultado, subcriteria)) {
			resultado = ((CriteriaImpl.Subcriteria) resultado).getParent();
		}
		return resultado;
	}

	/**
	 * @return fábrica dos objetos da api do hibernate STJ
	 */
	private HibernateFactory getHibernateFactory() {
		return HibernateFactory.getInstancia();
	}

	/**
	 * Recupera uma sub criteria da query passada por parâmetro.
	 * 
	 * @param query
	 *            Query
	 * @param alias
	 *            Alias
	 * @return sub criteria da query passada por parâmetro.
	 */
	@SuppressWarnings("unchecked")
	private Criteria recuperarSubCriteria(Criteria query, String alias) {
		Criteria resultado = null;
		Criteria principal = getCriteriaPrincipal(query);

		Iterator<Criteria> i = ((CriteriaImpl) principal).iterateSubcriteria();
		while (i.hasNext() && !isReferencia(resultado)) {
			Criteria criteria = i.next();
			if (UtilString.isStringsIguais(criteria.getAlias(), alias)) {
				resultado = criteria;
			}
		}
		return resultado;
	}

	/**
	 * Registra a ação de alteração. A ação é registrada no HibernateHolder.
	 * 
	 * @see HibernateHolder
	 */
	protected void registrarAcaoDeAlteracao() {
		HibernateHolder.setAcaoDeAlteracao();
	}

	/**
	 * Registra a ação de consulta. A ação é registrada no HibernateHolder.
	 * 
	 * @see HibernateHolder
	 */
	protected void registrarAcaoDeConsulta() {
		HibernateHolder.setAcaoDeConsulta();
	}

	/**
	 * Registra a ação de exclusão. A ação é registrada no HibernateHolder.
	 * 
	 * @see HibernateHolder
	 */
	protected void registrarAcaoDeExclusao() {
		HibernateHolder.setAcaoDeExclusao();
	}

	/**
	 * Registra a ação de inclusão. A ação é registrada no HibernateHolder.
	 * 
	 * @see HibernateHolder
	 */
	protected void registrarAcaoDeInclusao() {
		HibernateHolder.setAcaoDeInclusao();
	}
}
