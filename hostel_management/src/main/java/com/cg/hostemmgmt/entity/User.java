package com.cg.hostemmgmt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="name")
	private String name;
	@Column(name="dob")
	private LocalDate dob;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="gender")
	private String gender;
	@Column(name="iamge")
	private String image;
	@Column(name="address")
	private String address;
	@OneToOne
	private Warden warden;
	@OneToOne
	private Hostel hostel;
	@OneToOne
	private Room room;
	
	
	// Constructor
	public User() {
		super();
	}


	public User(Integer userId, String name, LocalDate dob, String contactNumber, String gender, String image,
			String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.image = image;
		this.address = address;
	}

	
	// Getter and Setter
	
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Warden getWarden() {
		return warden;
	}


	public void setWarden(Warden warden) {
		this.warden = warden;
	}


	public Hostel getHostel() {
		return hostel;
	}


	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	@Override
	public String toString() {
		return userId + "" + name + " " + dob + " " + contactNumber
				+ " " + gender + " " + image + " " + address + " ";
	}
	
	
	
	
	
	
	
	
	

}
