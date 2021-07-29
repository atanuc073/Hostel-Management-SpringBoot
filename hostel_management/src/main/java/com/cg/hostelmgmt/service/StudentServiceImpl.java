package com.cg.hostelmgmt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

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
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.StudentNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;
import com.cg.hostelmgmt.utils.StudentConstants;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService{
	
	private IStudentDao studentdao;
	private IRoomDao roomdao;
	private IHostelDao hosteldao;
	private IWardenDao wardendao;
	

	@Override
	public Map<String, String> addStudent(StudentDto studentdto) throws WardenNotFoundException, HostelNotFoundException, RoomNotFoundException, PhoneNumberAlreadyExistsException {
		Student student = new Student();
		
		if(!this.checkPhoneNumber(studentdto.getContactNumber())) {
			throw new PhoneNumberAlreadyExistsException(StudentConstants.CONTACT_NUMBER_ALREADY_EXISTS);
		}
		
		Optional<Warden> optWarden =wardendao.findById(studentdto.getWardenId());
		if(optWarden.isEmpty()) {
			throw new WardenNotFoundException(StudentConstants.WARDEN_NOT_FOUND);
		}
		Warden warden =optWarden.get();
		student.setWarden(warden);
		
		Optional<Hostel> optHostel = hosteldao.findById(studentdto.getHostelID());
		if(optHostel.isEmpty()) {
			throw new HostelNotFoundException(StudentConstants.HOSTEL_NOT_FOUND);
		}
		Hostel hostel = optHostel.get();
		
		
		
		Optional<Room> optRoom =roomdao.findById(studentdto.getRoomId());
		if(optRoom.isEmpty()) {
			throw new RoomNotFoundException(StudentConstants.ROOM_NOT_FOUND);
		}
		Room room =optRoom.get();
		student.setRoom(room);
		
		student.setName(studentdto.getName());
		student.setDob(studentdto.getDob());
		student.setEmailId(studentdto.getEmailId());
		student.setContactNumber(studentdto.getContactNumber());
		student.setGender(studentdto.getGender());
		student.setAddress(studentdto.getAddress());
		student.setImage(studentdto.getImage());
		
		
		
		return null;
	}
	
	private Boolean checkPhoneNumber(String phone){
		List<Student> students =studentdao.findByContactNumber(phone);
		return students.isEmpty();
		
	}
	private Boolean checkEmail(String email){
		List<Student> students =studentdao.findByEmailId(email);
		return students.isEmpty();
		
	}

	@Override
	public List<Student> getStudent() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student removeStudentById() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsByName() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByMobileNumber(String mobileNumber) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
