package com.example.demo.conf;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class MyWebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        String os = System.getProperty("os.name");
        System.out.println(os);
        if(os.toLowerCase().startsWith("win")){
            //--------------------------------------windows下保存路径-------------------------------------------------------------
            //项目图片访问路径
            registry.addResourceHandler("/pictureUpload/project/**").addResourceLocations("file:D:/pictureUpload/project/");
        }else{
            //--------------------------------------linux下保存路径---------------------------------------------------------------------------------
            //项目图片访问路径
            registry.addResourceHandler("/pictureUpload/project/**").addResourceLocations("file:/root/pictureUpload/project/");
        }
        super.addResourceHandlers(registry);
    }
}
