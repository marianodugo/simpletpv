/**
 * 
 */
package simpletpv.shared.exception;

import net.customware.gwt.dispatch.shared.ActionException;

/**
 * @author mcosta
 *
 */
public class InvalidSessionException extends ActionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidSessionException(String msg) {
		super(msg);
	}

}
