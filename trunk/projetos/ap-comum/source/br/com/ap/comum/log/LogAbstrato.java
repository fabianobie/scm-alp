/*
 * UtilLog.java
 *
 * Data de criação: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.comum.log;

import org.apache.log4j.Logger;

import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilizada para registro de logs do Sistema. <br>
 * Informações de uso:<br>
 * Para usar a classe siga os seguintes passos:<br>
 * <dd>1. Crie uma classe estendendo esta classe abstrata.<br> <dd>2. Implemente
 * o método abstrato getAppenderDoLog()<br> <dd>3. Registre no log4j.properties
 * da plataforma o appender criado.
 * 
 * @author adrianop
 */
public abstract class LogAbstrato {

	private Logger	logger;

	/**
	 * Mensagem de info usada no início dos métodos.
	 * 
	 * @param classe Classe que será usada para imprimir o nome da classe.
	 * @param metodo Método invocado
	 * @see Logger#info(java.lang.Object)
	 */
	public void infoInit(Class<?> classe, String metodo) {
		info(criarMensagem(classe, metodo, "inicio"));
	}

	/**
	 * Mensagem de info usada no início dos métodos.
	 * 
	 * @param classe Classe que será usada para imprimir o nome da classe.
	 * @param metodo Método invocado
	 * @see Logger#info(java.lang.Object)
	 */
	public void infoEnd(Class<?> classe, String metodo) {
		info(criarMensagem(classe, metodo, "fim"));
	}

	/**
	 * Mensagem de debug usada no início dos métodos.
	 * 
	 * @param classe Classe que será usada para imprimir o nome da classe.
	 * @param metodo Método invocado
	 * @see Logger#debug(java.lang.Object)
	 */
	public void debugInicio(Class<?> classe, String metodo) {
		debug(criarMensagem(classe, metodo, "inicio"));
	}

	/**
	 * Mensagem de debug usada no início dos métodos.
	 * 
	 * @param classe Classe que será usada para imprimir o nome da classe.
	 * @param metodo Método invocado
	 * @see Logger#debug(java.lang.Object)
	 */
	public void debugFim(Class<?> classe, String metodo) {
		debug(criarMensagem(classe, metodo, "fim"));
	}

	/**
	 * Log exibido no debug.
	 * 
	 * @param mensagem Mensagem do log.
	 * @param excecao Exceção
	 * @see Logger#debug(java.lang.Object, java.lang.Throwable)
	 */
	public void debug(Object mensagem, Throwable excecao) {
		getLogger().debug(mensagem, excecao);
	}

	/**
	 * Log exibido no debug.
	 * 
	 * @param mensagem Mensagem do log.
	 * @see Logger#debug(java.lang.Object)
	 */
	public void debug(Object mensagem) {
		getLogger().debug(mensagem);
	}

	/**
	 * Log exibido no debug.
	 * 
	 * @param excecao Exceção
	 * @see Logger#debug(java.lang.Object)
	 */
	public void debug(Throwable excecao) {
		String mensagem = excecao.getMessage();
		if (UtilString.isVazio(mensagem)) {
			mensagem = excecao.toString();
		}
		getLogger().debug(mensagem);
	}

	/**
	 * Log exibido no error.
	 * 
	 * @param mensagem Mensagem do log.
	 * @param excecao Exceção
	 * @see Logger#error(java.lang.Object, java.lang.Throwable)
	 */
	public void error(Object mensagem, Throwable excecao) {
		getLogger().error(mensagem, excecao);
	}

	/**
	 * Log exibido no error.
	 * 
	 * @param mensagem Mensagem do log.
	 * @see Logger#error(java.lang.Object)
	 */
	public void error(Object mensagem) {
		getLogger().error(mensagem);
	}

	/**
	 * Log exibido no fatal.
	 * 
	 * @param mensagem Mensagem do log.
	 * @param excecao Exceção
	 * @see Logger#fatal(java.lang.Object, java.lang.Throwable)
	 */
	public void fatal(Object mensagem, Throwable excecao) {
		getLogger().fatal(mensagem, excecao);
	}

	/**
	 * Log exibido no fatal.
	 * 
	 * @param mensagem Mensagem do log.
	 * @see Logger#fatal(java.lang.Object)
	 */
	public void fatal(Object mensagem) {
		getLogger().fatal(mensagem);
	}

	/**
	 * Log exibido no info.
	 * 
	 * @param mensagem Mensagem do log.
	 * @param excecao Exceção
	 * @see Logger#info(java.lang.Object, java.lang.Throwable)
	 */
	public void info(Object mensagem, Throwable excecao) {
		getLogger().info(mensagem, excecao);
	}

	/**
	 * Log exibido no info.
	 * 
	 * @param mensagem Mensagem do log.
	 * @see Logger#info(java.lang.Object)
	 */
	public void info(Object mensagem) {
		getLogger().info(mensagem);
	}

	/**
	 * Log exibido no warn.
	 * 
	 * @param mensagem Mensagem do log.
	 * @param excecao Exceção
	 * @see Logger#warn(java.lang.Object, java.lang.Throwable)
	 */
	public void warn(Object mensagem, Throwable excecao) {
		getLogger().warn(mensagem, excecao);
	}

	/**
	 * Log exibido no warn.
	 * 
	 * @param mensagem Mensagem do log.
	 * @see Logger#warn(java.lang.Object)
	 */
	public void warn(Object mensagem) {
		getLogger().warn(mensagem);
	}

	/**
	 * Retorna o logger usado pelo log.
	 * 
	 * @return String do logger registrado no log4j.
	 */
	protected abstract String getNomeDoLogger();

	/**
	 * @return Logger
	 * @see Logger
	 */
	protected Logger getLogger() {
		if (!UtilObjeto.isReferencia(logger)) {
			try {
				logger = Logger.getLogger(getNomeDoLogger());
				logger.info("Inicializando logger '" + getNomeDoLogger()
						+ "'.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logger;
	}

	/**
	 * Cria a mensagem que será exibida no console, a mensagem é composta pelo
	 * nome da classe, nome do método e sufixo (init ou end).
	 * 
	 * @param classe Classe que será usada para recupera o nome da mesma.
	 * @param metodo Método invocado.
	 * @param sufix Sufixo usado para exibir o log. (Ex: inicio, fim)
	 * @return Mensagem exibida no console.
	 */
	protected String criarMensagem(Class<?> classe, String metodo, String sufix) {
		StringBuilder mensagem = getStringFactory().novoStringBuilder();
		mensagem.append(classe.getName());
		mensagem.append(".").append(metodo);
		mensagem.append(" - ").append(sufix);

		return mensagem.toString();
	}

	/**
	 * @return fábrica de string.
	 */
	private StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

}