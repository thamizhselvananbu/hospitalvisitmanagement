package com.allm.hospitals.service;

import com.allm.hospitals.models.Hospital;

import java.util.List;

public interface HospitalService {

    //Get list of hospitals
    List<Hospital> getHospitals(int page, int limit);

    //search and filter hospitals by name
    List<Hospital> searchHospitals(String name, String city);

}
