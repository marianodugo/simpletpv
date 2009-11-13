/**
 * 
 */
package cbmarc.simpletpv.client.mvp;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class MainView extends AbstractView implements MainPresenter.Display  {
	private final DockPanel outer;
	private VerticalPanel east;
	private Panel north;

	private HTML listArticles;
	private Label westLabel;

	public MainView() {
		east = new VerticalPanel();
		VerticalPanel westPanel = new VerticalPanel();

		outer = new DockPanel();
		initWidget(outer);

		outer.setStyleName("main");

		westLabel = new Label("no name");
		listArticles = new HTML();
		westPanel.add(new HTML("Main West"));
		westPanel.add(listArticles);
		westPanel.add(westLabel);
		
		north = new HorizontalPanel();
		north.add(new HTML(AppLocale.constants().app_title()));
		north.addStyleName("northPanel");

		outer.add(north, DockPanel.NORTH);
		outer.add(westPanel, DockPanel.WEST);
		outer.add(east, DockPanel.EAST);
	}

	@Override
	public void setWestLabel(String westLabel) {
		this.westLabel.setText(westLabel);
	}

	@Override
	public void setListArticles(String listArticles) {
		this.listArticles.setHTML(listArticles);
	}

	@Override
	public void setEast(Widget widget) {
		east.clear();
		east.add(widget);
	}
}
