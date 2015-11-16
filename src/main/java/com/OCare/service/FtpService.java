package com.OCare.service;

import java.io.File;

/**
 * Created by fordevelopment on 15/11/11.
 */
public interface FtpService {
    String uploadFile(File file);
    String downloadFile(String fileName);
    String uploadDocFile(String fileName);
    File getFileById(String id);
}
