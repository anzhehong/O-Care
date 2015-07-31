package com.OCare.dao;

import com.OCare.entity.ElderMonitor;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/31.
 */
@Repository
public class ElderMonitorDAOImp extends IGeneralDAOImpl<ElderMonitor> implements ElderMonitorDAO {


    @Override
    public List<ElderMonitor> getAllUntreatedRequests() {
        String hql = "from ElderMonitor where type = 3";
        Query query = super.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public ElderMonitorDAOImp()
    {
        super(ElderMonitor.class);
    }
}
