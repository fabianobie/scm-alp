/*
 * DataFactory.java
 * 
 * Data de criação: 20/02/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.constante.Data;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Fábrica de objetos do tipo Date.<br>
 * Padrão factory method e singleton.
 * 
 * @author AdrianoP
 */
public final class DataFactory extends FactoryAbstrata {

	private static DataFactory	instancia	= new DataFactory();

	/**
	 * Construtor.
	 */
	private DataFactory() {
		// Construtor.
	}

	/**
	 * Retorna instância da classe.
	 * 
	 * @return instância da classe.
	 */
	public static DataFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna instância de Calendar.
	 * 
	 * @return instância de Calendar
	 */
	public Calendar novoCalendar() {
		return Calendar.getInstance(novoLocaleBrasil());
	}

	/**
	 * Retorna instância de Calendar.
	 * 
	 * @param data Data
	 * @return instância de Calendar
	 */
	public Calendar novoCalendar(Date data) {
		Calendar calendar = novoCalendar();

		if (UtilObjeto.isReferencia(data)) {
			calendar.setTime(data);
		}

		return calendar;
	}

	/**
	 * Retorna a instância de Calendar.
	 * 
	 * @param _long time em milis.
	 * @return instância de Calendar.
	 */
	public Calendar novoCalendar(long _long) {
		Calendar calendar = novoCalendar();
		calendar.setTimeInMillis(_long);
		return calendar;
	}

	/**
	 * Retorna instância de Calendar.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @return instância de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia);
		return calendar;
	}

	/**
	 * Retorna instância de Calendar.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return instância de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano, int hora,
			int minuto) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia, hora, minuto);
		return calendar;
	}

	/**
	 * Retorna instância de Calendar.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return instância de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano, int hora,
			int minuto, int segundo) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia, hora, minuto, segundo);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * Retorna instância de Date.
	 * 
	 * @return instância de Date
	 */
	public Date novoDate() {
		return new Date();
	}

	/**
	 * Retorna a instância de Date.
	 * 
	 * @param _long time em milis.
	 * @return instância de date.
	 */
	public Date novoDate(long _long) {
		Date data = novoDate();
		data.setTime(_long);
		return data;
	}

	/**
	 * Retorna instância de Date.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @return instância de Date
	 */
	public Date novoDate(int dia, int mes, int ano) {
		return novoCalendar(dia, mes, ano).getTime();
	}

	/**
	 * Retorna instância de Date.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return instância de Date
	 */
	public Date novoDate(int dia, int mes, int ano, int hora, int minuto) {
		return novoCalendar(dia, mes, ano, hora, minuto).getTime();
	}

	/**
	 * Retorna instância de Date.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return instância de Date
	 */
	public Date novoDate(int dia, int mes, int ano, int hora, int minuto,
			int segundo) {
		return novoCalendar(dia, mes, ano, hora, minuto, segundo).getTime();
	}

	/**
	 * @param _long long dos milis.
	 * @return instância de java.sql.Date
	 */
	public java.sql.Date novoSqlDate(long _long) {
		return new java.sql.Date(_long);
	}

	/**
	 * Retorna novo objeto java.sql.Date.
	 * 
	 * @param dia Dia
	 * @param mes Mês
	 * @param ano Ano
	 * @return Objeto java.sql.Date
	 */
	public java.sql.Date novoSqlDate(int dia, int mes, int ano) {
		Date data = novoDate(dia, mes, ano);
		return novoSqlDate(data.getTime());
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp() {
		return new Timestamp(novoDate().getTime());
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @param _long time em milis.
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp(long _long) {
		return new Timestamp(_long);
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano) {
		Date date = novoDate(dia, mes, ano);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano, int hora,
			int minuto) {
		Date date = novoDate(dia, mes, ano, hora, minuto);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano, int hora,
			int minuto, int segundo) {
		Date date = novoDate(dia, mes, ano, hora, minuto, segundo);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna instância de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes mês
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @param nanosegundo nonosegundo
	 * @return instância de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano, int hora,
			int minuto, int segundo, int nanosegundo) {

		Date date = novoDate(dia, mes, ano, hora, minuto, segundo);

		Timestamp ts = novoTimestamp();
		ts.setTime(date.getTime());
		ts.setNanos(nanosegundo);

		return ts;
	}

	/**
	 * Retorna instância de Time.
	 * 
	 * @return instância de Time
	 */
	public Time novoTime() {
		return new Time(novoDate().getTime());
	}

	/**
	 * Retorna instância de Time.
	 * 
	 * @param _long time em milis.
	 * @return instância de Time
	 */
	public Time novoTime(long _long) {
		return new Time(_long);
	}

	/**
	 * Retorna instância de Time.
	 * 
	 * @param hora hora
	 * @param minuto minuto
	 * @return instância de Time
	 */
	public Time novoTime(int hora, int minuto) {
		int day = Data.getPrimeiroDiaDoMesDefault();
		int month = Data.getPrimeiroMesDefault();
		int year = Data.getPrimeiroAnoDefault();

		Date data = novoDate(day, month, year, hora, minuto, 0);
		return novoTime(data.getTime());
	}

	/**
	 * Retorna instância de Time.
	 * 
	 * @param hour hora
	 * @param minute minuto
	 * @param second segundo
	 * @return instância de Time
	 */
	public Time novoTime(int hour, int minute, int second) {
		int day = Data.getPrimeiroDiaDoMesDefault();
		int month = Data.getPrimeiroMesDefault();
		int year = Data.getPrimeiroAnoDefault();

		Date data = novoDate(day, month, year, hour, minute, second);
		return new Time(data.getTime());
	}

	/**
	 * Retorna a instância de um SimpleDateFormat.
	 * 
	 * @param pattern Pattern da formatação.
	 * @return instância de um SimpleDateFormat
	 */
	public SimpleDateFormat novoSimpleDateFormat(String pattern) {
		return new SimpleDateFormat(pattern, novoLocaleBrasil());
	}

	/**
	 * Retorna a instância de um SimpleDateFormat.
	 * 
	 * @param pattern Pattern da formatação.
	 * @param dateFormatSymbols DateFormatSymbols
	 * @return instância de um SimpleDateFormat
	 */
	public SimpleDateFormat novoSimpleDateFormat(String pattern,
			DateFormatSymbols dateFormatSymbols) {
		return new SimpleDateFormat(pattern, dateFormatSymbols);
	}

	/**
	 * Retorna novo timezone padrão.
	 * 
	 * @return novo timezone padrão
	 */
	public TimeZone novoTimeZonePadrao() {
		return TimeZone.getDefault();
	}

	/**
	 * Retorna novo timezone do identificador determinado.
	 * 
	 * @param identificador Identificador do timezone. Ex: GMT-3:00
	 * @return novo timezone solicitado
	 */
	public TimeZone novoTimeZone(String identificador) {
		return TimeZone.getTimeZone(identificador);
	}

	/**
	 * @return Locale pt-BR.
	 * @see Constante#getLocaleBrasil()
	 */
	private Locale novoLocaleBrasil() {
		return Constante.getLocaleBrasil();
	}

}
