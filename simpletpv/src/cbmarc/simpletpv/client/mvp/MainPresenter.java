/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.simpletpv.client.i18n.AppLocale;
import cbmarc.simpletpv.client.mvp.article.ArticleFormPresenter;
import cbmarc.simpletpv.client.mvp.article.ArticleListPresenter;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
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
		public void setNorth(Widget widget);
		public void setCenter(Widget widget);
	}

	public static final Place PLACE = new Place("Main");
	
	@SuppressWarnings("unused")
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
		
		final Panel north = new HorizontalPanel();
		north.add(new HTML(AppLocale.constants().app_title()));
		display.setNorth(north);
		
		final Panel article = new VerticalPanel();
		article.add(this.articleFormPresenter.getDisplay().asWidget());
		article.add(this.articleListPresenter.getDisplay().asWidget());
		display.setCenter(article);
		
		bind();
	}

	@Override
	protected void onBind() {
	}

	/* (non-Javadoc)
	 * @see cbmarc.framework.client.mvp.AbstractPresenter#onPlaceRequest(net.customware.gwt.presenter.client.place.PlaceRequest)
	 */
	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// Grab the 'name' from the request and put it into the 'name' field.
		// This allows a tag of '#Greeting;name=Foo' to populate the name
		// field.
		//final String name = request.getParameter("name", null);
		 
		//if (name != null) {
		//display.getName().setValue(name);
		//}
	}
}
