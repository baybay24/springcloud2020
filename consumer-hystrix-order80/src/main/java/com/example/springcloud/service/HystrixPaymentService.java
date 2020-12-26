package com.example.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT" , fallback = HystrixPaymentServiceImpl.class)
public interface HystrixPaymentService {

    @GetMapping("/payment/getPortOK/{id}")
    public String getPortOK(@PathVariable("id") String id );

    @GetMapping("/payment/getPortTimeOut/{id}")
    public String getPortTimeOut(@PathVariable("id") String id );

    @GetMapping("/payment/caculator/{id}")
    public String caculator(@PathVariable("id") long id);
}
