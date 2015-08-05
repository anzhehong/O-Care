package com.OCare.controller;

import com.OCare.entity.*;
import com.OCare.service.AccountService;
import com.OCare.service.RegisterService;
import com.OCare.service.SMSService;
import com.OCare.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * @param phoneNum：Phone number
     * @param password：Password
     * @return
     * Error: true, ErrorMsg
     * Error: false, Account type, Account detail
     */
    @RequestMapping(value = "/logon" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> logon(String phoneNum, String password){
        Map<String, Object> result = new HashMap<String, Object>();

        if(phoneNum == null || password == null || phoneNum == "" || password == ""){
            result.put("error", true);
            result.put("errorMsg", "PhoneNum or password is empty");
            return result;
        }else{
            String status = accountService.logon(phoneNum, password).getKey();
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
                result.put("account", accountService.logon(phoneNum, password).getValue());
                return result;
            }
        }
    }

    /**
     * @param elderId: Elder CitizenId
     * @param companyId: Company Id
     * @param elderName: Elder Name
     * @param elderPhone: Elder Phone number
     * @param elderAddress: Elder address
     * @param elderPassword: Elder Password
     * @param elderImage: Elder Image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/elder", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> elderRegister(String elderId, int companyId, String elderName,
                                             String elderPhone, String elderAddress,
                                             String elderPassword, String elderImage){
        Map<String, Object> result = new HashMap<String, Object>();

        Elder elder = registerService.registerForAnElder(elderId, companyId, elderName, elderPhone, elderAddress, elderPassword, elderImage);
        result.put("error", false);
        result.put("account", elder);
        return result;
    }

    /**
     * @param relativeId: relative citizen_id
     * @param relativeName: relative name
     * @param relativePhone: relative phone number
     * @param relativeAddress: relative address
     * @param relativePassword: relative password
     * @param relativeImage: relative image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/relative" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> relativeRegister(String relativeId, String relativeName,
                                                String relativePhone, String relativeAddress,
                                                String relativePassword, String relativeImage){
        Map<String, Object> result = new HashMap<String, Object>();
        Relative relative = registerService.registerForARelative(relativeId, relativeName, relativePhone, relativeAddress, relativePassword, relativeImage);
        result.put("error", false);
        result.put("account", relative);
        return result;
    }

    /**
     * @param volunteerId: volunteer citizenId
     * @param volunteerName: volunteer name
     * @param volunteerPhone: volunteer phone number
     * @param volunteerAddress: volunteer address
     * @param volunteerEmail: volunteer email
     * @param volunteerCompanyId: volunteer's companyId
     * @param volunteerPassword: volunteer password
     * @param volunteerImage: volunteer image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/volunteer" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> volunteerRegister(String volunteerId, String volunteerName, String volunteerPhone,
                                                 String volunteerAddress, String volunteerEmail,
                                                 int volunteerCompanyId, String volunteerPassword, String volunteerImage){
        Map<String, Object> result = new HashMap<String, Object>();
        Volunteer volunteer = registerService.registerForAVolunteer(volunteerId, volunteerName, volunteerPhone, volunteerAddress, volunteerEmail, volunteerCompanyId, volunteerPassword, volunteerImage);
        result.put("error", false);
        result.put("account", volunteer);
        return result;
    }

    /**
     * @param lpId: legal person citizenId
     * @param lpName: legal person name
     * @param lpPhone: legal person phone number
     * @param lpEmail: legal person email
     * @param lpPassword: legal person password
     * @param lpImage: lega person image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/legalperson", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> legalPersonRegister(String lpId, String lpName, String lpPhone,
                                                   String lpEmail, String lpPassword, String lpImage){
        Map<String, Object> result = new HashMap<String, Object>();
        LegalPerson legalPerson = registerService.registerForALegalPerson(lpId, lpName, lpPhone, lpEmail, lpPassword, lpImage);
        result.put("error", false);
        result.put("account", legalPerson);
        return result;
    }

    /**
     * @param relativeId: relative citizenId
     * @param elderId: elder citizenId
     * @param togetherImg: together image
     * @return
     * Error: false,
     */
    @RequestMapping(value = "/apply/monitor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> applyMonitor(String relativeId, String elderId, String togetherImg){
        Map<String, Object> result = new HashMap<String, Object>();
        verifyService.submitMonitorApply(relativeId, elderId, togetherImg);
        result.put("error", false);
        return result;
    }

    /**
     * @param relativeId: relativeId
     * @return
     * Error: true, ErrorMsg
     * Error:false, monitor detail
     */
    @RequestMapping(value = "/status/monitor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> checkMonitor(String relativeId){
        Map<String, Object> result = new HashMap<String, Object>();
        List<ElderMonitor> list = verifyService.monitorStatus(relativeId);
        if (list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Invalid relativeId Or no related information.");
        }else{
            result.put("error", false);
            result.put("result", list);
        }
        return result;
    }

    /**
     * @param phoneNum: phone number
     * @return
     * Error: false, code
     */
    @RequestMapping(value = "/code",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> createCode(String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        int code = smsService.sendVerifyCodeToPhone(phoneNum);
        result.put("error", false);
        result.put("code", code);
        return result;
    }

    /**
     * @param id: citizenId
     * @param phoneNum: phone number
     * @return
     * Error: true, ErrorMsg
     * Error:false, account type
     */
    @RequestMapping(value = "/verify/phone", method = RequestMethod.GET)
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

    /**
     * @param id: citizenId
     * @param password: new password
     * @return
     * Error: true, ErrorMsg
     * Error: false
     */
    @RequestMapping(value = "/changepassword",method = RequestMethod.GET)
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
