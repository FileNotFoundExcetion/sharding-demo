package com.sharding.controller;

import com.sharding.ann.AccessLog;
import com.sharding.mapper.OrderMapper;
import com.sharding.request.TestRequest;
import com.sharding.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Value("#{testService2}")
    private TestService testService2;

    @Resource
    private OrderMapper orderMapper;

    @AccessLog(value = "test")
    @PostMapping("test")
    public Object test(@RequestBody String json){
        System.out.println(json);
        return json;
    }

    @AccessLog(value = "test01")
    @GetMapping("test01")
    public Object test01(TestRequest testRequest){
       return orderMapper.selectActivityInfo1(testRequest.getStart(),testRequest.getEnd());
     //   System.out.println(testRequest);
     //   return "";
    }
}
