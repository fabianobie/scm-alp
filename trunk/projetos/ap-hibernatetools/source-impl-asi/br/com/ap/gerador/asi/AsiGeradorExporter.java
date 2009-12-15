/*
 * AsiGeradorExporter.java
 * 
 * Data de cria��o: 13/02/2009
 */
package br.com.ap.gerador.asi;

import org.hibernate.tool.hbm2x.Cfg2JavaTool;

import br.com.ap.gerador.GeradorExporter;

/**
 * Respons�vel pela disponibiliza��o das informa��es usadas pelos templates
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