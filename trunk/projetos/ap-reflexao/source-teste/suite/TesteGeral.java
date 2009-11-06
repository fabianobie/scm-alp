/*
 * TesteGeral.java
 * 
 * Data de cria��o: 21/04/2007
 * 
 *
 *
 */
package suite;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * TestSuite de todos dos TestCase's.
 * 
 * @author AdrianoP
 */
public class TesteGeral extends TestSuite {

	/**
	 * @return Test
	 */
	public static Test suite() {
		Collection<File> colecaoDeFile = getColecaoDosArquivosDeTeste();
		Collection<Class<TestCase>> colecaoDeClasse = converterFileEmClasse(colecaoDeFile);

		Iterator<Class<TestCase>> iterator = colecaoDeClasse.iterator();
		TestSuite testes = novoTestSuite();
		while (iterator.hasNext()) {
			testes.addTestSuite(iterator.next());
		}
		return testes;
	}

	/**
	 * Retorna cole��o dos arquivos de teste.
	 * 
	 * @return cole��o dos arquivos de teste.
	 */
	private static Collection<File> getColecaoDosArquivosDeTeste() {
		FilenameFilter filtro = new FilenameFilter() {
			public boolean accept(File pasta, String nome) {
				boolean isPasta = !UtilString.isTemString(nome, ".");
				return isPasta || nome.endsWith("Test.class");
			}
		};
		return UtilArquivo.getColecaoDeFileRecursivo(getPath(), filtro);
	}

	/**
	 * Converte a cole��o de file em cole��o de classe
	 * 
	 * @param colecaoDeFile
	 *            Cole��o de file.
	 * @return cole��o de classse
	 */
	private static Collection<Class<TestCase>> converterFileEmClasse(
			Collection<File> colecaoDeFile) {
		Collection<Class<TestCase>> colecao = getColecaoFactory()
				.novoArrayList();
		if (UtilObjeto.isReferencia(colecaoDeFile)) {
			for (File arquivo : colecaoDeFile) {
				Class<TestCase> classe = getClasse(arquivo);
				colecao.add(classe);
			}
		}
		return colecao;
	}

	/**
	 * Retorna a classe do arquivo.
	 * 
	 * @param arquivo
	 *            File
	 * @return classe do arquivo.
	 */
	@SuppressWarnings("unchecked")
	private static Class<TestCase> getClasse(File arquivo) {
		String nome = arquivo.getAbsolutePath();
		System.out.println(nome);
		nome = UtilString.substring(nome, nome.indexOf("br\\"));
		nome = nome.replaceAll("[\\\\]", ".");
		nome = UtilString.removerSufixo(nome, ".class");

		Class<TestCase> classe = null;
		try {
			classe = (Class<TestCase>) Class.forName(nome);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return classe;
	}

	/**
	 * @return path da pasta de teste.
	 */
	private static String getPath() {
		URL url = TesteGeral.class.getResource("/");
		String path = url.getPath();
		path = UtilString.substituirString(path, "source/", "test/");

		return path;
	}

	/**
	 * @return nova suite de teste.
	 */
	private static TestSuite novoTestSuite() {
		return new TestSuite("Testes do br.com.ap.reflexao");
	}

	/**
	 * @return f�brica de cole��o.
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
