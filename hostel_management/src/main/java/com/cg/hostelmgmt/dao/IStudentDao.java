package com.cg.hostelmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hostelmgmt.entity.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, Integer>{

}
