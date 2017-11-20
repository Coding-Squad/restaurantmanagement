package com.restaurant.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Masum on 11/21/2017.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
