package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class StreamConsumer9902 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer9902.class,args);
    }


}
