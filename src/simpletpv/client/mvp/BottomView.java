/**
 * 
 */
package simpletpv.client.mvp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class BottomView extends Composite implements BottomPresenter.Display  {
	private final HorizontalPanel outer;
	
	public BottomView() {
		outer = new HorizontalPanel();
		initWidget(outer);

		outer.setBorderWidth(1);
		outer.setStyleName("bottom");
		outer.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		outer.add(new HTML("Bottom"));
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void startProcessing() {
	}

	@Override
	public void stopProcessing() {
	}
}
