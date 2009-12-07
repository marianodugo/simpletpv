/**
 * 
 */
package cbmarc.simpletpv.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * @author MCOSTA
 * 
 * SOURCE: http://employeeadm.appspot.com/
 *
 */
public class SelectableFlexTable extends FlexTable {
	public void selectRow(int row) {
		getRowFormatter().addStyleName(row, "selected");
	}
	
	public void unSelectRow(int row) {
		getRowFormatter().removeStyleName(row, "selected");
	}
	
	public int getRowForEvent(ClickEvent event) {
		return getCellForEvent(event).getRowIndex();
	}
}
