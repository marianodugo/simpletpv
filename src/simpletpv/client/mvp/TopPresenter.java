/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.shared.rpc.SendGreeting;
import simpletpv.shared.rpc.SendGreetingResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

/**
 * @author MCOSTA
 *
 */
public class TopPresenter extends WidgetPresenter<TopPresenter.Display> {
	public interface Display extends WidgetDisplay {
		public HasClickHandlers getTopHyperlink();
	}

	public static final Place PLACE = new Place("Top");

	private final DispatchAsync dispatcher;

	@Inject
	public TopPresenter(final Display display, final EventBus eventBus
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
		display.getTopHyperlink().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				dispatcher.execute(
						new SendGreeting("test"),
						new DisplayCallback<SendGreetingResult>(display) {

							@Override
							protected void handleFailure(Throwable e) {
								Window.alert("FAILURE");
							}

							@Override
							protected void handleSuccess(
									SendGreetingResult value) {
								Window.alert("SUCCESS");
							}
					
				});
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
