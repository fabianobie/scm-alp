/*
 * CarregarAnnotationSessionFactoryBean.java
 * 
 * Data de criação: 20/06/2008
 */

package teste.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * Carrega todas as entidades contidas no pacote informado.
 */
public class CarregarAnnotationSessionFactoryBean extends AnnotationSessionFactoryBean {

	private String[] packages;

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
		List<Class> classesEntidades = new ArrayList<Class>();
		
		for (int i = 0; i < packages.length; i++) {
			try {
				String packageName = packages[i];
				String[] classesEntidade = getClassesPorPacote(this.getClass().getClassLoader(), packageName);
				if (classesEntidade != null) {
					for (String s : classesEntidade) {
						String nome = packageName + "." + s.substring(0, s.indexOf(".class"));
						try {
							classesEntidades.add(Class.forName(nome));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
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
	 * 
	 * @throws Exception Falha na operação
	 */
	private String[] getClassesPorPacote(ClassLoader loader, String pack) throws Exception {
		try {
			URL resource = loader.getResource(pack.replace('.', '/'));
			File dir = new File(resource.toURI());
			String[] nomes = dir.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".class");
				}
			});
			return nomes;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
