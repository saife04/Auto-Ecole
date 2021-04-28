package com.sid.autoEcole.dao;

import com.sid.autoEcole.entities.CdRom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.Student;

import java.util.List;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM student s WHERE "
            + "	("
            + "		s.authorized = true)"
            + "		AND"
            + "		( s.status = 'ACTIVE' OR s.status = 'FAILED_EXAM' ) order by s.id")
    List<Student> findAllAuthorized();


    @Query("SELECT s FROM student s WHERE "
            + "	("
            + "		s.authorized = true)"
            + "		AND"
            + "		( s.status = 'ACTIVE' OR s.status = 'FAILED_EXAM' ) order by s.authorizationDate")
    Page<Student> findAuthorized(Pageable pageable);


    @Query("SELECT s FROM student s WHERE "
            + "		( s.status = 'FAILED_EXAM' ) order by s.id")
    List<Student> getFailedStudent();


}
