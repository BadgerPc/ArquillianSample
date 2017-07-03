package com.example.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;

public final class MyMultipartConfig {
    
    private MyMultipartConfig() {
        
    }
    
    public static MultipartConfigElement getMultiPartConfig() {
        String location = "";
        long maxFileSize = -1;
        long maxRequestSize = -1;
        int fileSizeThreshold = 0;
        
        MultipartConfigFactory mcf = new MultipartConfigFactory();
        mcf.setLocation(location);
        mcf.setFileSizeThreshold(fileSizeThreshold);
        mcf.setMaxFileSize(maxFileSize);
        mcf.setMaxRequestSize(maxRequestSize);
        return mcf.createMultipartConfig();
    }

}
