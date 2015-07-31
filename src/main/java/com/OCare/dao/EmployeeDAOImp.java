package com.OCare.dao;

import com.OCare.entity.Employee;

/**
 * Created by fowafolo on 15/7/28.
 */
public class EmployeeDAOImp extends IGeneralDAOImpl<Employee> implements EmployeeDAO {

    public EmployeeDAOImp()
    {
        super(Employee.class);
    }
}
