/*
 * ICrud.java
 * 
 * Data de criação: 19/03/2009
 */
package br.com.ap.arquitetura.util;

import java.io.Serializable;
import java.util.Collection;

import br.com.ap.comum.javabean.JavaBean;

/**
 * Interface que representa um CRUD.
 * 
 * @param <T> Tipo do Objeto manipulado pelo CRUD.
 * @author AdrianoP
 */
public interface CRUD<T extends JavaBean> {

    /**
     * Busca a entidade pelo seu identificador.
     * 
     * @param entidade Entidade com o identificador.
     * 
     * @return Entidade pesquisada
     */
    public T obter(T entidade);

    /**
     * Insere o objeto informado como parametro na entidade gerenciada por esta
     * classe.
     * 
     * @param <R> Tipo do objeto de retorno
     * @param entidade Objeto da entidade
     * 
     * @return Chave da entidade inserida na base de dados, podendo ser um
     *         objeto com mais de um atributo representando a chave
     */
    public <R extends Serializable> R incluir(T entidade);

    /**
     * Altera a entidade na base de dados.
     * 
     * @param entidade Objeto da entidade
     */
    public void alterar(T entidade);

    /**
     * Inseri o objeto caso ele não exista, senão, atualiza o objeto na
     * entidade.
     * 
     * @param entidade Objeto da entidade
     */
    public void salvar(T entidade);

    /**
     * Remove o objeto da entidade gerenciada por esta classe.
     * 
     * @param entidade Objeto da entidade
     */
    public void excluir(T entidade);

    /**
     * Remove todos os objetos informados como parametro da entidade gerenciada
     * por esta classe.
     * 
     * @param entidades Objetos da entidade
     */
    public void excluirTodos(Collection<T> entidades);

    /**
     * Consulta os objetos que possuirem os valores dos atributos do objeto
     * informado.
     * 
     * @param entidade Objeto que será utilizado como parâmetro na consulta.
     * 
     * @return Lista das entidades encontradas.
     */
    public Collection<T> consultar(T entidade);

    /**
     * Consultar todos os objetos da entidade.
     * 
     * @return Lista de todas objetos da entidade
     */
    public Collection<T> consultar();
}
