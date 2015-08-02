package com.OCare.controller;

import com.OCare.entity.ElderMonitor;
import com.OCare.service.AccountService;
import com.OCare.service.RegisterService;
import com.OCare.service.SMSService;
import com.OCare.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 8/2/15.
 */
@Controller
@RequestMapping("/app")
public class InterfaceController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private SMSService smsService;

    @RequestMapping("/logon")
    @ResponseBody
    public Map<String, Object> logon(String phoneNum, String password){
        Map<String, Object> result = new HashMap<String, Object>();

        if(phoneNum == null || password == null || phoneNum == "" || password == ""){
            result.put("error", true);
            result.put("errorMsg", "PhoneNum or password is empty");
            return result;
        }else{
            String status = accountService.logon(phoneNum, password);
            if(status == "Invalid Account"){
                result.put("error", true);
                result.put("errorMsg", "Invalid Account");
                return result;
            }else if (status == "Incorrect password"){
                result.put("error", true);
                result.put("errorMsg", "Incorrect password");
                return result;
            }else{
                result.put("error", false);
                result.put("accountType", status);
                return result;
            }
        }
    }

    @RequestMapping("/register/elder")
    @ResponseBody
    public Map<String, Object> elderRegister(String elderId, int companyId, String elderName,
                                             String elderPhone, String elderAddress,
                                             String elderPassword, String elderImage){
        Map<String, Object> result = new HashMap<String, Object>();
        registerService.registerForAnElder(elderId, companyId, elderName, elderPhone, elderAddress, elderPassword, elderImage);
        result.put("error", false);
        return result;
    }

    @RequestMapping("/register/relative")
    @ResponseBody
    public Map<String, Object> relativeRegister(String relativeId, String relativeName,
                                                String relativePhone, String relativeAddress,
                                                String relativePassword, String relativeImage){

        Map<String, Object> result = new HashMap<String, Object>();
        registerService.registerForARelative(relativeId, relativeName, relativePhone, relativeAddress, relativePassword, relativeImage);
        result.put("error", false);
        return result;
    }

    @RequestMapping("/register/volunteer")
    @ResponseBody
    public Map<String, Object> volunteerRegister(String volunteerId, String volunteerName, String volunteerPhone,
                                                 String volunteerAddress, String volunteerEmail,
                                                 int volunteerCompanyId, String volunteerPassword, String volunteerImage){
        Map<String, Object> result = new HashMap<String, Object>();
        registerService.registerForAVolunteer(volunteerId, volunteerName, volunteerPhone, volunteerAddress, volunteerEmail, volunteerCompanyId, volunteerPassword, volunteerImage);
        result.put("error", false);
        return result;
    }

    @RequestMapping("/register/legalperson")
    @ResponseBody
    public Map<String, Object> legalPersonRegister(String lpId, String lpName, String lpPhone,
                                                   String lpEmail, String lpPassword, String lpImage){
        Map<String, Object> result = new HashMap<String, Object>();
        registerService.registerForALegalPerson(lpId, lpName, lpPhone, lpEmail, lpPassword, lpImage);
        result.put("error", false);
        return result;
    }

    @RequestMapping("/apply/monitor")
    @ResponseBody
    public Map<String, Object> applyMonitor(String relativeId, String elderId, String togetherImg){
        Map<String, Object> result = new HashMap<String, Object>();
        verifyService.submitMonitorApply(relativeId, elderId, togetherImg);
        result.put("error", false);
        return result;
    }

    @RequestMapping("/status/monitor")
    @ResponseBody
    public Map<String, Object> checkMonitor(String relativeId){
        Map<String, Object> result = new HashMap<String, Object>();
        List<ElderMonitor> list = verifyService.monitorStatus(relativeId);
        if (list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Invalid relativeId");
        }else{
            result.put("error", false);
            result.put("result", list);
        }
        return result;
    }

    @RequestMapping("/code")
    @ResponseBody
    public Map<String, Object> createCode(String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        int code = smsService.sendVerifyCodeToPhone(phoneNum);
        result.put("error", false);
        result.put("code", code);
        return result;
    }

    @RequestMapping("/verify/phone")
    @ResponseBody
    public Map<String, Object> verifyPhoneNum(String id, String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        String status = accountService.verifyPhoneNum(id, phoneNum);
        if(status == "Incorrect phone number") {
            result.put("error", true);
            result.put("errorMsg", "Incorrect phone number");
            return result;
        }else if (status == "Invalid Account"){
            result.put("error", true);
            result.put("errorMsg", "Invalid Account");
            return result;
        }else{
            result.put("error", false);
            result.put("type", status);
            return result;
        }
    }

    @RequestMapping("/changepassword")
    @ResponseBody
    public Map<String, Object> changePassword(String id, String password){
        Map<String, Object> result = new HashMap<String, Object>();
        String status = accountService.changePassword(id, password);
        if(status == "Invalid Account"){
            result.put("error", true);
            result.put("errorMsg", "Invalid Account");
            return result;
        }else{
            result.put("error", false);
            return result;
        }

    }
}
