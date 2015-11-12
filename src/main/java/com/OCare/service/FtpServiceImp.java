package com.OCare.service;

import it.sauronsoftware.ftp4j.FTPClient;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by fordevelopment on 15/11/11.
 */
@Service
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
