/*
 * NumeroFactory.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.conversor.UtilConversorDeDouble;

/**
 * Fábrica de objetos usados para manipulação de números.<br>
 * Padrão Factory Method e Singleton.
 * 
 * @author AdrianoP
 */
public final class NumeroFactory extends FactoryAbstrata {

	private static NumeroFactory	instancia	= new NumeroFactory();

	/**
	 * Construtor.
	 */
	private NumeroFactory() {
		// Construtor.
	}

	/**
	 * @return instância da classe.
	 */
	public static NumeroFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna instância de NumberFormat.
	 * 
	 * @return instância de NumberFormat.
	 */
	public NumberFormat novoNumberFormat() {
		return NumberFormat.getInstance(novoLocaleBrasil());
	}

	/**
	 * Retorna instância de DecimalFormat.
	 * 
	 * @return instância de DecimalFormat.
	 */
	public DecimalFormat novoDecimalFormat() {
		int qtd = Constante.getQuantidadeMinimaDeCasasDecimais();

		DecimalFormat df = null;
		df = (DecimalFormat) NumberFormat.getInstance(novoLocaleBrasil());
		df.setMinimumFractionDigits(qtd);
		return df;
	}

	/**
	 * Retorna instância de DecimalFormat.
	 * 
	 * @param qtdCasasDecimais Quantidade de casas decimais.
	 * @return instância de DecimalFormat.
	 */
	public DecimalFormat novoDecimalFormat(int qtdCasasDecimais) {
		DecimalFormat df = novoDecimalFormat();
		df.setMinimumFractionDigits(qtdCasasDecimais);
		df.setMaximumFractionDigits(qtdCasasDecimais);
		return df;
	}

	/**
	 * Retorna novo integer.
	 * 
	 * @param valor int
	 * @return novo integer.
	 */
	public Integer novoInteger(int valor) {
		return new Integer(valor);
	}

	/**
	 * Retorna novo integer.
	 * 
	 * @param valor String
	 * @return novo integer.
	 */
	public Integer novoInteger(String valor) {
		return new Integer(valor);
	}

	/**
	 * Retorna novo Long.
	 * 
	 * @param valor long
	 * @return novo Long.
	 */
	public Long novoLong(long valor) {
		return new Long(valor);
	}

	/**
	 * Retorna novo Long.
	 * 
	 * @param valor String
	 * @return novo Long.
	 */
	public Long novoLong(String valor) {
		return new Long(valor);
	}

	/**
	 * Retorna novo Short.
	 * 
	 * @param valor short
	 * @return novo Short.
	 */
	public Short novoShort(short valor) {
		return new Short(valor);
	}

	/**
	 * Retorna novo Short.
	 * 
	 * @param valor String
	 * @return novo Short.
	 */
	public Short novoShort(String valor) {
		return new Short(valor);
	}

	/**
	 * Retorna novo Float.
	 * 
	 * @param valor float
	 * @return novo Float.
	 */
	public Float novoFloat(float valor) {
		return new Float(valor);
	}

	/**
	 * Retorna novo Float.
	 * 
	 * @param valor String
	 * @return novo Float.
	 */
	public Float novoFloat(String valor) {
		return new Float(valor);
	}

	/**
	 * Retorna novo Double.
	 * 
	 * @param valor double
	 * @return novo Double.
	 */
	public Double novoDouble(double valor) {
		return new Double(valor);
	}

	/**
	 * Retorna novo BigInteger.
	 * 
	 * @param valor Valor do BigInteger
	 * @return novo BigInteger.
	 */
	public BigInteger novoBigInteger(String valor) {
		return new BigInteger(valor);
	}

	/**
	 * Retorna novo BigDecimal.
	 * 
	 * @param valor Valor
	 * @param precisao Precisão
	 * @return novo BigDecimal.
	 */
	public BigDecimal novoBigDecimal(String valor, int precisao) {
		return new BigDecimal(novoBigInteger(valor), precisao);
	}

	/**
	 * Retorna novo big decimal.
	 * 
	 * @param string String
	 * @return novo BigDecimal
	 */
	public BigDecimal novoBigDecimal(String string) {
		return new BigDecimal(string);
	}

	/**
	 * Retorna novo big decimal
	 * 
	 * @param _double double
	 * @return big decimal
	 */
	public BigDecimal novoBigDecimal(Double _double) {
		double d = UtilConversorDeDouble.converterParaPrimitivo(_double);
		return novoBigDecimal(d);
	}

	/**
	 * Retorna novo big decimal
	 * 
	 * @param _double double
	 * @return big decimal
	 */
	public BigDecimal novoBigDecimal(double _double) {
		return new BigDecimal(_double);
	}

	/**
	 * Retorna novo byte.
	 * 
	 * @param _byte byte
	 * @return byte
	 */
	public Byte novoByte(byte _byte) {
		return new Byte(_byte);
	}

	/**
	 * Retorna novo byte.
	 * 
	 * @param _byte byte
	 * @return byte
	 */
	public Byte novoByte(String _byte) {
		return new Byte(_byte);
	}

	/**
	 * @return novo Locale pt-BR.
	 * @see Constante#getLocaleBrasil()
	 */
	private Locale novoLocaleBrasil() {
		return Constante.getLocaleBrasil();
	}

}
