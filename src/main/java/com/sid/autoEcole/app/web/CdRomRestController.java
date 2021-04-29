package com.sid.autoEcole.app.web;

import com.sid.autoEcole.app.dao.CdRomRepository;
import com.sid.autoEcole.app.dao.SeriesRepository;
import com.sid.autoEcole.app.entities.CdRom;
import com.sid.autoEcole.app.entities.Series;
import com.sid.autoEcole.app.models.forms.SessionResultForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
