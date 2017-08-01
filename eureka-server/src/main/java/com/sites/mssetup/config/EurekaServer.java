package com.sites.mssetup.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient

public class EurekaServer  extends SpringBootServletInitializer{	
	private static Class<EurekaServer> applicationClass = EurekaServer.class;
	private Logger logger = LoggerFactory.getLogger(applicationClass);
	
	private static final String DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates/";
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {    	
        SpringApplication.run(applicationClass, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	logger.info("Configuring Eureka server...");
        return application.sources(applicationClass);
    }
    
    /**
     * Overrides Spring Boot's {@link FreeMarkerAutoConfiguration} to prefer
     * using a {@link SpringTemplateLoader} instead of the file system. This
     * corrects an issue where Spring Boot may use an empty 'templates' file
     * resource to resolve templates instead of the packaged Eureka classpath
     * templates.
     * 
     * @return FreeMarker configuration
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths(DEFAULT_TEMPLATE_LOADER_PATH);
        configurer.setDefaultEncoding(DEFAULT_CHARSET);
        configurer.setPreferFileSystemAccess(false);
        return configurer;
    }
}
