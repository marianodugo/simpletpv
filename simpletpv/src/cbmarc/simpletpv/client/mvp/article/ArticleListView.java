/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.ui.SelectableFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * @author MCOSTA
 *
 */
public class ArticleListView extends AbstractView 
		implements ArticleListPresenter.Display {
	
	final private ArticleConstants constants;
	
	final private HorizontalPanel outer = new HorizontalPanel();
	private SelectableFlexTable articleListTable = new SelectableFlexTable();

	public ArticleListView() {
		constants = GWT.create(ArticleConstants.class);

		initWidget(outer);
		
		outer.setWidth("100%");
		
		articleListTable.setWidth("100%");
		articleListTable.getRowFormatter().setStyleName(0, "header");
		articleListTable.setHTML(0, 0, constants.listId());
		articleListTable.setHTML(0, 1, constants.listLabel());
		articleListTable.setHTML(0, 2, constants.listPrice());
		articleListTable.setHTML(0, 3, constants.listDate());
		
		outer.add(articleListTable);
	}

	public SelectableFlexTable getArticleListTable() {
		return articleListTable;
	}
}
