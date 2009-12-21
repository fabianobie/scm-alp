/*
 * UtilString.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.string;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.ap.comum.constante.EL;
import br.com.ap.comum.constante.Metodo;
import br.com.ap.comum.constante.pattern.PatternDeNumero;
import br.com.ap.comum.constante.pattern.PatternDeString;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe utilitária responsável em manipular strings.
 * 
 * @author adrianop
 */
public final class UtilString {

	/**
	 * Construtor.
	 */
	private UtilString() {
		// Construtor
	}

	/**
	 * Retorna true se a string estiver vazia.
	 * 
	 * @param string String
	 * @return true se a string estiver vazia
	 */
	public static boolean isVazio(String string) {
		return (!UtilObjeto.isReferencia(string) || string.trim().equals(""));
	}

	/**
	 * Retorna true se alguma string tiver vazia.
	 * 
	 * @param string1 String
	 * @param string2 String
	 * @return true se alguma string tiver vazia.
	 */
	public static boolean isVazio(String string1, String string2) {
		return (isVazio(string1) || isVazio(string2));
	}

	/**
	 * Retorna true se alguma string tiver vazia.
	 * 
	 * @param string1 String
	 * @param string2 String
	 * @param string3 String
	 * @return true se alguma string tiver vazia.
	 */
	public static boolean isVazio(String string1, String string2, String string3) {
		return (isVazio(string1, string2) || isVazio(string3));
	}

	/**
	 * Retorna true se alguma string tiver vazia.
	 * 
	 * @param strings Strings
	 * @return true se alguma string tiver vazia.
	 */
	public static boolean isVazioTodos(String... strings) {
		boolean res = true;

		if (UtilObjeto.isReferencia(strings)) {
			res = false;
			for (int idx = 0; idx < strings.length && (res == false); idx++) {
				res = isVazio(strings[idx]);
			}
		}
		return res;
	}

	/**
	 * Retorna string em maiúsculo.
	 * 
	 * @param string String
	 * @return string em maiúsculo.
	 */
	public static String maiuscula(String string) {

		if (!isVazio(string)) {
			string = string.toUpperCase();
		}
		return string;
	}

	/**
	 * Retorna string em maiúsculo.
	 * 
	 * @param string String
	 * @return string em maiúsculo.
	 */
	public static String maiuscula(char string) {
		return maiuscula(String.valueOf(string));
	}

	/**
	 * Retorna string em minúsculo.
	 * 
	 * @param string String
	 * @return string em minúsculo.
	 */
	public static String minuscula(String string) {

		if (!isVazio(string)) {
			string = string.toLowerCase();
		}
		return string;
	}

	/**
	 * Retorna string em minúsculo.
	 * 
	 * @param string String
	 * @return string em minúsculo.
	 */
	public static String minuscula(char string) {
		return minuscula(String.valueOf(string));
	}

	/**
	 * Altera a string definida por parâmetro.
	 * 
	 * @param srcString String que será modificada.
	 * @param localizar String que será pesquisada.
	 * @param novaString String substituta.
	 * @return nova string com as devidas alterações.
	 */
	public static String substituirString(String srcString, String localizar,
			String novaString) {

		if (!isVazio(srcString, localizar)) {
			srcString = srcString.replaceAll(localizar, novaString);
		}
		return srcString;
	}

	/**
	 * Altera a string com base na condição passada por parâmetro.
	 * 
	 * @param condicao Condição
	 * @param srcString String que será modificada.
	 * @param localizar String que será pesquisada.
	 * @param seVerdadeiro String substituta caso a condição seja true.
	 * @param seFalso String substituta caso a condição seja false.
	 * @return nova string com as devidas alterações.
	 */
	public static String substituirStringSe(boolean condicao, String srcString,
			String localizar, String seVerdadeiro, String seFalso) {
		if (condicao) {
			srcString = UtilString.substituirString(srcString, localizar,
					seVerdadeiro);
		} else {
			srcString = UtilString.substituirString(srcString, localizar,
					seFalso);
		}

		return srcString;
	}

	/**
	 * Remove a string definida por parâmetro.
	 * 
	 * @param srcString String que será modificada.
	 * @param localizar String que será removida.
	 * @return nova string com as devidas alterações.
	 */
	public static String remover(String srcString, String localizar) {
		if (!isVazio(srcString, localizar)) {
			srcString = srcString.replaceAll(localizar, "");
		}
		return srcString;
	}

	/**
	 * Quebra a string pelo delimitador definido e retorna uma coleção com os
	 * tokens.
	 * 
	 * @param string String que será quebrada.
	 * @param separador String separadora.
	 * @return List de strings.
	 */
	public static List<String> split(String string, String separador) {
		List<String> result = getColecaoFactory().novoArrayList();

		if (!isVazio(string, separador)) {
			StringTokenizer st = new StringTokenizer(string, separador);
			while (st.hasMoreTokens()) {
				result.add(st.nextToken());
			}
		}
		return result;
	}

