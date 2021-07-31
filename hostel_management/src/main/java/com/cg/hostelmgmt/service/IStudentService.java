package com.cg.hostelmgmt.service;

import java.util.List;


import com.cg.hostelmgmt.dto.StudentDto;
import com.cg.hostelmgmt.entity.Student;
import com.cg.hostelmgmt.exception.EmailIdAlreadyExistsException;
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.MobileNumberNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.StudentNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;

public interface IStudentService {
	public Student addStudent(StudentDto studentdto) throws WardenNotFoundException, HostelNotFoundException, RoomNotFoundException, PhoneNumberAlreadyExistsException, EmailIdAlreadyExistsException;
	public List<Student> getStudents() throws StudentNotFoundException;
	public Student removeStudentById(Integer studentId) throws StudentNotFoundException;
	public Student getStudentById(Integer studentId) throws StudentNotFoundException;
	public List<Student> getStudentsByName(String name) throws StudentNotFoundException;
	public List<Student> getStudentByMobileNumber(String mobileNumber) throws StudentNotFoundException, MobileNumberNotFoundException;
	
	

}
