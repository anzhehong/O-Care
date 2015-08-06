package com.OCare.service;

import com.OCare.entity.Contract;
import com.OCare.entity.ElderCondition;

import java.util.List;

/**
 * Created by mark on 8/7/15.
 */
public interface ContractService {

    public List<Contract> getAllContracts();
    public List<Contract> getContractsByElderId(String elderId);
    public Contract getContractsById(int id);

    //ElderCondition
    public List<ElderCondition> getElderConditionByElderId(String elderId);
}
