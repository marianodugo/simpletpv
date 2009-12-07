/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * @author MCOSTA
 *
 */
public class TopView extends AbstractView implements TopPresenter.Display  {
	private final HorizontalPanel outer;
	private final Hyperlink login;
	
	/**
	 * 
	 */
	public TopView() {
		outer = new HorizontalPanel();
		initWidget(outer);
		
		login = new Hyperlink(AppLocale.constants().login(), "login");
		
		outer.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		outer.add(login);
		outer.setStyleName("top");
	}

	@Override
	public HasClickHandlers getLoginHyperlink() {
		return login;
	}
}
