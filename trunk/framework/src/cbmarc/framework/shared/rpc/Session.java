/**
 * 
 */
package cbmarc.framework.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

/**
 * @author mcosta
 *
 */
public abstract class Session<R extends Result> implements Action<R> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String session;

	protected Session() {
	}
	
	public Session(String session) {
		this.session = session;
	}

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

}
