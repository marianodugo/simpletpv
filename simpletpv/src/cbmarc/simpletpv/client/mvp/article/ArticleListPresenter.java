/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import com.google.inject.Inject;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;

/**
 * @author MCOSTA
 *
 */
public class ArticleListPresenter
		extends AbstractPresenter<ArticleListPresenter.Display> {

	public interface Display extends AbstractPresenter.Display {
	}
	
	public static final Place PLACE = new Place("ArticleList");
	
	@SuppressWarnings("unused")
	private final DispatchAsync dispatcher;
	
	@Inject
	public ArticleListPresenter(Display display, EventBus eventBus
			, final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		bind();
	}

	/* (non-Javadoc)
	 * @see cbmarc.framework.client.mvp.AbstractPresenter#onBind()
	 */
	@Override
	protected void onBind() {
	}
}
