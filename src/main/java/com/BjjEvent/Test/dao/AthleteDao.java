package com.BjjEvent.Test.dao;

import com.BjjEvent.Test.models.Athlete;

import java.util.List;

public interface AthleteDao {

    void register(Athlete athlete);

    List<Athlete> listAthletes();
}
