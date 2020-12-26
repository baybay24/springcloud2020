package com.example.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    @HystrixCommand(fallbackMethod = "getPortOKHystrixHandler")
    public String getPortOK(String id) {
        return "HystrixService  OK  port: ";
    }

    public String getPortOKHystrixHandler(){
        return "waiting for a while";
    }


    @Override
    @HystrixCommand(fallbackMethod = "getTimeOutHystrixHandler")
    public String getPortTimeOut(String id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HystrixService  TimeOut  port: ";
    }

    @Override
    @HystrixCommand(fallbackMethod = "caculatorHandler" , commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value="true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMiliseconds", value="10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String caculator(@PathVariable("id") long id) {
        if(id>0){
            throw new RuntimeException("不能输入负数");
        }
        return Thread.currentThread().getName()+"\t"+" , "+ IdUtil.simpleUUID();
    }

    public String getTimeOutHystrixHandler(){
        return "waiting for a while, because service time out";
    }

    public String caculatorHandler(@PathVariable("id") long id){
        return Thread.currentThread().getName()+"\t"+id+" , 不能输入负数, "+ IdUtil.simpleUUID();
    }


    public String fixDefaultHandler(){
        return "fixDefaultHandler";
    }
}
