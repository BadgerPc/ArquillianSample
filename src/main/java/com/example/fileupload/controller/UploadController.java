package com.example.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


//import com.example.FileUploadIssueHelper.FileUploadHelperCustomService;
import com.example.fileupload.service.MyCustomService;

@RestController
@RequestMapping("/upload")
public class UploadController implements BaseController {
    
    @Autowired
    private MyCustomService myCustomService;
    
/*    @Autowired
    private FileUploadHelperCustomService fileUploadHelperCustomService;*/
    
    @RequestMapping(method = RequestMethod.GET, value = "/sayhello")
    public String sayHello() {
    	return "I am here";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fileupload")
    public void saveFileUpload(MultipartHttpServletRequest request) throws Exception {

        if (request.getFileMap().get("schema") != null) {
            MultipartFile schemaFile = request.getFileMap().get("schema");
            
            if (schemaFile != null) {
            	
                System.out.println("Validating Uploaded File");
                myCustomService.validateUpload(schemaFile);
                System.out.println("Validated...Call Backend to Store File");
                myCustomService.uploadSchemaforEndPoint(schemaFile);
                System.out.println("Stored....");
            }
        }
    }

/*    @RequestMapping(method = RequestMethod.POST, value = "/fileuploadhelper")
    public void saveFileUploadHelper(MultipartHttpServletRequest request) {
        
        logger.debug("Test");
        System.out.println("\n\n\nInside saveFileUploadHelper aaaa");
        if (request.getFileMap().get("schema") != null) {
            MultipartFile schemaFile = request.getFileMap().get("schema");
            System.out.println("\n\n\nInside saveFileUploadHelper bbbb");
            
            if (schemaFile != null) {
                System.out.println("\n\n\nInside saveFileUploadHelper cccc");
                myCustomService.validateUpload(schemaFile);
                System.out.println("\n\n\nInside saveFileUploadHelper dddd");
                fileUploadHelperCustomService.uploadSchemaforEndPointinFileUploadHelper(schemaFile);
                System.out.println("\n\n\nInside saveFileUploadHelper eeee");
            }
        }
    }*/
}
