/*
 * UtilEstrategiaDeFormatadores.java
 * 
 * Data de criação: 30/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.estrategia;

import java.util.Map;
import java.util.Properties;

import br.com.ap.comum.arquivo.UtilCarregarMapaDeObjetos;
import br.com.ap.comum.constante.Arquivo;
import br.com.ap.comum.fabrica.FormatadorFactory;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe utilitária que implementa o mapeamento e solicitação de estratégia de
 * conversores.
 * 
 * @author adrianop
 */
public final class UtilEstrategiaDeFormatadores extends
		UtilEstrategiaAbstrata<String, IFormatador<?>> {

	private static UtilEstrategiaDeFormatadores	instancia	= new UtilEstrategiaDeFormatadores();

	/**
	 * Construtor.
	 */
	private UtilEstrategiaDeFormatadores() {
		// Construtor.
	}

	/**
	 * @return instância da classe.
	 */
	public static UtilEstrategiaDeFormatadores getInstancia() {
		return instancia;
	}

	/**
	 * Retorna true se a chave da estratégia existir.
	 * 
	 * @param chave Chave da estratégia
	 * @return true se a chave da estratégia existir.
	 */
	public boolean isExiste(Class<?> chave) {
		String string = UtilObjeto.getNome(chave);
		return isExiste(string);
	}

	/**
	 * Retorna estratégia solicitada.
	 * 
	 * @param chave Class da Chave da estratégia.
	 * @return estratégia solicitada.
	 */
	public IFormatador<?> recuperar(Class<?> chave) {
		String string = UtilObjeto.getNome(chave);
		return recuperar(string);
	}

	/**
	 * @see br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#carregarDadosDaEstrategia()
	 */
	@Override
	protected Map<String, IFormatador<?>> carregarDadosDaEstrategia() {
		String arquivo = Arquivo.getPathFormatadoresPadraoProperties();
		Properties properties = getArquivoFactory().novoProperties(arquivo);

		return novoUtilCarregarMapaDeObjetos().getMapa(properties);
	}

	/**
	 * @see br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#getEstrategiaPadrao()
	 */
	@Override
	protected IFormatador<?> getEstrategiaPadrao() {
		return getFormatadorFactory().novoFormatadorDeString();
	}

	/**
	 * @return novo UtilCarregarMapaDeObjetos
	 */
	private UtilCarregarMapaDeObjetos<IFormatador<?>> novoUtilCarregarMapaDeObjetos() {
		return new UtilCarregarMapaDeObjetos<IFormatador<?>>();
	}

	/**
	 * @return fábrica de formatadores.
	 */
	private FormatadorFactory getFormatadorFactory() {
		return FormatadorFactory.getInstancia();
	}
}
