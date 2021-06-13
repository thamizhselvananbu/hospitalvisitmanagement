package com.allm.hospitals.repository;

import com.allm.hospitals.models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Integer> {

    Patients findByName(String name);

    @Query("SELECT p FROM Patients p WHERE p.name = ?1 and p.password = ?2")
    Patients findByNameAndPassword(String name, String password);

}
