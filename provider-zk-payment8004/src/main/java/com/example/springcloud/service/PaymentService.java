package com.example.springcloud.service;

import com.example.springcloud.entities.CommonResult;

public interface PaymentService {
    CommonResult getPaymentByPort(String port);
}
