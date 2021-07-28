package com.cg.hostelmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hostelmgmt.entity.Room;

@Repository
public interface IRoomDao extends JpaRepository<Room, Integer>{

}
