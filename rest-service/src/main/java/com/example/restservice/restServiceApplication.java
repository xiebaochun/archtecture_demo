package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({
        "com.ecrisson.org",
        "com.example.restservice"
})
@EnableConfigurationProperties
public class restServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(restServiceApplication.class, args);//NOSONAR
    }
}
