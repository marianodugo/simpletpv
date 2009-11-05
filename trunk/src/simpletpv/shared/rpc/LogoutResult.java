/**
 * 
 */
package simpletpv.shared.rpc;

import simpletpv.shared.entity.User;
import net.customware.gwt.dispatch.shared.Result;

/**
 * @author mcosta
 *
 */
public class LogoutResult implements Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public LogoutResult(User user) {
		this.user = user;
	}
	
	@SuppressWarnings("unused")
	private LogoutResult() {
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
