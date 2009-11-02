/**
 * 
 */
package simpletpv.client.mvp;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

/**
 * @author MCOSTA
 *
 */
public abstract class AbstractPresenter<D extends AbstractPresenter.Display> 
		extends WidgetPresenter<D> {
	public interface Display extends WidgetDisplay {
	}
	
	public AbstractPresenter(final D display, final EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub
		
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
