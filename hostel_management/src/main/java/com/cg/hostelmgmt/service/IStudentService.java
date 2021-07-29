package com.cg.hostelmgmt.service;

import java.util.List;
import java.util.Map;

import com.cg.hostelmgmt.dto.StudentDto;
import com.cg.hostelmgmt.entity.Student;
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.StudentNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;

public interface IStudentService {
	public Map<String, String> addStudent(StudentDto studentdto) throws WardenNotFoundException, HostelNotFoundException, RoomNotFoundException, PhoneNumberAlreadyExistsException;
	public List<Student> getStudent() throws StudentNotFoundException;
	public Student removeStudentById() throws StudentNotFoundException;
	public Student getStudentById() throws StudentNotFoundException;
	public List<Student> getStudentsByName() throws StudentNotFoundException;
	public Student getStudentByMobileNumber(String mobileNumber) throws StudentNotFoundException;
	

}
