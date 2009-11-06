/*
 * RuntimeExceptionAbstrato.java
 * 
 * Data de criação: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe abstrata que representa um exceção, provê os recursos necessários para
 * trabalhar com exceções na metodologia de chaves e parâmetros.<br>
 * A exceção é composta por atributos que serão usados para montagem da mensagem
 * que provavelmente será recuperado de um arquivo externo.<br>
 * Os atributos são: <br>
 * <dd>key: chave da mensagem<br> <dd>args: parâmetro da mensagem<br>
 * O método abstrato getMessage deverá ser implementado para que a mensagem de
 * exceção seja montada.
 * 
 * @author adrianop
 */
public abstract class RuntimeExceptionAbstrato extends RuntimeException {

	private String		key;

	private String[]	args;

	/**
	 * Construtor.
	 */
	public RuntimeExceptionAbstrato() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao exceção do tipo RuntimeExceptionAbstrato
	 */
	public RuntimeExceptionAbstrato(RuntimeExceptionAbstrato excecao) {
		super(excecao.getKey());
		setKey(excecao.getKey());
		setArgs(excecao.getArgs());

		super.initCause(excecao.getCause());
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao exceção do tipo ExceptionAbstrato
	 */
	public RuntimeExceptionAbstrato(ExceptionAbstrato excecao) {
		super(excecao.getKey());
		setKey(excecao.getKey());
		setArgs(excecao.getArgs());

		super.initCause(excecao.getCause());
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave da mensagem
	 */
	public RuntimeExceptionAbstrato(String key) {
		super(key);
		setKey(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave da mensagem.
	 * @param args argumento da mensagem.
	 */
	public RuntimeExceptionAbstrato(String key, String... args) {
		super(key);
		setKey(key);
		setArgs(args);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave da mensagem.
	 * @param e Exceção.
	 */
	public RuntimeExceptionAbstrato(String key, Throwable e) {
		super(key, e);
		setKey(key);
		setArgs(UtilExcecao.getMensagem(e));
	}

	/**
	 * Construtor.
	 * 
	 * @param e Exceção.
	 */
	public RuntimeExceptionAbstrato(Throwable e) {
		super(e);
		setKey(UtilExcecao.getMensagem(e));
	}

	/**
	 * @return String do stacktrace.
	 */
	public String getStackTraceString() {
		return UtilExcecao.getStackStrace(this);
	}

	/**
	 * Retorna args.
	 * 
	 * @return String
	 */
	public String[] getArgs() {
		return args;
	}

	/**
	 * Atribui args.
	 * 
	 * @param args args
	 */
	public void setArgs(String... args) {
		this.args = args;
	}

	/**
	 * Retorna key.
	 * 
	 * @return String
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Atribui key.
	 * 
	 * @param key key
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
