/**
 * 
 */
package cbmarc.framework.shared.event;

import cbmarc.framework.shared.entity.User;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author mcosta
 *
 */
public class LogoutEvent extends GwtEvent<LogoutEventHandler> {
	public static Type<LogoutEventHandler> TYPE = 
		new Type<LogoutEventHandler>();
	private User user;

	/**
	 * @param user
	 */
	public LogoutEvent(User user) {
		this.user = user;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	@Override
	protected void dispatch(LogoutEventHandler handler) {
		handler.onLogout(this);
	}
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LogoutEventHandler> 
			getAssociatedType() {
		return TYPE;
	}
}
