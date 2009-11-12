/**
 * 
 */
package cbmarc.simpletpv.shared.rpc;

import cbmarc.framework.shared.rpc.GenericResult;
import cbmarc.simpletpv.shared.entity.Article;
import net.customware.gwt.dispatch.shared.Action;

/**
 * @author MCOSTA
 *
 */
public class SendArticle implements Action<GenericResult> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article article;
	
	@SuppressWarnings("unused")
	private SendArticle() {
	}
	
	public SendArticle(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return article;
	}

}
