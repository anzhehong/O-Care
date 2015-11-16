package com.OCare.service;

import it.sauronsoftware.ftp4j.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * Created by fordevelopment on 15/11/11.
 */
@Service
@Transactional
public class FtpServiceImp implements FtpService {

    @Override
    public String uploadFile(File file) {
        try {
            // 创建客户端
            FTPClient client = new FTPClient();
            // 不指定端口，则使用默认端口21
            client.connect("202.120.163.167", 21);
            // 用户登录
            client.login("ocare", "ocare");
            // 打印地址信息
            System.out.println(client);
            client.changeDirectory("contract");
            client.upload(file);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public String downloadFile(String fileName) {
        try {
            FTPClient client = new FTPClient();
            client.connect("202.120.163.167", 21);
            client.login("ocare", "ocare");
            client.changeDirectory("Contracts");
            client.changeDirectory(fileName);
            System.out.println(client);


            File file = new File("xmlTodoc/"+ fileName + ".xml");
            System.out.print("path:>>>>>>>>>>>>>"+file.getPath());
            if (!file.exists())
                file.createNewFile();
            client.download(fileName + ".xml",file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public String uploadDocFile(String fileName) {
        try {
            FTPClient client = new FTPClient();
            client.connect("202.120.163.167", 21);
            client.login("ocare", "ocare");
            client.changeDirectory("Contracts");
            client.changeDirectory(fileName);
            System.out.println(client);
            File file = new File("xmlTodoc/" + fileName + ".doc");
            client.upload(file);
            file.delete();
            client.disconnect(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public File getFileById(String id) {
        return null;
    }
}
