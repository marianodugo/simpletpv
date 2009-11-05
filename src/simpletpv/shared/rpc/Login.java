/**
 * 
 */
package simpletpv.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

/**
 * @author mcosta
 *
 */
public class Login implements Action<LoginResult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;
    
    @SuppressWarnings("unused")
	private Login() {
    }
    
    public Login(String username, String password) {
    	this.username = username;
    	this.password = password;
    }

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

}
