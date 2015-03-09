package domain;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Leave
 *
 */
@Entity

public class Leave implements Serializable {

	
	private Integer id;
	private Date from;
	private Date to;
	private String subject;
	private Boolean state;
	private static final long serialVersionUID = 1L;

	public Leave() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}   
	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
   
}
