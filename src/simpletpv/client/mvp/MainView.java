/**
 * 
 */
package simpletpv.client.mvp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class MainView extends Composite implements MainPresenter.Display  {
	private final DockPanel outer;

	public MainView() {
		outer = new DockPanel();
		initWidget(outer);
		
		outer.setBorderWidth(1);
		outer.setStyleName("main");
		outer.add(new HTML("Main West"), DockPanel.WEST);
		outer.add(new HTML("Main East"), DockPanel.EAST);
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
