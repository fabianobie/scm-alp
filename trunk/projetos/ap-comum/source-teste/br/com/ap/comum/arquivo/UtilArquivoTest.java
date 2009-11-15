/*
 * UtilArquivoTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilArquivo
 */
public class UtilArquivoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#fechar(java.io.OutputStream)}.
	 */
	@Test
	public final void testFechar_OutputStream() {
		OutputStream o = getOutputStreamDoArquivoTemp();
		o = UtilArquivo.fechar(o);
		o = UtilArquivo.fechar(o);

		assertNull(o);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#fechar(java.io.InputStream)}.
	 */
	@Test
	public final void testFechar_InputStream() {
		InputStream o = getArquivoFactory().novoFileInputStream(
				getArquivoTemp());
		o = UtilArquivo.fechar(o);
		o = UtilArquivo.fechar(o);
		
		assertNull(o);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#fechar(java.io.Reader)}.
	 */
	@Test
	public final void testFechar_Reader() {
		Reader r = getReaderDoArquivoTemp();
		r = UtilArquivo.fechar(r);
		r = UtilArquivo.fechar(r);

		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#fechar(java.io.Writer)}.
	 */
	@Test
	public final void testFechar_Writer() {
		Writer r = getWriterDoArquivoTemp();
		r = UtilArquivo.fechar(r);
		r = UtilArquivo.fechar(r);

		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getColecaoDeFile(java.lang.String)}.
	 */
	@Test
	public final void testGetColecaoDeFile() {
		String path = getPathAtual();

		Collection<File> arquivos = UtilArquivo.getColecaoDeFile(path);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() > 0);

		arquivos = UtilArquivo.getColecaoDeFile(null);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getColecaoDeFile(java.lang.String, java.io.FilenameFilter)}.
	 */
	@Test
	public final void testGetColecaoDeFile_StringFileNameFilter() {
		String path = getPathAtual();
		FilenameFilter filtro = novoFilenameFilterDeArquivosJava();

		Collection<File> arquivos = UtilArquivo.getColecaoDeFile(path, filtro);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() > 0);

		arquivos = UtilArquivo.getColecaoDeFile(null);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() == 0);
	}



	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getColecaoDeFileRecursivo(java.lang.String)}.
	 */
	@Test
	public final void testGetColecaoDeFileRecursivo() {
		String path = getPathAtual();
		path = UtilString.remover(path, "arquivo/");

		Collection<File> arquivos = UtilArquivo.getColecaoDeFileRecursivo(path);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() > 0);

		arquivos = UtilArquivo.getColecaoDeFileRecursivo(null);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getColecaoDeFileRecursivo(java.lang.String, java.io.FilenameFilter)}.
	 */
	@Test
	public final void testGetColecaoDeFileRecursivo_StringFilenameFilter() {
		String path = getPathAtual();
		path = UtilString.remover(path, "arquivo/");
		FilenameFilter filtro = novoFilenameFilterDeArquivosJava();
		
		Collection<File> arquivos = UtilArquivo.getColecaoDeFileRecursivo(path, filtro);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() > 0);
		
		arquivos = UtilArquivo.getColecaoDeFileRecursivo(null, filtro);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getColecaoDeInputStream(java.lang.String)}.
	 */
	@Test
	public final void testGetColecaoDeInputStream() {
		String path = getPathAtual();

		Collection<InputStream> arquivos = UtilArquivo
				.getColecaoDeInputStream(path);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() > 0);

		arquivos = UtilArquivo.getColecaoDeInputStream(null);
		assertNotNull(arquivos);
		assertTrue(arquivos.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getTextoDoArquivo(java.lang.String)}.
	 */
	@Test
	public final void testGetTextoDoArquivoString_String() {
		String path = getArquivoTeste().getPath();

		String texto = UtilArquivo.getTextoDoArquivo(path);
		assertNotNull(texto);

		path = "inexistente";
		texto = UtilArquivo.getTextoDoArquivo(path);
		assertEquals("", texto);

		path = null;
		texto = UtilArquivo.getTextoDoArquivo(path);
		assertEquals("", texto);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getTextoDoArquivo(java.io.File)}.
	 */
	@Test
	public final void testGetTextoDoArquivo_File() {
		File arquivo = getArquivoTeste();

		String texto = UtilArquivo.getTextoDoArquivo(arquivo);
		assertNotNull(texto);

		arquivo = new File("asdf");
		texto = UtilArquivo.getTextoDoArquivo(arquivo);
		assertEquals("", texto);

		arquivo = null;
		texto = UtilArquivo.getTextoDoArquivo(arquivo);
		assertEquals("", texto);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getTextoDoArquivo(java.io.BufferedReader, boolean)}.
	 */
	@Test
	public final void testGetTextoDoArquivo_BufferedReader_Boolean() {
		String path = getArquivoTeste().getPath();
		BufferedReader reader = getArquivoFactory().novoBufferedReader(path);

		String texto = UtilArquivo.getTextoDoArquivo(reader, true);
		assertNotNull(texto);

		reader = null;
		texto = UtilArquivo.getTextoDoArquivo(reader, false);
		assertEquals("", texto);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#getTextoDoInputStream(InputStream)}.
	 */
	@Test
	public final void testGetTextoDoInputStream() {
		String path = "./log4j.properties";
		InputStream is = getArquivoFactory().novoInputStream(path);
		
		String texto = UtilArquivo.getTextoDoInputStream(is);
		assertNotNull(texto);
		
		texto = UtilArquivo.getTextoDoInputStream(null);
		assertEquals("", texto);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#isExiste(java.io.File)}.
	 */
	@Test
	public final void testIsExiste() {
		File arquivo = getArquivoTeste();

		boolean existe = UtilArquivo.isExiste(arquivo);
		assertTrue(existe);

		existe = UtilArquivo.isExiste(getArquivoFactory().novoFile("xxx"));
		assertFalse(existe);

		existe = UtilArquivo.isExiste(null);
		assertFalse(existe);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#isPasta(java.lang.String)}.
	 */
	@Test
	public final void testIsPasta_String() {
		String pasta = getPathAtual();

		boolean ehPasta = UtilArquivo.isPasta(pasta);
		assertTrue(ehPasta);

		pasta = "asdf";
		ehPasta = UtilArquivo.isPasta(pasta);
		assertFalse(ehPasta);

		pasta = null;
		ehPasta = UtilArquivo.isPasta(pasta);
		assertFalse(ehPasta);

	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#isPasta(java.io.File)}.
	 */
	@Test
	public final void testIsPasta_File() {
		File pasta = getArquivoFactory().novoFile(getPathAtual());

		boolean ehPasta = UtilArquivo.isPasta(pasta);
		assertTrue(ehPasta);

		pasta = getArquivoFactory().novoFile("asdf");
		ehPasta = UtilArquivo.isPasta(pasta);
		assertFalse(ehPasta);

		pasta = null;
		ehPasta = UtilArquivo.isPasta(pasta);
		assertFalse(ehPasta);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#isArquivo(java.lang.String)}.
	 */
	@Test
	public final void testIsArquivo_String() {
		String arquivo = getArquivoTeste().getPath();

		boolean ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertTrue(ehArquivo);

		arquivo = "xxx";
		ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertFalse(ehArquivo);

		arquivo = null;
		ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertFalse(ehArquivo);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilArquivo#isArquivo(java.io.File)}.
	 */
	@Test
	public final void testIsArquivo_File() {
		File arquivo = getArquivoTeste();

		boolean ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertTrue(ehArquivo);

		arquivo = getArquivoFactory().novoFile("xxx");
		ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertFalse(ehArquivo);

		arquivo = null;
		ehArquivo = UtilArquivo.isArquivo(arquivo);
		assertFalse(ehArquivo);
	}

	/**
	 * @return filtro que arquivos de extensão java.
	 */
	private FilenameFilter novoFilenameFilterDeArquivosJava() {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				boolean isPasta = !UtilString.isTemString(name, ".");
				return isPasta || name.endsWith(".java");
			}
		};
	}
	
	/**
	 * @return outputstream do arquivo temp
	 */
	private OutputStream getOutputStreamDoArquivoTemp() {
		return getArquivoFactory().novoFileOutputStream(getArquivoTemp());
	}

	/**
	 * @return reader do arquivo temp
	 */
	private Reader getReaderDoArquivoTemp() {
		return getArquivoFactory().novoFileReader(getArquivoTemp());
	}

	/**
	 * @return writer do arquivo temp
	 */
	private Writer getWriterDoArquivoTemp() {
		return getArquivoFactory().novoFileWriter(getArquivoTemp());
	}

	/**
	 * @return arquivo teste.properties.
	 */
	private File getArquivoTeste() {
		return getArquivoFactory().novoFile(getPath("teste.properties"));
	}

	/**
	 * @return arquivo teste.properties.
	 */
	private File getArquivoTemp() {
		return getArquivoFactory().novoFile(getPath("temp.properties"));
	}

	/**
	 * @return path do arquivo teste.properties
	 */
	private String getPathAtual() {
		String path = this.getClass().getResource(".").getPath();
		path = UtilString.substituirString(path, "bin", "source");
		return path;
	}

}