	/**
	 * Quebra a string pelo tamanho do bloco definido e retorna uma coleção com
	 * os tokens.
	 * 
	 * @param string String que será quebrada.
	 * @param tamanho Tamanho do bloco que representa um registro
	 * @return List de strings.
	 */
	public static List<String> split(String string, int tamanho) {
		List<String> result = getColecaoFactory().novoArrayList();

		if (!isVazio(string)) {
			tamanho = (tamanho != 0 ? tamanho : 1);
			int inicio = 0;
			int fim = inicio + tamanho;

			while (inicio < string.length()) {
				result.add(substring(string, inicio, fim));
				inicio = fim;
				fim += tamanho;
			}
		}
		return result;
	}

	/**
	 * Verifica a existência de uma string.
	 * 
	 * @param srcString String que será validada.
	 * @param localizar String que será pesquisada.
	 * @return true se a string existir.
	 */
	public static boolean isTemString(String srcString, String localizar) {
		boolean result = false;

		if (!isVazio(srcString, localizar)) {
			result = srcString.indexOf(localizar) != -1;
		}
		return result;
	}

	/**
	 * Retorna true se a string estiver no tamanho definido.
	 * 
	 * @param string String validada.
	 * @param tamanho tamanho verificado.
	 * @return true se a string estiver no tamanho definido.
	 */
	public static boolean isNoTamanho(String string, int tamanho) {
		boolean res = false;

		if (!isVazio(string)) {
			res = string.length() == tamanho;
		}
		return res;
	}

	/**
	 * Repete a string a quantidade de vezes definida.
	 * 
	 * @param string String que será repetida.
	 * @param quantidade Quantidade de repetições.
	 * @return nova string.
	 */
	public static String repetir(String string, int quantidade) {
		StringBuffer result = new StringBuffer();

		if (!isVazio(string)) {
			while (quantidade > 0) {
				result.append(string);
				quantidade--;
			}
		}
		return result.toString();
	}

	/**
	 * Completa a string com a novaString definida à esquerda até o tamanho
	 * também definido.
	 * 
	 * @param srcString String que será alterada.
	 * @param novaString String que será repetida.
	 * @param tamanho Tamanho final da string.
	 * @return string alterada.
	 */
	public static String completarAEsquerda(String srcString,
			String novaString, int tamanho) {
		StringBuilder result = getStringFactory().novoStringBuilder();
		result.append(converterParaVazio(srcString));

		if (UtilObjeto.isReferencia(novaString)) {
			tamanho = (tamanho - result.length());
			result.insert(0, repetir(novaString, tamanho));
		}
		return result.toString();
	}

	/**
	 * Completa a string com a novaString definida à direita até o tamanho
	 * também definido.
	 * 
	 * @param srcString String que será alterada.
	 * @param novaString String que será repetida.
	 * @param tamanho Quantidade de repetições.
	 * @return string alterada.
	 */
	public static String completarADireita(String srcString, String novaString,
			int tamanho) {
		StringBuilder result = getStringFactory().novoStringBuilder();
		result.append(converterParaVazio(srcString));

		if (UtilObjeto.isReferencia(novaString)) {
			tamanho = (tamanho - result.length());
			result.insert(result.length(), repetir(novaString, tamanho));
		}
		return result.toString();
	}

	/**
	 * Remove os caracteres de uma string.
	 * 
	 * @param string string
	 * @return string sem caracteres.
	 */
	public static String removerCaracteres(String string) {

		if (!isVazio(string)) {
			string = remover(string, PatternDeString.getPattern());
		}
		return string;
	}

	/**
	 * Remove a acentuação de uma string.
	 * 
	 * @param string string
	 * @return string sem acentos.
	 */
	public static String removerAcentuacao(String string) {

		if (!isVazio(string)) {
			string = substituirString(string, "[ÁÀÂÃ]", "A");
			string = substituirString(string, "[áàâãª]", "a");
			string = substituirString(string, "[ÉÈÊ]", "E");
			string = substituirString(string, "[éèê]", "e");
			string = substituirString(string, "[ÍÌÎÏ]", "I");
			string = substituirString(string, "[íìîï]", "i");
			string = substituirString(string, "[ÓÒÔÕÖ]", "O");
			string = substituirString(string, "[óòôõºö]", "o");
			string = substituirString(string, "[ÚÙÛÜ]", "U");
			string = substituirString(string, "[úùûü]", "u");
			string = substituirString(string, "[Ç]", "C");
			string = substituirString(string, "[ç]", "c");
			string = substituirString(string, "[~\\d^´`]", "");
			string = substituirString(string, "[\\d¨]", "");
		}
		return string;
	}

