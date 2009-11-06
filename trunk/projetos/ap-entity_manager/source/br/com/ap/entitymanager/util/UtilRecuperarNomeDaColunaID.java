/*
 * UtilRecuperarNomeDaColunaID.java
 * 
 * Data de criação: 25/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.util;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.reflexao.UtilReflexaoMetodo;

/**
 * Classe utilitária responsável pela recuperação do nome da coluna marcada com
 * a anotação ID.
 * 
 * @author adrianop
 */
public final class UtilRecuperarNomeDaColunaID {
	private static Map<Class<?>, List<Field>>	mapaDeAtributos;

	/**
	 * Construtor.
	 */
	private UtilRecuperarNomeDaColunaID() {
		// Construtor.
	}

	/**
	 * Retorna o nome da coluna PK da entidade.
	 * 
	 * @param classe
	 *            Classe da entidade.
	 * @return Nome da coluna PK da entidade.
	 */
	public static String get(Class<?> classe) {
		String nome = null;
		List<Field> atributos = getAtributos(classe);
		for (int indice = 0; indice < atributos.size() && nome == null; indice++) {
			Field atributo = atributos.get(indice);
			nome = recuperarNomeDoCampoPeloAtributo(nome, classe, atributo);
			nome = recuperarNomeDoCampoPeloMetodo(nome, classe, atributo);
		}
		return nome;
	}

	/**
	 * Retorna o nome do campo pelo atributo, caso a anotação esteja no atributo
	 * da classe.
	 * 
	 * @param nome
	 *            Nome do campo.
	 * @param classe
	 *            Classe.
	 * @param atributo
	 *            Atributo.
	 * @return nome do campo pelo atributo.
	 */
	private static String recuperarNomeDoCampoPeloAtributo(String nome,
			Class<?> classe, Field atributo) {

		if (UtilString.isVazio(nome) && isId(atributo)) {
			nome = atributo.getName();
		}
		return nome;
	}

	/**
	 * Retorna o nome do campo pelo método, caso a anotação esteja no método
	 * GET.
	 * 
	 * @param nome
	 *            Nome do campo.
	 * @param classe
	 *            Classe.
	 * @param atributo
	 *            Atributo.
	 * @return nome do campo pelo método.
	 */
	private static String recuperarNomeDoCampoPeloMetodo(String nome,
			Class<?> classe, Field atributo) {

		if (UtilString.isVazio(nome)) {
			String nomeDoAtributo = atributo.getName();
			Method metodo = UtilReflexaoMetodo.getMetodoGet(classe,
					nomeDoAtributo);

			if (UtilObjeto.isReferencia(metodo) && isId(metodo)) {
				nome = metodo.getName();
				nome = UtilString.getNomeDoAtributo(nome);
			}
		}
		return nome;
	}

	private static boolean isId(AnnotatedElement elemento) {
		return UtilObjeto.isReferencia(elemento.getAnnotation(Id.class));
	}

	/**
	 * Retorna os atributos da classe.
	 * 
	 * @param classe
	 *            Classe
	 * @return atributos da classe.
	 */
	private static List<Field> getAtributos(Class<?> classe) {
		List<Field> atributos = getMapaDeAtributos().get(classe);
		if (!UtilObjeto.isReferencia(atributos)) {
			Field[] metodosArray = classe.getDeclaredFields();
			atributos = Arrays.asList(metodosArray);
			getMapaDeAtributos().put(classe, atributos);
		}
		return atributos;
	}

	/**
	 * @return mapaDeAtributos
	 */
	private static Map<Class<?>, List<Field>> getMapaDeAtributos() {
		if (!UtilObjeto.isReferencia(mapaDeAtributos)) {
			mapaDeAtributos = getColecaoFactory().novoHashMap();
		}
		return mapaDeAtributos;
	}

	/**
	 * @return fábrica de coleção.
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
