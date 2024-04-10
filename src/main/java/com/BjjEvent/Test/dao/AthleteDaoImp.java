package com.BjjEvent.Test.dao;

import com.BjjEvent.Test.models.Athlete;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    //----------------register athlete------------------
    @Override
    public void register(Athlete athlete) {
        entityManager.merge(athlete);
    }

    //----------------list athletes-----------------
    @Override
    public List<Athlete> listAthletes() {
        String query = "FROM Athlete";

        return entityManager.createQuery(query).getResultList();
    }

    //--------------user login-------------------
    @Override
    public Athlete loginEmailPassCheck(Athlete athlete) {
        String query = "FROM Athlete WHERE email = :email";

        List<Athlete> listAth = entityManager.createQuery(query)
                .setParameter("email", athlete.getEmail())
                .getResultList();

        if (listAth.isEmpty()) //evit null pointer exception
            return null;

        String passwordHashed = listAth.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, athlete.getPassword()))
            return listAth.get(0);
    return null;
    }

}
