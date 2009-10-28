/**
 * 
 */
package simpletpv.server.handler;

import com.google.inject.Inject;

import simpletpv.shared.rpc.GenericResult;
import simpletpv.shared.rpc.SendArticle;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

/**
 * @author MCOSTA
 *
 */
public class SendArticleHandler implements 
		ActionHandler<SendArticle, GenericResult> {
	
	@Inject
	public SendArticleHandler() {
	}

	@Override
	public GenericResult execute(SendArticle action, ExecutionContext context)
			throws ActionException {
		try {
			return new GenericResult("OK", true);
		} catch(Exception cause) {
			throw new ActionException(cause);
		}
	}

	@Override
	public Class<SendArticle> getActionType() {
		return SendArticle.class;
	}

	@Override
	public void rollback(SendArticle arg0, GenericResult arg1,
			ExecutionContext arg2) throws ActionException {
		// TODO Auto-generated method stub
		
	}

}
