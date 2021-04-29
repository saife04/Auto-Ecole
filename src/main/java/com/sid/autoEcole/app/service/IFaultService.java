package com.sid.autoEcole.app.service;

import com.sid.autoEcole.app.entities.Student;

public interface IFaultService {

       Double getAverageFault(Long cdRomId, Long serieId);
}
