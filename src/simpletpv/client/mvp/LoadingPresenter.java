/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.shared.events.LoadingEvent;
import simpletpv.shared.events.LoadingEventHandler;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

/**
 * @author MCOSTA
 *
 */
public class LoadingPresenter extends 
		WidgetPresenter<LoadingPresenter.Display> {
	public interface Display extends WidgetDisplay {
		public void showWidget();
	}
	
	public static final Place PLACE = new Place("Loading");

	@Inject
	public LoadingPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		bind();
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(LoadingEvent.TYPE, 
				new LoadingEventHandler() {

					@Override
					public void onLoading(boolean isComplete) {
						if(isComplete) {
							display.stopProcessing();
						} else {
							display.startProcessing();
						}
					}			
		}));
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revealDisplay() {
		// TODO Auto-generated method stub
		
	}
}
