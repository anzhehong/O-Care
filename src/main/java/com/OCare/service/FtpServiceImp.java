package com.OCare.service;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by fordevelopment on 15/11/11.
 */
@Service("FtpService")
public class FtpServiceImp implements FtpService {

    @Override
    public String uploadFile(File file) {
        return "success";
    }

    @Override
    public File getFileById(String id) {
        return null;
    }
}
