package com.elidjongrembi.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.elidjongrembi.transactions")
@EnableJpaRepositories("com.elidjongrembi.transactions.dao.jpa")
public class Application extends SpringBootServletInitializer {

    private static final Class<Application> applicationClass = Application.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
		log.debug("Application is running...");
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	log.debug("Application configure");
    	return application.sources(applicationClass);
    }

}
