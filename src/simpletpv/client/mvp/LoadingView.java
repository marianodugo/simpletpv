/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.client.localization.AppLocale;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class LoadingView extends PopupPanel 
		implements LoadingPresenter.Display {
	
	private final FlowPanel outer = new FlowPanel();
	
	public LoadingView() {
		//final Image ajaxImage = new Image("path_to_ajax_wait_image");
		final Grid grid = new Grid(1, 2);

		//grid.setWidget(0, 0, ajaxImage);
		grid.setText(0, 1, AppLocale.constants().loading());
		
		outer.add(grid);
		add(outer);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void startProcessing() {
		center();
		show();
	}

	@Override
	public void stopProcessing() {
		hide();
	}

	@Override
	public void showWidget() {
		startProcessing();
	}

}
