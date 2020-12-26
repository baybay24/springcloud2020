package com.example.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentHystrixService {
    public String getPortOK(@PathVariable("id") String id );

    public String getPortTimeOut(@PathVariable("id") String id );

    public String caculator(@PathVariable("id") long id);
}
