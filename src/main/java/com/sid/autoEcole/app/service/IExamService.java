package com.sid.autoEcole.app.service;

import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.models.forms.ExamResultForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IExamService  {

    List<Student> findAllAuthorizedStudent();

    Page<Student> findAuthorizedStudentToPassExam();

    Boolean updateStudentInformationAfterExam(List<ExamResultForm> examResultForm);

}
