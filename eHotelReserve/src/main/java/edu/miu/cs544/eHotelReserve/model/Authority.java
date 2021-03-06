package edu.miu.cs544.eHotelReserve.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

   	@Column(nullable = false)
 	private String authority;
 	
	 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

 	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
 
 	
}
