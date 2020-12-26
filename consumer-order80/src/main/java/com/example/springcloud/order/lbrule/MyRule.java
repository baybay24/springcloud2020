package com.example.springcloud.order.lbrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyRule {
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
