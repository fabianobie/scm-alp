/**
 * ActitivityDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.model.Activity;
import org.jbpm.pvm.internal.model.ObservableElement;
import org.jbpm.pvm.internal.model.OpenProcessDefinition;
import org.jbpm.pvm.internal.model.Transition;

import br.com.ap.comum.objeto.UtilObjeto;

/**
 * @author adriano.pamplona
 *
 */
public class ActivityDecorator extends JbpmDecoratorAbstrato {
	private Activity activity;
	private String name;
	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#findActivity(java.lang.String)
	 */
	public Activity findActivity(String arg0) {
		return getActivity().findActivity(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#findOutgoingTransition(java.lang.String)
	 */
	public Transition findOutgoingTransition(String arg0) {
		return getActivity().findOutgoingTransition(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#getActivities()
	 */
	public List<? extends Activity> getActivities() {
		return getActivity().getActivities();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#getActivitiesMap()
	 */
	public Map<String, Activity> getActivitiesMap() {
		return getActivity().getActivitiesMap();
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#getActivity(java.lang.String)
	 */
	public Activity getActivity(String arg0) {
		return activity.getActivity(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getDbid()
	 */
	public long getDbid() {
		return getActivity().getDbid();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getDefaultOutgoingTransition()
	 */
	public Transition getDefaultOutgoingTransition() {
		return getActivity().getDefaultOutgoingTransition();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getIncomingTransitions()
	 */
	public List<Transition> getIncomingTransitions() {
		return getActivity().getIncomingTransitions();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getName()
	 */
	public String getName() {
		String resultado = getActivity().getName();
		if (isVazio(resultado)) {
			resultado = name;
		}
		return resultado;
	}
	
	/**
	 * @param name Atribui name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getOutgoingTransition(java.lang.String)
	 */
	public Transition getOutgoingTransition(String arg0) {
		return getActivity().getOutgoingTransition(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getOutgoingTransitions()
	 */
	public List<Transition> getOutgoingTransitions() {
		return getActivity().getOutgoingTransitions();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getOutgoingTransitionsMap()
	 */
	public Map<String, Transition> getOutgoingTransitionsMap() {
		return getActivity().getOutgoingTransitionsMap();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getParent()
	 */
	public ObservableElement getParent() {
		return getActivity().getParent();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getParentActivity()
	 */
	public Activity getParentActivity() {
		return getActivity().getParentActivity();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getProcessDefinition()
	 */
	public OpenProcessDefinition getProcessDefinition() {
		return getActivity().getProcessDefinition();
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getProperty(java.lang.String)
	 */
	public Object getProperty(String arg0) {
		return getActivity().getProperty(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#getPropertyKeys()
	 */
	public Set<String> getPropertyKeys() {
		return getActivity().getPropertyKeys();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#getType()
	 */
	public String getType() {
		return getActivity().getType();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#hasActivities()
	 */
	public boolean hasActivities() {
		return getActivity().hasActivities();
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.CompositeElement#hasActivity(java.lang.String)
	 */
	public boolean hasActivity(String arg0) {
		return getActivity().hasActivity(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElement#hasEvent(java.lang.String)
	 */
	public boolean hasEvent(String arg0) {
		return getActivity().hasEvent(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#hasIncomingTransitions()
	 */
	public boolean hasIncomingTransitions() {
		return getActivity().hasIncomingTransitions();
	}

	/**
	 * @param arg0
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#hasOutgoingTransition(java.lang.String)
	 */
	public boolean hasOutgoingTransition(String arg0) {
		return getActivity().hasOutgoingTransition(arg0);
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.Activity#hasOutgoingTransitions()
	 */
	public boolean hasOutgoingTransitions() {
		return getActivity().hasOutgoingTransitions();
	}

	/**
	 * @return retorna activity.
	 */
	public Activity getActivity() {
		if (!UtilObjeto.isReferencia(activity)) {
			activity = getEntidadeFactory().novaActivity();
		}
		return activity;
	}
	
	/**
	 * @param activity Atribui activity.
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}




}
