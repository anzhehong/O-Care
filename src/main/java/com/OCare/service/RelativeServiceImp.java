package com.OCare.service;

import com.OCare.dao.RelativeDAO;
import com.OCare.entity.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by fowafolo on 15/8/7.
 */

@Service("Relative")
@Transactional
public class RelativeServiceImp implements RelativeService {

    @Autowired
    private RelativeDAO relativeDAO;

    @Override
    public Relative getRelativeById(String id) {
        Relative relative = relativeDAO.queryById(id);
        return relative;
    }
}
