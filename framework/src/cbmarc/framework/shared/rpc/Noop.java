/**
 * 
 */
package cbmarc.framework.shared.rpc;


/**
 * @author mcosta
 * 
 * NOOP (short for No OPeration or No Operation Performed)
 *
 */
public class Noop extends Session<NoopResult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Noop(String session) {
		super(session);
	}
	
	@SuppressWarnings("unused")
	private Noop() {
	}

}
