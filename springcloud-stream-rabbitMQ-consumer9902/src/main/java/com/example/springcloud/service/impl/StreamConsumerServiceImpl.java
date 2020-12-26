package com.example.springcloud.service.impl;

import com.example.springcloud.service.StreamConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class StreamConsumerServiceImpl implements StreamConsumerService {

    @StreamListener(Sink.INPUT)
    public void consumer(@Payload String payload) {
        log.info("payload: "+payload);
    }
}
