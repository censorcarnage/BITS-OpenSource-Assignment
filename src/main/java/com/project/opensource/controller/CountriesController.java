package com.project.opensource.controller;

import com.project.opensource.entity.Countries;
import com.project.opensource.model.Response;
import com.project.opensource.repository.CountriesRepository;
import com.project.opensource.service.CountriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @GetMapping("/countries")
    public ResponseEntity<Response> getAllCountries() {
        Response response = countriesService.getCountries();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
