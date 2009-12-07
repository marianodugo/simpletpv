/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class TopView extends AbstractView implements TopPresenter.Display  {
	private final HorizontalPanel outer;
	
	/**
	 * 
	 */
	public TopView() {
		outer = new HorizontalPanel();
		initWidget(outer);
		
		outer.setStyleName("top");
	}

	@Override
	public void setTop(Widget widget) {
		outer.clear();
		outer.add(widget);
	}
}
