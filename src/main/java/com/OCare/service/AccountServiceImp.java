package com.OCare.service;

import com.OCare.dao.*;
import com.OCare.entity.*;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mark on 8/2/15.
 */
@Service("LogonService")
@Transactional
public class AccountServiceImp implements AccountService {

    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private RelativeDAO relativeDAO;
    @Autowired
    private VolunteerDAO volunteerDAO;
    @Autowired
    private LegalPersonDAO legalPersonDAO;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public Pair<String, Object> logon(String phoneNum, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        if(elder != null){
            if (elder.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Elder", elder);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if(relative != null){
            if(relative.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Relative", relative);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if (volunteer != null){
            if (volunteer.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Volunteer", volunteer);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if (legalPerson != null){
            if (legalPerson.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("LegalPerson", legalPerson);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else{
            Pair<String, Object> pair = new Pair<String, Object>("Invalid Account", null);
            return pair;
        }
    }

    @Override
    public Pair<String, Object> adminlogon(String phoneNum, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Admin admin=adminDao.queryByPhoneNum(phoneNum);
        if(admin != null){
            if (admin.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Admin", admin);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else{
            Pair<String, Object> pair = new Pair<String, Object>("Invalid Account", null);
            return pair;
        }
    }

    @Override
    public String verifyPhoneNum(String id, String phoneNum) {
        Elder elder = elderDAO.queryById(id);
        Relative relative = relativeDAO.queryById(id);
        Volunteer volunteer = volunteerDAO.queryById(id);
        LegalPerson legalPerson = legalPersonDAO.queryById(id);
        if(elder != null){
            if (elder.getPhone().equals(phoneNum)){
                return "Elder";
            }else{
                return "Incorrect phone number";
            }
        }else if(relative != null){
            if(relative.getPhone().equals(phoneNum)){
                return "Relative";
            }else{
                return "Incorrect phone number";
            }
        }else if (volunteer != null){
            if (volunteer.getPhone().equals(phoneNum)){
                return "Volunteer";
            }else{
                return "Incorrect phone number";
            }
        }else if (legalPerson != null){
            if (legalPerson.getPhone().equals(phoneNum)){
                return "LegalPerson";
            }else{
                return "Incorrect phone number";
            }
        }else{
            return "Invalid Account";
        }
    }

    @Override
    public String changePassword(String id, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Elder elder = elderDAO.queryById(id);
        Relative relative = relativeDAO.queryById(id);
        Volunteer volunteer = volunteerDAO.queryById(id);
        LegalPerson legalPerson = legalPersonDAO.queryById(id);
        if(elder != null){
            elder.setPassword(md5Password);
            elderDAO.update(elder);
            return "change success";
        }else if(relative != null){
            relative.setPassword(md5Password);
            relativeDAO.update(relative);
            return "change success";
        }else if (volunteer != null){
            volunteer.setPassword(md5Password);
            volunteerDAO.update(volunteer);
            return "change success";
        }else if (legalPerson != null){
            legalPerson.setPassword(md5Password);
            legalPersonDAO.update(legalPerson);
            return "change success";
        }else{
            return "Invalid Account";
        }
    }

    @Override
    public String lostPasswordHandle(String id, int role, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        if(role==1){
            Elder elder = elderDAO.queryById(id);
            Relative relative = relativeDAO.queryById(id);
            if(elder != null||relative != null) {
                if (elder != null) {
                    elder.setPassword(md5Password);
                    elderDAO.update(elder);

                }
                if (relative != null) {
                    relative.setPassword(md5Password);
                    relativeDAO.update(relative);
                }
                return "change success";
            }
            else{
                return "Invalid Account";
            }
        }else if(role==2){
            LegalPerson legalPerson = legalPersonDAO.queryById(id);
            if (legalPerson != null){
                legalPerson.setPassword(md5Password);
                legalPersonDAO.update(legalPerson);
                return "change success";
            }else{
                return "Invalid Account";
            }
        }else if(role==3){
            Employee employee=employeeDao.queryById(id);
            if (employee != null){
                employee.setPassword(md5Password);
                employeeDao.update(employee);
                return "change success";
            }else{
                return "Invalid Account";
            }
        }else if(role==4){
            Admin admin=adminDao.queryById(id);
            if (admin != null){
                admin.setPassword(md5Password);
                adminDao.update(admin);
                return "change success";
            }else{
                return "Invalid Account";
            }
        }else if(role==5){
            Volunteer volunteer = volunteerDAO.queryById(id);
            if (volunteer != null){
                volunteer.setPassword(md5Password);
                volunteerDAO.update(volunteer);
                return "change success";
            }else{
                return "Invalid Account";
            }
        }else {
            return "NO ROLE";
        }
    }

    @Override
    public String personInforModifyHandle(String id,int role, Object object) {
        if(role==0)
        {
            Elder new_elder=(Elder)object;
            Elder elder = elderDAO.queryById(id);
            if(elder==null)
            {
                return "Invalid Account";
            }
            if(!new_elder.getPhone().equals(null)){
                elder.setPhone(new_elder.getPhone());
            }
            if(!new_elder.getPassword().equals(null)){
                elder.setPassword(new_elder.getPassword());
            }
            if(!new_elder.getImage().equals(null)){
                elder.setImage(new_elder.getImage());
            }
            elderDAO.update(elder);
            return "change success";

        }
        else if(role==1)
        {
            Relative new_relative=(Relative)object;
            Relative relative = relativeDAO.queryById(id);
            if(relative==null)
            {
                return "Invalid Account";
            }
            if(!new_relative.getPhone().equals(null)){
                relative.setPhone(new_relative.getPhone());
            }
            if(!new_relative.getPassword().equals(null)){
                relative.setPassword(new_relative.getPassword());
            }
            if(!new_relative.getImage().equals(null)){
                relative.setImage(new_relative.getImage());
            }
            relativeDAO.update(relative);
            return "change success";}
        else if(role==2)
        {
            LegalPerson new_legalPerson=(LegalPerson) object;
            LegalPerson legalPerson = legalPersonDAO.queryById(id);
            if(legalPerson==null)
            {
                return "Invalid Account";
            }
            if(!new_legalPerson.getPhone().equals(null)){
                legalPerson.setPhone(new_legalPerson.getPhone());
            }
            if(!new_legalPerson.getPassword().equals(null)){
                legalPerson.setPassword(new_legalPerson.getPassword());
            }
            if(!new_legalPerson.getImage().equals(null)){
                legalPerson.setImage(new_legalPerson.getImage());
            }
            legalPersonDAO.update(legalPerson);
            return "change success";
        }
        else if(role==3)
        {
            Admin new_admin=(Admin) object;
            Admin admin=adminDao.queryById(id);
            if(admin==null)
            {
                return "Invalid Account";
            }

            if(!new_admin.getPassword().equals(null)){
                admin.setPassword(new_admin.getPassword());
            }

            adminDao.update(admin);
            return "change success";
        }
        else if(role==4)
        {
            Employee new_employee=(Employee) object;
            Employee employee=employeeDao.queryById(id);
            if(employee==null)
            {
                return "Invalid Account";
            }
            if(!new_employee.getPhone().equals(null)){
                employee.setPhone(new_employee.getPhone());
            }
            if(!new_employee.getPassword().equals(null)){
                employee.setPassword(new_employee.getPassword());
            }
            if(!new_employee.getImage().equals(null)){
                employee.setImage(new_employee.getImage());
            }
            employeeDao.update(employee);
            return "change success";
        }
        else
        {
            return "ROLE NOT EXIST";
        }
    }



    @Override
    public Pair<String, Object> getImageByPhoneNum(String phoneNum) {
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);

        if (elder!=null)
        {
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",elder.getImage());
            return pair;
        }else if(relative != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",relative.getImage());
            return pair;
        }else if (volunteer != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",volunteer.getImage());
            return pair;
        }else if (legalPerson != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",legalPerson.getImage());
            return pair;
        }else{
            Pair<String, Object> pair = new Pair<String, Object>("PhoneNum does not match to any account!",null);
            return pair;
        }
    }

    @Override
    public boolean isChangeImageSucc(String phoneNum,String newImg) {
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        boolean flag ;
        if (elder!=null)
        {
            elder.setImage(newImg);
            elderDAO.update(elder);
            flag = true;
        }else if(relative != null){
            relative.setImage(newImg);
            relativeDAO.update(relative);
            flag = true;
        }else if (volunteer != null){
            volunteer.setImage(newImg);
            volunteerDAO.update(volunteer);
            flag = true;
        }else if (legalPerson != null){
            legalPerson.setImage(newImg);
            legalPersonDAO.update(legalPerson);
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
