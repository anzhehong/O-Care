package com.OCare.controller;

import com.OCare.service.SMSSerivceImp;

/**
 * Created by fowafolo on 15/7/31.
 */
public class TestSMS {
    public static void main(String[] args) {
        SMSSerivceImp ss = new SMSSerivceImp();
        ss.sendVerifyCodeToPhone("13162528836");
    }
}
