/**
 * UtilPropriedadeDominio.java
 *
 * Data: 15/12/2009
 */
package br.com.ap.gerador.asi.util;

import java.util.Map;
import java.util.Properties;

import org.hibernate.cfg.reveng.TableIdentifier;

import br.com.ap.comum.arquivo.UtilCarregarMapaDeString;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.gerador.asi.util.constante.Arquivo;

/**
 * @author adriano.pamplona
 */
public final class UtilAtributoDominio {
	private static Map<String, String> mapaPrefixoPropriedade;
	private static Map<String, String> mapaRenomearPrefixo;
	
	public static String nomear(TableIdentifier tabela, String propriedade) {
		if (UtilObjeto.isReferenciaTodos(tabela, propriedade)) {
			String nome = tabela.getName();
			String prefixo = getPrefixo(propriedade);
			String sufixo = getSufixo(propriedade);
			
			if (UtilObjeto.isReferencia(prefixo) && nome.equalsIgnoreCase(sufixo)) {
				if (getMapaPrefixoPropriedade().containsKey(prefixo)) {
					propriedade = getMapaPrefixoPropriedade().get(prefixo);
				}
			}
			
			if (getMapaRenomearPrefixo().containsKey(prefixo)) {
				String novoPrefixo = getMapaPrefixoPropriedade().get(prefixo);
				if (UtilString.isVazio(novoPrefixo)) {
					propriedade = propriedade.replace(prefixo, "");
					
				}
			}
		}
		return propriedade;
	}

	private static String getSufixo(String propriedade) {
		String sufixo = null;
		
		if (UtilObjeto.isReferencia(propriedade)) {
			int indice = UtilString.getPrimeiraMaiuscula(propriedade);
			if (indice > -1) {
				sufixo = propriedade.substring(indice, propriedade.length());
			}
		}
		return sufixo;
	}

	private static String getPrefixo(String propriedade) {
		String prefixo = null;
		
		if (UtilObjeto.isReferencia(propriedade)) {
			int indice = UtilString.getPrimeiraMaiuscula(propriedade);
			if (indice > -1) {
				prefixo = propriedade.substring(0, indice);
			}
		}
		return prefixo;
	}

	/**
	 * @return retorna mapaPrefixoPropriedade.
	 */
	public static Map<String, String> getMapaPrefixoPropriedade() {
		if (!UtilObjeto.isReferencia(mapaPrefixoPropriedade)) {
			mapaPrefixoPropriedade = ColecaoFactory.getInstancia().novoHashMap();
			
			Properties property = ArquivoFactory.getInstancia().novoProperties(Arquivo.getPrefixoAtributoProperty());
			UtilCarregarMapaDeString util = new UtilCarregarMapaDeString();
			mapaPrefixoPropriedade = util.getMapa(property);
		}
		return mapaPrefixoPropriedade;
	}

	/**
	 * @return retorna mapaRenomearPrefixo.
	 */
	public static Map<String, String> getMapaRenomearPrefixo() {
		if (!UtilObjeto.isReferencia(mapaRenomearPrefixo)) {
			mapaRenomearPrefixo = ColecaoFactory.getInstancia().novoHashMap();
			
			Properties property = ArquivoFactory.getInstancia().novoProperties(Arquivo.getRenomearPrefixoProperty());
			UtilCarregarMapaDeString util = new UtilCarregarMapaDeString();
			mapaRenomearPrefixo = util.getMapa(property);
		}
		return mapaRenomearPrefixo;
	}
}
