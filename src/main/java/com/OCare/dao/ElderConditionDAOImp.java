package com.OCare.dao;

import com.OCare.entity.ElderCondition;
import org.springframework.stereotype.Repository;

/**
 * Created by fowafolo on 15/7/30.
 */

@Repository
public class ElderConditionDAOImp extends IGeneralDAOImpl<ElderCondition> implements ElderConditionDAO {

    public ElderConditionDAOImp()
    {
        super(ElderCondition.class);
    }

}
