/**
 * 
 */
package simpletpv.server;

import java.util.List;

import net.customware.gwt.dispatch.shared.ActionException;

import simpletpv.shared.entity.Article;

/**
 * @author mcosta
 *
 */
public interface ArticleDAO {
	void insert(Article article) throws ActionException;
	void delete(Article article) throws ActionException;
	void update(Article article) throws ActionException;
	
	int count();
	//Article select(int id);
	List<Article> selectAll();
}
