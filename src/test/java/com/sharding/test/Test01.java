package com.sharding.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharding.entity.Order;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Test01 {
    public static void main(String[] args) throws JsonProcessingException, DecoderException, UnsupportedEncodingException {
        Order order=new Order();
        order.setOrderId("123456");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(order));
        byte[] bytes = Hex.decodeHex("2eb7fd33f53ecbe19559e61ce7077ec8");
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
