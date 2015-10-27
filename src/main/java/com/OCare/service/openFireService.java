package com.OCare.service;

/**
 * Created by mark on 10/27/15.
 */
public interface openFireService {
    //传说中的管理员查看某房间中的所有成员
    public Object findMembersByPhoneNum(String phoneNum, String roomId);
    public Object findRoomsById(String roomId);
    //某人查看某房间中的某一成员
    public Object findMemberByPhoneNumAndRoomId(String phoneNum, String roomId);
}
