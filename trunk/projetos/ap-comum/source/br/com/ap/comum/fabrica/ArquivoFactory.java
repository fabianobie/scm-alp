/*
 * ArquivoFactory.java
 * 
 * Data de criação: 04/04/2008
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Properties;

import br.com.ap.comum.arquivo.UtilArquivo;

/**
 * Fábrica de objetos IO.
 * 
 * @author adrianop
 */
public final class ArquivoFactory extends FactoryAbstrata {

	private static ArquivoFactory	instancia	= new ArquivoFactory();

	/**
	 * Construtor.
	 */
	private ArquivoFactory() {
		// Construtor.
	}

	/**
	 * @return instância da classe.
	 */
	public static ArquivoFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo BufferedInputStream.
	 * 
	 * @param is InputStream adicionado ao buffered.
	 * @return novo BufferedInputStream
	 */
	public InputStream novoBufferedInputStream(InputStream is) {
		return new BufferedInputStream(is);
	}

	/**
	 * Retorna novo BufferedOutputStream.
	 * 
	 * @param os OutputStream adicionado ao buffered
	 * @return novo BufferedOutputStream
	 */
	public OutputStream novoBufferedOutputStream(OutputStream os) {
		return new BufferedOutputStream(os);
	}

	/**
	 * Retorna novo BufferedReader.
	 * 
	 * @param arquivo Arquivo que será usado para criar o reader
	 * @return novo BufferedReader
	 */
	public BufferedReader novoBufferedReader(File arquivo) {
		BufferedReader resultado = null;
		if (UtilArquivo.isExiste(arquivo)) {
			Reader reader = novoFileReader(arquivo);
			resultado = novoBufferedReader(reader);
		}
		return resultado;
	}

	/**
	 * Retorna novo BufferedReader.
	 * 
	 * @param is InputStream
	 * @return novo BufferedReader
	 */
	public BufferedReader novoBufferedReader(InputStream is) {
		BufferedReader resultado = null;
		if (isReferencia(is)) {
			Reader reader = novoInputStreamReader(is);
			resultado = novoBufferedReader(reader);
		}
		return resultado;
	}

	/**
	 * Retorna novo BufferedReader.
	 * 
	 * @param reader Reader
	 * @return novo BufferedReader
	 */
	public BufferedReader novoBufferedReader(Reader reader) {
		BufferedReader resultado = null;
		if (isReferencia(reader)) {
			resultado = new BufferedReader(reader);
		}
		return resultado;
	}

	/**
	 * Retorna novo BufferedWriter.
	 * 
	 * @param writer Writer que será passado para o buffered
	 * @return novo BufferedWriter
	 */
	public Writer novoBufferedWriter(Writer writer) {
		return new BufferedWriter(writer);
	}

	/**
	 * Retorna novo ByteArrayInputStream.
	 * 
	 * @param bytes Array de bytes.
	 * @return novo ByteArrayInputStream
	 */
	public InputStream novoByteArrayInputStream(byte[] bytes) {
		return new ByteArrayInputStream(bytes);
	}

	/**
	 * Retorna novo ByteArrayOutputStream.
	 * 
	 * @return novo ByteArrayOutputStream
	 */
	public OutputStream novoByteArrayOutputStream() {
		return new ByteArrayOutputStream();
	}

	/**
	 * Retorna novo ByteArrayOutputStream.
	 * 
	 * @param tamanho Tamanho inicial
	 * @return novo ByteArrayOutputStream
	 */
	public OutputStream novoByteArrayOutputStream(int tamanho) {
		return new ByteArrayOutputStream(tamanho);
	}

	/**
	 * Retorna novo CharArrayReader.
	 * 
	 * @param chars Array de char.
	 * @return novo CharArrayReader
	 */
	public Reader novoCharArrayReader(char[] chars) {
		return new CharArrayReader(chars);
	}

	/**
	 * Retorna novo CharArrayWriter.
	 * 
	 * @return novo CharArrayWriter
	 */
	public Writer novoCharArrayWriter() {
		return new CharArrayWriter();
	}

	/**
	 * Retorna novo CharArrayWriter.
	 * 
	 * @param tamanho Tamanho inicial
	 * @return novo CharArrayWriter
	 */
	public Writer novoCharArrayWriter(int tamanho) {
		return new CharArrayWriter(tamanho);
	}

	/**
	 * Retorna novo DataInputStream.
	 * 
	 * @param is InputStream
	 * @return novo DataInputStream
	 */
	public InputStream novoDataInputStream(InputStream is) {
		return new DataInputStream(is);
	}

