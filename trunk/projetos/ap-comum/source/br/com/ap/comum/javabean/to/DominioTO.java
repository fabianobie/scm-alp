/*
 * DominioTO.java
 * 
 * Data de criação: 26/04/2007
 */
package br.com.ap.comum.javabean.to;

/**
 * Classe responsável em representar um Domínio com código e descrição.
 * 
 * @param <K> Tipo do código de domínio
 * @param <D> Tipo da descrição do domínio
 * @author adrianop
 */
public class DominioTO<K, D> extends TOAbstrato {

    private K codigo;
    private D descricao;

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
	boolean iguais = false;

	if (isReferencia(obj) && (obj instanceof DominioTO)) {
	    DominioTO<K, D> to = (DominioTO<K, D>) obj;
	    K codigo = getCodigo();
	    K codigoOutro = to.getCodigo();

	    if (isReferencia(codigo, codigoOutro)) {
		iguais = codigo.equals(codigoOutro);
	    }
	}
	return iguais;
    }

    /**
     * @return codigo
     */
    public K getCodigo() {
	return codigo;
    }

    /**
     * @param codigo Atribui codigo.
     */
    public void setCodigo(K codigo) {
	this.codigo = codigo;
    }

    /**
     * @return descricao
     */
    public D getDescricao() {
	return descricao;
    }

    /**
     * @param descricao Atribui descricao.
     */
    public void setDescricao(D descricao) {
	this.descricao = descricao;
    }

}
