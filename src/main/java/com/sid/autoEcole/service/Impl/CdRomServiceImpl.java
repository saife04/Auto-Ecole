package com.sid.autoEcole.service.Impl;

import com.sid.autoEcole.dao.*;
import com.sid.autoEcole.service.ICdRomService;
import com.sid.autoEcole.service.IExamService;
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






