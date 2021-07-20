package com.ming.blog.controller;

import com.ming.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/20</pre>
 */
@RestController
@RequestMapping("/stream/provider")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("send")
    public Object testSend() {
        return testService.send();
    }

}
