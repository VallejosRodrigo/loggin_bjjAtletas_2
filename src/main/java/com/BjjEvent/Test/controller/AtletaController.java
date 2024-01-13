package com.BjjEvent.Test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtletaController {

    @RequestMapping(value = "testing")
    public String test(){

        return "holis";
    }





}
