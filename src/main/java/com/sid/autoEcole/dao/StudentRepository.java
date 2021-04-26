package com.sid.autoEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.Student;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

}
