package edu.miu.cs544.eHotelReserve.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class User implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	// private String userID;

	@NotEmpty(message = "{NotEmpty.validation}")
	private String firstName;

	@NotEmpty(message = "{NotEmpty.validation}")
	private String lastName;

	@Column(name = "email")
	@NotEmpty(message = "{NotEmpty}")
	@Email(message="{Email.validation}")
	private String email;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "username", nullable = true, unique = true)
	private UserCredential userCredentials;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Booking> booking;
	
	
    public UserCredential getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredential userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserCredential getUserCredential() {
		return userCredentials;
	}

	public void setUserCredential(UserCredential userCredentials) {
		this.userCredentials = userCredentials;
	}

	public User() {
	}

	public User(String firstName, String lastName, Address address, String userName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email=email;
	}

	public Long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
