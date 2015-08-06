package com.OCare.dao;

import com.OCare.entity.ElderCondition;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/30.
 */

@Repository
public class ElderConditionDAOImp extends IGeneralDAOImpl<ElderCondition> implements ElderConditionDAO {

    public ElderConditionDAOImp()
    {
        super(ElderCondition.class);
    }

    @Override
    public List<ElderCondition> findElderCondition(String elderId) {
        String hql = "from ElderCondition where elder_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", elderId);
        return query.list();
    }
}
