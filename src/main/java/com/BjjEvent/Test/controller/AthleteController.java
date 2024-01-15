package com.BjjEvent.Test.controller;

import com.BjjEvent.Test.dao.AthleteDao;
import com.BjjEvent.Test.models.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteDao athleteDao;

    //-------------list athletes-----------------------------------
    @RequestMapping(value = "regathletes")
    public List<Athlete> getAthletes(){

        return athleteDao.listAthletes();
    }


    //--------------register athletes------------------------------
    @RequestMapping(value = "athletes",method = RequestMethod.POST)
    public void registerUser(@RequestBody Athlete athlete){

        athleteDao.register(athlete);

    }





}
