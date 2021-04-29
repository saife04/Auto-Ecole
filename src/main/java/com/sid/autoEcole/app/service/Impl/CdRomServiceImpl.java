package com.sid.autoEcole.app.service.Impl;

import com.sid.autoEcole.app.dao.CdRomRepository;
import com.sid.autoEcole.app.service.ICdRomService;
import com.sid.autoEcole.app.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CdRomServiceImpl implements ICdRomService {


	private final CdRomRepository cdRomRepository;


	@Autowired
	public CdRomServiceImpl( CdRomRepository cdRomRepository) {
		this.cdRomRepository = cdRomRepository;
	}

}






