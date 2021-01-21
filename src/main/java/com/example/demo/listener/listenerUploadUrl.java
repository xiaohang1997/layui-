package com.example.demo.listener;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class listenerUploadUrl implements ServletContextListener {

    @Value("${upload.imgUrl}")
    private String imgUrl;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        File filepath = new File(imgUrl);
        if(!filepath.exists()){
            filepath.mkdirs();
        }else{
            System.out.println("路径存在");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
