/*
 * TesteAbstrato.java
 * 
 * Data de criação: Jul 1, 2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate;

import java.io.File;
import java.util.Properties;

import junit.framework.TestCase;

import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import br.com.ap.arquitetura.dao.DAO;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.ConversorFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.FormatadorFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.hibernate.holder.HibernateHolder;
import br.com.ap.hibernate.interceptor.ExemploAuditoriaInterceptor;

/**
 * Classe que implementa os recursos necessários aos testes.
 * 
 * @author adrianop
 */
public abstract class TesteAbstrato extends TestCase {

	/**
	 * Session factory
	 */
	private static SessionFactory sessionFactory;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		SessionFactory sf = getSessionFactory();
		Session sessao = getSessionFactory().openSession();
		sessao.beginTransaction();

		SessionHolder sh = novoSessionHolder(sessao);
		TransactionSynchronizationManager.bindResource(sf, sh);

		HibernateHolder.setSessionFactory(sf);
		HibernateHolder.setSession(sessao);
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		SessionFactory sf = getSessionFactory();
		SessionHolder sh = getSessionHolder();
		Session sessao = sh.getSession();
		sessao.flush();

		Transaction t = sessao.getTransaction();
		t.commit();
		TransactionSynchronizationManager.unbindResource(sf);
		SessionFactoryUtils.releaseSession(sessao, sf);

		HibernateHolder.reinicializar();
	}

	/**
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		getSessionFactory().close();
		sessionFactory = null;

		super.finalize();
	}

	/**
	 * Retorna nova DAO.
	 * 
	 * @param <T> Tipo da Entidade da DAO.
	 * @param classe Tipo da DAO
	 * @return nova teste.dao
	 */
	@SuppressWarnings("unchecked")
	protected <T extends DAO<?>> T novaDAO(Class<?> classe) {
		T dao = null;
		try {
			dao = (T) classe.newInstance();
			((HibernateCrudDaoAbstrato<?>) dao)
			        .setSessionFactory(getSessionFactory());
		} catch (Exception e) {
			assertNull(e);
		}

		return dao;
	}

	/**
	 * @return Retorna sessionFactory
	 */
	protected static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = novoSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * Retorna o session holder da transação
	 * 
	 * @return session holder atual
	 */
	protected SessionHolder getSessionHolder() {
		SessionFactory sf = getSessionFactory();
		return (SessionHolder) TransactionSynchronizationManager
		        .getResource(sf);
	}

	/**
	 * Retorna novo session holder.
	 * 
	 * @param sessao Sessão
	 * @return novo session holder.
	 */
	protected SessionHolder novoSessionHolder(Session sessao) {
		return new SessionHolder(sessao);
	}

	/**
	 * @return novo session factory
	 */
	protected static SessionFactory novoSessionFactory() {
		AnnotationConfiguration annotationCfg = new AnnotationConfiguration();
		Configuration cfg = annotationCfg.configure();
		Interceptor interceptor = novoInterceptor();
		if (interceptor != null) {
			cfg.setInterceptor(interceptor);
		}
		return cfg.buildSessionFactory();
	}

	/**
	 * @return AuditoriaInterceptor
	 */
	protected static Interceptor novoInterceptor() {
		return new ExemploAuditoriaInterceptor();
	}

	/**
	 * @param arquivo nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected File novoFile(String arquivo) {
		return getArquivoFactory().novoFile(getPath(arquivo));
	}

	/**
	 * @param arquivo nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected Properties novoProperties(String arquivo) {
		return getArquivoFactory().novoProperties(getPath(arquivo));
	}

	/**
	 * @param nome Nome do arquivo.
	 * @return path do arquivo
	 */
	protected String getPath(String nome) {
		return this.getClass().getResource(nome).getPath();
	}

	/**
	 * @return fábrica de IO
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return fábrica de string
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Retorna novo ColecaoFactory.
	 * 
	 * @return novo ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo NumeroFactory.
	 * 
	 * @return novo NumeroFactory
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna novo DataFactory.
	 * 
	 * @return novo DataFactory
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna nova fábrica de conversores.
	 * 
	 * @return nova fábrica de conversores
	 */
	protected ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}

	/**
	 * Retorna nova fábrica de formatadores.
	 * 
	 * @return nova fábrica de formatadores
	 */
	protected FormatadorFactory getFormatadorFactory() {
		return FormatadorFactory.getInstancia();
	}
}
