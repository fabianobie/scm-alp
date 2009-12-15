/*
 * AsiGeradorExporter.java
 * 
 * Data de criação: 13/02/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.tool.hbm2x.Cfg2JavaTool;

import br.com.ap.gerador.GeradorExporter;

/**
 * Responsável pela disponibilização das informações usadas pelos templates
 * freemarker.
 * 
 * @author adrianop
 */
public class AsiGeradorExporter extends GeradorExporter {

	@Override
	public Cfg2JavaTool getCfg2JavaTool() {
		return new AsiGeradorCfg2JavaTool();
	}
}