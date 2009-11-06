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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Produto entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "produto", catalog = "db001", uniqueConstraints = {})
public class Produto implements Entidade {

	private Integer		codigo;
	private Categoria	categoria;
	private String		descricao;
	private Double		preco;
	private Set<Item>	items	= new HashSet<Item>(0);

	/**
	 * Construtor.
	 */
	public Produto() {
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
	@Column(name = "cod_prd", unique = true, nullable = false, insertable = true, updatable = true)
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
	 * @return categoria
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cat", unique = false, nullable = false, insertable = true, updatable = true)
	public Categoria getCategoria() {
		return this.categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return descricao
	 */
	@Column(name = "descr", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return preco
	 */
	@Column(name = "preco", unique = false, nullable = true, insertable = true, updatable = true, precision = 9)
	public Double getPreco() {
		return this.preco;
	}

	/**
	 * @param preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return items
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<Item> getItems() {
		return this.items;
	}

	/**
	 * @param items
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}

}