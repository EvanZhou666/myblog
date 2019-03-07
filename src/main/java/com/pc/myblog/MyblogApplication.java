package com.pc.myblog;

import com.pc.myblog.properties.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityProperties.class)
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

}
