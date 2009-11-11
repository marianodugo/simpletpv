/**
 * 
 */
package cbmarc.framework.client.mvp;

import cbmarc.framework.shared.event.LoadingEvent;
import cbmarc.framework.shared.event.LoadingEventHandler;

import com.google.inject.Inject;

import net.customware.gwt.presenter.client.EventBus;

/**
 * @author MCOSTA
 *
 */
public class LoadingPresenter extends 
		AbstractPresenter<LoadingPresenter.Display> {
	public interface Display extends AbstractPresenter.Display {
		public void showWidget();
	}

	@Inject
	public LoadingPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		bind();
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
