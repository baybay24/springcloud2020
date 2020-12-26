package com.example.springcloud.service;

import org.springframework.stereotype.Component;

@Component

public class HystrixPaymentServiceImpl implements HystrixPaymentService{
    @Override
    public String getPortOK(String id) {
        return "consumer_OK_Hystrix fix";
    }

    @Override
    public String getPortTimeOut(String id) {
        return "consumer_TimeOut_Hystrix fix";
    }

    @Override
    public String caculator(long id) {
        return null;
    }
}