	/**
	 * Remove os números de uma string.
	 * 
	 * @param string string
	 * @return string sem números.
	 */
	public static String removerNumeros(String string) {

		if (!isVazio(string)) {
			string = remover(string, PatternDeNumero.getInteger());
		}
		return string;
	}

	/**
	 * Remove o sufixo da string.
	 * 
	 * @param srcString String que será modificada.
	 * @param sufixo Sufixo que será removido.
	 * @return string alterada.
	 */
	public static String removerSufixo(String srcString, String sufixo) {
		if (!isVazio(srcString, sufixo) && srcString.endsWith(sufixo)) {
			int tamanho = srcString.length() - sufixo.length();
			srcString = substring(srcString, 0, tamanho);
		}
		return srcString;
	}

	/**
	 * Remove o prefixo da string.
	 * 
	 * @param srcString String que será modificada.
	 * @param prefixo Prefixo que será removido.
	 * @return string alterada.
	 */
	public static String removerPrefixo(String srcString, String prefixo) {
		if (!isVazio(srcString, prefixo)) {
			while (srcString.startsWith(prefixo)) {
				srcString = substring(srcString, 1);
			}
		}
		return srcString;
	}

	/**
	 * Remove os espaços da string.
	 * 
	 * @param string string
	 * @return string sem espaços.
	 */
	public static String trim(String string) {
		if (UtilObjeto.isReferencia(string)) {
			string = string.trim();
		}
		return string;
	}

	/**
	 * Substring da string passada por parâmetro.
	 * 
	 * @param string String
	 * @param inicio Índice inicial
	 * @return substring
	 */
	public static String substring(String string, int inicio) {
		if (!isVazio(string) && string.length() > inicio) {
			string = string.substring(inicio);
		}
		return string;
	}

	/**
	 * Substring da string passada por parâmetro.
	 * 
	 * @param string String
	 * @param inicio Índice inicial
	 * @param fim Índice final
	 * @return substring
	 */
	public static String substring(String string, int inicio, int fim) {
		if (!isVazio(string) && string.length() > inicio) {
			if (fim < inicio) {
				fim = inicio;
			}

			if (fim > string.length()) {
				fim = string.length();
			}

			string = string.substring(inicio, fim);
		}
		return string;
	}

	/**
	 * Retorna o nome do método com o prefixo definido.
	 * 
	 * @param prefix prefixo
	 * @param atributo nome do atributo
	 * @return nome do método.
	 */
	public static String getNomeMetodo(String prefix, String atributo) {
		StringBuilder nome = getStringFactory().novoStringBuilder();
		if (!isVazio(prefix, atributo) && atributo.length() > 1) {
			if (!atributo.startsWith(prefix)) {
				nome.append(prefix);
				nome.append(atributo.substring(0, 1).toUpperCase());
				nome.append(atributo.substring(1));
			} else {
				nome.append(atributo);
			}
		}
		return nome.toString();
	}

	/**
	 * Retorna o nome do atributo com base no nome do método.
	 * 
	 * @param nomeDoMetodo Nome do método. Ex: getMatricula
	 * @return nome do atributo.
	 */
	public static String getNomeDoAtributo(String nomeDoMetodo) {
		StringBuffer atributo = new StringBuffer();

		if (!isVazio(nomeDoMetodo)) {
			String get = Metodo.getPrefixoGet();
			String set = Metodo.getPrefixoSet();
			String is = Metodo.getPrefixoIs();

			int inicio = 0;
			if (nomeDoMetodo.startsWith(get) || nomeDoMetodo.startsWith(set)) {
				inicio = 3;
			}
			if (nomeDoMetodo.startsWith(is)) {
				inicio = 2;
			}
			atributo.append(nomeDoMetodo);
			atributo.delete(0, inicio);
			atributo.replace(0, 1, minuscula(atributo.charAt(0)));
		}
		return atributo.toString();
	}

	/**
	 * Retorna a quantidade de caracteres solicitados.
	 * 
	 * @param string String que será percorrida e verificada a quantidade de
	 *        caracteres.
	 * @param caracter Caracter que será contado.
	 * @return quantidade de caracteres.
	 */
	public static int getQuantidadeDeCaracteres(String string, char caracter) {
		int quantidade = 0;

		if (!isVazio(string)) {
			for (int indice = 0; indice < string.length(); indice++) {
				if (string.charAt(indice) == caracter) {
					quantidade++;
				}
			}
		}
		return quantidade;
	}

	/**
	 * Retorna a string do objeto solicitado. Será invocado o método toString.
	 * 
	 * @param objeto Objeto solicitado
	 * @return string do objeto.
	 */
	public static String getString(Object objeto) {
		String resultado = null;

		if (UtilObjeto.isReferencia(objeto)) {
			resultado = objeto.toString();
		}
		return resultado;
	}

