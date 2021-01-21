package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductService;
import com.example.demo.until.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUpload {
    @Value("${upload.imgUrl}")
    private String imgUrl;

    @RequestMapping("/upload")
    public JSONObject upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        String fileName = UploadFile.uploadFile(file);
        //获得当前项目所在路径
//        String pathRoot=request.getSession().getServletContext().getRealPath("");
//        System.out.println(pathRoot);
        String sqlFile = imgUrl+fileName;
//        }
        resUrl.put("src", sqlFile);
        res.put("code", 0);
        res.put("msg", "上传成功");
        res.put("data", resUrl);
        String str="";
//        str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" +dir + "\"}}";

        return res;

    }
}
