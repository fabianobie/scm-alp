/*
 * UtilEstrategiaDeConversores.java
 * 
 * Data de cria��o: 30/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.estrategia;

import java.util.Map;
import java.util.Properties;

import br.com.ap.comum.arquivo.UtilCarregarMapaDeObjetos;
import br.com.ap.comum.constante.Arquivo;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.fabrica.ConversorFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe utilit�ria que implementa o mapeamento e solicita��o de estrat�gia de
 * conversores.
 * 
 * @author adrianop
 */
public final class UtilEstrategiaDeConversores extends
		UtilEstrategiaAbstrata<String, IConversor<?, ?>> {

	private static UtilEstrategiaDeConversores	instancia	= new UtilEstrategiaDeConversores();

	/**
	 * Construtor.
	 */
	private UtilEstrategiaDeConversores() {
		// Construtor.
	}

	/**
	 * @return inst�ncia da classe.
	 */
	public static UtilEstrategiaDeConversores getInstancia() {
		return instancia;
	}

	/**
	 * Retorna true se a chave da estrat�gia existir.
	 * 
	 * @param chave Chave da estrat�gia
	 * @return true se a chave da estrat�gia existir.
	 */
	public boolean isExiste(Class<?> chave) {
		String string = UtilObjeto.getNome(chave);
		return isExiste(string);
	}

	/**
	 * Retorna a estrat�gia solicitada.
	 * 
	 * @param chave Chave da estrat�gia que deseja recuperar.
	 * @return estrat�gia solicitada.
	 */
	public IConversor<?, ?> recuperar(Class<?> chave) {
		String string = UtilObjeto.getNome(chave);
		return recuperar(string);
	}

	/**
	 * @see br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#carregarDadosDaEstrategia()
	 */
	@Override
	protected Map<String, IConversor<?, ?>> carregarDadosDaEstrategia() {
		String arquivo = Arquivo.getPathConversoresPadraoProperties();
		Properties properties = getArquivoFactory().novoProperties(arquivo);

		return novoUtilCarregarMapaDeObjetos().getMapa(properties);
	}

	/**
	 * @see br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#getEstrategiaPadrao()
	 */
	@Override
	protected IConversor<?, ?> getEstrategiaPadrao() {
		return getConversorFactory().novoConversorDeStringParaString();
	}

	/**
	 * @return novo UtilCarregarMapaDeObjetos
	 */
	private UtilCarregarMapaDeObjetos<IConversor<?, ?>> novoUtilCarregarMapaDeObjetos() {
		return new UtilCarregarMapaDeObjetos<IConversor<?, ?>>();
	}

	/**
	 * @return f�brica de conversores.
	 */
	private ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}
}
