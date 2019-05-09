package com.handex.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ExternalAdapterService extends SpringBootServletInitializer {

    /**
     * Initializes this application when running as a standalone application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExternalAdapterService.class, args);
    }

    /**
     * Initializes this application when running in a servlet container (e.g. Tomcat)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExternalAdapterService.class);
    }

}
