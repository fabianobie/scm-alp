/*
 * GeradorReverseEngineeringStrategy.java
 * 
 * Data de cria��o: 13/02/2009
 */
package br.com.ap.gerador;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringSettings;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import br.com.ap.comum.objeto.UtilPrimitivo;

/**
 * Respons�vel pela parametriza��o da engenharia reversa das tabelas do banco de
 * dados.
 * 
 * @author adrianop
 */
public class GeradorReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

	/**
	 * @param delegate Strategy
	 */
	public GeradorReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
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
	public String columnToHibernateTypeName(TableIdentifier table, String columnName, int sqlType,
			int length, int precision, int scale, boolean nullable, boolean generatedIdentifier) {
		String tipo = super.columnToHibernateTypeName(table, columnName, sqlType, length,
				precision, scale, nullable, generatedIdentifier);
		if (UtilPrimitivo.isPrimitivo(tipo)) {
			tipo = UtilPrimitivo.getNomeDaClasseDoWrapper(tipo);
		}
		return tipo;
	}
}
