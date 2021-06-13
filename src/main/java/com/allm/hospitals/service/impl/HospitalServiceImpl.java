package com.allm.hospitals.service.impl;

import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.repository.HospitalRespository;
import com.allm.hospitals.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private static List<Hospital> listHospitals = new ArrayList<>();

    @Autowired
    private HospitalRespository hospitalRepository;

    @Override
    public List<Hospital> getHospitals(int page, int limit) {
        Pageable pagination = PageRequest.of(page, limit);
        Page<Hospital> hospitalPage =  hospitalRepository.findAll(pagination);
        List<Hospital> hospitalList = hospitalPage.getContent();
        return hospitalList;
    }

    @Override
    public List<Hospital> searchHospitals(String name, String city) {
        return hospitalRepository.findByNameAndCity(name, city);
    }
}
