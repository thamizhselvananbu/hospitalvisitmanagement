package com.allm.hospitals.repository;

import com.allm.hospitals.models.Visits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitsRepository extends JpaRepository<Visits, Integer> {
}
