package com.nikita.hohunskyi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRest {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

}
