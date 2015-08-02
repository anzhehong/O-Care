package com.OCare.service;

/**
 * Created by mark on 8/2/15.
 */
public interface AccountService {
    public String logon(String phoneNum, String password);
    public String verifyPhoneNum(String id, String phoneNum);
    public String changePassword(String id, String password);
}
