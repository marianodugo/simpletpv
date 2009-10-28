/**
 * 
 */
package simpletpv.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

/**
 * @author MCOSTA
 *
 */
public class SendArticle implements Action<GenericResult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public SendArticle(final String name) {
		this.name = name;
	}
	
	public String getArticle() {
		return name;
	}

}
