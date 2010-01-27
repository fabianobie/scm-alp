/*
 * FormularioAction.java
 * 
 * Data de criação: 16/10/2009
 */
package teste.action.formulario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 */
public class FormularioAction extends TesteJSFActionAbstrato {
	private String			inputTextString;
	private Date			inputTextData;
	private Double			inputTextNumerico;
	private String			inputSecret;
	private String			inputTextarea;
	private List<String>	selectManyCheckbox;
	private List<String>	selectManyListbox;
	private List<String>	selectManyMenu;
	private boolean			selectBooleanCheckbox;
	private String			selectOneListbox;
	private String			selectOneMenu;
	private String			selectOneRadio;
	private String			selectItems;

	/**
	 * @return formulário.
	 */
	public String acaoCarregar() {
		return "formulario";
	}

	/**
	 * @return formulário.
	 */
	public String acaoEnviar() {
		return "formulario";
	}
	
	/**
	 * @return ListaSelectItems
	 */
	public List<SelectItem> getListaSelectItems() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("01", "Opção 1"));
		lista.add(new SelectItem("02", "Opção 2"));
		lista.add(new SelectItem("03", "Opção 3"));
		return lista;
	}

	/**
	 * @return the inputTextString
	 */
	public String getInputTextString() {
		return inputTextString;
	}

	/**
	 * @param inputTextString the inputTextString to set
	 */
	public void setInputTextString(String inputTextString) {
		this.inputTextString = inputTextString;
	}

	/**
	 * @return the inputTextData
	 */
	public Date getInputTextData() {
		return inputTextData;
	}

	/**
	 * @param inputTextData the inputTextData to set
	 */
	public void setInputTextData(Date inputTextData) {
		this.inputTextData = inputTextData;
	}

	/**
	 * @return the inputTextNumerico
	 */
	public Double getInputTextNumerico() {
		return inputTextNumerico;
	}

	/**
	 * @param inputTextNumerico the inputTextNumerico to set
	 */
	public void setInputTextNumerico(Double inputTextNumerico) {
		this.inputTextNumerico = inputTextNumerico;
	}

	/**
	 * @return the inputSecret
	 */
	public String getInputSecret() {
		return inputSecret;
	}

	/**
	 * @param inputSecret the inputSecret to set
	 */
	public void setInputSecret(String inputSecret) {
		this.inputSecret = inputSecret;
	}

	/**
	 * @return the inputTextarea
	 */
	public String getInputTextarea() {
		return inputTextarea;
	}

	/**
	 * @param inputTextarea the inputTextarea to set
	 */
	public void setInputTextarea(String inputTextarea) {
		this.inputTextarea = inputTextarea;
	}

	/**
	 * @return the selectManyCheckbox
	 */
	public List<String> getSelectManyCheckbox() {
		return selectManyCheckbox;
	}

	/**
	 * @param selectManyCheckbox the selectManyCheckbox to set
	 */
	public void setSelectManyCheckbox(List<String> selectManyCheckbox) {
		this.selectManyCheckbox = selectManyCheckbox;
	}

	/**
	 * @return the selectManyListbox
	 */
	public List<String> getSelectManyListbox() {
		return selectManyListbox;
	}

	/**
	 * @param selectManyListbox the selectManyListbox to set
	 */
	public void setSelectManyListbox(List<String> selectManyListbox) {
		this.selectManyListbox = selectManyListbox;
	}

	/**
	 * @return the selectManyMenu
	 */
	public List<String> getSelectManyMenu() {
		return selectManyMenu;
	}

	/**
	 * @param selectManyMenu the selectManyMenu to set
	 */
	public void setSelectManyMenu(List<String> selectManyMenu) {
		this.selectManyMenu = selectManyMenu;
	}

	/**
	 * @return the selectBooleanCheckbox
	 */
	public boolean isSelectBooleanCheckbox() {
		return selectBooleanCheckbox;
	}

	/**
	 * @param selectBooleanCheckbox the selectBooleanCheckbox to set
	 */
	public void setSelectBooleanCheckbox(boolean selectBooleanCheckbox) {
		this.selectBooleanCheckbox = selectBooleanCheckbox;
	}

	/**
	 * @return the selectOneListbox
	 */
	public String getSelectOneListbox() {
		return selectOneListbox;
	}

	/**
	 * @param selectOneListbox the selectOneListbox to set
	 */
	public void setSelectOneListbox(String selectOneListbox) {
		this.selectOneListbox = selectOneListbox;
	}

	/**
	 * @return the selectOneMenu
	 */
	public String getSelectOneMenu() {
		return selectOneMenu;
	}

	/**
	 * @param selectOneMenu the selectOneMenu to set
	 */
	public void setSelectOneMenu(String selectOneMenu) {
		this.selectOneMenu = selectOneMenu;
	}

	/**
	 * @return the selectOneRadio
	 */
	public String getSelectOneRadio() {
		return selectOneRadio;
	}

	/**
	 * @param selectOneRadio the selectOneRadio to set
	 */
	public void setSelectOneRadio(String selectOneRadio) {
		this.selectOneRadio = selectOneRadio;
	}

	/**
	 * @return the selectItems
	 */
	public String getSelectItems() {
		return selectItems;
	}

	/**
	 * @param selectItems the selectItems to set
	 */
	public void setSelectItems(String selectItems) {
		this.selectItems = selectItems;
	}
}
