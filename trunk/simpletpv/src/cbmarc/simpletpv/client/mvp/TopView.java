/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class TopView extends AbstractView implements TopPresenter.Display  {

	interface Binder extends UiBinder<Widget, TopView> { }
	private static final Binder binder = GWT.create(Binder.class);

	@UiField Anchor loginLink;
	
	/**
	 * 
	 */
	public TopView() {
		initWidget(binder.createAndBindUi(this));
		
		loginLink.setText(AppLocale.constants().login());
	}

	@Override
	public HasClickHandlers getLoginHyperlink() {
		return loginLink;
	}
}
