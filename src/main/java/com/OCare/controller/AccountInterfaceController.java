package com.OCare.controller;

import com.OCare.entity.*;
import com.OCare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by mark on 8/2/15.
 */
@Controller
@RequestMapping("/app")
public class AccountInterfaceController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private SMSService smsService;
    @Autowired
    private ElderService elderService;
    @Autowired
    private RelativeService relativeService;

    /**
     * @param phoneNum：Phone number
     * @param password：Password
     * @return
     * Error: true, ErrorMsg
     * Error: false, Account type, Account detail
     */
    @RequestMapping(value = "/logon")
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
    @RequestMapping(value = "/register/elder")
    @ResponseBody
    public Map<String, Object> elderRegister(String elderId, int companyId, String elderName,
                                             String elderPhone, String elderAddress,
                                             String elderPassword, String elderImage){
        Map<String, Object> result = new HashMap<String, Object>();

        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(elderId,elderPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
        Elder elder = registerService.registerForAnElder(elderId, companyId, elderName, elderPhone, elderAddress, elderPassword, elderImage);
        System.out.println(isIdOrPhoneNumExist(elderId,elderPhone));
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
    @RequestMapping(value = "/register/relative")
    @ResponseBody
    public Map<String, Object> relativeRegister(String relativeId, String relativeName,
                                                String relativePhone, String relativeAddress,
                                                String relativePassword, String relativeImage){
        Map<String, Object> result = new HashMap<String, Object>();
        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(relativeId,relativePhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
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
    @RequestMapping(value = "/register/volunteer")
    @ResponseBody
    public Map<String, Object> volunteerRegister(String volunteerId, String volunteerName, String volunteerPhone,
                                                 String volunteerAddress, String volunteerEmail,
                                                 int volunteerCompanyId, String volunteerPassword, String volunteerImage){
        Map<String, Object> result = new HashMap<String, Object>();

        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(volunteerId,volunteerPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
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
    @RequestMapping(value = "/register/legalperson")
    @ResponseBody
    public Map<String, Object> legalPersonRegister(String lpId, String lpName, String lpPhone,
                                                   String lpEmail, String lpPassword, String lpImage){
        Map<String, Object> result = new HashMap<String, Object>();
        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(lpId,lpPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
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
    @RequestMapping(value = "/apply/monitor")
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
    @RequestMapping(value = "/status/monitor")
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
    @RequestMapping(value = "/code")
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
    @RequestMapping(value = "/verify/phone")
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
    @RequestMapping(value = "/changepassword")
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

    public boolean isIdOrPhoneNumExist(String id, String phoneNum) {
        boolean flag = true;
        ArrayList<Elder> elders = registerService.getAllElders();
        ArrayList<Relative> relatives = registerService.getAllRelatives();
        ArrayList<Volunteer> volunteers = registerService.getAllVolunteers();
        ArrayList<LegalPerson> legalPersons = registerService.getAllLegalPerson();

        Iterator<Elder> elderIterator = elders.iterator();
        Iterator<Relative> relativeIterator = relatives.iterator();
        Iterator<Volunteer> volunteerIterator = volunteers.iterator();
        Iterator<LegalPerson> legalPersonIterator = legalPersons.iterator();

        while (elderIterator.hasNext())
        {
            Elder elder = elderIterator.next();
            if (elder.getId().equals(id)||elder.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (relativeIterator.hasNext())
        {
            Relative relative = relativeIterator.next();
            if (relative.getId().equals(id) || relative.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (volunteerIterator.hasNext())
        {
            Volunteer volunteer = volunteerIterator.next();
            if (volunteer.getId().equals(id) || volunteer.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (legalPersonIterator.hasNext())
        {
            LegalPerson legalPerson  = legalPersonIterator.next();
            if (legalPerson.getId().equals(id) || legalPerson.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }

        return flag;
    }

    /*
        功能：根据phoneNum拿到头像
     */
    @RequestMapping(value = "/getImageByPhoneNum")
    @ResponseBody
    public Map<String,Object> getImageByPhoneNum(String phoneNum)
    {
        Map<String , Object>result = new HashMap<String, Object>();
        //传参错误
        if (phoneNum == null || phoneNum == "null")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid!");
        }else {
            String status = accountService.getImageByPhoneNum(phoneNum).getKey();
            if (status == "get image successfully.")
            {
                result.put("error",false);
                result.put("image",accountService.getImageByPhoneNum(phoneNum).getValue());
            }else if (status == "PhoneNum does not match to any account!")
            {
                result.put("error",true);
                result.put("error","PhoneNum does not match to any account!");
            }
        }
        return result;
    }

    /*
        功能：根据phoneNum修改头像为newImage
     */
    @RequestMapping("/setNewImageByPhoneNum")
    @ResponseBody
    public Map<String,Object>setNewImageByPhoneNum(String phoneNum, String newImage)
    {
        Map<String, Object>result = new HashMap<String, Object>();
        //传参数错误
        if (phoneNum == null || phoneNum == "" || newImage == null || newImage == "")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid Or new Image is valid!");
        }else {
            boolean flag = accountService.isChangeImageSucc(phoneNum, newImage);
            if (flag == true)
            {
                result.put("error",false);
            }else
            {
                result.put("error",true);
                result.put("errorMsg","Change Image Successfully!");
            }
        }
        return result;
    }

    /*
        功能：修改某个人和老人的关系为新的type
     */
    @RequestMapping("/changeRelation")
    @ResponseBody
    public Map<String,Object> changeRelationBetweenElderAndSomebody(String elderId,String sbPhoneNum,int newRelationType)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (sbPhoneNum == null || sbPhoneNum == "")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid Or new Image is valid!");
        }else {
            boolean flag = verifyService.changeRelationBetweenElderAndSomebody(elderId, sbPhoneNum, newRelationType);
            if (flag == false)
            {
                result.put("error",true);
                result.put("errorMsg","Change Relation Failed.");
            }else {
                result.put("error",false);
            }

        }
        return result;
    }

    /*
        功能：监护人负责删除某个人和老人的关系（设type为7）
     */
    @RequestMapping("/deleteRelation")
    @ResponseBody
    public Map<String,Object> deleteRelationBetweenElderAndSomebody(String elderId, String sbPhoneNum)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (sbPhoneNum == null || sbPhoneNum == "")
        {
            result.put("error",true);
            result.put("errorMsg","Delete Relation Failed.");
        }else {
            boolean flag = verifyService.deleteRelationBetweenElderAndSomebody(elderId, sbPhoneNum);
            if (flag == false)
            {
                result.put("error",true);
                result.put("errorMsg","Delete Relation Failed.");
            }else {
                result.put("error",false);
            }
        }
        return result;
    }

    /*
        功能：通过身份证拿到某个老人的全部信息，即实体集
     */
    @RequestMapping("/getElderInfo")
    @ResponseBody
    public Map<String,Object> getElderInfoById(String elderId)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Elder Id Input Error!");
        }else {
            Elder elder = elderService.getElderById(elderId);
            result.put("error",false);
            result.put("elderEntity",elder);
        }
        return result;
    }

    /*
        功能：通过身份证拿到某个relative的全部信息，即实体集
     */
    @RequestMapping("/getRelativeInfo")
    @ResponseBody
    public Map<String,Object> getRelativeInfoById(String relativeId)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (relativeId == null || relativeId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Relative Id Input Error!");
        }else {
            Relative relative = relativeService.getRelativeById(relativeId);
            result.put("error",false);
            result.put("elderEntity",relative);
        }
        return result;
    }

    /*
        功能：通过老人Id拿到所有的监护人的list
     */
    @RequestMapping("/getMonitorsByElderId")
    @ResponseBody
    public Map<String ,Object> getMonitorsByElderId(String elderId)
    {
        Map<String ,Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Elder Id Input Error!");
        }else {
            ArrayList<Relative> relatives = elderService.getAllMonitorsByElderId(elderId);
            result.put("error",false);
            result.put("MonitorList",relatives);
        }
        return result;
    }
}
