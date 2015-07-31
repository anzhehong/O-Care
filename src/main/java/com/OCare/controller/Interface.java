package com.OCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fowafolo on 15/7/31.
 */
@Controller
@RequestMapping("/interface")
public class Interface {

    @RequestMapping("")
    @ResponseBody
    public Map<String , String> json(){
        Map<String,String> result = new HashMap<String, String>();
        result.put("杨春雨","蠢驴");
        result.put("杨春雨","逗比");
        return result;
    }
}
