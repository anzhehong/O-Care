package com.OCare.dao;

import com.OCare.entity.Elder;
import org.springframework.stereotype.Repository;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class ElderDAOImp extends IGeneralDAOImpl<Elder> implements ElderDAO{


    public ElderDAOImp()
    {
        super(Elder.class);
    }

}
