/**
 * 
 */
package simpletpv.shared.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mcosta
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private Date loginDate;
	private boolean auth;
	private String sessionId;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	/**
	 * @return the auth
	 */
	public boolean isAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
