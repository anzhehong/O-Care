package com.OCare.service;

import com.OCare.dao.EmployeeConditionDAO;
import com.OCare.dao.EmployeeDAO;
import com.OCare.entity.Employee;
import com.OCare.entity.EmployeeCondition;
import com.OCare.entity.JavaMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.TreeUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 8/3/15.
 */
@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeConditionDAO employeeConditionDAO;

    @Override
    public Employee createEmployee(String employeeId, int companyId, String name, String phone, String address, String start, String end, String image, String password, String position, String department) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setCompany_id(companyId);
        employee.setName(name);
        employee.setPhone(phone);
        employee.setAddress(address);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setContract_start(format.parse(start));
            employee.setContract_end(format.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setPassword(password);
        employee.setImage(image);
        employee.setStatus(101);//正常

        employeeDAO.insert(employee);
        return employee;
    }

    @Override
    public Employee createEmployee(String employeeId, int companyId, String name, String phone, String address, String start, String end, String image, String password) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setCompany_id(companyId);
        employee.setName(name);
        employee.setPhone(phone);
        employee.setAddress(address);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setContract_start(format.parse(start));
            employee.setContract_end(format.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDepartment("");
        employee.setPosition("");
        employee.setPassword(password);
        employee.setImage(image);
        employee.setStatus(101);//正常

        employeeDAO.insert(employee);
        return employee;
    }

    @Override
    public Employee createEmployee(String employeeId, int companyId, String name, String phone, String address, String start, String end, String image, String password, String position, String department, String superior, String workExperience, String workDetail) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setCompany_id(companyId);
        employee.setName(name);
        employee.setPhone(phone);
        employee.setAddress(address);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setContract_start(format.parse(start));
            employee.setContract_end(format.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setPassword(JavaMD5Util.MD5(password));
        employee.setImage(image);
        employee.setSuperior(superior);
        employee.setWorkDetail(workDetail);
        employee.setWorkExperience(workExperience);
        employee.setStatus(101);//正常

        employeeDAO.insert(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDAO.queryById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeDAO.findEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeDAO.findEmployeeByDepartment(department);
    }

    @Override
    public List<Employee> getEmployeesByPosition(String position) {
        return employeeDAO.findEmployeeByPosition(position);
    }

    @Override
    public List<Employee> getEmployeesByPhoneNum(String phoneNum) {
        return employeeDAO.findEmployeeByPhoneNum(phoneNum);
    }

    @Override
    public boolean changeEmployeePassword(String employeeId, String newPassword) {
        Employee employee = employeeDAO.queryById(employeeId);
        if(employee == null){
            return false;
        }else{
            employee.setPassword(newPassword);
            employeeDAO.update(employee);
            return true;
        }
    }

    @Override
    public boolean changeEmployeeStatus(String employeeId, int status) {
        Employee employee = employeeDAO.queryById(employeeId);
        if(employee == null){
            return false;
        }else{
            employee.setStatus(status);
            employeeDAO.update(employee);
            return false;
        }
    }

    @Override
    public boolean isPasswordMatchEmployeeId(String employeeId, String password) {
        Employee employee = employeeDAO.queryById(employeeId);
        if(employee == null){
            return false;
        }else{
            if (employee.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public List<EmployeeCondition> getEmployeeConditionByEmployeeId(String employeeId) {
        return employeeConditionDAO.findEmployeeConditionByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeCondition> getEmployeeConditionBetween(String start, String end, String employeeId) {
        return employeeConditionDAO.findEmployeeConditionBetween(employeeId, start, end);
    }
}
