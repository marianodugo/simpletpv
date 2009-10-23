/**
 * 
 */
package simpletpv.client.mvp;

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
public class BottomPresenter extends WidgetPresenter<BottomPresenter.Display> {
	public interface Display extends WidgetDisplay {
	}

	public static final Place PLACE = new Place("Bottom");

	@Inject
	public BottomPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		bind();
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
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
