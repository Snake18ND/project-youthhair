package com.example.doanweb.service.impl;

import com.example.doanweb.service.UploadService;
import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired ServletContext app;

    public File save(MultipartFile file, String folder) {
        File dir = new File(app.getRealPath( folder));
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File savedFile = new  File(dir,name);
            file.transferTo(savedFile.getAbsoluteFile());
            return savedFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
