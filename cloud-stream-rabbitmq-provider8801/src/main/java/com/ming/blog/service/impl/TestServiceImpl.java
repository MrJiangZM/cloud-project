package com.ming.blog.service.impl;

import com.ming.blog.message.TestMsgProviderBody;
import com.ming.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import java.util.UUID;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/20</pre>
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class TestServiceImpl implements TestService {

    @Qualifier("output")
    @Autowired
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serialNumber = UUID.randomUUID().toString();
        TestMsgProviderBody testMsgProviderBody = new TestMsgProviderBody(10L, "小明", serialNumber);
        messageChannel.send(MessageBuilder.withPayload(testMsgProviderBody).build());
        System.out.println("---SerialNumber---: " + serialNumber);
        return serialNumber;
    }

}
