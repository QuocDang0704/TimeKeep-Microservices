package com.example.timekeeplogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimeKeepLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeKeepLoginApplication.class, args);
    }

}
