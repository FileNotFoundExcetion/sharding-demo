package com.sharding.test;

import cn.hutool.core.convert.impl.StringConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharding.entity.Order;

import java.util.Objects;

public class Test01 {
    public static void main(String[] args) throws JsonProcessingException {
        Order order=new Order();
        order.setOrderId("123456");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(order));
    }
}
