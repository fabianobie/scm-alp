/*
 * ConversorFactory.java
 * 
 * Data de criação: 17/10/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaDouble;
import br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaInteger;
import br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaLong;
import br.com.ap.comum.conversor.instancia.ConversorDeDoubleParaBigDecimal;
import br.com.ap.comum.conversor.instancia.ConversorDeSqlDateParaUtilDate;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaBigDecimalSemPrecisao;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaBoolean;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaByte;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaByteArray;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaCharacter;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaDate;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaDouble;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaFloat;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaInteger;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaLong;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaReader;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaShort;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaString;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaTime;
import br.com.ap.comum.conversor.instancia.ConversorDeStringParaTimestamp;
import br.com.ap.comum.conversor.instancia.ConversorDeTimeParaString_HHmm;
import br.com.ap.comum.conversor.instancia.ConversorDeTimestampParaUtilDate;
import br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaSqlDate;
import br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaStringNoPadrao;
import br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTime;
import br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTimestamp;
import br.com.ap.comum.conversor.instancia.IConversor;

/**
 * Fábrica de conversores de instância.
 * 
 * @author adrianop
 */
public final class ConversorFactory extends FactoryAbstrata {
	private static ConversorFactory	instancia	= new ConversorFactory();

	/**
	 * Construtor.
	 */
	private ConversorFactory() {
		// Construtor.
	}

	/**
	 * Retorna instância da classe.
	 * 
	 * @return instância da classe.
	 */
	public static ConversorFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo conversor de bigdecimal para double.
	 * 
	 * @return conversor
	 */
	public IConversor<BigDecimal, Double> novoConversorDeBigDecimalParaDouble() {
		return new ConversorDeBigDecimalParaDouble();
	}

	/**
	 * Retorna novo conversor de bigdecimal para integer.
	 * 
	 * @return conversor
	 */
	public IConversor<BigDecimal, Integer> novoConversorDeBigDecimalParaInteger() {
		return new ConversorDeBigDecimalParaInteger();
	}

	/**
	 * Retorna novo conversor de bigdecimal para long.
	 * 
	 * @return conversor
	 */
	public IConversor<BigDecimal, Long> novoConversorDeBigDecimalParaLong() {
		return new ConversorDeBigDecimalParaLong();
	}

	/**
	 * Retorna novo conversor de double para bigdecimal
	 * 
	 * @return conversor
	 */
	public IConversor<Double, BigDecimal> novoConversorDeDoubleParaBigDecimal() {
		return new ConversorDeDoubleParaBigDecimal();
	}

	/**
	 * Retorna novo conversor de sqldate para utildate.
	 * 
	 * @return conversor
	 */
	public IConversor<java.sql.Date, java.util.Date> novoConversorDeSqlDateParaUtilDate() {
		return new ConversorDeSqlDateParaUtilDate();
	}

	/**
	 * Retorna novo conversor de string para boolean.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Boolean> novoConversorDeStringParaBoolean() {
		return new ConversorDeStringParaBoolean();
	}

	/**
	 * Retorna novo conversor de string para byte.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Byte> novoConversorDeStringParaByte() {
		return new ConversorDeStringParaByte();
	}

	/**
	 * Retorna novo conversor de string para byte array.
	 * 
	 * @return conversor
	 */
	public IConversor<String, byte[]> novoConversorDeStringParaByteArray() {
		return new ConversorDeStringParaByteArray();
	}

	/**
	 * Retorna novo conversor de string para caracter.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Character> novoConversorDeStringParaCharacter() {
		return new ConversorDeStringParaCharacter();
	}

	/**
	 * Retorna novo conversor de string para date.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Date> novoConversorDeStringParaDate() {
		return new ConversorDeStringParaDate();
	}

	/**
	 * Retorna novo conversor de string para double.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Double> novoConversorDeStringParaDouble() {
		return new ConversorDeStringParaDouble();
	}

	/**
	 * Retorna novo conversor de string para float.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Float> novoConversorDeStringParaFloat() {
		return new ConversorDeStringParaFloat();
	}

	/**
	 * Retorna novo conversor de string para integer.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Integer> novoConversorDeStringParaInteger() {
		return new ConversorDeStringParaInteger();
	}

	/**
	 * Retorna novo conversor de string para long.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Long> novoConversorDeStringParaLong() {
		return new ConversorDeStringParaLong();
	}

	/**
	 * Retorna novo conversor de string para reader.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Reader> novoConversorDeStringParaReader() {
		return new ConversorDeStringParaReader();
	}

	/**
	 * Retorna novo conversor de string para short.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Short> novoConversorDeStringParaShort() {
		return new ConversorDeStringParaShort();
	}

	/**
	 * Retorna novo conversor de string para string.
	 * 
	 * @return conversor
	 */
	public IConversor<String, String> novoConversorDeStringParaString() {
		return new ConversorDeStringParaString();
	}

	/**
	 * Retorna novo conversor de string para time.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Time> novoConversorDeStringParaTime() {
		return new ConversorDeStringParaTime();
	}

	/**
	 * Retorna novo conversor de string para timestamp.
	 * 
	 * @return conversor
	 */
	public IConversor<String, Timestamp> novoConversorDeStringParaTimestamp() {
		return new ConversorDeStringParaTimestamp();
	}

	/**
	 * Retorna novo conversor de utildate para sqldate.
	 * 
	 * @return conversor
	 */
	public IConversor<java.util.Date, java.sql.Date> novoConversorDeUtilDateParaSqlDate() {
		return new ConversorDeUtilDateParaSqlDate();
	}

	/**
	 * Retorna novo conversor de utildate para string no padrão.
	 * 
	 * @return conversor
	 */
	public IConversor<Date, String> novoConversorDeUtilDateParaStringNoPadrao() {
		return new ConversorDeUtilDateParaStringNoPadrao();
	}

	/**
	 * Retorna novo conversor de utildate para time.
	 * 
	 * @return conversor
	 */
	public IConversor<Date, Time> novoConversorDeUtilDateParaTime() {
		return new ConversorDeUtilDateParaTime();
	}

	/**
	 * Retorna novo conversor de utildate para timestamp.
	 * 
	 * @return conversor
	 */
	public IConversor<Date, Timestamp> novoConversorDeUtilDateParaTimestamp() {
		return new ConversorDeUtilDateParaTimestamp();
	}

	/**
	 * Retorna novo conversor de timestamp para utilDate.
	 * 
	 * @return conversor
	 */
	public IConversor<Timestamp, Date> novoConversorDeTimestampParaUtilDate() {
		return new ConversorDeTimestampParaUtilDate();
	}

	/**
	 * Retorna novo conversor de time para String (HH:mm).
	 * 
	 * @return conversor
	 */
	public IConversor<Time, String> novoConversorDeTimeParaString_HHmm() {
		return new ConversorDeTimeParaString_HHmm();
	}

	/**
	 * Retorna novo conversor de string para bigdecimal sem precisão
	 * 
	 * @return conversor
	 */
	public IConversor<String, BigDecimal> novoConversorDeStringParaBigDecimalSemPrecisao() {
		return new ConversorDeStringParaBigDecimalSemPrecisao();
	}

}
