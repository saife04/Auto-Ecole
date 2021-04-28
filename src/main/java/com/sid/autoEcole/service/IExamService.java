package com.sid.autoEcole.service;

import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.models.forms.ExamResultForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IExamService  {

    List<Student> findAllAuthorizedStudent();

    Page<Student> findAuthorizedStudentToPassExam();

    Boolean updateStudentInformationAfterExam(List<ExamResultForm> examResultForm);

}
