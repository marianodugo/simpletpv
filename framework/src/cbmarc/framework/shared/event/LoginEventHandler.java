/**
 * 
 */
package cbmarc.framework.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mcosta
 *
 */
public interface LoginEventHandler extends EventHandler {
	public void onLogin(LoginEvent event);
}
