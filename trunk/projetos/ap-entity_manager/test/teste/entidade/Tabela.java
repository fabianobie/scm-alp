package teste.entidade;

// default package

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.ap.comum.javabean.entidade.Entidade;

/**
 * Tabela entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tabela", schema = "db001")
public class Tabela implements Entidade {

	private Integer		codigo;
	private String		tabela;
	private Integer		acao;
	private String		usuario;
	private Timestamp	data;
	private Set<Campo>	campos	= new HashSet<Campo>(0);

	// Constructors

	/**
	 * Construtor.
	 */
	public Tabela() {
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
	@Column(name = "CODIGO_TABELA", unique = true, nullable = false, insertable = true, updatable = true)
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
	 * @return tabela
	 */
	@Column(name = "TABELA", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getTabela() {
		return this.tabela;
	}

	/**
	 * @param tabela
	 */
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	/**
	 * @return acao
	 */
	@Column(name = "ACAO", unique = false, nullable = false, insertable = true, updatable = true)
	public Integer getAcao() {
		return this.acao;
	}

	/**
	 * @param acao
	 */
	public void setAcao(Integer acao) {
		this.acao = acao;
	}

	/**
	 * @return usuario
	 */
	@Column(name = "USUARIO", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return data
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public Date getData() {
		return this.data;
	}

	/**
	 * @param data
	 */
	public void setData(Timestamp data) {
		this.data = data;
	}

	/**
	 * @return campos
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tabela")
	public Set<Campo> getCampos() {
		return this.campos;
	}

	/**
	 * @param campos
	 */
	public void setCampos(Set<Campo> campos) {
		this.campos = campos;
	}

}