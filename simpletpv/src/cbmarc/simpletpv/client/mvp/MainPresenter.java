/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import java.util.List;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.simpletpv.client.mvp.article.ArticleFormPresenter;
import cbmarc.simpletpv.client.mvp.article.ArticleListPresenter;
import cbmarc.simpletpv.shared.entity.Article;
import cbmarc.simpletpv.shared.event.SendArticleEvent;
import cbmarc.simpletpv.shared.event.SendArticleEventHandler;
import cbmarc.simpletpv.shared.rpc.FetchArticles;
import cbmarc.simpletpv.shared.rpc.FetchArticlesResult;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author MCOSTA
 *
 */
public class MainPresenter extends AbstractPresenter<MainPresenter.Display> {
	public interface Display extends AbstractPresenter.Display {
		public void setListArticles(String listArticles);
		public void setWestLabel(String westLabel);
		public void setEast(Widget widget);
	}

	public static final Place PLACE = new Place("Main");
	
	private final DispatchAsync dispatcher;
	private final ArticleFormPresenter articleFormPresenter;
	private final ArticleListPresenter articleListPresenter;

	@Inject
	public MainPresenter(final Display display, final EventBus eventBus
			, final DispatchAsync dispatcher
			, final ArticleFormPresenter articleFormPresenter
			, final ArticleListPresenter articleListPresenter) {
		super(display, eventBus);
		
		this.dispatcher = dispatcher;
		this.articleFormPresenter = articleFormPresenter;
		this.articleListPresenter = articleListPresenter;
		
		final Panel article = new VerticalPanel();
		article.add(this.articleListPresenter.getDisplay().asWidget());
		article.add(this.articleFormPresenter.getDisplay().asWidget());
		
		display.setEast(article);
		
		bind();
	}

	@Override
	protected void onBind() {
		doFetchAllArticles();
		
		registerHandler(eventBus.addHandler(SendArticleEvent.TYPE,
				new SendArticleEventHandler() {

					@Override
					public void onSendArticle(SendArticleEvent event) {
						display.setWestLabel("new value entered");
						doFetchAllArticles();
					}
			
		}));
	}
	
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
						StringBuilder sb = new StringBuilder();

						for (Article item : results) {
							sb.append(item.toString() + "<br>");
						}
						
						display.setListArticles(sb.toString());
					}
					
				});
	}
	
	/*private void doSend() {
		eventBus.fireEvent(new LoadingEvent(false));
		dispatcher.execute(
				new SendArticle(display.getNameTextBox().getValue()),
				new DisplayCallback<GenericResult>(display) {

					@Override
					protected void handleFailure(Throwable e) {
						eventBus.fireEvent(new LoadingEvent(true));
						Window.alert("FAILURE: " + e.getCause());
					}

					@Override
					protected void handleSuccess(GenericResult value) {
						eventBus.fireEvent(new LoadingEvent(true));
						eventBus.fireEvent(new SendArticleEvent());
					}
					
				});
	}*/
}
