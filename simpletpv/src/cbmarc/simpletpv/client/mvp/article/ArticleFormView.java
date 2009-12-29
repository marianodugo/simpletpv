/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import cbmarc.framework.client.mvp.AbstractView;
import cbmarc.simpletpv.client.i18n.AppLocale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author MCOSTA
 *
 */
public class ArticleFormView extends AbstractView 
		implements ArticleFormPresenter.Display {
	final private ArticleConstants constants;

	interface MyUiBinder extends UiBinder<Widget, ArticleFormView> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField HasText labelLabel;
	@UiField TextBox labelTextBox;
	
	@UiField HasText descriptionLabel;
	@UiField HasValue<String> descriptionTextBox;
	
	@UiField HasText priceLabel;
	@UiField HasValue<String> priceTextBox;

	@UiField Button submitButton;
	@UiField Button cancelButton;
	
	/**
	 * 
	 */
	public ArticleFormView() {
		constants = GWT.create(ArticleConstants.class);
		sinkEvents(Event.ONKEYPRESS);
		initWidget(uiBinder.createAndBindUi(this));
		
		labelLabel.setText(constants.formLabel());
		descriptionLabel.setText(constants.formDescription());
		priceLabel.setText(constants.formPrice());
		
		submitButton.setText(AppLocale.constants().submit());
		cancelButton.setText(AppLocale.constants().cancel());
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
