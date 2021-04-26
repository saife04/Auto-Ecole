package com.sid.autoEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.ExamResult;
import com.sid.autoEcole.entities.Student;

@RepositoryRestResource
public interface ExmanResultRepository extends JpaRepository<ExamResult, Long> {

}
