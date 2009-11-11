/**
 * 
 */
package cbmarc.framework.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mcosta
 *
 */
public interface LogoutEventHandler extends EventHandler {
	public void onLogout(LogoutEvent event);
}
