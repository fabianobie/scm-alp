package teste.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Campo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "campo", schema = "db001")
public class Campo implements Entidade {

	private Integer codigo;
	private Tabela  tabela;
	private String  nome;
	private String  valorAnterior;
	private String  valorPosterior;

	/**
	 * Construtor.
	 */
	public Campo() {
		// Construtor.
	}

	/**
	 * @see Entidade#getIdentificador()
	 */
	@Transient
	public Serializable getIdentificador() {
		return getCodigo();
	}

	/**
	 * @return codigo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO_CAMPO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo Cidade
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return tabela
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_TABELA", nullable = false, insertable = true, updatable = true)
	public Tabela getTabela() {
		return this.tabela;
	}

	/**
	 * @param tabela Tabela
	 */
	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	/**
	 * @return nome
	 */
	@Column(name = "NOME", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome Nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return valorAnterior
	 */
	@Column(name = "VALOR_ANTERIOR", 
			unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getValorAnterior() {
		return this.valorAnterior;
	}

	/**
	 * @param valorAnterior Valor Anterior
	 */
	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	/**
	 * @return valorPosterior
	 */
	@Column(name = "VALOR_POSTERIOR", 
			unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getValorPosterior() {
		return this.valorPosterior;
	}

	/**
	 * @param valorPosterior Valor Posterior
	 */
	public void setValorPosterior(String valorPosterior) {
		this.valorPosterior = valorPosterior;
	}

}