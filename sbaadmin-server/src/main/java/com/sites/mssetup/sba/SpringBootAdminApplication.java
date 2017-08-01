package com.sites.mssetup.sba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminApplication extends SpringBootServletInitializer  {

	private static Class<SpringBootAdminApplication> applicationClass = SpringBootAdminApplication.class;
	private static final Logger logger = LoggerFactory.getLogger(applicationClass);
	
    public static void main(String[] args) {
    	logger.info("Starting up sba admin server...");
        SpringApplication.run(applicationClass, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application;
    }
}