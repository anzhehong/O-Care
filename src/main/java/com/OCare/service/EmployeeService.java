package com.OCare.service;

import com.OCare.entity.Employee;

import java.util.List;

/**
 * Created by mark on 8/3/15.
 */
public interface EmployeeService {
    public Employee createEmployee(String employeeId, int companyId, String name, String phone,
                                   String address, String start, String end, String image, String password,
                                   String position, String department);
    public Employee createEmployee(String employeeId, int companyId, String name, String phone,
                                   String address, String start, String end, String image,String password);
    public List<Employee> getEmployeesByName(String name);
    public List<Employee> getEmployeesByDepartment(String department);
    public List<Employee> getEmployeesByPosition(String position);
    public boolean changeEmployeePassword(String employeeId, String newPassword);
    public boolean changeEmployeeStatus(String employeeId, int status);
    public boolean isPasswordMatchEmployeeId(String employeeId, String password);
}