/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.simpletpv.client.ui.SelectableFlexTable;
import cbmarc.simpletpv.shared.entity.Article;
import cbmarc.simpletpv.shared.event.SendArticleEvent;
import cbmarc.simpletpv.shared.event.SendArticleEventHandler;
import cbmarc.simpletpv.shared.rpc.FetchArticles;
import cbmarc.simpletpv.shared.rpc.FetchArticlesResult;

/**
 * @author MCOSTA
 *
 */
public class ArticleListPresenter
		extends AbstractPresenter<ArticleListPresenter.Display> {

	public interface Display extends AbstractPresenter.Display {
		public SelectableFlexTable getArticleListTable();
	}
	
	public static final Place PLACE = new Place("ArticleList");
	
	private final DispatchAsync dispatcher;
	
	protected int indexSelected = 0;
	protected List<Article> articles = null;
	
	@Inject
	public ArticleListPresenter(Display display, EventBus eventBus
			, final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		
		doFetchAllArticles();
		bind();
	}

	/* (non-Javadoc)
	 * @see cbmarc.framework.client.mvp.AbstractPresenter#onBind()
	 */
	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(SendArticleEvent.TYPE,
				new SendArticleEventHandler() {

					@Override
					public void onSendArticle(SendArticleEvent event) {
						doFetchAllArticles();
					}
		}));

		display.getArticleListTable().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SelectableFlexTable sft = display.getArticleListTable();
				Window.alert(Integer.toString(sft.getRowForEvent(event)));
			}
			
		});
	}
	
	/**
	 * 
	 */
	public void onStart() {
	}
	
	/**
	 * 
	 */
	private void doFetchAllArticles() {
		dispatcher.execute(
			new FetchArticles(), 
			new DisplayCallback<FetchArticlesResult>(display) {

				@Override
				protected void handleFailure(Throwable e) {
					Window.alert("FAILURE: " + e.getMessage());
				}

				@Override
				protected void handleSuccess(FetchArticlesResult value) {
					List<Article> results = value.getArticles();
					
					int size = results.size();
					for(int i = 0; i < size; i ++)
						addUserToListTable(results.get(i), i+1);
				}
			});
	}
	
	private void addUserToListTable(Article a, int row) {
		SelectableFlexTable table = display.getArticleListTable();

		table.setHTML(row, 0, a.getId().toString());
		table.setHTML(row, 1, a.getLabel());
		table.setHTML(row, 2, a.getPrice().toString());
		table.setHTML(row, 3, a.getDate().toString());
	}
}