/*
 * Servico.java
 * 
 * Data de criação: 16/10/2009
 */
package teste.service;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import teste.dao.ICategoriaDAO;
import teste.dao.ICidadeDAO;
import teste.dao.IClienteDAO;
import teste.dao.IItemDAO;
import teste.dao.IPedidoDAO;
import teste.dao.IProdutoDAO;
import teste.entidade.Categoria;
import teste.entidade.Cidade;
import teste.entidade.Cliente;
import teste.entidade.Item;
import teste.entidade.Pedido;
import teste.entidade.Produto;

/**
 * @author adriano.pamplona
 */
@Service
@SuppressWarnings("unused")
public class TesteJSFService {

	@Resource
	private ICategoriaDAO categoriaDAO;

	@Resource
	private ICidadeDAO cidadeDAO;

	@Resource
	private IClienteDAO clienteDAO;

	@Resource
	private IItemDAO itemDAO;

	@Resource
	private IPedidoDAO pedidoDAO;

	@Resource
	private IProdutoDAO produtoDAO;

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Categoria arg0) {
		categoriaDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Categoria> consultarCategoria() {
		return categoriaDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Categoria> consultar(Categoria arg0) {
		return categoriaDAO.consultar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosCategoria(Collection<Categoria> arg0) {
		categoriaDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Categoria arg0) {
		categoriaDAO.excluir(arg0);
	}

	/**
	 * @return
	 * @see teste.dao.ICategoriaDAO#getCodigoDoProximoRegistro()
	 */
	public Long getCodigoDoProximoRegistro() {
		return categoriaDAO.getCodigoDoProximoRegistro();
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Categoria arg0) {
		return categoriaDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Categoria obterCategoria(Serializable arg0) {
		return categoriaDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Categoria obter(Categoria arg0) {
		return categoriaDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Categoria arg0) {
		categoriaDAO.salvar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Cidade arg0) {
		cidadeDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Cidade> consultarCidade() {
		return cidadeDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Cidade> consultar(Cidade arg0) {
		return cidadeDAO.consultar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosCidade(Collection<Cidade> arg0) {
		cidadeDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Cidade arg0) {
		cidadeDAO.excluir(arg0);
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Cidade arg0) {
		return cidadeDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Cidade obterCidade(Serializable arg0) {
		return cidadeDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Cidade obter(Cidade arg0) {
		return cidadeDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Cidade arg0) {
		cidadeDAO.salvar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Cliente arg0) {
		clienteDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Cliente> consultarCliente() {
		return clienteDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Cliente> consultar(Cliente arg0) {
		return clienteDAO.consultar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosCliente(Collection<Cliente> arg0) {
		clienteDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Cliente arg0) {
		clienteDAO.excluir(arg0);
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Cliente arg0) {
		return clienteDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Cliente obterCliente(Serializable arg0) {
		return clienteDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Cliente obter(Cliente arg0) {
		return clienteDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Cliente arg0) {
		clienteDAO.salvar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Item arg0) {
		itemDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Item> consultarItem() {
		return itemDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Item> consultar(Item arg0) {
		return itemDAO.consultar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosItem(Collection<Item> arg0) {
		itemDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Item arg0) {
		itemDAO.excluir(arg0);
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Item arg0) {
		return itemDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Item obterItem(Serializable arg0) {
		return itemDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Item obter(Item arg0) {
		return itemDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Item arg0) {
		itemDAO.salvar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Pedido arg0) {
		pedidoDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Pedido> consultarPedido() {
		return pedidoDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Pedido> consultar(Pedido arg0) {
		return pedidoDAO.consultar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosPedido(Collection<Pedido> arg0) {
		pedidoDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Pedido arg0) {
		pedidoDAO.excluir(arg0);
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Pedido arg0) {
		return pedidoDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Pedido obterPedido(Serializable arg0) {
		return pedidoDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Pedido obter(Pedido arg0) {
		return pedidoDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Pedido arg0) {
		pedidoDAO.salvar(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void alterar(Produto arg0) {
		produtoDAO.alterar(arg0);
	}

	/**
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	public Collection<Produto> consultarProduto() {
		return produtoDAO.consultar();
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	public Collection<Produto> consultar(Produto arg0) {
		return produtoDAO.consultar(arg0);
	}

	/**
	 * @return
	 * @see teste.dao.IProdutoDAO#consultarLivros()
	 */
	public Collection<Produto> consultarLivros() {
		return produtoDAO.consultarLivros();
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	public void excluirTodosProduto(Collection<Produto> arg0) {
		produtoDAO.excluirTodos(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public void excluir(Produto arg0) {
		produtoDAO.excluir(arg0);
	}

	/**
	 * @param <R>
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	public <R extends Serializable> R incluir(Produto arg0) {
		return produtoDAO.incluir(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.io.Serializable)
	 */
	public Produto obterProduto(Serializable arg0) {
		return produtoDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	public Produto obter(Produto arg0) {
		return produtoDAO.obter(arg0);
	}

	/**
	 * @param arg0
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	public void salvar(Produto arg0) {
		produtoDAO.salvar(arg0);
	}
}
