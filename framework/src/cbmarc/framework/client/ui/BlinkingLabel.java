package cbmarc.framework.client.ui;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;

/*
 * Source: http://www.arundhaj.com/2008/12/gwt-blinking-label.html
 * 
 * BlinkingLabel blinkLabel = new BlinkingLabel();
 * // Timer will start only if visibility set to true,
 * // if false it will cancel the timer
 * blinkLabel.setVisible(true);
 * blinkLabel.setText("0 device offline");
 */

public class BlinkingLabel extends Label {
	// Swap color based on this color type. This variable
	// holds either 0 or 1
	int colorType;

	// Timer to enable the Label to blink
	Timer blinkingTimer;

	public BlinkingLabel() {
	    super();
	    // Initially single color
	    addStyleName("OfflineLabel");
	    setColorType(0);
	    initTimer();
	}

	public BlinkingLabel(String text) {
	    super(text);
	    // Initially single color
	    addStyleName("OfflineLabel");
	    setColorType(0);
	    initTimer();
	}

	private void initTimer() {
	    blinkingTimer = new Timer() {
	        public void run() {
	            // Swap the style based on previous colorType
	            if(colorType == 0) {
	                removeStyleName("OfflineLabel-blink");
	                addStyleName("OfflineLabel");
	                setColorType(1);
	            } else {
	                removeStyleName("OfflineLabel");
	                addStyleName("OfflineLabel-blink");
	                setColorType(0);
	            }
	        }
	    };
	}

	public int getColorType() {
	    return colorType;
	}

	public void setColorType(int colorType) {
	    this.colorType = colorType;
	}

	// overridden this method to Start/Stop the timer based on visibility
	public void setVisible(boolean visible) {
	    super.setVisible(visible);

	    // start timer if visible, else cancel it
	    if(visible) {
	        // blink for every 1 second
	        blinkingTimer.scheduleRepeating(1000);
	    } else {
	        blinkingTimer.cancel();
	    }
	}
}