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
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="room_id")
	private Integer roomId;
	@Column(name="room_no")
	private String roomNo;
	@Column(name="description")
	private String description;
	@ManyToOne
	@JoinColumn(name="hostel_id", referencedColumnName = "hostel_id")
	private Hostel hostel;
	@OneToMany(mappedBy = "room")
	private Set<Student> students;
	
	// Constructor
	
	public Room(Integer roomId, String roomNo, String description) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.description = description;
	}


	public Room() {
		super();
	}

	// Getter and Setter
	
	public Integer getRoomId() {
		return roomId;
	}


	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Hostel getHostel() {
		return hostel;
	}


	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}


	public Set<Student> getstudents() {
		return students;
	}


	public void setstudents(Set<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return roomId + " " + roomNo + " " + description + " " + hostel
				+ " " + students + " ";
	}
	
	
	

	

}
