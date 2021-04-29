package com.sid.autoEcole.app.service.Impl;

import com.sid.autoEcole.app.dao.CdRomRepository;
import com.sid.autoEcole.app.dao.FaultRepository;
import com.sid.autoEcole.app.entities.CdRom;
import com.sid.autoEcole.app.service.IFaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class FaultServiceImpl implements IFaultService {

	private static final Logger LOG = LoggerFactory.getLogger(FaultServiceImpl.class);

	private final FaultRepository faultRepository;

	private final CdRomRepository cdRomRepository;

	@Autowired
	public FaultServiceImpl(FaultRepository faultRepository, CdRomRepository cdRomRepository) {
		this.faultRepository = faultRepository;
		this.cdRomRepository = cdRomRepository;
	}

	@Override
	public Double getAverageFault(Long cdRomId, Long serieId) {
		try {
			CdRom cd = cdRomRepository.findById(cdRomId).get();
			Assert.notNull(cd, "CDROM CANNOT BE NULL");
			return faultRepository.getAverageFault(cdRomId, serieId);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}
}






