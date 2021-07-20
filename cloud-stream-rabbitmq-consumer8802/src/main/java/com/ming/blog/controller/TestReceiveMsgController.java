package com.ming.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/20</pre>
 */
@Component
@EnableBinding(Sink.class)
public class TestReceiveMsgController {


    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("Consumer - 1: " + message.getPayload() + "\t port: " + serverPort);
    }

}
