package com.OCare.service;

import com.OCare.dao.ElderDAO;
import com.OCare.dao.LegalPersonDAO;
import com.OCare.dao.RelativeDAO;
import com.OCare.dao.VolunteerDAO;
import com.OCare.entity.*;
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

    @Override
    public String logon(String phoneNum, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        if(elder != null){
            if (elder.getPassword() == md5Password){
                return "Elder";
            }else{
                return "Incorrect password";
            }
        }else if(relative != null){
            if(relative.getPassword() == md5Password){
                return "Relative";
            }else{
                return "Incorrect password";
            }
        }else if (volunteer != null){
            if (volunteer.getPassword() == md5Password){
                return "Volunteer";
            }else{
                return "Incorrect password";
            }
        }else if (legalPerson != null){
            if (legalPerson.getPassword() == md5Password){
                return "LegalPerson";
            }else{
                return "Incorrect password";
            }
        }else{
            return "Invalid Account";
        }
    }

    @Override
    public String verifyPhoneNum(String id, String phoneNum) {
        Elder elder = elderDAO.queryById(id);
        Relative relative = relativeDAO.queryById(id);
        Volunteer volunteer = volunteerDAO.queryById(id);
        LegalPerson legalPerson = legalPersonDAO.queryById(id);
        if(elder != null){
            if (elder.getPhone() == phoneNum){
                return "Elder";
            }else{
                return "Incorrect phone number";
            }
        }else if(relative != null){
            if(relative.getPhone() == phoneNum){
                return "Relative";
            }else{
                return "Incorrect phone number";
            }
        }else if (volunteer != null){
            if (volunteer.getPhone() == phoneNum){
                return "Volunteer";
            }else{
                return "Incorrect phone number";
            }
        }else if (legalPerson != null){
            if (legalPerson.getPhone() == phoneNum){
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
}
