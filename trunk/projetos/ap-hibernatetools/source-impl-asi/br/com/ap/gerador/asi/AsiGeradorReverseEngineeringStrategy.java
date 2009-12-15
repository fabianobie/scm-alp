/*
 * AsiGeradorReverseEngineeringStrategy.java
 * 
 * Data de criação: 13/02/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.cfg.reveng.ReverseEngineeringSettings;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import br.com.ap.gerador.GeradorReverseEngineeringStrategy;

/**
 * Responsável pela parametrização da engenharia reversa das tabelas do banco de
 * dados.
 * 
 * @author adrianop
 */
public class AsiGeradorReverseEngineeringStrategy extends
		GeradorReverseEngineeringStrategy {

	/**
	 * @param delegate Strategy
	 */
	public AsiGeradorReverseEngineeringStrategy(
			ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	/**
	 * @see org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy#setSettings(org.hibernate.cfg.reveng.ReverseEngineeringSettings)
	 */
	@Override
	public void setSettings(ReverseEngineeringSettings settings) {
		super.setSettings(settings);
	}

	@Override
	public String getTableIdentifierStrategyName(TableIdentifier tableIdentifier) {
		return "sequence";
	}

}
