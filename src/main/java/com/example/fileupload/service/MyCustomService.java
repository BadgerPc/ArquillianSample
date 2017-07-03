package com.example.fileupload.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MyCustomService {
    
    public void uploadSchemaforEndPoint(MultipartFile schemaFile) throws Exception {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Inside MyCustomService uploadSchemaforEndPoint");
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n MyCustomService Input Stream :" + schemaFile.getInputStream());
    }
    
    public void validateUpload(MultipartFile schemaFile) {
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Inside MyCustomService validateUpload");
    	
    	try {
            File schemaData = new File(schemaFile.getName());
            
            schemaFile.transferTo(schemaData);
            
            System.out.println( "\n\n\n\n\n\nFile getAbsolutePath:" + schemaData.getAbsolutePath());
            
            System.out.println( "\n\n\n\n\n\nFile getAbsoluteFile:" + schemaData.getAbsoluteFile());
            
        } catch (IOException e) {
            System.out.println("MyCustomService Exception caught :" + e.toString());
        }
    	
    }

}
