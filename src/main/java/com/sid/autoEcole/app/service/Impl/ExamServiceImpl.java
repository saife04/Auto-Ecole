package com.sid.autoEcole.app.service.Impl;

import com.sid.autoEcole.app.dao.CdRomRepository;
import com.sid.autoEcole.app.dao.ExamRepository;
import com.sid.autoEcole.app.dao.StudentRepository;
import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.models.enums.StudentStatus;
import com.sid.autoEcole.app.models.forms.ExamResultForm;
import com.sid.autoEcole.app.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {


	private final CdRomRepository cdRomRepository;
	private final ExamRepository examRepository;
	private final StudentRepository studentRepository;


	@Autowired
	public ExamServiceImpl(CdRomRepository cdRomRepository, ExamRepository examRepository, StudentRepository studentRepository) {
		this.cdRomRepository = cdRomRepository;
		this.examRepository = examRepository;
		this.studentRepository = studentRepository;
	}



    @Override
	public List<Student> findAllAuthorizedStudent() {
		return studentRepository.findAllAuthorized();
	}

	@Override
	public Page<Student> findAuthorizedStudentToPassExam() {
		return studentRepository.findAuthorized((PageRequest.of(0,8)));
	}

	@Override
	public Boolean updateStudentInformationAfterExam(List<ExamResultForm> examResultForm) {

		examResultForm.forEach(e-> {
			Student student = studentRepository.findById(e.getStudentId()).get();
			Assert.notNull(student, "STUDENT CANNOT BE NULL");
			Integer score = e.getResultScore();
			if (score < 5) {
				student.setStatus(StudentStatus.NOT_ACTIVE);
			} else {
				student.setStatus(StudentStatus.FAILED_EXAM);
			}
			studentRepository.save(student);
		});
		return true;
	}


}