	/**
	 * Retorna novo DataOutputStream.
	 * 
	 * @param os OutputStream
	 * @return novo DataOutputStream
	 */
	public OutputStream novoDataOutputStream(OutputStream os) {
		return new DataOutputStream(os);
	}

	/**
	 * Retorna novo FileDescriptor.
	 * 
	 * @return novo FileDescriptor
	 */
	public FileDescriptor novoFileDescriptor() {
		return new FileDescriptor();
	}

	/**
	 * Retorna o FileInputStream do path passado por parâmetro.
	 * 
	 * @param path Path do arquivo.
	 * @return FileInputStream do path.
	 */
	public InputStream novoFileInputStream(String path) {
		FileInputStream fis = null;

		if (!isVazio(path)) {
			try {
				fis = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				getLog().warn("Arquivo não encontrado, path: "+ path);
			}
		}
		return fis;
	}

	/**
	 * Retorna o FileInputStream do path passado por parâmetro.
	 * 
	 * @param arquivo Arquivo.
	 * @return FileInputStream do path.
	 */
	public InputStream novoFileInputStream(File arquivo) {
		FileInputStream fis = null;

		if (isReferencia(arquivo)) {
			try {
				fis = new FileInputStream(arquivo);
			} catch (FileNotFoundException e) {
				String path = arquivo.getAbsolutePath();
				getLog().warn(
						"Arquivo '" + path
								+ "' não encontrado na estrutura de pastas.");
			}
		}
		return fis;
	}

	/**
	 * Retorna novo FileOutputStream.
	 * 
	 * @param arquivo Arquivo que será gerado.
	 * @return novo FileOutputStream
	 */
	public OutputStream novoFileOutputStream(File arquivo) {
		OutputStream fos = null;
		if (isReferencia(arquivo)) {
			try {
				fos = new FileOutputStream(arquivo);
			} catch (FileNotFoundException e) {
				String path = arquivo.getAbsolutePath();
				getLog().warn(
						"Arquivo '" + path
								+ "' não encontrado na estrutura de pastas.");
			}
		}
		return fos;
	}

	/**
	 * Retorna novo FileOutputStream.
	 * 
	 * @param path Path do arquivo que será gerado.
	 * @return novo FileOutputStream
	 */
	public OutputStream novoFileOutputStream(String path) {
		OutputStream fos = null;
		if (!isVazio(path)) {
			try {
				fos = new FileOutputStream(path);
			} catch (FileNotFoundException e) {
				getLog().warn(
						"Arquivo '" + path
								+ "' não encontrado na estrutura de pastas.");
			}
		}
		return fos;
	}

	/**
	 * Retorna novo FilePermission.
	 * 
	 * @param path Path do arquivo que será gerado.
	 * @param permissao Permissão do arquivo.
	 * @return novo FilePermission
	 */
	public FilePermission novoFilePermission(String path, String permissao) {
		return new FilePermission(path, permissao);
	}

	/**
	 * Retorna novo FileReader.
	 * 
	 * @param path Path do arquivo
	 * @return novo FileReader
	 */
	public Reader novoFileReader(String path) {
		File arquivo = novoFile(path);
		return novoFileReader(arquivo);
	}

	/**
	 * Retorna novo FileReader.
	 * 
	 * @param arquivo Arquivo
	 * @return novo FileReader
	 */
	public Reader novoFileReader(File arquivo) {
		Reader reader = null;
		try {
			reader = new FileReader(arquivo);
		} catch (FileNotFoundException e) {
			String path = arquivo.getAbsolutePath();
			getLog().warn(
					"Arquivo '" + path
							+ "' não encontrado na estrutura de pastas.");
		}
		return reader;
	}

	/**
	 * Retorna novo FileWriter.
	 * 
	 * @param arquivo Arquivo
	 * @return novo FileWriter
	 */
	public Writer novoFileWriter(File arquivo) {
		Writer writer = null;
		try {
			writer = new FileWriter(arquivo);
		} catch (IOException e) {
			String path = arquivo.getAbsolutePath();
			getLog().warn(
					"Arquivo '" + path
							+ "' não encontrado na estrutura de pastas.");
		}
		return writer;
	}

	/**
	 * Retorna novo StringReader.
	 * 
	 * @param string String
	 * @return novo StringReader
	 */
	public Reader novoStringReader(String string) {
		return new StringReader(string);
	}

