/*
 * AlunoTO.java
 * 
 * Data de criação: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe usada no teste.
 * 
 * @author adrianop
 */
@Ignore
public class AlunoTO implements Serializable {
	private long matricula;
	private String nome;
	private Character sexo;
	private AlunoTO alunoFilhoTO;
	private List<AlunoTO> listaDeAlunos;
	private Map<String, AlunoTO> mapaDeAlunos;

	/**
	 * Construtor.
	 */
	public AlunoTO() {
		// Construtor.
	}

	/**
	 * Construtor.
	 * 
	 * @param nome
	 *            Nome
	 */
	public AlunoTO(String nome) {
		setNome(nome);
	}

	/**
	 * Método usado como teste
	 */
	@Ignore
	public void metodoComAnotacao() {
		// não faz nada.
	}

	/**
	 * @return matricula
	 */
	public long getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            Atribui matricula.
	 */
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            Atribui nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return sexo
	 */
	public Character getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            Atribui sexo.
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return alunoFilhoTO
	 */
	public AlunoTO getAlunoFilhoTO() {
		if (!UtilObjeto.isReferencia(alunoFilhoTO)) {
			alunoFilhoTO = new AlunoTO();
		}
		return alunoFilhoTO;
	}

	/**
	 * @param alunoTO
	 *            Atribui alunoFilhoTO.
	 */
	public void setAlunoFilhoTO(AlunoTO alunoTO) {
		this.alunoFilhoTO = alunoTO;
	}

	/**
	 * @return listaDeAlunos
	 */
	public List<AlunoTO> getListaDeAlunos() {
		if (!UtilObjeto.isReferencia(listaDeAlunos)) {
			listaDeAlunos = getColecaoFactory().novoArrayList();
		}
		return listaDeAlunos;
	}

	/**
	 * @param listaDeAlunos
	 *            Atribui listaDeAlunos.
	 */
	public void setListaDeAlunos(List<AlunoTO> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}

	/**
	 * @return mapaDeAlunos
	 */
	public Map<String, AlunoTO> getMapaDeAlunos() {
		if (!UtilObjeto.isReferencia(mapaDeAlunos)) {
			mapaDeAlunos = getColecaoFactory().novoHashMap();
		}
		return mapaDeAlunos;
	}

	/**
	 * @param mapaDeAlunos
	 *            Atribui mapaDeAlunos.
	 */
	public void setMapaDeAlunos(Map<String, AlunoTO> mapaDeAlunos) {
		this.mapaDeAlunos = mapaDeAlunos;
	}

	/**
	 * @return fábrica de coleção
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
