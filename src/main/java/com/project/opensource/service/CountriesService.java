package com.project.opensource.service;

import com.project.opensource.entity.Countries;
import com.project.opensource.model.Meta;
import com.project.opensource.model.Response;
import com.project.opensource.repository.CountriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;

    public Response getCountries() {
        Response response = null;
        List<Countries> countryList = getCountriesFromPersistence();
        List<String> countries = new ArrayList<>();
        if(!countryList.isEmpty()) {
            countryList.forEach(i -> {
                countries.add(i.getName());
            });
            response = createSuccessResponse(countries, response);
        } else
            response = createFailureResponse(response);
        return response;
    }

    private Response createFailureResponse(Response response) {
        return Response.builder().meta(Meta.builder().errorCode("C_001").errorMessage("Failure in fetching countries.").build()).build();
    }

    private Response createSuccessResponse(List<String> countryList, Response response) {
        return Response.builder().meta(Meta.builder().errorCode("C_000").errorMessage("Fetching countries successful.").build()).data(countryList).build();
    }


    public List<Countries> getCountriesFromPersistence() {
        List<Countries> countries = new ArrayList<>();
        try {
            countries = countriesRepository.findAll();
        } catch (Exception e) {
            log.info("GET COUNTRIES || PROBLEM IN FETCHING COUNTRY DATA FROM H2");
        }
        return countries;
    }
}

