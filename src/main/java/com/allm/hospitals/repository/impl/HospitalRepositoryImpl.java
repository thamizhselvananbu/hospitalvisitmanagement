package com.allm.hospitals.repository.impl;

import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.repository.HospitalRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HospitalRepositoryImpl implements HospitalRepositoryCustom {

    EntityManager entityManager;

    @Override
    public List<Hospital> findByNameAndCity(String name, String city) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hospital> criteriaQuery = criteriaBuilder.createQuery(Hospital.class);
        Root<Hospital> hospitalRoot = criteriaQuery.from(Hospital.class);
        Predicate predicate1 = null;
        Predicate predicate2 = null;

        if (name != null && city != null) {
            predicate1 = criteriaBuilder.equal(hospitalRoot.get("name"), name);
            predicate2 = criteriaBuilder.equal(hospitalRoot.get("city"), city);
            Predicate finalPredicate = criteriaBuilder.and(predicate1, predicate2);
            criteriaQuery.where(finalPredicate);
        }

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
