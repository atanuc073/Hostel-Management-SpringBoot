package com.cg.hostelmgmt.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hostelmgmt.dto.StudentDto;
import com.cg.hostelmgmt.dto.SuccessMessage;
import com.cg.hostelmgmt.entity.Student;
import com.cg.hostelmgmt.exception.EmailIdAlreadyExistsException;
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;
import com.cg.hostelmgmt.service.IStudentService;

@RestController
public class StudentCrudController {
	@Autowired
	private IStudentService studentService;
	@PostMapping("addstudent")
	public Student addStudent(@Valid @RequestBody StudentDto studentDto) throws WardenNotFoundException, HostelNotFoundException, RoomNotFoundException, PhoneNumberAlreadyExistsException, EmailIdAlreadyExistsException {
		Student student =studentService.addStudent(studentDto);
		return student;
		
	}
	
	

}
