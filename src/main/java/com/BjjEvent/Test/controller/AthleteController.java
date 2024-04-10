package com.BjjEvent.Test.controller;

import com.BjjEvent.Test.dao.AthleteDao;
import com.BjjEvent.Test.models.Athlete;
import com.BjjEvent.Test.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteDao athleteDao;

    @Autowired
    JWTUtil jwtUtil;

    //-------------list athletes-----------------------------------
    @GetMapping(value = "regathletes")
    public List<Athlete> getAthletes(@RequestHeader(value = "Authorization") String token){


            String athleteDNI = jwtUtil.getKey(token);
            System.out.println("Athlete DNI: " + athleteDNI);

            if(athleteDNI == null){
                System.out.println("RODOLFINO DEL POTRIÑO: El DNI del atleta es nulo");
                return new ArrayList<>();
            }



        return athleteDao.listAthletes();
    }

    //--------------register athletes------------------------------
    @RequestMapping(value = "athletes",method = RequestMethod.POST)
    public void registerUser(@RequestBody Athlete athlete){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,athlete.getPassword());
        athlete.setPassword(hash);

        athleteDao.register(athlete);
    }





}
