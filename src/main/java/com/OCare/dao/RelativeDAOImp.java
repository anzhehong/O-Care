package com.OCare.dao;

import com.OCare.entity.Relative;
import org.springframework.stereotype.Repository;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class RelativeDAOImp extends IGeneralDAOImpl<Relative> implements RelativeDAO {

    public RelativeDAOImp()
    {
        super(Relative.class);
    }
}
