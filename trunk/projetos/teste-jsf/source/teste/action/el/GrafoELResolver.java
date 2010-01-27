/**
 * GrafoELResolver.java
 *
 * Data: 27/11/2009
 */
package teste.action.el;

import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.el.ELException;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.PropertyUtils;

import teste.util.UtilJsf;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.string.UtilString;

/**
 * EL responsável em recuperar e atribuir o valor a uma empressão ignorando se
 * um dos objetos for nulo.
 * 
 * @author adriano.pamplona
 * 
 */
public class GrafoELResolver extends BeanELResolver {

	@Override
	public Object getValue(ELContext context, Object base, Object atributoObject)
			throws NullPointerException, PropertyNotFoundException, ELException {

		Object resultado = null;
		String atributo = (String) atributoObject;

		if (base == null) {
			if (isGrafoEL(atributo)) {
				resultado = new GrafoEL();
				context.setPropertyResolved(true);
			}
		}

		try {
			if (base instanceof GrafoEL) {
				GrafoEL grafoEL = (GrafoEL) base;

				if (!UtilString.isStringsIguais(atributo, "valorEL")) {
					if (grafoEL.isListaDeAtributoVazia()) {
						Object atributoPai = UtilJsf
								.getObjetoDoContexto(atributo);
						grafoEL.adicionarAtributo(atributo, atributoPai);
					} else {
						Object atributoPai = grafoEL.getUltimoValorAtributo();
						Object atributoFilho = PropertyUtils.getProperty(
								atributoPai, atributo);
						Class<?> classeFilho = PropertyUtils.getPropertyType(
								atributoPai, atributo);
						if (atributoFilho == null) {
							if (Entidade.class.isAssignableFrom(classeFilho)) {
								atributoFilho = ConstructorUtils
										.invokeConstructor(classeFilho, null);
							}
						}
						grafoEL.adicionarAtributo(atributo, atributoFilho);
					}
					resultado = grafoEL;
					context.setPropertyResolved(true);
				} else {
					resultado = grafoEL.getUltimoValorAtributo();
					context.setPropertyResolved(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public void setValue(ELContext contexto, Object base,
			Object atributoObject, Object valor) throws NullPointerException,
			PropertyNotFoundException, PropertyNotWritableException,
			ELException {

		String atributo = (String) atributoObject;
		if ((base instanceof GrafoEL)
				&& UtilString.isStringsIguais(atributo, "valorEL")) {
			GrafoEL grafoEL = (GrafoEL) base;

			int ultimo = grafoEL.getValorAtributo().size() - 1;
			grafoEL.getValorAtributo().remove(ultimo);
			grafoEL.getValorAtributo().add(valor);

			try {
				for (int indice = 0; indice < grafoEL.getValorAtributo().size() - 1; indice++) {
					int indiceFilho = indice + 1;
					Object valorAtributoPai = grafoEL.getValorAtributo().get(
							indice);

					Object valorAtributoFilho = grafoEL.getValorAtributo().get(
							indiceFilho);
					String chaveAtributoFilho = grafoEL.getChaveAtributo().get(
							indiceFilho);

					PropertyUtils.setProperty(valorAtributoPai,
							chaveAtributoFilho, valorAtributoFilho);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			contexto.setPropertyResolved(true);
		}
	}

	protected boolean isGrafoEL(String parametro) {
		return UtilString.isStringsIguais(parametro, "GrafoEL");
	}
}
