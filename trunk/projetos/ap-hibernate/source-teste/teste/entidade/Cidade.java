package teste.entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.javabean.entidade.ExclusaoLogica;

/**
 * Cidade entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cidade", catalog = "db001", uniqueConstraints = {})
public class Cidade implements Entidade, ExclusaoLogica {

	private Integer			codigo;
	private String			nome;
	private Boolean			excluido;
	private Set<Cliente>	clientes	= new HashSet<Cliente>(0);

	/**
	 * Construtor.
	 */
	public Cidade() {
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
	 * @GeneratedValue(strategy = GenerationType.AUTO, generator="generator")
	 * @GenericGenerator(name = "generator", strategy = "sequence", parameters =
	 *                        { @Parameter(name = "sequence", value =
	 *                        "DB001.SEQ_CATEGORIA") })
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_cid", unique = true, nullable = false)
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo Código
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return nome
	 */
	@Column(name = "nome", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
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
	 * @return excluido
	 */
	@Column(name = "cod_exclusao", unique = false, nullable = true, insertable = true, updatable = true)
	public Boolean getExcluido() {
		return excluido;
	}

	/**
	 * @param excluido Atribui excluido.
	 */
	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	/**
	 * @return clientes
	 */
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "cidade")
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	/**
	 * @param clientes Clientes
	 */
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}