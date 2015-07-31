package com.OCare.dao;

import com.OCare.entity.LegalPerson;
import org.springframework.stereotype.Repository;

/**
 * Created by fowafolo on 15/7/28.
 */

@Repository
public class LegalPersonDAOImp extends IGeneralDAOImpl<LegalPerson> implements LegalPersonDAO {

    public LegalPersonDAOImp()
    {
        super(LegalPerson.class);
    }
}
