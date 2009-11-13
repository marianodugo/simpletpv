/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class ArticleFormView extends AbstractView 
		implements ArticleFormPresenter.Display {

	final private ArticleConstants constants;
	private FlexTable panel;

	private TextBox labelTextBox;
	private TextBox descriptionTextBox;
	private TextBox priceTextBox;

	private Button submitButton;
	private Button cancelButton;
	
	public ArticleFormView() {
		constants = GWT.create(ArticleConstants.class);
		
		sinkEvents(Event.ONKEYPRESS);
		
		initWidget(createForm());
	}
	
	private Widget createForm() {
		final Panel outer = new VerticalPanel();
		
		panel = new FlexTable();
		panel.setCellSpacing(6);
		
		labelTextBox = new TextBox();
		createFormLine(constants.formLabel(), labelTextBox);
		labelTextBox.setFocus(true);
		
		descriptionTextBox = new TextBox();
		createFormLine(constants.formDescription(), descriptionTextBox);
		
		priceTextBox = new TextBox();
		createFormLine(constants.formPrice(), priceTextBox);
		
		outer.add(panel);
		
		final HorizontalPanel buttonsPanel = new HorizontalPanel();
		buttonsPanel.setSpacing(5);
		
		submitButton = new Button(AppLocale.constants().submit());
		buttonsPanel.add(submitButton);
		
		cancelButton = new Button(AppLocale.constants().cancel());
		buttonsPanel.add(cancelButton);
		
		outer.add(buttonsPanel);
		
		return outer;
	}
	
	private void createFormLine(String header, Widget value) {
		int numRows = panel.getRowCount();

		panel.setHTML(numRows, 0, header);
		panel.setWidget(numRows, 1, value);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Composite#onBrowserEvent(com.google.gwt.user.client.Event)
	 */
	@Override
	public void onBrowserEvent(Event event) {
		if(event.getKeyCode() == KeyCodes.KEY_ENTER)
			submitButton.click();
		
		super.onBrowserEvent(event);
	}

	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}

	@Override
	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	@Override
	public Focusable getLabelFocus() {
		return labelTextBox;
	}

	@Override
	public HasValue<String> getDescriptionTextBox() {
		return descriptionTextBox;
	}

	@Override
	public HasValue<String> getLabelTextBox() {
		return labelTextBox;
	}

	@Override
	public HasValue<String> getPriceTextBox() {
		return priceTextBox;
	}
}
