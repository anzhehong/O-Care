package com.OCare.dao;

import com.OCare.entity.Volunteer;
import org.springframework.stereotype.Repository;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class VolunteerDAOImp extends IGeneralDAOImpl<Volunteer> implements VolunteerDAO {

    public VolunteerDAOImp()
    {
        super(Volunteer.class);
    }
}
