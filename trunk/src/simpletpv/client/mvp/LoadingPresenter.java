/**
 * 
 */
package simpletpv.client.mvp;

import simpletpv.shared.events.LoadingEvent;
import simpletpv.shared.events.LoadingEventHandler;

import com.google.inject.Inject;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;

/**
 * @author MCOSTA
 *
 */
public class LoadingPresenter extends 
		AbstractPresenter<LoadingPresenter.Display> {
	public interface Display extends AbstractPresenter.Display {
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
}
