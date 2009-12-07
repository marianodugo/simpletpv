/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;

/**
 * @author MCOSTA
 *
 */
public class TopPresenter extends AbstractPresenter<TopPresenter.Display> {
	public interface Display extends AbstractPresenter.Display {
		public HasClickHandlers getLoginHyperlink();
	}

	public static final Place PLACE = new Place("Top");

	/**
	 * @param display
	 * @param eventBus
	 */
	@Inject
	public TopPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);		
		bind();
	}

	/* (non-Javadoc)
	 * @see cbmarc.framework.client.mvp.AbstractPresenter#onBind()
	 */
	@Override
	protected void onBind() {
		display.getLoginHyperlink().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doLogin();
			}
			
		});
	}
	
	private void doLogin() {
		Window.alert("You clicked \"" 
				+ AppLocale.constants().login() + "\" Hyperlink");
	}
}
