/**
 * StatusAction.java
 *
 * Data: 08/01/2010
 */
package teste.action.status;

/**
 * @author adriano.pamplona
 * 
 */
public class StatusAction {

	/**
	 * @return paginacao
	 */
	public String acaoCarregar() {
		return "status";
	}

	/**
	 * @return status
	 */
	public String acaoExecutar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "status";
	}
}
