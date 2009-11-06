/*
 * ExceptionAbstrato.java 
 * 
 * Data de cria��o: 27/10/2006 
 * 
 *  
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe abstrata que representa um exce��o, prov� os recursos necess�rios para
 * trabalhar com exce��es na metodologia de chaves e par�metros.<br>
 * A exce��o � composta por atributos que ser�o usados para montagem da mensagem
 * que provavelmente ser� recuperado de um arquivo externo.<br>
 * Os atributos s�o: <br>
 * <dd>key: chave da mensagem<br> <dd>args: par�metros da mensagem<br>
 * O m�todo abstrato getMessage dever� ser implementado para que a mensagem de
 * exce��o seja montada.
 * 
 * @author adrianop
 */
public abstract class ExceptionAbstrato extends Exception {

	private String		key;

	private String[]	args;

	/**
	 * Construtor.
	 */
	public ExceptionAbstrato() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao exce��o do tipo ExceptionAbstrato
	 */
	public ExceptionAbstrato(ExceptionAbstrato excecao) {
		super(excecao.getKey());
		setKey(excecao.getKey());
		setArgs(excecao.getArgs());

		super.initCause(excecao.getCause());
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao exce��o do tipo RuntimeExceptionAbstrato
	 */
	public ExceptionAbstrato(RuntimeExceptionAbstrato excecao) {
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
	public ExceptionAbstrato(String key) {
		super(key);
		setKey(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave da mensagem.
	 * @param args argumentos da mensagem.
	 */
	public ExceptionAbstrato(String key, String... args) {
		super(key);
		setKey(key);
		setArgs(args);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave da mensagem.
	 * @param e Exce��o.
	 */
	public ExceptionAbstrato(String key, Throwable e) {
		super(key, e);
		setKey(key);
		setArgs(UtilExcecao.getMensagem(e));
	}

	/**
	 * Construtor.
	 * 
	 * @param e Exce��o.
	 */
	public ExceptionAbstrato(Throwable e) {
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

	/**
	 * @return args
	 */
	public String[] getArgs() {
		return args;
	}

	/**
	 * @param args Atribui args.
	 */
	public void setArgs(String... args) {
		this.args = args;
	}
}
