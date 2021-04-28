package com.sid.autoEcole.web;

import com.sid.autoEcole.dao.CdRomRepository;
import com.sid.autoEcole.dao.SeriesRepository;
import com.sid.autoEcole.entities.CdRom;
import com.sid.autoEcole.entities.Series;
import com.sid.autoEcole.models.forms.SessionResultForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CdRomRestController {

    private final CdRomRepository cdRomRepository;


    @Autowired
    public CdRomRestController( CdRomRepository cdRomRepository) {
        this.cdRomRepository = cdRomRepository;
    }


   // Rest api to list all CdRom
    @GetMapping("/cdRom/list")
    public List<CdRom> series(){
        return cdRomRepository.findAll();
    }

    @PostMapping("/cdRom/add")
    public Boolean addStudentToPassExam(@RequestBody List<SessionResultForm> sessionResultForm) {

        //return cdRomRepository.addSessionResult(sessionResultForm);
        return true;
    }
}
