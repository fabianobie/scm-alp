/**
 * MembershipDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import org.jbpm.pvm.internal.identity.impl.MembershipImpl;

import br.com.ap.arquitetura.dao.CrudDao;

/**
 * DAO de acesso às informação do Membership.
 * 
 * @author adriano.pamplona
 */
public interface MembershipDao extends CrudDao<MembershipImpl> {
	// interface
}
