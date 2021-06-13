package com.allm.hospitals.repository;

import com.allm.hospitals.models.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRespository extends JpaRepository<Hospital, Integer>, HospitalRepositoryCustom {

    Page<Hospital> findAll(Pageable pageable);

    Hospital findByName(String name);
}
