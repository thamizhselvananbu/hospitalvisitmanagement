package com.allm.hospitals.repository;

import com.allm.hospitals.models.Hospital;

import java.util.List;

public interface HospitalRepositoryCustom {

    //search hospitals by name and filter by city
    public List<Hospital> findByNameAndCity(String name, String city);

}
