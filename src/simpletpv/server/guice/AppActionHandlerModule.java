package simpletpv.server.guice;

import simpletpv.server.handler.SendGreetingHandler;
import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

/**
 * Module which binds the handlers and configurations
 *
 */
public class AppActionHandlerModule extends ActionHandlerModule {
	@Override
	protected void configureHandlers() {
		bindHandler(SendGreetingHandler.class);
	}
}