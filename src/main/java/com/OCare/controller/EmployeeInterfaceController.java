package com.OCare.controller;

import com.OCare.dao.CompanyDAO;
import com.OCare.entity.Employee;
import com.OCare.entity.EmployeeCondition;
import com.OCare.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 8/6/15.
 */
@Controller
@RequestMapping("/app")
public class EmployeeInterfaceController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping("/employee/id")
    @ResponseBody
    public Map<String, Object> getEmployeeById(String id){
        Map<String, Object> result = new HashMap<String, Object>();
        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input id is null");
            return result;
        }

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null){
            result.put("error", true);
            result.put("errorMsg", "Can not find employee");
            return result;
        }

        result.put("error", false);
        result.put("employee", employee);
        return result;
    }

    @RequestMapping("/employee/phone")
    @ResponseBody
    public Map<String, Object> getEmployeeByPhoneNum(String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        if (phoneNum == null || phoneNum.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input phoneNum is null");
            return result;
        }

        List<Employee> list = employeeService.getEmployeesByPhoneNum(phoneNum);

        if (list.size() == 0 || list == null){
            result.put("error", true);
            result.put("errorMsg", "Can not find employee");
            return result;
        }

        result.put("error", false);
        result.put("employee", list);
        return result;
    }

    @RequestMapping("/employee/insert")
    @ResponseBody
    public Map<String, Object> insertEmployee(String employeeId, String companyId,
                                              String name, String phone, String address, String start,
                                              String end, String image, String password, String position,
                                              String department, String superior, String workExperience,
                                              String workDetail){
        Map<String, Object> result = new HashMap<String, Object>();
        if (employeeId == null ||employeeId.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (name == null ||name.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (phone == null ||phone.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (address == null ||address.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (start == null ||start.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (end == null ||end.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (image == null ||image.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (password == null ||password.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (position == null ||position.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (department == null ||department.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (superior == null ||superior.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (workDetail == null ||workDetail.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (workExperience == null ||workExperience.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (companyId == null ||companyId.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        if (companyDAO.getById(Integer.parseInt(companyId)) == null){
            result.put("error", true);
            result.put("errorMsg", "Company can not found");
            return result;
        }

        Employee employee = employeeService.createEmployee(employeeId, Integer.parseInt(companyId), name, phone, address, start, end, image,
                password, position, department, superior, workExperience, workDetail);

        if (employee == null){
            result.put("error", true);
            result.put("errorMsg", "Create employee failed");
            return result;
        }else{
            result.put("error", false);
            result.put("employee", employee);
            return result;
        }
    }

    @RequestMapping("/employee/attendance")
    @ResponseBody
    public Map<String, Object> getAttendance(String employeeId){
        Map<String, Object> result = new HashMap<String, Object>();

        if (employeeId == null ||employeeId.equals("") ){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<EmployeeCondition> list = employeeService.getEmployeeConditionByEmployeeId(employeeId);

        if (list.size() == 0 || list == null){
            result.put("error", true);
            result.put("errorMsg", "Cannot find Employee");
            return result;
        }

        result.put("error", true);
        result.put("employeeCondition", list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/employee/attendance/between")
    public Map<String, Object> getAttendanceBetween(String employeeId, String start, String end){
        Map<String, Object> result = new HashMap<String, Object>();
        if (employeeId == null || start == null || end == null || start.equals("") ||  employeeId.equals("")  || end.equals("") ){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<EmployeeCondition> list = employeeService.getEmployeeConditionBetween(start, end, employeeId);

        if (list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Cannot find Employee");
            return result;
        }

        result.put("error", true);
        result.put("employeeCondition", list);
        return result;
    }
}
