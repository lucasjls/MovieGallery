package com.joaolucas.moviegalerysas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class HomeController {

    @RequestMapping(method= RequestMethod.GET)
    public String root(){
        return "index";
    }
}

