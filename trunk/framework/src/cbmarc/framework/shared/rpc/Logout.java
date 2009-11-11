/**
 * 
 */
package cbmarc.framework.shared.rpc;

/**
 * @author mcosta
 *
 */
public class Logout extends Session<LogoutResult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Logout(String session) {
		super(session);
	}
	
	@SuppressWarnings("unused")
	private Logout() {
	}

}
