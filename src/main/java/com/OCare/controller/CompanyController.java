package com.OCare.controller;

import com.OCare.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/create")
    public String createCompany(String name, String legalPerson, String phone, String address){
        companyService.createCompany(name, legalPerson, phone, address);
        return "company";
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public String getCompanyByName(@PathVariable String name, Model model){
        model.addAttribute("companies", companyService.getByName(name));
        return "company";
    }

    @RequestMapping("/legalperson")
    public String getCompanyByLegalPerson(String legalPerson, Model model){
        model.addAttribute("companies", companyService.getByLegalPerson(legalPerson));
        return "company";
    }


    @RequestMapping("/list")
    public String listUnapproveCompanies(Model model){
        model.addAttribute("list", companyService.unapproveCompanies());
        return "company";
    }

    @RequestMapping(value = "/agree/{id}", method = RequestMethod.GET)
    public String agreeApply(@PathVariable String id){
        companyService.changeStatus(Integer.parseInt(id), 102);
        return "company";
    }

    @RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
    public String rejectApply(@PathVariable String id){
        companyService.changeStatus(Integer.parseInt(id), 103);
        return "company";
    }

}
