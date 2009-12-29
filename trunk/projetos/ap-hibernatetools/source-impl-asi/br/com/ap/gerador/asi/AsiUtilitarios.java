/**
 * AsiUtilitarios.java
 *
 * Data: 29/12/2009
 */
package br.com.ap.gerador.asi;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Entity;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @author adriano.pamplona
 * 
 */
public class AsiUtilitarios {
	private static final String	PATH_ENTIDADES	= "C:/java/projetos/entities/src/main/java/br/com/linkdata/entity";

	private static final String	PACOTE			= "br.com.linkdata.entity";

	/**
	 * @param args Parâmetros
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		gerarNomesParaPersistence();
	}

	/**
	 * Gera os nomes das entidades da pasta original do projeto.
	 * 
	 * @throws Exception
	 */
	private static void gerarNomesParaPersistence() throws Exception {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		
		File pasta = new File(PATH_ENTIDADES);
		String[] arquivos = pasta.list();
		for (String arquivo : arquivos) {
			arquivo = arquivo.substring(0, arquivo.indexOf("."));

			if (!UtilString.isVazio(arquivo)) {
				arquivo = PACOTE + "." + arquivo;
				Class<?> classe = Class.forName(arquivo);
				Entity entityAnnotation = classe.getAnnotation(Entity.class);

				if (UtilObjeto.isReferencia(entityAnnotation)) {
					classes.add(classe);
				}
			}
		}
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("classes", classes);
		gerar("persistence/persistence.ftl", parametros, "./source-impl-asi/META-INF/persistence.xml");
	}

	/**
	 * Gera baseado em um template.
	 * 
	 * @param pathTemplate Path do template que será usado.
	 * @param parametros Parâmetros passados para o freemarker.
	 * @param arquivoSaida Nome do arquivo de saída
	 * @throws Exception
	 */
	private static void gerar(String pathTemplate, Map<String, Object> parametros, String arquivoSaida) throws Exception {
		Configuration configuration = novoConfiguration();
		Template template = configuration.getTemplate(pathTemplate);
		
		FileWriter out = new FileWriter(arquivoSaida);
		template.process(parametros, out);
		out.flush();
		out.close();
		System.out.println("Arquivo "+ arquivoSaida +" gerado!");
	}

	/**
	 * @return Configuration
	 */
	private static Configuration novoConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(AsiUtilitarios.class,
				"/br/com/ap/gerador/asi/template/");
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("ISO-8859-1");
		configuration.setEncoding(new Locale("pt", "BR"), "ISO-8859-1");
		configuration.setDateFormat("dd/MM/yyyy");

		return configuration;
	}
}
