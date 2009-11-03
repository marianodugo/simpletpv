/**
 * 
 */
package simpletpv.server.handler;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.inject.Inject;

import simpletpv.server.PMF;
import simpletpv.shared.entity.Article;
import simpletpv.shared.rpc.FetchArticles;
import simpletpv.shared.rpc.FetchArticlesResult;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

/**
 * @author mcosta
 *
 */
public class FetchArticlesHandler implements 
		ActionHandler<FetchArticles, FetchArticlesResult> {
	
	@Inject
	public FetchArticlesHandler() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public FetchArticlesResult execute(final FetchArticles action, 
			final ExecutionContext context) throws ActionException {

		try {
			List<Article> results;
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query query = pm.newQuery(Article.class);
			query.setOrdering("id desc");

			try {
				results = (List<Article>) query.execute();
			} finally {
				query.closeAll();
			}
			
			List<Article> copy = new ArrayList<Article>();
			copy.addAll(results);
			
			return new FetchArticlesResult(copy);
		} catch(Exception e) {
			throw new ActionException(e);
		}
	}

	@Override
	public Class<FetchArticles> getActionType() {
		return FetchArticles.class;
	}

	@Override
	public void rollback(FetchArticles arg0, FetchArticlesResult arg1,
			ExecutionContext arg2) throws ActionException {
		// TODO Auto-generated method stub
	}
}