	/**
	 * Retorna o array de bytes da string.
	 * 
	 * @param string String que será convertida.
	 * @return array de bytes.
	 */
	public static byte[] getBytes(String string) {
		byte[] bytes = null;

		if (!isVazio(string)) {
			bytes = string.getBytes();
		}

		return bytes;
	}

	/**
	 * Retorna um Reader da String.
	 * 
	 * @param string String que será convertida.
	 * @return Reader
	 */
	public static Reader getReader(String string) {
		Reader reader = null;

		if (!isVazio(string)) {
			reader = new StringReader(string);
		}
		return reader;
	}

	/**
	 * Retorna true se existir somente letras.
	 * 
	 * @param string String validada
	 * @return true se existir somente letras.
	 */
	public static boolean isSomenteLetras(String string) {
		boolean res = false;

		if (!isVazio(string)) {
			String p = PatternDeString.getStringEmTodosOsCaracteres();
			res = Pattern.matches(p, string);
		}
		return res;
	}

	/**
	 * Retorna o tamanho da string.
	 * 
	 * @param string String que será lida e verificada o seu tamanho
	 * @return tamanho da string.
	 */
	public static int getTamanho(String string) {
		int tamanho = 0;

		if (!isVazio(string)) {
			tamanho = string.length();
		}
		return tamanho;
	}

	/**
	 * Retorna true se as duas strings forem iguais.
	 * 
	 * @param string0 String validada
	 * @param string1 String validada
	 * @return booleano
	 */
	public static boolean isStringsIguais(String string0, String string1) {
		boolean resultado = false;

		if (!isVazio(string0, string1)) {
			resultado = string0.equals(string1);
		}
		return resultado;
	}

	/**
	 * Retorna o índice da primeira letra maiúscula da string.
	 * 
	 * @param string String que será persquisada.
	 * @return índice da primeira letra maiúscula.
	 */
	public static int getPrimeiraMaiuscula(String string) {
		int resultado = -1;

		if (!isVazio(string)) {
			Pattern pattern = Pattern.compile(EL.getLetraMaiuscula());
			Matcher matcher = pattern.matcher(string);
			if (matcher.find()) {
				resultado = matcher.start();
			}
		}
		return resultado;
	}

	/**
	 * Retorna true se as duas strings forem iguais (ignorando
	 * maiúscula/minúscula).
	 * 
	 * @param string0 String validada
	 * @param string1 String validada
	 * @return booleano
	 */
	public static boolean isStringsIguaisIgnoreCase(String string0,
			String string1) {
		boolean resultado = false;

		if (!isVazio(string0, string1)) {
			resultado = string0.equalsIgnoreCase(string1);
		}
		return resultado;
	}

	/**
	 * Retorna a string pluralizada, ex: casa retorna casas.
	 * 
	 * @param singular String que será pluralizada.
	 * @return string pluralizada.
	 */
	public static String pluralizar(String singular) {

		if (!isVazio(singular)) {
			char letra = singular.charAt(singular.length() - 1);
			switch (letra) {
			case 'x':
			case 's':
				singular += "es";
				break;
			case 'y':
				singular = singular.substring(0, singular.length() - 1) + "ies";
				break;
			default:
				singular += "s";
			}
		}
		return singular;
	}

	/**
	 * Retorna uma string no padrão java, as strings com separadores do tipo
	 * "_", " " ou "-" serão transformadas para o padrão java.<br/>
	 * Ex: produto_final = ProdutoFinal
	 * 
	 * @param string String que será transformada.
	 * 
	 * @return String no padrão Java.
	 */
	public static String padraoJava(String string) {
		if (!isVazio(string)) {
			List<String> capitalizaveis = split("_ -", 1);
			StringBuffer resultado = getStringFactory().novoStringBuffer();

			boolean capitalizar = true;
			for (int indice = 0; indice < string.length(); indice++) {
				String letra = String.valueOf(string.charAt(indice));
				if (capitalizaveis.contains(letra)) {
					capitalizar = true;
					continue;
				}

				if (capitalizar) {
					resultado.append(maiuscula(letra));
				} else {
					resultado.append(minuscula(letra));
				}
				capitalizar = false;

			}
			string = resultado.toString();
		}
		return string;

	}

	/**
	 * Retorna a string passada por parâmetro, se a string for nula será
	 * retonrado vazio.
	 * 
	 * @param string String
	 * @return String.
	 */
	private static String converterParaVazio(String string) {
		return (UtilObjeto.isReferencia(string) ? string : "");
	}

	/**
	 * @return instância de ColecaoFactory.
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * @return instância da fábrica de string
	 */
	private static StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

}
