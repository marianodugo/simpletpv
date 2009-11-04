/**
 * 
 */
package simpletpv.server.handler;

import java.util.Date;

import com.google.inject.Inject;

import simpletpv.server.ArticleDAO;
import simpletpv.server.ArticleJdoDAO;
import simpletpv.shared.entity.Article;
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
	//private ArticleDAO articleDAO = new ArticleDAOMock();
	private ArticleDAO articleDAO = new ArticleJdoDAO();
	
	@Inject
	public SendArticleHandler() {
	}

	@Override
	public GenericResult execute(final SendArticle action, 
			final ExecutionContext context) throws ActionException {

		try {
			Article article = new Article(action.getArticle());
			article.setDate(new Date());
			articleDAO.insert(article);
			
			/*PersistenceManager pm = PMF.get().getPersistenceManager();
			Article a = new Article(action.getArticle());
			Query query = pm.newQuery(Article.class);
			query.setOrdering("id asc");

			try {
				List<Article> results = (List<Article>) query.execute();
				if(results.size() >= 10) {
					pm.deletePersistent(results.get(0));
				}
				
				pm.makePersistent(a);
			} finally {
				pm.close();
			}*/
			
			return new GenericResult(action.getArticle(), true);
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
