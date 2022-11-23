package com.sharding.test001;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class PP {
    public static void main(String[] args) throws JsonProcessingException, OgnlException {
        String original="{\"city\": \"北京市\", \"province\": \"北京市\"}";
        InputStream inputStream = new ByteArrayInputStream(original.getBytes(StandardCharsets.UTF_8));
        String josn = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        OgnlContext ognlContext=new OgnlContext();
        ObjectMapper objectMapper=new ObjectMapper();
        Map map = objectMapper.readValue(josn, Map.class);
        ognlContext.setRoot(map);
        String value =  (String) Ognl.getValue("city1", ognlContext, ognlContext.getRoot());
        System.out.println(value);
    }
}
