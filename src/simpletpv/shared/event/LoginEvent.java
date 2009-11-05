/**
 * 
 */
package simpletpv.shared.event;

import simpletpv.shared.entity.User;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author mcosta
 *
 */
public class LoginEvent extends GwtEvent<LoginEventHandler> {
	public static Type<LoginEventHandler> TYPE = 
		new Type<LoginEventHandler>();
	private User user;

	/**
	 * @param user
	 */
	public LoginEvent(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	@Override
	protected void dispatch(LoginEventHandler handler) {
		handler.onLogin(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LoginEventHandler> 
			getAssociatedType() {
		return TYPE;
	}

}
