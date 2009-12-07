/**
 * 
 */
package cbmarc.simpletpv.client.mvp.article;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import cbmarc.framework.client.mvp.AbstractPresenter;
import cbmarc.framework.shared.event.LoadingEvent;
import cbmarc.framework.shared.rpc.GenericResult;
import cbmarc.simpletpv.shared.entity.Article;
import cbmarc.simpletpv.shared.event.SendArticleEvent;
import cbmarc.simpletpv.shared.rpc.SendArticle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;

/**
 * @author MCOSTA
 *
 */
public class ArticleFormPresenter 
		extends AbstractPresenter<ArticleFormPresenter.Display> {

	public interface Display extends AbstractPresenter.Display {
		public HasValue<String> getLabelTextBox();
		public HasValue<String> getDescriptionTextBox();
		public HasValue<String> getPriceTextBox();
		
		public Focusable getLabelFocus();
		
		public HasClickHandlers getSubmitButton();
		public HasClickHandlers getCancelButton();
	}
	
	public static final Place PLACE = new Place("ArticleForm");
	
	private final DispatchAsync dispatcher;
	
	/**
	 * @param display
	 * @param eventBus
	 * @param dispatcher
	 */
	@Inject
	public ArticleFormPresenter(Display display, EventBus eventBus
			, final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		bind();
	}

	/* (non-Javadoc)
	 * @see cbmarc.framework.client.mvp.AbstractPresenter#onBind()
	 */
	@Override
	protected void onBind() {
		display.getSubmitButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doSubmit();
			}
			
		});
		
		display.getCancelButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doCancel();
			}
			
		});
	}
	
	/**
	 * 
	 */
	private void doReset() {
		display.getLabelTextBox().setValue("");
		display.getDescriptionTextBox().setValue("");
		display.getPriceTextBox().setValue("");

		display.getLabelFocus().setFocus(true);
	}
	
	/**
	 * 
	 */
	private void doSubmit() {
		try {
			int labelSize = display.getLabelTextBox().getValue().length();
			float price = new Float(display.getPriceTextBox().getValue());
			
			if(labelSize == 0 || labelSize > 25 || price > 100 || price < 0)
				throw new Exception();
			
			Article article = new Article(
					display.getLabelTextBox().getValue(),
					display.getDescriptionTextBox().getValue(),
					price);

			doSend(article);
		} catch(Exception e) {
			Window.alert(e.toString());
		}
	}
	
	/**
	 * 
	 */
	private void doCancel() {
		doReset();
	}
	
	/**
	 * 
	 */
	private void doSend(Article article) {
		eventBus.fireEvent(new LoadingEvent(false));

		dispatcher.execute(
				new SendArticle(article),
				new DisplayCallback<GenericResult>(display) {

					@Override
					protected void handleFailure(Throwable e) {
						eventBus.fireEvent(new LoadingEvent(true));
						Window.alert("FAILURE: " + e.getCause());
					}

					@Override
					protected void handleSuccess(GenericResult value) {
						eventBus.fireEvent(new LoadingEvent(true));
						eventBus.fireEvent(new SendArticleEvent());
						doReset();
					}
					
				});
	}
}
