package com.cg.hostelmgmt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hostelmgmt.dao.IHostelDao;
import com.cg.hostelmgmt.dao.IRoomDao;
import com.cg.hostelmgmt.dao.IStudentDao;
import com.cg.hostelmgmt.dao.IWardenDao;
import com.cg.hostelmgmt.dto.StudentDto;
import com.cg.hostelmgmt.entity.Hostel;
import com.cg.hostelmgmt.entity.Room;
import com.cg.hostelmgmt.entity.Student;
import com.cg.hostelmgmt.entity.Warden;
import com.cg.hostelmgmt.exception.EmailIdAlreadyExistsException;
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.MobileNumberNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.StudentNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;
import com.cg.hostelmgmt.utils.StudentConstants;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private IStudentDao studentdao;
	@Autowired
	private IRoomDao roomdao;
	@Autowired
	private IHostelDao hosteldao;
	@Autowired
	private IWardenDao wardendao;
	

	@Override
	public Student addStudent(StudentDto studentdto) throws WardenNotFoundException, HostelNotFoundException, RoomNotFoundException, PhoneNumberAlreadyExistsException, EmailIdAlreadyExistsException {
		Student student = new Student();
		
		if(!checkPhoneNumber(studentdto.getContactNumber())) {
			throw new PhoneNumberAlreadyExistsException(StudentConstants.CONTACT_NUMBER_ALREADY_EXISTS);
		}
		if(!checkEmail(studentdto.getEmailId())) {
			throw new EmailIdAlreadyExistsException(StudentConstants.EMAIL_ALREADY_EXISTS);
		}
		System.out.println("Line 1");
		Optional<Warden> optWarden =wardendao.findById(studentdto.getWardenId());
		if(optWarden.isEmpty()) {
			throw new WardenNotFoundException(StudentConstants.WARDEN_NOT_FOUND);
		}
		System.out.println("Line2");
		Warden warden =optWarden.get();
		student.setWarden(warden);
		System.out.println("Line 3");
		Optional<Hostel> optHostel = hosteldao.findById(studentdto.getHostelID());
		if(optHostel.isEmpty()) {
			throw new HostelNotFoundException(StudentConstants.HOSTEL_NOT_FOUND);
		}
		Hostel hostel = optHostel.get();
		student.setHostel(hostel);
		
		
		System.out.println("Line 4");
		Optional<Room> optRoom =roomdao.findById(studentdto.getRoomId());
		if(optRoom.isEmpty()) {
			throw new RoomNotFoundException(StudentConstants.ROOM_NOT_FOUND);
		}
		Room room =optRoom.get();
		student.setRoom(room);
		System.out.println("Line 5");
		
		student.setName(studentdto.getName().toLowerCase());
		student.setDob(studentdto.getDob());
		student.setEmailId(studentdto.getEmailId());
		student.setContactNumber(studentdto.getContactNumber());
		student.setGender(studentdto.getGender());
		student.setAddress(studentdto.getAddress());
		student.setImage("image");
		Student savedStudent = studentdao.save(student);
		System.out.println("hello");
		Student newStudent =studentdao.getById(savedStudent.getStudentId());
		System.out.println("world");
		newStudent.setImage(studentdto.getName()+savedStudent.getStudentId().toString());
		Student savedStudent1 = studentdao.save(student);
		
		
		
		return savedStudent1;
	}
	
	private Boolean checkPhoneNumber(String phone){
		List<Student> students =studentdao.findByContactNumber(phone);;
		return students.isEmpty();
		
	}
	private Boolean checkEmail(String email){
		List<Student> students =studentdao.findByEmailId(email);
		return students.isEmpty();
		
	}

	@Override
	public List<Student> getStudents() throws StudentNotFoundException {
		List<Student> students = studentdao.findAll();
		if (students.isEmpty()) {
			throw new StudentNotFoundException();
		}
		return students;
	}

	@Override
	public Student removeStudentById(Integer studentId) throws StudentNotFoundException {
		Optional<Student> optStudent = studentdao.findById(studentId);
		if(optStudent.isEmpty()) {
			throw new StudentNotFoundException();
		}
		Student student =optStudent.get();
		studentdao.deleteById(studentId);
		
		
		return student;
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		Optional<Student> optStudent = studentdao.findById(studentId);
		if(optStudent.isEmpty()) {
			throw new StudentNotFoundException();
		}
		Student student =optStudent.get();
		return student;
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentNotFoundException {
		List<Student> students = studentdao.findByNameContaining(name.toLowerCase());
		if(students.isEmpty()) {
			throw new StudentNotFoundException(StudentConstants.NO_STUDENT_WITH_THIS_NAME);
		}
		return students;
	}

	@Override
	public List<Student> getStudentByMobileNumber(String mobileNumber) throws StudentNotFoundException, MobileNumberNotFoundException {
		List<Student> students=studentdao.findByContactNumber(mobileNumber);
		if(students.isEmpty()) {
			throw new MobileNumberNotFoundException(StudentConstants.MOBILE_NUMBER_NOT_FOUND);
		}
		return students;
	}
	

}
