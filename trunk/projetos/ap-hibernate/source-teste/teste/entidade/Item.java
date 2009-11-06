package teste.entidade;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Item entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "item", catalog = "db001", uniqueConstraints = {})
public class Item implements Entidade {

	private ItemId	id;
	private Produto	produto;
	private Pedido	pedido;
	private Long	quantidade;

	/**
	 * Construtor.
	 */
	public Item() {
		// Construtor.
	}

	/**
	 * @see Entidade#getIdentificador()
	 */
	@Transient
	public Serializable getIdentificador() {
		return getId();
	}

	/**
	 * @return id
	 */
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "numeroPedido", column = @Column(
					name = "nro_ped", unique = false, nullable = false, insertable = true, updatable = true)),
			@AttributeOverride(name = "numeroItem", column = @Column(
					name = "nro_item", unique = false, nullable = false, insertable = true, updatable = true)) })
	public ItemId getId() {
		return this.id;
	}

	/**
	 * @param id ItemId
	 */
	public void setId(ItemId id) {
		this.id = id;
	}

	/**
	 * @return produto
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prd", unique = false, nullable = false, insertable = true, updatable = true)
	public Produto getProduto() {
		return this.produto;
	}

	/**
	 * @param produto Produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return pedido
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "nro_ped", unique = false, nullable = false, insertable = false, updatable = false)
	public Pedido getPedido() {
		return this.pedido;
	}

	/**
	 * @param pedido Pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return quantidade
	 */
	@Column(name = "qtde", 
			unique = false, nullable = false, insertable = true, updatable = true, precision = 5, scale = 0)
	public Long getQuantidade() {
		return this.quantidade;
	}

	/**
	 * @param quantidade Quantidade
	 */
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

}