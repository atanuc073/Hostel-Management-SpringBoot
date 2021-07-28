package com.cg.hostelmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hostelmgmt.entity.Warden;
@Repository
public interface IWarden extends JpaRepository<Warden, Integer>{

}
