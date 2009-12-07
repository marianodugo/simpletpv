/**
 * 
 */
package cbmarc.simpletpv.shared.entity;

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
public class TicketLines implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private Article article;
	
	@Persistent
	private Integer quantity;
	
	@Persistent
	private Float price;
	
	@SuppressWarnings("unused")
	private TicketLines() {
	}

	/**
	 * @param description
	 */
	public TicketLines(Article article, Float price) {
		this.article = article;
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
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[TicketLines");
		sb.append("[id: " + this.id + "]");
		sb.append("]");
		
		return sb.toString();
	}
}
