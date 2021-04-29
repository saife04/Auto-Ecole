package com.sid.autoEcole.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.app.entities.Series;
import com.sid.autoEcole.app.entities.Student;

@RepositoryRestResource
public interface SeriesRepository extends JpaRepository<Series, Long> {

}
