package com.sid.autoEcole.app.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.app.entities.Question;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	@Query("select q from question q order by random()")
	public Page<Question> getRandomQuestion(Pageable pageable);

}
