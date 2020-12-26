package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class,args);
    }
}
