package com.example.demo.until;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFile {
    @Value("${upload.imgUrl}")
    private static String imgUrl;

    public static String uploadFile(MultipartFile file){
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(imgUrl + fileName);
        try {
            file.transferTo(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
