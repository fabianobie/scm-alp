/*
 * UtilData.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.data;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import br.com.ap.comum.calculadores.UtilSubtratoresDeNumero;
import br.com.ap.comum.constante.Data;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;
import br.com.ap.comum.validador.UtilValidadorDeNumeroNoPeriodo;

/**
 * Classe utilitária com operações em datas.
 * 
 * @author adriyearp
 */
public final class UtilData {

	/**
	 * Construtor.
	 */
	private UtilData() {
		// Construtor.
	}

	/**
	 * Retorna a quantidade de dias do ano.
	 * 
	 * @param data Data.
	 * @return quantidade de dias do ano.
	 */
	public static int getDiasDoAno(Date data) {
		int res = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			res = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		}
		return res;
	}

	/**
	 * Retorna a quantidade de dias do ano.
	 * 
	 * @param ano Ano.
	 * @return quantidade de dias do ano.
	 */
	public static int getDiasDoAno(int ano) {
		int dias = 0;

		if (Data.getPrimeiroAnoDefault() <= ano) {
			Date data = null;
			int mes = Data.getPrimeiroMesDefault();
			int dia = Data.getPrimeiroDiaDoMesDefault();

			data = getDataFactory().novoDate(dia, mes, ano);
			dias = getDiasDoAno(data);
		}

		return dias;
	}

	/**
	 * Retorna a quantidade de dias do mês.
	 * 
	 * @param data Data.
	 * @return quantidade de dias.
	 */
	public static int getDiasDoMes(Date data) {
		int res = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			res = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		return res;
	}

	/**
	 * Retorna a quantidade de dias do mês.
	 * 
	 * @param month Mês.
	 * @return quantidade de dias.
	 */
	public static int getDiasDoMes(int month) {
		int res = 0;

		if (month > Data.getPrimeiroMesDefault()) {
			Calendar calendar = getDataFactory().novoCalendar();
			Date data = getDataFactory().novoDate(
					Data.getPrimeiroDiaDoMesDefault(), month,
					calendar.get(Calendar.YEAR));
			res = getDiasDoMes(data);
		}

		return res;
	}

	/**
	 * Retorna o dia da semana.<br>
	 * <dd>1 = domingo<br> <dd>2 = segunda<br> <dd>3 = terça<br> <dd>4 = quarta
	 * <br> <dd>5 = quinta<br> <dd>6 = sexta<br> <dd>7 = sábado
	 * 
	 * @param data Data.
	 * @return dia da semana.
	 */
	public static int getDiaDaSemana(Date data) {
		int res = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			res = calendar.get(Calendar.DAY_OF_WEEK);
		}
		return res;
	}

	/**
	 * Retorna a hora no formato de 12 horas.
	 * 
	 * @param data Data.
	 * @return hora.
	 */
	public static int getHoraNoFormatoDe12(Date data) {
		int res = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			res = calendar.get(Calendar.HOUR);
		}
		return res;
	}

	/**
	 * Retorna a hora no formato de 24 horas.
	 * 
	 * @param data Data.
	 * @return hora.
	 */
	public static int getHoraNoFormatoDe24(Date data) {
		int res = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			res = calendar.get(Calendar.HOUR_OF_DAY);
		}
		return res;
	}

	/**
	 * Efetua o parse da string para um Date.
	 * 
	 * @param string String que será convertida.
	 * @param pattern Pattern usado na conversão.
	 * @return Date.
	 */
	public static Date parse(String string, String pattern) {
		return parse(string, pattern, false);
	}

	/**
	 * Efetua o parse da string para um Date.
	 * 
	 * @param string String que será convertida.
	 * @param pattern Pattern usado na conversão.
	 * @param lenient Se true a data inválida será retornada nula.
	 * @return Date.
	 */
	public static Date parse(String string, String pattern, boolean lenient) {
		Date res = null;

		if (!UtilString.isVazio(string, pattern)) {
			SimpleDateFormat sdf = null;
			try {
				sdf = getDataFactory().novoSimpleDateFormat(pattern);
				sdf.setLenient(lenient);
				res = sdf.parse(string);
			} catch (IllegalArgumentException e) {
				getLog().warn("Pattern inválido", e);
			} catch (ParseException e) {
				getLog().warn("Parser não efetuado", e);
			}
		}

		return res;
	}

	/**
	 * Retorna ano da data.
	 * 
	 * @param data Data
	 * @return ano da data.
	 */
	public static int getAno(Date data) {
		int resultado = Data.getPrimeiroAnoDefault();

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			resultado = calendar.get(Calendar.YEAR);
		}

		return resultado;
	}

	/**
	 * Retorna mês da data.
	 * 
	 * @param data Data
	 * @return mês da data.
	 */
	public static int getMes(Date data) {
		int resultado = Data.getPrimeiroMesDefault();

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			resultado = calendar.get(Calendar.MONTH);
			resultado++;
		}

		return resultado;
	}

	/**
	 * Retorna dia da data.
	 * 
	 * @param data Data
	 * @return dia da data.
	 */
	public static int getDia(Date data) {
		int resultado = Data.getPrimeiroDiaDoMesDefault();

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			resultado = calendar.get(Calendar.DAY_OF_MONTH);
		}

		return resultado;
	}

	/**
	 * Retorna o último dia do mês da data informada.
	 * 
	 * @param data Data
	 * @return último dia do mês.
	 */
	public static int getUltimoDiaDoMes(Date data) {
		int resultado = 0;

		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			resultado = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		return resultado;
	}

	/**
	 * Retorna o último dia do mês informado.
	 * 
	 * @param mes Mês
	 * @return último dia do mês.
	 */
	@SuppressWarnings("boxing")
	public static int getUltimoDiaDoMes(int mes) {
		int result = 0;

		if (UtilValidadorDeNumeroNoPeriodo.validar(mes, Data.getJaneiro(),
				Data.getDezembro())) {

			Date data = getDataFactory().novoDate();
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.DAY_OF_MONTH, Data
					.getPrimeiroDiaDoMesDefault());
			calendar.set(Calendar.MONTH, UtilSubtratoresDeNumero.subtrair(mes,
					1));
			result = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		return result;
	}

	/**
	 * Retorna o último dia do mês da data atual.
	 * 
	 * @return último dia do mês.
	 */
	public static int getUltimoDiaDoMes() {
		Date data = getDataFactory().novoDate();
		return getUltimoDiaDoMes(data);
	}

	/**
	 * Ajusta horas, minutos e segundos na data.
	 * 
	 * @param data Data que será atualizada.
	 * @param horas horas
	 * @param minutos minutos
	 * @param segundos segundos
	 * @return data atualizada
	 */
	public static Date ajustarData(Date data, int horas, int minutos,
			int segundos) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.HOUR, horas);
			calendar.set(Calendar.MINUTE, minutos);
			calendar.set(Calendar.SECOND, segundos);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta horas, minutos e segundos na data.
	 * 
	 * @param data Data que será atualizada.
	 * @param hora hora
	 * @return data atualizada
	 */
	public static Date ajustarData(Date data, Time hora) {
		if (UtilObjeto.isReferencia(data, hora)) {
			Calendar horaCalendar = getDataFactory().novoCalendar(hora);

			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.HOUR, horaCalendar.get(Calendar.HOUR));
			calendar.set(Calendar.MINUTE, horaCalendar.get(Calendar.MINUTE));
			calendar.set(Calendar.SECOND, horaCalendar.get(Calendar.SECOND));
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta a hora da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param hora Hora
	 * @return data atualizada
	 */
	public static Date ajustarDataParaHora(Date data, int hora) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.HOUR_OF_DAY, hora);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta os minutos da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param minuto Minuto
	 * @return data atualizada
	 */
	public static Date ajustarDataParaMinuto(Date data, int minuto) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.MINUTE, minuto);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta os segundos da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param segundos Segundos
	 * @return data atualizada
	 */
	public static Date ajustarDataParaSegundos(Date data, int segundos) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.SECOND, segundos);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta o dia da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param dia Dia
	 * @return data atualizada
	 */
	public static Date ajustarDataParaDia(Date data, int dia) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.DAY_OF_MONTH, dia);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta o mês da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param mes Dia
	 * @return data atualizada
	 */
	public static Date ajustarDataParaMes(Date data, int mes) {
		if (isReferencia(data)) {
			mes = UtilSubtratoresDeNumero.subtrair(mes, 1);

			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.MONTH, mes);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta o ano da data.
	 * 
	 * @param data Data que será atualizada.
	 * @param ano Ano
	 * @return data atualizada
	 */
	public static Date ajustarDataParaAno(Date data, int ano) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.set(Calendar.YEAR, ano);
			data = calendar.getTime();
		}
		return data;
	}

	/**
	 * Ajusta os milisegundos de uma data.
	 * 
	 * @param data Data que será atualizada.
	 * @param milisegundos Milisegundos
	 * @return data atualizada
	 */
	public static Timestamp ajustarDataParaMilisegundo(Date data,
			int milisegundos) {
		Timestamp ts = getDataFactory().novoTimestamp();
		ts.setTime(data.getTime());
		if (isReferencia(data)) {
			ts.setNanos(milisegundos);
		}
		return ts;
	}

	/**
	 * Ajusta o timezone para o identificador determinado.
	 * 
	 * @param identificador Identificador do timezone. Ex: GMT-3:00
	 */
	public static void ajustarTimeZone(String identificador) {
		TimeZone timeZone = getDataFactory().novoTimeZone(identificador);
		TimeZone.setDefault(timeZone);
	}

	/**
	 * Retorna nova data nula.
	 * 
	 * @return data nula.
	 */
	public static Date getDataNula() {
		int dia = Data.getPrimeiroDiaDoMesDefault();
		int mes = Data.getPrimeiroMesDefault();
		int ano = Data.getPrimeiroAnoDefault();

		return getDataFactory().novoDate(dia, mes, ano);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna novo novo calendar.
	 * 
	 * @param data Data que será usada para criar o calendar.
	 * @return novo calendar.
	 */
	private static Calendar novoCalendar(Date data) {
		return getDataFactory().novoCalendar(data);
	}

	/**
	 * @return instância de DataFactory.
	 */
	private static DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
