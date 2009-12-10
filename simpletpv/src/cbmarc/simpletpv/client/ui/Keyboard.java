/**
 * 
 */
package cbmarc.simpletpv.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author MCOSTA
 * 
 * SOURCE:
 * http://lemnik.wordpress.com/2009/03/12/using-event-handlers-in-gwt-16/
 *
 */
public class Keyboard extends Composite 
		implements HasSelectionHandlers<String> {
	
	private HorizontalPanel outer;
	private final List<KeyButton> bList = new ArrayList<KeyButton>();
	private final String buttons[][] = {
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-"},
			{"", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "DEL"},
			{"", "", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":"},
			{"TAB", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ";"},
			{"","","","","","SPACE","","","","","","CLEAR"}
	};
	
	private final int buttonSpacing = 3;
	private final String buttonWidth = "60px";
	private final String buttonHeight = "60px";
	
	/**
	 * 
	 */
	public Keyboard() {
		outer = new HorizontalPanel();
		initWidget(outer);
		
		outer.setBorderWidth(5);
		createKeyboard();
	}
	
	/**
	 * 
	 */
	private void createKeyboard() {
		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(buttonSpacing);
		
		for(int i = 0; i < buttons.length; i++) {
			HorizontalPanel hp = new HorizontalPanel();
			hp.setSpacing(buttonSpacing);

			for(int j=0; j < buttons[i].length; j++) {
				if(buttons[i][j].isEmpty()) {
					hp.add(new HTML("&nbsp;&nbsp;&nbsp;"));
				} else {
					KeyButton b = new KeyButton(buttons[i][j]);
					bList.add(b);

					hp.add(b);
				}
			}
			
			vp.add(hp);
		}
		
		outer.add(vp);
	}
	
	/**
	 * @param keyButtonValue
	 */
	public void setClickKeyButton(final String keyButtonValue) {
		SelectionEvent.fire(this, keyButtonValue);
	}

	@Override
	public HandlerRegistration addSelectionHandler(
			SelectionHandler<String> handler) {
		return addHandler(handler, SelectionEvent.getType());
	}
	
	/**
	 * @author MCOSTA
	 *
	 */
	private class KeyButton extends Button {
		private HandlerRegistration registration;
		
		/**
		 * @param text
		 */
		public KeyButton(String text) {
			setText(text);
			setHeight(buttonHeight);
			
			if(text.length() < 2)
				setWidth(buttonWidth);
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onLoad()
		 */
		@Override
		protected void onLoad() {
			super.onLoad();
			
			registration = addDomHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					setClickKeyButton(KeyButton.this.getText());
				}
				
			}, ClickEvent.getType());
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onUnload()
		 */
		@Override
		protected void onUnload() {
			super.onUnload();
			
			registration.removeHandler();
			registration = null;
		}
	}
}