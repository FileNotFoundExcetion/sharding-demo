package com.sharding.controller;

import com.sharding.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("#{testService2}")
    private TestService testService2;
    @Value("${server.port}")
    private String port;
    @GetMapping("test")
    public Object test(){
        System.out.println(testService2);
        System.out.println(port);
      return "";
    }
}
