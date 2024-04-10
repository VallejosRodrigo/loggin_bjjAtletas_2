
package com.BjjEvent.Test.controller;

import com.BjjEvent.Test.dao.AthleteDao;
import com.BjjEvent.Test.models.Athlete;
import com.BjjEvent.Test.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AthleteDao athleteDao;

    @Autowired
    JWTUtil jwtUtil;

    //--------------check login------------------------------
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody Athlete athlete){

        Athlete athleteLog = athleteDao.loginEmailPassCheck(athlete);

        if(athleteLog != null){
          String tokenJwt = jwtUtil.create(String.valueOf(athleteLog.getDni()),athleteLog.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }









}