package teste.entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.javabean.entidade.ExclusaoLogica;

/**
 * Cliente entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cliente", catalog = "db001", uniqueConstraints = {})
public class Cliente implements Entidade, ExclusaoLogica {

	private Integer		codigo;
	private Cidade		cidade;
	private String		nome;
	private Boolean		excluido;
	private Set<Pedido>	pedidos	= new HashSet<Pedido>(0);

	/**
	 * Construtor.
	 */
	public Cliente() {
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
	@Column(name = "cod_cli", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return cidade
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cid", unique = false, nullable = false, insertable = true, updatable = true)
	public Cidade getCidade() {
		return this.cidade;
	}

	/**
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return nome
	 */
	@Column(name = "nome", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return pedidos
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	/**
	 * @param pedidos
	 */
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
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
}