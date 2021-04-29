package com.sid.autoEcole.app.web;

import com.sid.autoEcole.app.dao.SeriesRepository;
import com.sid.autoEcole.app.entities.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieRestController {

    @Autowired
    private final SeriesRepository serieRepository;

    public SerieRestController(SeriesRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping("/list-series")
    public List<Series> series(){
        return serieRepository.findAll();
    }
}
