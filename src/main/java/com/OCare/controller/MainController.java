package com.OCare.controller;

import com.OCare.dao.CompanyDAO;
import com.OCare.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by mark on 7/12/15.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyDAO companyDAO;


    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/hr")
    public String hrHome(Model model)
    {
        model.addAttribute("employee",employeeService.getAllEmployees());
        return "HR";
    }

    @RequestMapping("/hr/entry")
    public String hrEntry() {
        return "entry";
    }

    @RequestMapping("/hr/import")
    public String hrImport() {
        return "import";
    }

    @RequestMapping("/hr/leave")
    public String hrLeave() {
        return "leave";
    }

    @RequestMapping("/hr/table")
    public String hrTable(Model model)
    {
        model.addAttribute("employee",employeeService.getAllEmployees());
        return "table";
    }

    @RequestMapping("/ht/table")
    public String htTable() {
        return "htgl";
    }


}
