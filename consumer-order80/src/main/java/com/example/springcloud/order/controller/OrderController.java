package com.example.springcloud.order.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.order.lbrule.MyRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private MyRule myRule;
    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL="http://provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER-PAYMENT");
        if(instanceList == null && instanceList.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = myRule.instance(instanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.postForObject(uri+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER-PAYMENT");
        if(instanceList == null && instanceList.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = myRule.instance(instanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER-PAYMENT");
        if(instanceList == null && instanceList.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = myRule.instance(instanceList);
        URI uri = serviceInstance.getUri();
        log.info("uri ---- "+uri+"/payment/lb");
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
