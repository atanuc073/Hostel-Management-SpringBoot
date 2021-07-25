package com.cg.hostemmgmt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "warden")
public class Warden {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="warden_id")
	private Integer wardenId;
	@Column(name="warden_name")
	private String wardenName;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="address")
	private String address;
	@Column(name="gender")
	private String gender;
	@Column(name="image")
	private String image;
	@OneToOne
	private Hostel hostel;
	@OneToMany
	private Set<User> users;
	
	// constructor
	
	public Warden() {
		super();
		
	}

	public Warden(Integer wardenId, String wardenName, String contactNumber, String address, String gender,
			String image) {
		super();
		this.wardenId = wardenId;
		this.wardenName = wardenName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.gender = gender;
		this.image = image;
	}
	
	// Getter and Setter

	public Integer getWardenId() {
		return wardenId;
	}

	public void setWardenId(Integer wardenId) {
		this.wardenId = wardenId;
	}

	public String getWardenName() {
		return wardenName;
	}

	public void setWardenName(String wardenName) {
		this.wardenName = wardenName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return wardenId + " " + wardenName + " " + contactNumber
				+ " " + address + " " + gender + " ";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}