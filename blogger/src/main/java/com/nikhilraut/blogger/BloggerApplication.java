package com.nikhilraut.blogger;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerApplication.class, args);

		Logger logger = Logger.getLogger(BloggerApplication.class);
		
		logger.info("log info message");
		logger.error("log error message");
		logger.debug("log debug message");
		
	}
}
