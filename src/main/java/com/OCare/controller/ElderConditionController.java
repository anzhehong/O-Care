package com.OCare.controller;

import com.OCare.entity.ElderCondition;
import com.OCare.service.ElderConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Li on 2015/7/29.
 */
@Controller
@RequestMapping("/map")
public class ElderConditionController {
    @Autowired
    private ElderConditionService elderConditionService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String ShowElders(ModelMap map,ServletRequest request,HttpSession session1) {
        // request.removeAttribute("Elders");
        List<ElderCondition> list = elderConditionService.allElderConditions();
        System.out.println(list.size());
        System.out.println("shagnmianshisize");
        map.addAttribute("Elders",list);
//        session.close();
        return "Map";
    }

    @RequestMapping(value = "/Refresh", method = RequestMethod.GET)
    public void RefreshCondition(ModelMap map,ServletRequest request)  {

        List<ElderCondition> list = elderConditionService.allElderConditions();

        map.addAttribute("Elders",list);
        request.setAttribute("RefreshElders", list);


    }

}
