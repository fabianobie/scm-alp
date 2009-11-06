/*
 * UtilCarregarMapaDeArquivos.java
 * 
 * Data de criação: 27/04/2007
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * Classe utilitária responsável em carregar o texto de todos os arquivos de uma
 * pasta definida.<br>
 * O mapa é composto pelo nome do arquivo como chave e o texto do arquivo como
 * valor da chave do mapa.<br>
 * 
 * @author adrianop
 */
public class UtilCarregarMapaDeArquivos extends
		UtilCarregarMapaAbstrato<String, String, String> {

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#getMapa(java.lang.Object)
	 */
	@Override
	public Map<String, String> getMapa(String origem) {

		Map<String, String> mapa = getColecaoFactory().novoHashMap();

		if (!isVazio(origem)) {
			Collection<File> colecao = getColecaoDeFile(origem);

			for (File arquivo : colecao) {
				if (UtilArquivo.isArquivo(arquivo)) {
					String texto = getTextoDoArquivo(arquivo);
					mapa.put(getNomeArquivo(arquivo), texto);
				}
			}
		}

		return mapa;
	}

	/**
	 * Retorna o nome do arquivo.
	 * 
	 * @param arquivo
	 *            File
	 * @return Nome do arquivo
	 */
	private String getNomeArquivo(File arquivo) {
		return arquivo.getName();
	}

	/**
	 * Retorna o texto do arquivo.
	 * 
	 * @param arquivo
	 *            File
	 * @return String do conteúdo do arquivo.
	 */
	private String getTextoDoArquivo(File arquivo) {
		return UtilArquivo.getTextoDoArquivo(arquivo);
	}

	/**
	 * Retorna os arquivos SQL da pasta onde os mesmo estão locados.
	 * 
	 * @param pathDaPasta
	 *            Path da pasta
	 * @return Coleção de objetos do tipo java.io.File
	 */
	private Collection<File> getColecaoDeFile(String pathDaPasta) {
		return UtilArquivo.getColecaoDeFile(pathDaPasta);
	}
}
