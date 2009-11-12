/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;

import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * @author MCOSTA
 *
 */
public class BottomView extends AbstractView
		implements BottomPresenter.Display  {
	private final HorizontalPanel outer;
	
	public BottomView() {
		outer = new HorizontalPanel();
		initWidget(outer);

		outer.setStyleName("bottom");
	}
}
