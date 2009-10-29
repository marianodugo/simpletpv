package simpletpv.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class SendGreeting implements Action<SendGreetingResult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	@SuppressWarnings("unused")
	private SendGreeting() {
	}

	public SendGreeting(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}