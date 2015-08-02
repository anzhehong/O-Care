package com.OCare.service;

import javafx.util.Pair;

/**
 * Created by mark on 8/2/15.
 */
public interface AccountService {
    public Pair<String, Object> logon(String phoneNum, String password);
    public String verifyPhoneNum(String id, String phoneNum);
    public String changePassword(String id, String password);
}
