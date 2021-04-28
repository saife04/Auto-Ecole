package com.sid.autoEcole.service;

import com.sid.autoEcole.entities.Student;

import java.util.List;

public interface IFaultService {

       Double getAverageFault(Long cdRomId, Long serieId);
}
