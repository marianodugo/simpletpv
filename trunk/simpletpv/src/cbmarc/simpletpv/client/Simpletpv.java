package cbmarc.simpletpv.client;

import cbmarc.simpletpv.client.gin.AppGinjector;
import cbmarc.simpletpv.client.mvp.AppPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Simpletpv implements EntryPoint {
	private final AppGinjector injector = GWT.create(AppGinjector.class);

	@Override
	public void onModuleLoad() {
		final AppPresenter appPresenter = injector.getAppPresenter();

		appPresenter.go(RootPanel.get());
		injector.getPlaceManager().fireCurrentPlace();
	}
}
