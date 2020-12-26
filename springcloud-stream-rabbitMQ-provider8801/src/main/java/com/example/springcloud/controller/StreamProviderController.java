package com.example.springcloud.controller;

import com.example.springcloud.service.StreamProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class StreamProviderController {

    @Resource
    StreamProviderService service;

    @GetMapping("/provider")
    public void provider(){
        service.provider();
    }
}
