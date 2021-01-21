package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductService;
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

    @Resource
    private ProductService productService;

    @RequestMapping("/upload")
    public JSONObject upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //String path = request.getSession().getServletContext().getRealPath("upload");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String path = "D:\\var\\uploaded_files\\";
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();       //本来的文件名
//        String fileName = uuid.toString() + originalFilename;
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        System.out.println("path="+path);
        File dir = new File(path+fileName);
        File filepath = new File(path);
        if(!filepath.exists()){
            filepath.mkdirs();
        }else{
            System.out.println("路径存在");
        }
        file.transferTo(dir);
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
