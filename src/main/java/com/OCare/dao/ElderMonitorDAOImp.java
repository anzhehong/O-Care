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

    @Override
    public List<ElderMonitor> queryByRelativeId(String relativeId) {
        String hql = "from ElderMonitor where relative_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", relativeId);
        return query.list();
    }

    @Override
    public ElderMonitor getById(int id) {
        return (ElderMonitor) sessionFactory.getCurrentSession().get(ElderMonitor.class, id);
    }

    public ElderMonitorDAOImp()
    {
        super(ElderMonitor.class);
    }
}
