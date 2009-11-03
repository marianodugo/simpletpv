/**
 * 
 */
package simpletpv.shared.entity;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author mcosta
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Article extends AbstractArticle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String description;

	/**
	 * @param description
	 */
	public Article(String description) {
		super();
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
