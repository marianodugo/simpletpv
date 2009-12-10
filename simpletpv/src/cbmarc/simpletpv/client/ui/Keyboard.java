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
	
	// "\n" => new line
	// "\t" => insert tab
	private final String buttons[] = {
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "\n",
			"\t", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "<-", "\n",
			"\t", "\t", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\n",
			"TAB", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ";", "\n"
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
		int i0 = 0, i1 = 0;
		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(buttonSpacing);
		
		for(i0 = 0; i1 < buttons.length; ++i0) {
			HorizontalPanel hp = new HorizontalPanel();
			hp.setSpacing(buttonSpacing);

			for(; i1 < buttons.length; ++i1) {
				if(buttons[i1].equals("\t")) {
					hp.add(new HTML("&nbsp;&nbsp;&nbsp;"));
				} else if(buttons[i1].equals("\n")) {
					++i1;

					break;
				} else {
					KeyButton b = new KeyButton(buttons[i1]);
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

	/* (non-Javadoc)
	 * @see com.google.gwt.event.logical.shared.HasValueChangeHandlers#addValueChangeHandler(com.google.gwt.event.logical.shared.ValueChangeHandler)
	 */
	/*@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}*/
	
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
			setSize(buttonWidth, buttonHeight);
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