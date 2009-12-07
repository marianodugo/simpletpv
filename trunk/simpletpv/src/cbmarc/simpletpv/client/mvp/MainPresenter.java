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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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
		public void setSouth(Widget widget);
	}

	public static final Place PLACE = new Place("Main");
	
	@SuppressWarnings("unused")
	private final DispatchAsync dispatcher;
	private final ArticleFormPresenter articleFormPresenter;
	private final ArticleListPresenter articleListPresenter;

	/**
	 * @param display
	 * @param eventBus
	 * @param dispatcher
	 * @param articleFormPresenter
	 * @param articleListPresenter
	 */
	@Inject
	public MainPresenter(final Display display, final EventBus eventBus
			, final DispatchAsync dispatcher
			, final ArticleFormPresenter articleFormPresenter
			, final ArticleListPresenter articleListPresenter) {
		super(display, eventBus);
		
		this.dispatcher = dispatcher;
		this.articleFormPresenter = articleFormPresenter;
		this.articleListPresenter = articleListPresenter;
		
		// Set the north panel
		final Panel north = new HorizontalPanel();
		north.add(new HTML(AppLocale.constants().app_title()));
		display.setNorth(north);
		
		// Set the center panel
		final Panel article = new VerticalPanel();
		article.setWidth("100%");
		article.add(this.articleFormPresenter.getDisplay().asWidget());
		article.add(this.articleListPresenter.getDisplay().asWidget());
		display.setCenter(article);
		
		// Set the south panel
		final HorizontalPanel south = new HorizontalPanel();		
		final HorizontalPanel southleft = new HorizontalPanel();
		final HorizontalPanel southright = new HorizontalPanel();
		
		southleft.setWidth("100%");
		southleft.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		southleft.add(new HTML(AppLocale.constants().app_copyright()));

		southright.setWidth("100%");
		southright.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		southright.add(new HTML(AppLocale.constants().app_version()));
		
		south.setWidth("100%");
		south.add(southleft);
		south.add(southright);
		
		display.setSouth(south);
		
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
