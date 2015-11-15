package com.OCare.controller;

import com.OCare.entity.Contract;
import com.OCare.entity.ElderCondition;
import com.OCare.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 8/6/15.
 */
@Controller
@RequestMapping("/app")
public class ContractInterfaceController {

    @Autowired
    private ContractService contractService;


    @RequestMapping("/contract/insert")
    @ResponseBody
    public Map<String, Object> insertContract(int id,int company_id,String elder_id,String startTime,String endTime,int status,String folder_name) throws ParseException {
        Map<String, Object> result = new HashMap<String, Object>();


        if (elder_id == null || elder_id.equals("")||startTime == null || startTime.equals("")||endTime == null || endTime.equals("")||folder_name == null || folder_name.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date start_time= sdf.parse(startTime);
        Date end_time= sdf.parse(endTime);

        Contract contract=new Contract();
        contract.setId(id);
        contract.setCompany_id(company_id);
        contract.setElder_id(elder_id);
        contract.setStart_time(start_time);
        contract.setEnd_time(end_time);
        contract.setStatus(status);
        contract.setFolder_name(folder_name);
        System.out.println(">>>>>>>>>>>test"+folder_name);
        boolean b=contractService.insertContract(contract);


        result.put("error", false);
        result.put("insert","insert succeed" );
        return result;
    }

    @ResponseBody
    @RequestMapping("/contract/all")
    public Map<String, Object> getAllContract(){
        Map<String, Object> result = new HashMap<String, Object>();

        List<Contract> list = contractService.getAllContracts();

        if(list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "No contracts");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/contract/id")
    public Map<String, Object> getAllContractById(String id){
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        Contract contract = contractService.getContractsById(Integer.parseInt(id));

        if (contract == null){
            result.put("error", true);
            result.put("errorMsg", "Contracts not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", contract);
        return result;
    }

    @ResponseBody
    @RequestMapping("/contract/elderId")
    public Map<String, Object> getAllContractByElderId(String id) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<Contract> list = contractService.getContractsByElderId(id);

        if (list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Contracts not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/elder/condition")
    public Map<String, Object> getElderConditionByElderId(String id) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<ElderCondition> list = contractService.getElderConditionByElderId(id);

        if (list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Condition not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }




}
