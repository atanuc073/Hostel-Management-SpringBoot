package com.cg.hostelmgmt.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class StudentDto {
	private Integer studentId;
	@NotBlank(message = "Student Name can not be empty")
	private String name;
	@Past(message="Student birth date must be a previous date")
	private LocalDate dob;
	@NotBlank(message="student email id can not be empty")
	@Email(message="Must be a valid email id")
	private String emailId;
	@Pattern(regexp = "^[0-9]{10}",message="Mobile Number should be 10 digits")
	private String contactNumber;
	@Pattern(regexp = "(male|female|other)",message="gender should be ma;le/female/other")
	private String gender;
	private String image;
	@NotBlank(message="address should not be blank")
	private String address;
	
	// constructor
	public StudentDto() {
		super();
		
	}

	public StudentDto(Integer studentId, String name, LocalDate dob, String emailId, String contactNumber,
			String gender, String image, String address) {
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

	public StudentDto(String name, LocalDate dob, String emailId, String contactNumber, String gender, String image,
			String address) {
		super();
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.image = image;
		this.address = address;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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


}
