package com.OCare.dao;

import com.OCare.entity.ofMucMember;

import java.util.List;

/**
 * Created by mark on 10/27/15.
 */
public interface ofMucMemberDAO extends IGeneralDAO<ofMucMember> {

    public List<ofMucMember> getAllMembersByRoomId(int roomId);
    public List<ofMucMember> getMemberByRoomIdAndPhoneNum(int roomId, String phoneNum);
}
