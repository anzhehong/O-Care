package com.OCare.controller;

import com.OCare.dao.CompanyDAO;
import com.OCare.entity.Employee;
import com.OCare.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping("/hr/insert")
    @ResponseBody
    public Map<String,Object> hrInsert(String name,String address,String phone,String identity,String position,String department,String superior,String start_time,String finish_time) {
        Map<String, Object> result = new HashMap<String, Object>();
        double x=Math.random()*10000;
        if (name == null || address==null|| position==null|| identity==null|| phone==null|| department==null|| superior==null|| start_time==null|| finish_time==null){
            result.put("error", true);
            result.put("errorMsg", "There is no available data");
            return result;
        }
else {
            Employee employee = employeeService.createEmployee(x + "", 2, name, phone, address, start_time, finish_time, "xxx", "xxx", position, department, superior, "xxx", "xxx");
            result.put("error", false);
            result.put("created_name", employee.getId());
            return result;
        }
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
    @RequestMapping("/hr/confirm")
    @ResponseBody
    public Map<String, Object> getemployeeById(String employeeid) {
        Employee employee=employeeService.getEmployeeById(employeeid);
        Map<String, Object> result = new HashMap<String, Object>();

        String xxx= employee.getPhone();
        String xxx1= employee.getDepartment();
        result.put("employee_id", employee.getId());
        result.put("employee_name",employee.getName());
        result.put("employee_phone",employee.getPhone());
        result.put("employee_position",employee.getPosition());
        result.put("employee_department",employee.getDepartment());
        result.put("employee_superior",employee.getSuperior());
        return result;


    }
    @RequestMapping("/hr/remove")
    @ResponseBody
    public Map<String, Object> removeemployeeById(String employeeid) {
        Employee employee=employeeService.getEmployeeById(employeeid);
        Map<String, Object> result = new HashMap<String, Object>();

        String xxx= employee.getPhone();
        String xxx1= employee.getDepartment();
        result.put("employee_id", employee.getId());
        result.put("employee_name",employee.getName());
        result.put("employee_phone",employee.getPhone());
        result.put("employee_position",employee.getPosition());
        result.put("employee_department",employee.getDepartment());
        result.put("employee_superior",employee.getSuperior());
        return result;


    }

}
