package com.sid.autoEcole.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.autoEcole.entities.CdRom;

@RepositoryRestResource
public interface CdRomRepository extends JpaRepository<CdRom, Long> {
	
	@Query("select c from cd_rom c order by random()")
	public Page<CdRom> getRandomCdRom(Pageable pageable);

}
