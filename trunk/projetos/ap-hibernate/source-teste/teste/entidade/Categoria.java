package teste.entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Categoria entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "categoria", schema = "db001", uniqueConstraints = {})
public class Categoria implements Entidade {

	private Integer			codigo;
	private String			descricao;
	private Set<Produto>	produtos	= new HashSet<Produto>(0);

	/**
	 * Construtor.
	 */
	public Categoria() {
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
	// MYSQL: @GeneratedValue(strategy = GenerationType.AUTO)
	// DB2: @GenericGenerator(name = "generator", 
	// strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "DB001.SEQ_CATEGORIA") })
	@Id
	@GenericGenerator(name="seq_id", strategy="increment")
	@GeneratedValue(generator="seq_id")
	@Column(name = "cod_cat", unique = true, nullable = false)
	public Integer getCodigo() {
		return this.codigo;
	}

	/**
	 * @param codigo código
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return descricao
	 */
	@Column(name = "descr", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao Descrição
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return produtos
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	/**
	 * @param produtos Produtos
	 */
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
}