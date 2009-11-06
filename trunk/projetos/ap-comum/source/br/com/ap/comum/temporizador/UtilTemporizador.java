/*
 * UtilTemporizador.java
 * 
 * Data de criação: 24/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.temporizador;

import br.com.ap.comum.calculadores.UtilDivisoresDeNumero;
import br.com.ap.comum.calculadores.UtilSubtratoresDeNumero;
import br.com.ap.comum.excecao.TemporizadorException;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.util.UtilLog;
import br.com.ap.comum.util.UtilMensagem;
import br.com.ap.comum.util.UtilTemporizadorException;
import br.com.ap.comum.validador.UtilValidadorDeNumeroInicialMaiorQueNumeroFinal;

/**
 * Classe utilitária para contagem de tempo decorrido.
 * 
 * @author AdrianoP
 */
@SuppressWarnings("boxing")
public class UtilTemporizador {

	private int		tempoSugerido;
	private long	inicio;
	private long	fim;

	/**
	 * Construtor.
	 * 
	 * @param tempoSugerido Tempo sugerido
	 */
	protected UtilTemporizador(int tempoSugerido) {
		setTempoSugerido(tempoSugerido);
	}

	/**
	 * Retorna a instância da classe.
	 * 
	 * @param tempoSugerido Tempo máximo sugerido.
	 * @return intância da classe.
	 */
	public static UtilTemporizador novaInstancia(int tempoSugerido) {
		return new UtilTemporizador(tempoSugerido);
	}

	/**
	 * Inicia a contagem do tempo.
	 */
	public void iniciar() {
		inicio = getMilisegundosAtual();
	}

	/**
	 * Finaliza a contagem do tempo.
	 */
	public void finalizar() {
		fim = getMilisegundosAtual();
	}

	/**
	 * Retorna o tempo decorrido em segundos.
	 * 
	 * @return tempo decorrido.
	 */
	public int getTempoDecorrido() {
		int milis = (int) UtilSubtratoresDeNumero.subtrair(fim, inicio);
		return (int) UtilDivisoresDeNumero.dividir(milis, 1000);
	}

	/**
	 * Efetua o log do tempo decorrido.
	 */
	public void log() {
		int decorrido = getTempoDecorrido();
		int sugerido = getTempoSugerido();
		if (UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(decorrido,
				sugerido)) {
			getLog().warn(getMensagemDeLog(), getTempoDeRespostaExpirado());
		} else {
			getLog().info(getMensagemDeLog());
		}
	}

	/**
	 * Valida se o tempo decorrido está dentro do sugerido, caso contrário será
	 * lançada uma exceção de runtime.
	 * 
	 * @throws TemporizadorException Exceção do temporizador
	 */
	public void validar() throws TemporizadorException {
		int decorrido = getTempoDecorrido();
		int sugerido = getTempoSugerido();
		if (UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(decorrido,
				sugerido)) {
			throw getTempoDeRespostaExpirado();
		}
	}

	/**
	 * Retorna a exceção de tempo de resposta expirado.
	 * 
	 * @return exceção
	 */
	protected TemporizadorException getTempoDeRespostaExpirado() {
		int decorrido = getTempoDecorrido();
		int sugerido = getTempoSugerido();

		return UtilTemporizadorException.tempoDeRespostaExpirado(decorrido,
				sugerido);
	}

	/**
	 * Retorna o tempo atual em milisegundos.
	 * 
	 * @return milisegundos.
	 */
	protected long getMilisegundosAtual() {
		return System.currentTimeMillis();
	}

	/**
	 * @return Retorna log
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * @return Retorna tempo
	 */
	protected int getTempoSugerido() {
		return tempoSugerido;
	}

	/**
	 * @param tempo Atribui tempo
	 */
	protected void setTempoSugerido(int tempo) {
		this.tempoSugerido = tempo;
	}

	/**
	 * @return mensagem do log.
	 */
	protected String getMensagemDeLog() {
		int decorrido = getTempoDecorrido();
		int sugerido = getTempoSugerido();
		return getUtilMensagem().getTempoDeResposta(decorrido, sugerido);
	}

	/**
	 * @return utilitário de mensagem.
	 */
	protected UtilMensagem getUtilMensagem() {
		return UtilMensagem.getInstancia();
	}

}
