package com.OCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by mark on 7/12/15.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index() {
        return "homepage";
    }


}
