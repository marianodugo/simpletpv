/**
 * 
 */
package cbmarc.simpletpv.shared.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String company;
	
	@Persistent
	private String employee;
	
	@Persistent
	private Long cashier;
	
	@Persistent
	private Date date;
	
	@Persistent
	private Long payment;
	
	@Persistent
	private Float price;
	
	@Persistent
	private Long service;
	
	@Persistent
	private String user;
	
	@Persistent
	private List<TicketLines> lines;
	
	@SuppressWarnings("unused")
	private Ticket() {
	}

	/**
	 * @param description
	 */
	public Ticket(String company, String employee, List<TicketLines> lines) {
		this.company = company;
		this.employee = employee;
		this.lines = lines;
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
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	/**
	 * @return the cashier
	 */
	public Long getCashier() {
		return cashier;
	}

	/**
	 * @param cashier the cashier to set
	 */
	public void setCashier(Long cashier) {
		this.cashier = cashier;
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

	/**
	 * @return the payment
	 */
	public Long getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Long payment) {
		this.payment = payment;
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
	 * @return the service
	 */
	public Long getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Long service) {
		this.service = service;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the lines
	 */
	public List<TicketLines> getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(List<TicketLines> lines) {
		this.lines = lines;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Ticket");
		sb.append("[id: " + this.id + "]");
		sb.append("]");
		
		return sb.toString();
	}
}
