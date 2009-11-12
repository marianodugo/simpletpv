/**
 * 
 */
package cbmarc.simpletpv.shared.entity;

import java.io.Serializable;
import java.util.Date;

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
	private String label;
	
	@Persistent
	private String description;
	
	@Persistent
	private Float price;
	
	@Persistent
	private Date date;
	
	@SuppressWarnings("unused")
	private Article() {
	}

	/**
	 * @param description
	 */
	public Article(String label, String description, Float price) {
		super();
		this.label = label;
		this.description = description;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Article");
		sb.append("[id: " + this.id + "]");
		sb.append("[label: " + this.label + "]");
		sb.append("[description: " + this.description + "]");
		sb.append("[price: " + this.price + "]");
		sb.append("[date: " + this.date + "]");
		sb.append("]");
		
		return sb.toString();
	}
}
