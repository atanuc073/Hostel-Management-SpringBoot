package com.cg.hostelmgmt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private Integer studentId;
	@Column(name="name")
	private String name;
	@Column(name="dob")
	private LocalDate dob;
	@Column(name="email_id")
	private String emailId;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="gender")
	private String gender;
	@Column(name="iamge")
	private String image;
	@Column(name="address")
	private String address;
	@OneToOne
	@JoinColumn(name="warden_id",referencedColumnName = "warden_id")
	private Warden warden;
	@OneToOne
	@JoinColumn(name="hostel_id",referencedColumnName = "hostel_id")
	private Hostel hostel;
	@ManyToOne
	@JoinColumn(name="room_id",referencedColumnName = "room_id")
	private Room room;
	
	
	// Constructor
	public Student() {
		super();
	}
	

	public Student(Integer studentId, String name, LocalDate dob, String emailId, String contactNumber, String gender,
			String image, String address) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.image = image;
		this.address = address;
	}







	// Getter and Setter
	


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
	


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return studentId + "" + name + " " + dob + " " + contactNumber
				+ " " + gender + " " + image + " " + address + " ";
	}
	
	
	
	
	
	
	
	
	

}
