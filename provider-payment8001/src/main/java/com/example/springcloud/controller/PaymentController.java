package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
       int result = paymentService.create(payment);
        log.info(""+payment);
       if(result > 0 ){
           return new CommonResult(200,"server.port:"+port+" 插入成功",result);
       }else
           return new CommonResult(444,"server.port:"+port+" 插入失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
               Payment payment = paymentService.getPaymentById(id);
        log.debug(""+id);
        if(payment != null ){

            return new CommonResult(200,"server.port:"+port+" 查询成功",payment);
        }else
            return new CommonResult(444,"server.port:"+port+" 查询失败",null);

    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return port;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String serviceTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
