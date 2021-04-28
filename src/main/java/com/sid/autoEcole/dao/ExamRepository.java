package com.sid.autoEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.Exam;
import com.sid.autoEcole.entities.Student;

@RepositoryRestResource
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
