/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.client.localization.AppLocale;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class MainView extends Composite implements MainPresenter.Display  {
	private final DockPanel outer;
	private TextBox nameTextBox;
	private Button submitButton;

	public MainView() {
		outer = new DockPanel();
		initWidget(outer);
		
		outer.setBorderWidth(1);
		outer.setStyleName("main");
		outer.add(new HTML("Main West"), DockPanel.WEST);
		outer.add(createForm(), DockPanel.EAST);
	}
	
	private Widget createForm() {
		HorizontalPanel layout = new HorizontalPanel();
		
		layout.setSpacing(5);

		nameTextBox = new TextBox();
        submitButton = new Button(AppLocale.constants().submit());
        
		layout.add(new HTML(AppLocale.constants().name() + " :"));
		layout.add(nameTextBox);
		layout.add(submitButton);
		
		return layout;
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

	@Override
	public HasValue<String> getNameTextBox() {
		return nameTextBox;
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}
}
