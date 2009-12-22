/**
 * ActitivityDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.pvm.internal.model.ActivityImpl;

import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Decorator da entidade Activity.
 * 
 * @author adriano.pamplona
 */
public class ActivityDecorator extends JbpmDecoratorAbstrato {
	private ActivityImpl	activityImpl;

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ActivityImpl#getName()
	 */
	public String getName() {
		return getActivityImpl().getName();
	}

	/**
	 * @param name
	 * @see org.jbpm.pvm.internal.model.ActivityImpl#setName(java.lang.String)
	 */
	public void setName(String name) {
		getActivityImpl().setName(name);
	}

	/**
	 * @return retorna activity.
	 */
	public ActivityImpl getActivityImpl() {
		if (!UtilObjeto.isReferencia(activityImpl)) {
			activityImpl = getEntidadeFactory().novaActivity();
		}
		return activityImpl;
	}

	/**
	 * @param activity Atribui activity.
	 */
	public void setActivityImpl(ActivityImpl activity) {
		this.activityImpl = activity;
	}

}
