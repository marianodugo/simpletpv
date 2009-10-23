package simpletpv.client.gin;

import simpletpv.client.mvp.AppPresenter;
import simpletpv.client.mvp.BottomPresenter;
import simpletpv.client.mvp.BottomView;
import simpletpv.client.mvp.MainPresenter;
import simpletpv.client.mvp.MainView;
import simpletpv.client.mvp.TopPresenter;
import simpletpv.client.mvp.TopView;

import com.google.inject.Singleton;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

public class AppClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {		
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(PlaceManager.class).in(Singleton.class);
		
		bindPresenter(TopPresenter.class, TopPresenter.Display.class, TopView.class);
		bindPresenter(MainPresenter.class, MainPresenter.Display.class, MainView.class);
		bindPresenter(BottomPresenter.class, BottomPresenter.Display.class, BottomView.class);
		
		bind(AppPresenter.class).in(Singleton.class);
	}
}