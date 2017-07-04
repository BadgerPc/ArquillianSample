package com.example.fileupload.controller;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import com.example.MyApplication;
import javax.inject.Inject;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RunWith(Arquillian.class)
public class UploadControllerTest {

	/**
     * <p>The context path of the deployed application.</p>
     */
    @ArquillianResource
    private URL contextPath;
    

	@Inject
	private MyApplication converter = new MyApplication();



    /**
     * <p>Autowired {@link RestTemplate}.</p>
     */
    @Autowired
    private RestTemplate restTemplate;
    
/*    @Deployment
    @OverProtocol("Servlet 3.0")
    public static Archive createTestArchive() {
    }
    */


	@Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "FileUploadIssue.war")
        				 .addPackages(true,"com.example")
        				 .addClasses(MyApplication.class)
        				 .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    /**
     * <p>Tests invocation of a REST service.</p>
     */
    @Test
    @RunAsClient
    public void testGetEmployees() {
    	
    	System.out.println( "Testing ******** : " + contextPath+ "upload/sayhello");
    	
    	System.out.println( "restTemplate ******** : " + restTemplate); // Prints null
    	
    	String result = restTemplate.getForObject(contextPath + "upload/sayhello", String.class);
    	
    	System.out.println( "Test : " + result);
    }
}
