/*
 * FormatadorDeInteger.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import br.com.ap.comum.excecao.FormatadorException;

/**
 * Formatador default de byte[].
 * 
 * @author adrianop
 */
public class FormatadorDeByteArray extends FormatadorAbstrato<Byte[]> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Byte[] objeto) throws FormatadorException {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto)) {
			byte[] bytes = converterParaPrimitivo(objeto);
			resultado = getStringFactory().novaString(bytes);
		}
		return resultado;
	}

	/**
	 * Converte um array de bytes(wrapper) para um array de bytes(primitivo)
	 * 
	 * @param valor Array de Bytes
	 * @return byte[]
	 */
	private byte[] converterParaPrimitivo(Byte[] valor) {
		byte[] bytes = new byte[valor.length];
		for (int indice = 0; indice < valor.length; indice++) {
			Byte _byte = valor[indice];
			bytes[indice] = _byte.byteValue();
		}
		return bytes;
	}
}
