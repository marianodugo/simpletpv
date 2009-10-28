package simpletpv.server.handler;

import simpletpv.shared.rpc.SendGreeting;
import simpletpv.shared.rpc.SendGreetingResult;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.google.inject.Inject;

public class SendGreetingHandler implements 
		ActionHandler<SendGreeting, SendGreetingResult> {

	@Inject
	public SendGreetingHandler() {
	}

	@Override
	public SendGreetingResult execute(final SendGreeting action,
					  final ExecutionContext context) throws ActionException {
		try {
			return new SendGreetingResult("name", "message");
		} catch (Exception cause) {
			throw new ActionException(cause);
		}
	}

	@Override
	public void rollback(final SendGreeting action,
			     final SendGreetingResult result,
			     final ExecutionContext context) throws ActionException {
		// Nothing to do here
	}
	
	@Override
	public Class<SendGreeting> getActionType() {
		return SendGreeting.class;
	}
}