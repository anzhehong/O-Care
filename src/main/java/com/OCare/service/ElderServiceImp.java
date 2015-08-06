package com.OCare.service;

import com.OCare.dao.ElderDAO;
import com.OCare.dao.ElderMonitorDAO;
import com.OCare.entity.Elder;
import com.OCare.entity.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by fowafolo on 15/8/7.
 */

@Service("Elder")
@Transactional
public class ElderServiceImp implements ElderService {
    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private ElderMonitorDAO elderMonitorDAO;

    @Override
    public Elder getElderById(String elderId) {
        Elder elder = elderDAO.queryById(elderId);
        return elder;
    }

    @Override
    public ArrayList<Relative> getAllMonitorsByElderId(String elderId) {
        ArrayList<Relative> list = elderMonitorDAO.getAllMonitorsByElderId(elderId);
        return list;
    }
}
