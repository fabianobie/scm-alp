/*
 * TesteAbstrato.java
 * 
 * Data de criação: Jul 1, 2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.io.File;
import java.util.Properties;

import junit.framework.TestCase;
import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.ConversorFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.FormatadorFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;

/**
 * Classe que implementa os recursos necessários aos testes.
 * 
 * @author adrianop
 */
public abstract class TesteAbstrato extends TestCase {
	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected File novoFile(String arquivo) {
		return getArquivoFactory().novoFile(getPath(arquivo));
	}

	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected Properties novoProperties(String arquivo) {
		return getArquivoFactory().novoProperties(getPath(arquivo));
	}

	/**
	 * @param nome
	 *            Nome do arquivo.
	 * @return path do arquivo
	 */
	protected String getPath(String nome) {
		return this.getClass().getResource(nome).getPath();
	}

	/**
	 * @return fábrica de IO
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return fábrica de string
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Retorna novo ColecaoFactory.
	 * 
	 * @return novo ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo NumeroFactory.
	 * 
	 * @return novo NumeroFactory
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna novo DataFactory.
	 * 
	 * @return novo DataFactory
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna nova fábrica de conversores.
	 * 
	 * @return nova fábrica de conversores
	 */
	protected ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}

	/**
	 * Retorna nova fábrica de formatadores.
	 * 
	 * @return nova fábrica de formatadores
	 */
	protected FormatadorFactory getFormatadorFactory() {
		return FormatadorFactory.getInstancia();
	}

	/**
	 * Retorna novo alunoTO com filho
	 * 
	 * @return novo alunoTO
	 */
	protected AlunoTO novoAlunoTO() {
		long matricula = 101L;
		String nome = "Fulano de Tal";
		String sexo = "M";

		AlunoTO to = novoAlunoTO(matricula, nome, sexo);
		AlunoTO filho = novoAlunoTO(matricula + 1, nome + " Filho", sexo);

		AlunoTO filhoDaLista1 = novoAlunoTO(matricula + 2, nome
				+ " Filho da Lista " + (matricula + 2), sexo);
		AlunoTO filhoDaLista2 = novoAlunoTO(matricula + 3, nome
				+ " Filho da Lista " + (matricula + 3), sexo);
		AlunoTO filhoDaLista3 = novoAlunoTO(matricula + 4, nome
				+ " Filho da Lista " + (matricula + 4), sexo);

		to.setAlunoFilhoTO(filho);
		to.getListaDeAlunos().add(filhoDaLista1);
		to.getListaDeAlunos().add(filhoDaLista2);
		to.getListaDeAlunos().add(filhoDaLista3);
		to.getMapaDeAlunos().put(getString(filhoDaLista1.getMatricula()),
				filhoDaLista1);
		to.getMapaDeAlunos().put(getString(filhoDaLista2.getMatricula()),
				filhoDaLista2);
		to.getMapaDeAlunos().put(getString(filhoDaLista3.getMatricula()),
				filhoDaLista3);

		return to;
	}

	/**
	 * Retorna novo alunoTO
	 * 
	 * @param matricula
	 *            Matrícula
	 * @param nome
	 *            Nome
	 * @param sexo
	 *            Sexo
	 * @return novo alunoTO
	 */
	protected AlunoTO novoAlunoTO(long matricula, String nome, String sexo) {
		AlunoTO to = new AlunoTO();
		to.setMatricula(matricula);
		to.setNome(nome);
		to.setSexo(UtilConversorDeString.converterParaCharacter(sexo));

		return to;
	}

	/**
	 * @param valor
	 * @return string do long
	 */
	protected String getString(long valor) {
		return String.valueOf(valor);
	}
}
