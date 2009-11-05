/**
 * 
 */
package simpletpv.server.handler;

import java.util.List;

import com.google.inject.Inject;

import simpletpv.server.ArticleDAO;
import simpletpv.server.ArticleJdoDAO;
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
	private ArticleDAO articleDAO = new ArticleJdoDAO();
	
	@Inject
	public FetchArticlesHandler() {
	}

	@Override
	public FetchArticlesResult execute(final FetchArticles action, 
			final ExecutionContext context) throws ActionException {

		try {
			List<Article> results = articleDAO.selectAll();

			return new FetchArticlesResult(results);
		} catch(Exception e) {
			throw new ActionException(e);
		}
	}

	@Override
	public Class<FetchArticles> getActionType() {
		return FetchArticles.class;
	}

	@Override
	public void rollback(FetchArticles action, FetchArticlesResult result,
			ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub
	}
}
