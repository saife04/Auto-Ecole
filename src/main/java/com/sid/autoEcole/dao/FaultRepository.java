package com.sid.autoEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.Fault;
import com.sid.autoEcole.entities.Session;
import com.sid.autoEcole.entities.Student;

@RepositoryRestResource
public interface FaultRepository extends JpaRepository<Fault, Long> {
	
	 Fault findBySessionAndStudent(Session session, Student student);


	@Query
	(value = " select  CAST(AVG(coalesce (f.fault_number,0)) as decimal(10,2)) AS moy " +
			" from Fault f " +
			" left join session s on f.session_id = s.id " +
			" left join cd_rom cd on cd.cdrom_id = s.cdrom_id " +
			" left join series sr on cd.cdrom_id = sr.cdrom_id " +
			" WHERE (cd.cdrom_id = :cdRomId and sr.number = :serieId)" , nativeQuery = true)
	 Double getAverageFault( Long cdRomId, Long serieId);

}
