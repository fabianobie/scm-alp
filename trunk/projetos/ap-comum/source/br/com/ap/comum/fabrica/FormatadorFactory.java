/*
 * FormatadorFactory.java
 * 
 * Data de cria��o: 05/09/2007
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
 * F�brica de formatadores de inst�ncia.<br>
 * Padr�o factory method e singleton.
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
	 * Retorna inst�ncia da classe.
	 * 
	 * @return inst�ncia da classe.
	 */
	public static FormatadorFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna nova inst�ncia do formatador de boleano.
	 * 
	 * @return formatador
	 */
	public IFormatador<Boolean> novoFormatadorDeBoolean() {
		return new FormatadorDeBoolean();
	}

	/**
	 * Retorna nova inst�ncia do formatador de byte.
	 * 
	 * @return formatador
	 */
	public IFormatador<Byte> novoFormatadorDeByte() {
		return new FormatadorDeByte();
	}

	/**
	 * Retorna nova inst�ncia do formatador de byte array.
	 * 
	 * @return formatador
	 */
	public IFormatador<Byte[]> novoFormatadorDeByteArray() {
		return new FormatadorDeByteArray();
	}

	/**
	 * Retorna nova inst�ncia do formatador de caracter.
	 * 
	 * @return formatador
	 */
	public IFormatador<Character> novoFormatadorDeCharacter() {
		return new FormatadorDeCharacter();
	}

	/**
	 * Retorna nova inst�ncia do formatador de data no padr�o.
	 * 
	 * @return formatador
	 */
	public IFormatador<Date> novoFormatadorDeDataParaPadrao() {
		return new FormatadorDeDataParaPadrao();
	}

	/**
	 * Retorna nova inst�ncia do formatador de double.
	 * 
	 * @return formatador
	 */
	public IFormatador<Double> novoFormatadorDeDouble() {
		return new FormatadorDeDouble();
	}

	/**
	 * Retorna nova inst�ncia do formatador de double para monet�rio.
	 * 
	 * @return formatador
	 */
	public IFormatador<Double> novoFormatadorDeDoubleParaMonetario() {
		return new FormatadorDeDoubleParaMonetario();
	}

	/**
	 * Retorna nova inst�ncia do formatador de float.
	 * 
	 * @return formatador
	 */
	public IFormatador<Float> novoFormatadorDeFloat() {
		return new FormatadorDeFloat();
	}

	/**
	 * Retorna nova inst�ncia do formatador de inteiro.
	 * 
	 * @return formatador
	 */
	public IFormatador<Integer> novoFormatadorDeInteger() {
		return new FormatadorDeInteger();
	}

	/**
	 * Retorna nova inst�ncia do formatador de long.
	 * 
	 * @return formatador
	 */
	public IFormatador<Long> novoFormatadorDeLong() {
		return new FormatadorDeLong();
	}

	/**
	 * Retorna nova inst�ncia do formatador de reader.
	 * 
	 * @return formatador
	 */
	public IFormatador<Reader> novoFormatadorDeReader() {
		return new FormatadorDeReader();
	}

	/**
	 * Retorna nova inst�ncia do formatador de short.
	 * 
	 * @return formatador
	 */
	public IFormatador<Short> novoFormatadorDeShort() {
		return new FormatadorDeShort();
	}

	/**
	 * Retorna nova inst�ncia do formatador de string.
	 * 
	 * @return formatador
	 */
	public IFormatador<String> novoFormatadorDeString() {
		return new FormatadorDeString();
	}

	/**
	 * Retorna nova inst�ncia do formatador de hora.
	 * 
	 * @return formatador
	 */
	public IFormatador<Time> novoFormatadorDeTime() {
		return new FormatadorDeTime();
	}

	/**
	 * Retorna nova inst�ncia do formatador de timestamp.
	 * 
	 * @return formatador
	 */
	public IFormatador<Timestamp> novoFormatadorDeTimestamp() {
		return new FormatadorDeTimestamp();
	}
}
