package teste.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Pedido entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pedido", catalog = "db001", uniqueConstraints = {})
public class Pedido implements Entidade {

	// Fields

	private Integer		numero;
	private Cliente		cliente;
	private Date		data;
	private Set<Item>	items	= new HashSet<Item>(0);

	/**
	 * Construtor.
	 */
	public Pedido() {
		// Construtor.
	}

	/**
	 * @see Entidade#getIdentificador()
	 */
	@Transient
	public Serializable getIdentificador() {
		return getNumero();
	}

	/**
	 * @return numero
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nro_ped", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getNumero() {
		return this.numero;
	}

	/**
	 * @param numeroPedido
	 */
	public void setNumero(Integer numeroPedido) {
		this.numero = numeroPedido;
	}

	/**
	 * @return cliente
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cli", unique = false, nullable = true, insertable = true, updatable = true)
	public Cliente getCliente() {
		return this.cliente;
	}

	/**
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return data
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "data", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Date getData() {
		return this.data;
	}

	/**
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return items
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "pedido")
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