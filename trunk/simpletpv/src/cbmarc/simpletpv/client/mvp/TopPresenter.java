/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author MCOSTA
 *
 */
public class TopPresenter extends AbstractPresenter<TopPresenter.Display> {
	public interface Display extends AbstractPresenter.Display {
		public void setTop(Widget widget);
	}

	public static final Place PLACE = new Place("Top");

	/**
	 * @param display
	 * @param eventBus
	 */
	@Inject
	public TopPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		
		final HorizontalPanel top = new HorizontalPanel();
		top.setWidth("100%");
		top.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		top.add(new Hyperlink(AppLocale.constants().login(), "login"));
		
		display.setTop(top);
		
		bind();
	}
}
