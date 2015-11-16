package com.OCare.service;

import java.io.File;

/**
 * Created by fordevelopment on 15/11/11.
 */
public interface FtpService {
    String uploadFile(File file);
    File getFileById(String id);
    String uploadFileById(File file,String id);
}
