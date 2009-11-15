/*
 * UtilArquivo.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;

import br.com.ap.comum.constante.CaracterEspecial;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe responsável pelo tratamento de arquivos.
 *
 * @author adrianop
 */
public final class UtilArquivo {

	/**
	 * Construtor.
	 */
	private UtilArquivo() {
		// Construtor.
	}

	/**
	 * Fecha um stream.
	 * 
	 * @param stream Stream que será fechado.
	 * @return outputstream nulo
	 */
	public static OutputStream fechar(OutputStream stream) {
		if (isReferencia(stream)) {
			try {
				stream.flush();
				stream.close();
			} catch (IOException e) {
				getLog().warn("Não foi possível fechar o stream", e);
			} finally {
				stream = null;
			}
		}
		return stream;
	}

	/**
	 * Fecha um stream.
	 * 
	 * @param stream Stream que será fechado.
	 * @return inputstream nulo
	 */
	public static InputStream fechar(InputStream stream) {
		if (isReferencia(stream)) {
			try {
				stream.close();
			} catch (IOException e) {
				getLog().warn("Não foi possível fechar o stream", e);
			} finally {
				stream = null;
			}
		}
		return stream;
	}

	/**
	 * Fecha um reader.
	 * 
	 * @param reader Reader que será fechado.
	 * @return reader nulo
	 */
	public static Reader fechar(Reader reader) {
		if (isReferencia(reader)) {
			try {
				reader.close();
			} catch (IOException e) {
				getLog().warn("Não foi possível fechar o reader", e);
			} finally {
				reader = null;
			}
		}
		return reader;
	}

