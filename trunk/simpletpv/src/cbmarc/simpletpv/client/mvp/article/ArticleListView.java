/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.ui.SelectableFlexTable;

/**
 * @author MCOSTA
 *
 */
public class ArticleListView extends AbstractView 
		implements ArticleListPresenter.Display {
	
	final private ArticleConstants constants;
	final private CaptionPanel captionPanel;
	
	private SelectableFlexTable articleList = new SelectableFlexTable();

	public ArticleListView() {
		constants = GWT.create(ArticleConstants.class);

		captionPanel = new CaptionPanel("Articles");
		initWidget(captionPanel);
		
		final Panel content = new VerticalPanel();
		
		articleList.getRowFormatter().setStyleName(0, "header");
		articleList.setHTML(0, 0, constants.listId());
		articleList.setHTML(0, 1, constants.listLabel());
		articleList.setHTML(0, 2, constants.listPrice());
		articleList.setHTML(0, 3, constants.listDate());
		
		content.add(articleList);
		
		captionPanel.add(content);
	}
}
