package com.example.config;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherServeletConfig {

    /**
     * Method for creating DispatcherServlet bean instance
     * 
     * @return DispatcherServlet instance
     */
    @Bean
    public DispatcherServlet dispatcherServlet() {
      return new DispatcherServlet();
    }
    
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
      ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");


      registration.setName(
          DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

      // registering multipart config as its required for recieving multipart file via eap server.
/*      registration.setMultipartConfig(MyMultipartConfig.getMultiPartConfig());*/
      return registration;
    }
}
