/*
 * ConversorAction.java
 * 
 * Data de criação: 23/10/2009
 */
package teste.action.conversor;

import java.util.Date;

import teste.action.TesteJSFActionAbstrato;
import teste.entidade.Cidade;

/**
 * @author adriano.pamplona
 */
public class ConversorAction extends TesteJSFActionAbstrato {
	private Date	inputTextHora;
	private Integer	inputTextInteiro;
	private Date	inputTextData;
	private Double	inputTextDouble;
	private Long	inputTextCPF;
	private Cidade	inputTextEntidadeCidade;

	/**
	 * @return conversor.
	 */
	public String acaoCarregar() {
		return "conversor";
	}

	/**
	 * @return the inputTextData
	 */
	public Date getInputTextData() {
		return inputTextData;
	}

	/**
	 * @param inputTextData
	 *            the inputTextData to set
	 */
	public void setInputTextData(Date inputTextData) {
		this.inputTextData = inputTextData;
	}

	/**
	 * @return the inputTextHora
	 */
	public Date getInputTextHora() {
		return inputTextHora;
	}

	/**
	 * @param inputTextHora
	 *            the inputTextHora to set
	 */
	public void setInputTextHora(Date inputTextHora) {
		this.inputTextHora = inputTextHora;
	}

	/**
	 * @return the inputTextInteiro
	 */
	public Integer getInputTextInteiro() {
		return inputTextInteiro;
	}

	/**
	 * @param inputTextInteiro
	 *            the inputTextInteiro to set
	 */
	public void setInputTextInteiro(Integer inputTextInteiro) {
		this.inputTextInteiro = inputTextInteiro;
	}

	/**
	 * @return the inputTextDouble
	 */
	public Double getInputTextDouble() {
		return inputTextDouble;
	}

	/**
	 * @param inputTextDouble
	 *            the inputTextDouble to set
	 */
	public void setInputTextDouble(Double inputTextDouble) {
		this.inputTextDouble = inputTextDouble;
	}

	/**
	 * @return the inputCPF
	 */
	public Long getInputTextCPF() {
		return inputTextCPF;
	}

	/**
	 * @param inputCPF
	 *            the inputCPF to set
	 */
	public void setInputTextCPF(Long inputCPF) {
		this.inputTextCPF = inputCPF;
	}

	/**
	 * @return the inputTextEntidadeCidade
	 */
	public Cidade getInputTextEntidadeCidade() {
		return inputTextEntidadeCidade;
	}

	/**
	 * @param inputTextEntidadeCidade the inputTextEntidadeCidade to set
	 */
	public void setInputTextEntidadeCidade(Cidade inputTextEntidadeCidade) {
		this.inputTextEntidadeCidade = inputTextEntidadeCidade;
	}
}
