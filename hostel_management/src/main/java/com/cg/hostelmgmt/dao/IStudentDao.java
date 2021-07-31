package com.cg.hostelmgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hostelmgmt.entity.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, Integer>{
	
	public List<Student> findByEmailId(String emailId);
	public List<Student> findByContactNumber(String contactNumber);
	public List<Student> findByNameContaining(String name);

}
