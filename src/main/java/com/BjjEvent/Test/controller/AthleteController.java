package com.BjjEvent.Test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtletaController {

    @RequestMapping(value = "athletes")
    public String test(){

        return "holis";
    }





}