	/**
	 * Retorna novo StringWriter.
	 * 
	 * @return novo StringWriter
	 */
	public Writer novoStringWriter() {
		return new StringWriter();
	}

	/**
	 * Novo File.
	 * 
	 * @param path Path do arquivo.
	 * @return novo file.
	 */
	public File novoFile(String path) {
		return new File(path);
	}

	/**
	 * Novo File.
	 * 
	 * @param uri URI do arquivo.
	 * @return novo file.
	 */
	public File novoFile(URI uri) {
		return new File(uri);
	}

	/**
	 * Retorna o Properties do path passado por parâmetro.
	 * 
	 * @param path path do arquivo de propriedades.
	 * @return properties.
	 */
	public Properties novoProperties(String path) {
		Properties properties = novoProperties();

		if (!isVazio(path)) {
			try {
				InputStream is = novoInputStream(path);
				if (isReferencia(is)) {
					properties.load(is);
				} else {
					getLog().warn("Properties '" + path + "' inexistente.");
				}
			} catch (IOException e) {
				getLog().warn("Erro ao criar o Properties do arquivo " + path);
			}
		}
		return properties;
	}

	/**
	 * Novo Properties.
	 * 
	 * @param is InputStream do arquivo que será usado para carregar o
	 *            properties.
	 * @return novo properties.
	 */
	public Properties novoProperties(InputStream is) {
		Properties properties = novoProperties();

		if (isReferencia(is)) {
			try {
				properties.load(is);
			} catch (IOException e) {
				getLog().warn("Erro ao ler Properties do InputStream.", e);
			}
		}
		return properties;
	}

	/**
	 * Novo Properties.
	 * 
	 * @return novo properties.
	 */
	public Properties novoProperties() {
		return new Properties();
	}

	/**
	 * Retorna o InputStream do arquivo passado por parâmetro.
	 * 
	 * @param path path do arquivo.
	 * @return InputStream do arquivo passado por parâmetro
	 */
	public InputStream novoInputStream(String path) {
		InputStream is = null;

		if (!isVazio(path)) {
			is = novoFileInputStream(path);
			is = novoInputStreamDoClassLoader(is, path);
			is = novoInputStreamDaClasse(is, path);
			if (isReferencia(is)) {
				getLog().warn("Arquivo '" + path + "' encontrado.");
			} else {
				getLog().warn("Arquivo '" + path + "' não encontrado.");
			}
		}

		return is;
	}

	/**
	 * Retorna novo InputStreamReader.
	 * 
	 * @param is InputStream
	 * @return novo InputStreamReader
	 */
	public Reader novoInputStreamReader(InputStream is) {
		Reader resultado = null;
		if (isReferencia(is)) {
			resultado = new InputStreamReader(is);
		}
		return resultado;
	}

	/**
	 * Retorna novo BufferedReader.
	 * 
	 * @param path Path do arquivo
	 * @return novo BufferedReader
	 */
	public BufferedReader novoBufferedReader(String path) {
		BufferedReader resultado = null;
		if (!isVazio(path)) {
			InputStream is = novoInputStream(path);
			resultado = novoBufferedReader(is);
		}
		return resultado;
	}

	/**
	 * Retorna o InputStream do path passado por parâmetro, o InputStream será
	 * recuperado do class dessa classe.
	 * 
	 * @param inputStream InputStream validado.
	 * @param path path do arquivo.
	 * @return InputStream
	 */
	private InputStream novoInputStreamDaClasse(InputStream inputStream,
			String path) {
		if (!isReferencia(inputStream)) {
			inputStream = ArquivoFactory.class.getResourceAsStream(path);
		}
		return inputStream;
	}

	/**
	 * Retorna InputStream do path passado por parâmetro, o InputStream será
	 * recuperado do classloader atual.
	 * 
	 * @param inputStream InputStream validado
	 * @param path path do arquivo.
	 * @return InputStream do path passado por parâmetro.
	 */
	private InputStream novoInputStreamDoClassLoader(InputStream inputStream,
			String path) {
		if (!isReferencia(inputStream)) {
			inputStream = getClassLoader().getResourceAsStream(path);
		}
		return inputStream;
	}

	/**
	 * Retorna ClassLoader usado para recupera os arquivos.
	 * 
	 * @return ClassLoader usado para recupera os arquivos
	 */
	private ClassLoader getClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (!isReferencia(cl)) {
			cl = getClass().getClassLoader();
		}
		return cl;
	}
}
