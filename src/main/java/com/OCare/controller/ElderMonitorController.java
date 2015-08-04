package com.OCare.controller;

import com.OCare.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mark on 8/2/15.
 */
@Controller
@RequestMapping("/monitor")
public class ElderMonitorController {
    @Autowired
    private VerifyService verifyService;

    @RequestMapping("/list")
    public String listAllRequest(Model model){
        model.addAttribute("list",verifyService.getAllUntreatedRequests());
        return "homepage";
    }

    @RequestMapping(value="/agree/{id}", method = RequestMethod.GET)
    public String agreeRequest(@PathVariable String id, Model model){
        verifyService.checkMonitorApply(Integer.parseInt(id), true);
        model.addAttribute("list", verifyService.getAllUntreatedRequests());
        model.addAttribute("request",verifyService.getRequestByID(Integer.parseInt(id)));
        return "verify";
    }



    @RequestMapping(value="/reject/{id}", method = RequestMethod.GET)
    public String rejectRequest(@PathVariable String id, Model model){
        verifyService.checkMonitorApply(Integer.parseInt(id), false);
        model.addAttribute("list", verifyService.getAllUntreatedRequests());
        model.addAttribute("request",verifyService.getRequestByID(Integer.parseInt(id)));
        return "verify";
    }
}
