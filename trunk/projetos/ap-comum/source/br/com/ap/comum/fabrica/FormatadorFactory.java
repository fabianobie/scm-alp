/*
 * FormatadorFactory.java
 * 
 * Data de criação: 05/09/2007
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.io.Reader;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.formatador.instancia.FormatadorDeBoolean;
import br.com.ap.comum.formatador.instancia.FormatadorDeByte;
import br.com.ap.comum.formatador.instancia.FormatadorDeByteArray;
import br.com.ap.comum.formatador.instancia.FormatadorDeCharacter;
import br.com.ap.comum.formatador.instancia.FormatadorDeDataParaPadrao;
import br.com.ap.comum.formatador.instancia.FormatadorDeDouble;
import br.com.ap.comum.formatador.instancia.FormatadorDeDoubleParaMonetario;
import br.com.ap.comum.formatador.instancia.FormatadorDeFloat;
import br.com.ap.comum.formatador.instancia.FormatadorDeInteger;
import br.com.ap.comum.formatador.instancia.FormatadorDeLong;
import br.com.ap.comum.formatador.instancia.FormatadorDeReader;
import br.com.ap.comum.formatador.instancia.FormatadorDeShort;
import br.com.ap.comum.formatador.instancia.FormatadorDeString;
import br.com.ap.comum.formatador.instancia.FormatadorDeTime;
import br.com.ap.comum.formatador.instancia.FormatadorDeTimestamp;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * Fábrica de formatadores de instância.<br>
 * Padrão factory method e singleton.
 * 
 * @author AdrianoP
 */
public final class FormatadorFactory extends FactoryAbstrata {
	private static FormatadorFactory	instancia	= new FormatadorFactory();

	/**
	 * Construtor.
	 */
	private FormatadorFactory() {
		// Construtor.
	}

	/**
	 * Retorna instância da classe.
	 * 
	 * @return instância da classe.
	 */
	public static FormatadorFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna nova instância do formatador de boleano.
	 * 
	 * @return formatador
	 */
	public IFormatador<Boolean> novoFormatadorDeBoolean() {
		return new FormatadorDeBoolean();
	}

	/**
	 * Retorna nova instância do formatador de byte.
	 * 
	 * @return formatador
	 */
	public IFormatador<Byte> novoFormatadorDeByte() {
		return new FormatadorDeByte();
	}

	/**
	 * Retorna nova instância do formatador de byte array.
	 * 
	 * @return formatador
	 */
	public IFormatador<Byte[]> novoFormatadorDeByteArray() {
		return new FormatadorDeByteArray();
	}

	/**
	 * Retorna nova instância do formatador de caracter.
	 * 
	 * @return formatador
	 */
	public IFormatador<Character> novoFormatadorDeCharacter() {
		return new FormatadorDeCharacter();
	}

	/**
	 * Retorna nova instância do formatador de data no padrão.
	 * 
	 * @return formatador
	 */
	public IFormatador<Date> novoFormatadorDeDataParaPadrao() {
		return new FormatadorDeDataParaPadrao();
	}

	/**
	 * Retorna nova instância do formatador de double.
	 * 
	 * @return formatador
	 */
	public IFormatador<Double> novoFormatadorDeDouble() {
		return new FormatadorDeDouble();
	}

	/**
	 * Retorna nova instância do formatador de double para monetário.
	 * 
	 * @return formatador
	 */
	public IFormatador<Double> novoFormatadorDeDoubleParaMonetario() {
		return new FormatadorDeDoubleParaMonetario();
	}

	/**
	 * Retorna nova instância do formatador de float.
	 * 
	 * @return formatador
	 */
	public IFormatador<Float> novoFormatadorDeFloat() {
		return new FormatadorDeFloat();
	}

	/**
	 * Retorna nova instância do formatador de inteiro.
	 * 
	 * @return formatador
	 */
	public IFormatador<Integer> novoFormatadorDeInteger() {
		return new FormatadorDeInteger();
	}

	/**
	 * Retorna nova instância do formatador de long.
	 * 
	 * @return formatador
	 */
	public IFormatador<Long> novoFormatadorDeLong() {
		return new FormatadorDeLong();
	}

	/**
	 * Retorna nova instância do formatador de reader.
	 * 
	 * @return formatador
	 */
	public IFormatador<Reader> novoFormatadorDeReader() {
		return new FormatadorDeReader();
	}

	/**
	 * Retorna nova instância do formatador de short.
	 * 
	 * @return formatador
	 */
	public IFormatador<Short> novoFormatadorDeShort() {
		return new FormatadorDeShort();
	}

	/**
	 * Retorna nova instância do formatador de string.
	 * 
	 * @return formatador
	 */
	public IFormatador<String> novoFormatadorDeString() {
		return new FormatadorDeString();
	}

	/**
	 * Retorna nova instância do formatador de hora.
	 * 
	 * @return formatador
	 */
	public IFormatador<Time> novoFormatadorDeTime() {
		return new FormatadorDeTime();
	}

	/**
	 * Retorna nova instância do formatador de timestamp.
	 * 
	 * @return formatador
	 */
	public IFormatador<Timestamp> novoFormatadorDeTimestamp() {
		return new FormatadorDeTimestamp();
	}
}
