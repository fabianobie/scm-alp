/**
 * AsiUtilitarios.java
 *
 * Data: 29/12/2009
 */
package br.com.ap.gerador.asi;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.gerador.asi.to.NamedQueryTO;
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
	public static void main(String[] args) {

		try {
			//gerarNomesParaReveng();
			gerarNomesParaPersistence();
			//gerarNamedQueries();
			//listarClassesQueNaoSaoEntidades();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void gerarNomesParaReveng() throws Exception {
		StringBuilder sb = new StringBuilder();
		
		File pasta = new File(PATH_ENTIDADES);
		String[] arquivos = pasta.list();
		for (String arquivo : arquivos) {
			arquivo = arquivo.substring(0, arquivo.indexOf("."));

			if (!UtilString.isVazio(arquivo)) {
				arquivo = PACOTE + "." + arquivo;
				Class<?> classe = Class.forName(arquivo);
				Entity entityAnnotation = classe.getAnnotation(Entity.class);

				if (UtilObjeto.isReferencia(entityAnnotation)) {
					Table table = classe.getAnnotation(Table.class);
					String nome = null;
					if (table != null) {
						nome = table.name();
					} else {
						nome = classe.getSimpleName();
					}
					nome = UtilString.minuscula(nome);
					
					sb.append("<table-filter match-name=\"").append(nome).append("\" exclude=\"true\" />\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	/**
	 * Lista as classes que não são entidades.
	 * 
	 * @throws Exception
	 */
	private static void listarClassesQueNaoSaoEntidades() throws Exception {
		File pasta = new File(PATH_ENTIDADES);
		String[] arquivos = pasta.list();
		for (String arquivo : arquivos) {
			arquivo = arquivo.substring(0, arquivo.indexOf("."));

			if (!UtilString.isVazio(arquivo)) {
				arquivo = PACOTE + "." + arquivo;
				Class<?> classe = Class.forName(arquivo);
				Entity entityAnnotation = classe.getAnnotation(Entity.class);

				if (!UtilObjeto.isReferencia(entityAnnotation)) {
					System.out.println(classe.getSimpleName());
				}
			}
		}
	}

	/**
	 * Gera os arquivos com os named queries mapeados nas entidades.
	 * 
	 * @throws Exception
	 */
	private static void gerarNamedQueries() throws Exception {
		StringBuilder arquivosHQL = new StringBuilder();
		final String PASTA_DESTINO = "source-gerado/br/com/linkdata/entity/hql/";

		File pasta = new File(PATH_ENTIDADES);
		String[] arquivos = pasta.list();
		for (String arquivo : arquivos) {
			arquivo = arquivo.substring(0, arquivo.indexOf("."));

			if (!UtilString.isVazio(arquivo)) {
				File pastaDestino = new File(PASTA_DESTINO);
				if (!pastaDestino.exists()) {
					pastaDestino.mkdirs();
				}
				if (arquivo.equalsIgnoreCase("fornecedorpf")) {
					System.out.println("achou");
				}
				Class<?> classe = Class.forName(PACOTE + "." + arquivo);
				String nomeArquivoHQL = classe.getSimpleName() + ".hql.xml";

				NamedQueries namedQueries = classe
						.getAnnotation(NamedQueries.class);

				if (UtilObjeto.isReferencia(namedQueries)) {
					NamedQuery[] array = namedQueries.value();
					Collection<NamedQueryTO> c = UtilColecao.aplicarConversor(
							Arrays.asList(array),
							new IConversor<NamedQuery, NamedQueryTO>() {

								@Override
								public NamedQueryTO converter(
										NamedQuery anotacao)
										throws ConversorException {
									NamedQueryTO to = new NamedQueryTO();
									to.setName(anotacao.name());
									to.setQuery(anotacao.query());
									return to;
								}

								@Override
								public Class<NamedQueryTO> getTipoDeDestino() {
									return NamedQueryTO.class;
								}

								@Override
								public Class<NamedQuery> getTipoDeOrigem() {
									return NamedQuery.class;
								}
							});
					Map<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("namedQueries", c);
					parametros.put("pacote", "br.com.linkdata.entity");
					gerar("hql/hql.cfg.ftl", parametros, PASTA_DESTINO
							+ nomeArquivoHQL);

					arquivosHQL.append("<mapping resource=\"").append(
							nomeArquivoHQL).append("\" />\n");
				}
			}
		}
		System.out.println(arquivosHQL.toString());
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
		gerar("persistence/persistence.ftl", parametros,
				"./source-impl-asi/META-INF/persistence.xml");
	}

	/**
	 * Gera baseado em um template.
	 * 
	 * @param pathTemplate Path do template que será usado.
	 * @param parametros Parâmetros passados para o freemarker.
	 * @param arquivoSaida Nome do arquivo de saída
	 * @throws Exception
	 */
	private static void gerar(String pathTemplate,
			Map<String, Object> parametros, String arquivoSaida)
			throws Exception {
		Configuration configuration = novoConfiguration();
		Template template = configuration.getTemplate(pathTemplate);

		FileWriter out = new FileWriter(arquivoSaida);
		template.process(parametros, out);
		out.flush();
		out.close();
		System.out.println("Arquivo " + arquivoSaida + " gerado!");
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
