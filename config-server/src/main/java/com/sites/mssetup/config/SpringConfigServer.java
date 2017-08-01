package com.sites.mssetup.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Run config server as a WAR application.
 * Reference
 * http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file
 *
 */
@EnableConfigServer
@SpringBootApplication
public class SpringConfigServer extends SpringBootServletInitializer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Class<SpringConfigServer> applicationClass = SpringConfigServer.class;
	
    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
    
    @ExceptionHandler(value = Exception.class)  
    public void handleException(Exception e){
    	logger.error("SpringConfigServer -> ", e);
	}  
}
