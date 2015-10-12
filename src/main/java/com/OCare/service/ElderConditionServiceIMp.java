package com.OCare.service;

import com.OCare.dao.ElderConditionDAO;
import com.OCare.entity.ElderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fowafolo on 15/7/30.
 */
@Service("elderConditionService")
@Transactional
public class ElderConditionServiceIMp implements ElderConditionService {
    @Autowired
    private ElderConditionDAO elderConditionDAO;

    @Override
    public List<ElderCondition> allElderConditions() {
        return elderConditionDAO.queryAll();
    }

    @Override
    public ElderCondition getElderPresentConditionById(String elderId) {
        return elderConditionDAO.findElderCondition(elderId).get(0);
    }


}
