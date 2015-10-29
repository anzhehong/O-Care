package com.OCare.dao;

import com.OCare.entity.ofMucMember;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 10/27/15.
 */
@Repository
public class ofMucMemberDAOImpl extends IGeneralDAOImpl<ofMucMember> implements ofMucMemberDAO {
    public ofMucMemberDAOImpl() {
        super(ofMucMember.class);
    }

    @Override
    public List<ofMucMember> getAllMembersByRoomId(int roomId) {
        String hql = "from ofMucMember where roomID = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("m", roomId);
        return query.list();
    }

    @Override
    public List<ofMucMember> getMemberByRoomIdAndPhoneNum(int roomId, String phoneNum) {
        String hql = "FROM ofMucMember WHERE roomID = :n AND jid LIKE :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("n", roomId);
        query.setString("m","%" + phoneNum + "%");
        return query.list();
    }
}
