package com.BjjEvent.Test.dao;

import com.BjjEvent.Test.models.Athlete;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AthleteDaoImp implements AthleteDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void register(Athlete athlete) {
        entityManager.merge(athlete);
    }

    @Override
    public List<Athlete> listAthletes() {

        String query = "FROM Athlete";

        return entityManager.createQuery(query).getResultList();
    }
}
