package com.sid.autoEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.Fault;
import com.sid.autoEcole.entities.Session;
import com.sid.autoEcole.entities.Student;

@RepositoryRestResource
public interface FaultRepository extends JpaRepository<Fault, Long> {
	
	public Fault findBySessionAndStudent(Session session, Student student);

}
