package com.example.springcloud.service.Impl;

import com.example.springcloud.service.StreamProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@Component
@EnableBinding(Source.class)
public class StreamProviderServiceImpl implements StreamProviderService {

    @Resource
    private MessageChannel output; // 消息发送管道

    public void provider() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);

    }


}
