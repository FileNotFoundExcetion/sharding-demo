package com.sharding.controller;

import com.sharding.ann.AccessLog;
import com.sharding.request.TestRequest;
import com.sharding.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("#{testService2}")
    private TestService testService2;

    @AccessLog(value = "test")
    @PostMapping("test")
    public Object test(@RequestBody TestRequest testRequest){
        System.out.println(testService2);
        return "";
    }
}
