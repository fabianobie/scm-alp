/*
 * ExporterExemplo.java
 * 
 * Data de criação: 13/02/2009
 */
package br.com.ap.gerador;

import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.POJOExporter;

/**
 * Responsável pela disponibilização das informações usadas pelos templates
 * freemarker.
 * 
 * @author adrianop
 */
public class GeradorExporter extends POJOExporter {

	@Override
	public Cfg2JavaTool getCfg2JavaTool() {
		return new GeradorCfg2JavaTool();
	}
}