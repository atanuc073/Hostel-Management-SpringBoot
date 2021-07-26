package com.cg.hostelmgmt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hostel")
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hostel_id")
	private Integer hostelId;
	@Column(name="hostel_name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="address")
	private String address;
	@Column(name="description")
	private String description;
	@Column(name = "fees")
	private Integer fees;
	@OneToOne
	@JoinColumn(name="warden_id",referencedColumnName = "warden_id")
	private Warden warden;
	@OneToMany(mappedBy = "hostel")
	private Set<Room> rooms;
	@OneToMany(mappedBy = "hostel")
	private Set<User> users;
	
	// Constructor
	
	
	

	public Hostel() {
		super();
		
	}
	
	public Hostel(Integer hostelId, String name, String type, String contactNumber, String address, String description,
			Integer fees) {
		super();
		this.hostelId = hostelId;
		this.name = name;
		this.type = type;
		this.contactNumber = contactNumber;
		this.address = address;
		this.description = description;
		this.fees = fees;
	}

	// Getter and Setter

	public Integer getHostelId() {
		return hostelId;
	}

	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Warden getWarden() {
		return warden;
	}



	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setWarden(Warden warden) {
		this.warden = warden;
	}

	@Override
	public String toString() {
		return hostelId + " " + name +" " + type +" "+contactNumber +" "
				+ address + " " + description + " " + fees;
	}
	
	
	
	
	
	
	
	
	

}
