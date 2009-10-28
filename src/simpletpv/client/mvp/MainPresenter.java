/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.shared.rpc.GenericResult;
import simpletpv.shared.rpc.SendArticle;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;

/**
 * @author MCOSTA
 *
 */
public class MainPresenter extends WidgetPresenter<MainPresenter.Display> {
	public interface Display extends WidgetDisplay {
		public HasValue<String> getNameTextBox();
		public HasClickHandlers getSubmitButton();
	}

	public static final Place PLACE = new Place("Main");
	
	private final DispatchAsync dispatcher;

	@Inject
	public MainPresenter(final Display display, final EventBus eventBus
			, final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		bind();
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		display.getSubmitButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doSend();
			}
			
		});
	}
	
	private void doSend() {
		dispatcher.execute(
				new SendArticle("lalala"), 
				new DisplayCallback<GenericResult>(display) {

					@Override
					protected void handleFailure(Throwable e) {
						Window.alert("FAILURE: " + e.getCause());
					}

					@Override
					protected void handleSuccess(GenericResult value) {
						Window.alert("SUCCESS: " + value.getMessage());
					}
					
				});
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
	}

	@Override
	protected void onUnbind() {		
	}

	@Override
	public void refreshDisplay() {		
	}

	@Override
	public void revealDisplay() {		
	}
}
