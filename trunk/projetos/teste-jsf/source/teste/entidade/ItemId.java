package teste.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * ItemId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class ItemId implements Serializable, Entidade {

	private Integer	numeroPedido;
	private Integer	numeroItem;

	/**
	 * Construtor.
	 */
	public ItemId() {
		// Construtor.
	}

	/**
	 * @see Entidade#getIdentificador()
	 */
	@Transient
	public Serializable getIdentificador() {
		return null;
	}

	/**
	 * @return numeroPedido
	 */
	@Column(name = "nro_ped", unique = false, nullable = false, insertable = true, updatable = true)
	public Integer getNumeroPedido() {
		return this.numeroPedido;
	}

	/**
	 * @param numeroPedido
	 */
	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * @return numeroItem
	 */
	@Column(name = "nro_item", unique = false, nullable = false, insertable = true, updatable = true)
	public Integer getNumeroItem() {
		return this.numeroItem;
	}

	/**
	 * @param numeroItem
	 */
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ItemId))
			return false;
		ItemId castOther = (ItemId) other;

		return ((this.getNumeroPedido() == castOther.getNumeroPedido()) || (this
				.getNumeroPedido() != null
				&& castOther.getNumeroPedido() != null && this
				.getNumeroPedido().equals(castOther.getNumeroPedido())))
				&& ((this.getNumeroItem() == castOther.getNumeroItem()) || (this
						.getNumeroItem() != null
						&& castOther.getNumeroItem() != null && this
						.getNumeroItem().equals(castOther.getNumeroItem())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumeroPedido() == null ? 0 : this.getNumeroPedido()
						.hashCode());
		result = 37
				* result
				+ (getNumeroItem() == null ? 0 : this.getNumeroItem()
						.hashCode());
		return result;
	}

}