/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class MainView extends AbstractView implements MainPresenter.Display  {
	private final DockPanel outer;
	private Panel north;
	private Panel center;
	private Panel south;

	public MainView() {
		outer = new DockPanel();
		initWidget(outer);

		north = new HorizontalPanel();
		north.addStyleName("northPanel");
		
		center = new  HorizontalPanel();
		center.addStyleName("centerPanel");

		south = new  HorizontalPanel();
		south.addStyleName("southPanel");
		south.add(new HTML("&nbsp"));
		
		outer.setStyleName("mainPanel");
		outer.add(north, DockPanel.NORTH);
		outer.add(center, DockPanel.CENTER);
		outer.add(south, DockPanel.SOUTH);
	}

	@Override
	public void setCenter(Widget widget) {
		center.clear();
		center.add(widget);
	}

	@Override
	public void setNorth(Widget widget) {
		north.clear();
		north.add(widget);
	}
}
