/*
 * AsiGeradorReverseEngineeringStrategy.java
 * 
 * Data de criação: 13/02/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.cfg.reveng.ReverseEngineeringSettings;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import br.com.ap.comum.objeto.UtilPrimitivo;
import br.com.ap.gerador.GeradorReverseEngineeringStrategy;
import br.com.ap.gerador.asi.util.UtilAtributoDominio;

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
	
//	@Override
//	public String columnToPropertyName(TableIdentifier table, String column) {
//		String property = super.columnToPropertyName(table, column);
//		return UtilAtributoDominio.nomear(table, property);
//	}
	public String columnToPropertyName(TableIdentifier table, String columnName) {
		columnName = super.columnToPropertyName(table, columnName);
		return UtilAtributoDominio.nomear(table, columnName);
	}
	
	@Override
	public String columnToHibernateTypeName(TableIdentifier table, String columnName, int sqlType, int length, int precision, int scale, boolean nullable, boolean generatedIdentifier) {
		String tipo = super.columnToHibernateTypeName(table, columnName, sqlType, length, precision, scale, nullable, generatedIdentifier);
		if (UtilPrimitivo.isPrimitivo(tipo)) {
			tipo = UtilPrimitivo.getNomeDaClasseDoWrapper(tipo);
		}
		return tipo;
	}
}
