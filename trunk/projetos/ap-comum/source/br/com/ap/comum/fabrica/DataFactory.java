/*
 * DataFactory.java
 * 
 * Data de cria��o: 20/02/2007
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
 * F�brica de objetos do tipo Date.<br>
 * Padr�o factory method e singleton.
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
	 * Retorna inst�ncia da classe.
	 * 
	 * @return inst�ncia da classe.
	 */
	public static DataFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna inst�ncia de Calendar.
	 * 
	 * @return inst�ncia de Calendar
	 */
	public Calendar novoCalendar() {
		return Calendar.getInstance(novoLocaleBrasil());
	}

	/**
	 * Retorna inst�ncia de Calendar.
	 * 
	 * @param data Data
	 * @return inst�ncia de Calendar
	 */
	public Calendar novoCalendar(Date data) {
		Calendar calendar = novoCalendar();

		if (UtilObjeto.isReferencia(data)) {
			calendar.setTime(data);
		}

		return calendar;
	}

	/**
	 * Retorna a inst�ncia de Calendar.
	 * 
	 * @param _long time em milis.
	 * @return inst�ncia de Calendar.
	 */
	public Calendar novoCalendar(long _long) {
		Calendar calendar = novoCalendar();
		calendar.setTimeInMillis(_long);
		return calendar;
	}

	/**
	 * Retorna inst�ncia de Calendar.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @return inst�ncia de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia);
		return calendar;
	}

	/**
	 * Retorna inst�ncia de Calendar.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return inst�ncia de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano, int hora,
			int minuto) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia, hora, minuto);
		return calendar;
	}

	/**
	 * Retorna inst�ncia de Calendar.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return inst�ncia de Calendar
	 */
	public Calendar novoCalendar(int dia, int mes, int ano, int hora,
			int minuto, int segundo) {
		Calendar calendar = novoCalendar();
		calendar.set(ano, mes - 1, dia, hora, minuto, segundo);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * Retorna inst�ncia de Date.
	 * 
	 * @return inst�ncia de Date
	 */
	public Date novoDate() {
		return new Date();
	}

	/**
	 * Retorna a inst�ncia de Date.
	 * 
	 * @param _long time em milis.
	 * @return inst�ncia de date.
	 */
	public Date novoDate(long _long) {
		Date data = novoDate();
		data.setTime(_long);
		return data;
	}

	/**
	 * Retorna inst�ncia de Date.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @return inst�ncia de Date
	 */
	public Date novoDate(int dia, int mes, int ano) {
		return novoCalendar(dia, mes, ano).getTime();
	}

	/**
	 * Retorna inst�ncia de Date.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return inst�ncia de Date
	 */
	public Date novoDate(int dia, int mes, int ano, int hora, int minuto) {
		return novoCalendar(dia, mes, ano, hora, minuto).getTime();
	}

	/**
	 * Retorna inst�ncia de Date.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return inst�ncia de Date
	 */
	public Date novoDate(int dia, int mes, int ano, int hora, int minuto,
			int segundo) {
		return novoCalendar(dia, mes, ano, hora, minuto, segundo).getTime();
	}

	/**
	 * @param _long long dos milis.
	 * @return inst�ncia de java.sql.Date
	 */
	public java.sql.Date novoSqlDate(long _long) {
		return new java.sql.Date(_long);
	}

	/**
	 * Retorna novo objeto java.sql.Date.
	 * 
	 * @param dia Dia
	 * @param mes M�s
	 * @param ano Ano
	 * @return Objeto java.sql.Date
	 */
	public java.sql.Date novoSqlDate(int dia, int mes, int ano) {
		Date data = novoDate(dia, mes, ano);
		return novoSqlDate(data.getTime());
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @return inst�ncia de Timestamp
	 */
	public Timestamp novoTimestamp() {
		return new Timestamp(novoDate().getTime());
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @param _long time em milis.
	 * @return inst�ncia de Timestamp
	 */
	public Timestamp novoTimestamp(long _long) {
		return new Timestamp(_long);
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @return inst�ncia de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano) {
		Date date = novoDate(dia, mes, ano);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @return inst�ncia de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano, int hora,
			int minuto) {
		Date date = novoDate(dia, mes, ano, hora, minuto);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @return inst�ncia de Timestamp
	 */
	public Timestamp novoTimestamp(int dia, int mes, int ano, int hora,
			int minuto, int segundo) {
		Date date = novoDate(dia, mes, ano, hora, minuto, segundo);
		return new Timestamp(date.getTime());
	}

	/**
	 * Retorna inst�ncia de Timestamp.
	 * 
	 * @param dia dia
	 * @param mes m�s
	 * @param ano ano
	 * @param hora hora
	 * @param minuto minuto
	 * @param segundo segundo
	 * @param nanosegundo nonosegundo
	 * @return inst�ncia de Timestamp
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
	 * Retorna inst�ncia de Time.
	 * 
	 * @return inst�ncia de Time
	 */
	public Time novoTime() {
		return new Time(novoDate().getTime());
	}

	/**
	 * Retorna inst�ncia de Time.
	 * 
	 * @param _long time em milis.
	 * @return inst�ncia de Time
	 */
	public Time novoTime(long _long) {
		return new Time(_long);
	}

	/**
	 * Retorna inst�ncia de Time.
	 * 
	 * @param hora hora
	 * @param minuto minuto
	 * @return inst�ncia de Time
	 */
	public Time novoTime(int hora, int minuto) {
		int day = Data.getPrimeiroDiaDoMesDefault();
		int month = Data.getPrimeiroMesDefault();
		int year = Data.getPrimeiroAnoDefault();

		Date data = novoDate(day, month, year, hora, minuto, 0);
		return novoTime(data.getTime());
	}

	/**
	 * Retorna inst�ncia de Time.
	 * 
	 * @param hour hora
	 * @param minute minuto
	 * @param second segundo
	 * @return inst�ncia de Time
	 */
	public Time novoTime(int hour, int minute, int second) {
		int day = Data.getPrimeiroDiaDoMesDefault();
		int month = Data.getPrimeiroMesDefault();
		int year = Data.getPrimeiroAnoDefault();

		Date data = novoDate(day, month, year, hour, minute, second);
		return new Time(data.getTime());
	}

	/**
	 * Retorna a inst�ncia de um SimpleDateFormat.
	 * 
	 * @param pattern Pattern da formata��o.
	 * @return inst�ncia de um SimpleDateFormat
	 */
	public SimpleDateFormat novoSimpleDateFormat(String pattern) {
		return new SimpleDateFormat(pattern, novoLocaleBrasil());
	}

	/**
	 * Retorna a inst�ncia de um SimpleDateFormat.
	 * 
	 * @param pattern Pattern da formata��o.
	 * @param dateFormatSymbols DateFormatSymbols
	 * @return inst�ncia de um SimpleDateFormat
	 */
	public SimpleDateFormat novoSimpleDateFormat(String pattern,
			DateFormatSymbols dateFormatSymbols) {
		return new SimpleDateFormat(pattern, dateFormatSymbols);
	}

	/**
	 * Retorna novo timezone padr�o.
	 * 
	 * @return novo timezone padr�o
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
