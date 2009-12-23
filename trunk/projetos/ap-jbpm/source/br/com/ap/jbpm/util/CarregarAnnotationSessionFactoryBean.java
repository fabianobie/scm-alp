/*
 * CarregarAnnotationSessionFactoryBean.java
 * 
 * Data de criação: 20/06/2008
 */

package br.com.ap.jbpm.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.List;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Carrega todas as entidades contidas no pacote informado.
 */
public class CarregarAnnotationSessionFactoryBean extends AnnotationSessionFactoryBean {

	private String[]	packages;

	/**
	 * Atribui o pacote que contem as entidades.
	 * 
	 * @param annotatedPackages Array contento o pacote
	 */
	@Override
	public void setAnnotatedPackages(String[] annotatedPackages) {
		packages = annotatedPackages;
		super.setAnnotatedPackages(annotatedPackages);
		setAnnotatedClasses(new Class[0]);
	}

	/**
	 * Atribui as classes anotadas
	 * 
	 * @param classes Classes
	 */
	@Override
	@SuppressWarnings( { "unchecked" })
	public void setAnnotatedClasses(Class[] classes) {
		List<Class> classesEntidades = getColecaoFactory().novoArrayList();

		for (int i = 0; i < packages.length; i++) {
			try {
				String packageName = packages[i];
				String[] classesEntidade = getClassesPorPacote(packageName);
				if (UtilObjeto.isReferencia(classesEntidade)) {
					for (String s : classesEntidade) {
						String nome = packageName + "." + s.substring(0, s.indexOf(".class"));
						classesEntidades.add(Class.forName(nome));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		super.setAnnotatedClasses(classesEntidades.toArray(new Class[0]));
	}

	/**
	 * Obtem as classes pelo pacote informado.
	 * 
	 * @param loader Class loader
	 * @param pack Pacote
	 * 
	 * @return Array com os nomes das classes
	 * @throws Exception Falha na operação
	 */
	private String[] getClassesPorPacote(String pack) throws Exception {
		String[] nomes = null;
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			URL resource = loader.getResource(pack.replace('.', '/'));
			if (resource != null) {
				File dir = new File(resource.toURI());
				nomes = dir.list(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".class");
					}
				});
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return nomes;
	}

	/**
	 * @return fábrica de coleção
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