	/**
	 * Fecha um writer.
	 * 
	 * @param writer Writer que será fechado.
	 * @return writer nulo
	 */
	public static Writer fechar(Writer writer) {
		if (isReferencia(writer)) {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				getLog().warn("Não foi possível fechar o writer", e);
			} finally {
				writer = null;
			}
		}
		return writer;
	}

	/**
	 * Retorna uma coleção de objetos do tipo File do path passado por
	 * parâmetro. O path deverá ser uma pasta do sistema.
	 * 
	 * @param path Path da pasta.
	 * @return Coleção de objetos do tipo java.io.File
	 */
	public static Collection<File> getColecaoDeFile(String path) {
		return getColecaoDeFile(path, null);
	}

	/**
	 * Retorna uma coleção de objetos do tipo File do path passado por
	 * parâmetro. O path deverá ser uma pasta do sistema.
	 * 
	 * @param path Path da pasta.
	 * @param filtro Filtro usado na recuperação dos arquivos.
	 * @return Coleção de objetos do tipo java.io.File
	 */
	public static Collection<File> getColecaoDeFile(String path,
			FilenameFilter filtro) {
		Collection<File> res = getColecaoFactory().novoArrayList();

		if (isPasta(path)) {
			File pasta = getArquivoFactory().novoFile(path);
			File[] arquivos = pasta.listFiles(filtro);
			res.addAll(Arrays.asList(arquivos));
		}

		return res;
	}

	/**
	 * Retorna a coleção de todos os arquivos do path passado como parâmetro,
	 * inclusive os arquivos das subpastas.
	 * 
	 * @param path Path
	 * @return coleção de todos os arquivos do path.
	 */
	public static Collection<File> getColecaoDeFileRecursivo(String path) {
		return getColecaoDeFileRecursivo(path, null);
	}

	/**
	 * Retorna a coleção de todos os arquivos do path passado como parâmetro,
	 * inclusive os arquivos das subpastas.
	 * 
	 * @param path Path
	 * @param filtro Filtro usado na recuperação dos arquivos.
	 * @return coleção de todos os arquivos do path.
	 */
	public static Collection<File> getColecaoDeFileRecursivo(String path,
			FilenameFilter filtro) {
		Collection<File> res = getColecaoFactory().novoArrayList();

		if (!isVazio(path)) {
			File file = getArquivoFactory().novoFile(path);

			if (isPasta(file)) {
				File[] arquivos = file.listFiles(filtro);
				for (File arquivo : arquivos) {
					String caminho = arquivo.getAbsolutePath();
					Collection<File> colecao = getColecaoDeFileRecursivo(
							caminho, filtro);
					res.addAll(colecao);
				}
			} else {
				res.add(file);
			}
		}

		return res;
	}

	/**
	 * Retorna uma coleção de objetos do tipo File do path passado por
	 * parâmetro. O path deverá ser uma pasta do sistema.
	 * 
	 * @param path Path da pasta.
	 * @return Coleção de objetos do tipo java.io.File
	 */
	public static Collection<InputStream> getColecaoDeInputStream(String path) {
		Collection<InputStream> res = getColecaoFactory().novoArrayList();
		Collection<File> arquivos = getColecaoDeFile(path);

		for (File arquivo : arquivos) {
			res.add(getArquivoFactory().novoFileInputStream(arquivo));
		}
		return res;
	}

	/**
	 * Retorna o texto do inputstream passado por parâmetro.
	 * 
	 * @param inputStream InputStream
	 * @return Texto do arquivo.
	 */
	public static String getTextoDoInputStream(InputStream inputStream) {
		String texto = getStringFactory().novaString();

		if (isReferencia(inputStream)) {
			BufferedReader br = getArquivoFactory().novoBufferedReader(inputStream);
			texto = getTextoDoArquivo(br, true);
		}
		return texto;
	}
	
	/**
	 * Retorna o texto do arquivo passado por parâmetro.
	 * 
	 * @param path Arquivo
	 * @return Texto do arquivo.
	 */
	public static String getTextoDoArquivo(String path) {
		String texto = getStringFactory().novaString();

		if (!isVazio(path)) {
			BufferedReader br = getArquivoFactory().novoBufferedReader(path);
			texto = getTextoDoArquivo(br, true);
		}
		return texto;
	}

	/**
	 * Retorna o texto do arquivo passado por parâmetro.
	 * 
	 * @param arquivo Arquivo
	 * @return Texto do arquivo.
	 */
	public static String getTextoDoArquivo(File arquivo) {
		String texto = getStringFactory().novaString();

		if (isReferencia(arquivo)) {
			BufferedReader br = getArquivoFactory()
					.novoBufferedReader(arquivo);
			texto = getTextoDoArquivo(br, true);
		}
		return texto;
	}

	/**
	 * Retorna o texto do arquivo passado por parâmetro.
	 * 
	 * @param reader StringBuffered do arquivo
	 * @param fechar Booleano que indica se o reader será fechado. (true = fecha
	 *            o reader)
	 * @return Texto do arquivo.
	 */
	public static String getTextoDoArquivo(BufferedReader reader,
			boolean fechar) {
		StringBuilder builder = getStringFactory().novoStringBuilder();

		if (isReferencia(reader)) {
			String quebra = CaracterEspecial.getQuebraComRetornoDeCarro();
			String linha = null;
			try {
				while (isReferencia(linha = reader.readLine())) {
					builder.append(linha).append(quebra);
				}
			} catch (IOException e) {
				getLog().warn("Erro ao ler o texto do reader.");
			} finally {
				if (fechar) {
					fechar(reader);
				}
			}
		}
		return builder.toString();
	}

	/**
	 * Retorna true se o arquivo existe.
	 * 
	 * @param arquivo Arquivo validado
	 * @return true se o arquivo existe.
	 */
	public static boolean isExiste(File arquivo) {
		return (isReferencia(arquivo) && arquivo.exists());
	}

	/**
	 * Retorna true se o arquivo for uma pasta.
	 * 
	 * @param path Path do arquivo que será validado.
	 * @return true se o arquivo for uma pasta.
	 */
	public static boolean isPasta(String path) {
		boolean resultado = false;

		if (!isVazio(path)) {
			File file = getArquivoFactory().novoFile(path);
			resultado = file.isDirectory();
		}
		return resultado;
	}

	/**
	 * Retorna true se o arquivo for uma pasta.
	 * 
	 * @param arquivo Arquivo que será validado.
	 * @return true se o arquivo for uma pasta.
	 */
	public static boolean isPasta(File arquivo) {
		return (isReferencia(arquivo) && arquivo.isDirectory());
	}

	/**
	 * Retorna true se o arquivo for um arquivo.
	 * 
	 * @param path Path do arquivo que será validado.
	 * @return true se o arquivo for um arquivo.
	 */
	public static boolean isArquivo(String path) {
		boolean resultado = false;

		if (!isVazio(path)) {
			File file = getArquivoFactory().novoFile(path);
			resultado = file.isFile();
		}
		return resultado;
	}

	/**
	 * Retorna true se o arquivo for um arquivo.
	 * 
	 * @param arquivo Arquivo que será validado.
	 * @return true se o arquivo for um arquivo.
	 */
	public static boolean isArquivo(File arquivo) {
		return (isReferencia(arquivo) && arquivo.isFile());
	}

	/**
	 * Retorna fábrica de IO.
	 * 
	 * @return fábrica de objetos IO
	 */
	private static ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * @return fábrica de string.
	 */
	private static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Verifica se o objeto tem referência.
	 * 
	 * @param obj objeto a ser verificado.
	 * @return true se o objeto tiver uma referência.
	 */
	private static boolean isReferencia(Object obj) {
		return UtilObjeto.isReferencia(obj);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String a ser validada.
	 * @return true se a string for vazia.
	 */
	private static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}
}
