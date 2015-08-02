package com.OCare.dao;

import com.OCare.entity.Employee;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
public class EmployeeDAOImp extends IGeneralDAOImpl<Employee> implements EmployeeDAO {

    public EmployeeDAOImp()
    {
        super(Employee.class);
    }

    @Override
    public Employee queryByPhoneNum(String phoneNum) {
        String hql = "from Employee where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<Employee> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
