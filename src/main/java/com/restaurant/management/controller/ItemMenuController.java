package com.restaurant.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pranto on 21-Nov-17.
 */
@Controller
public class ItemMenuController {

    @RequestMapping("/item")
    public String home(){
        return "index";
    }


}
