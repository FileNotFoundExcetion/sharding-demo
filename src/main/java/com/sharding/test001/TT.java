package com.sharding.test001;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Map;


@Slf4j
public class TT {
    public static void main(String[] args) throws InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        //empty beans不需要报错，没有就是没有了

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

//遇到不可识别字段的时候不要报错，因为前端传进来的字段不可信，可以不要影响正常业务逻辑

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

//遇到不可以识别的枚举的时候，为了保证服务的强壮性，建议也不要关心未知的，甚至给个默认的，特别是微服务大家的枚举值随时在变，但是老的服务是不需要跟着一起变的

        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL,true);

        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE,true);

    /*    ObjectMapper objectMapper=new ObjectMapper();
        TypeReference<Map<String, Integer>> token = new TypeReference<Map<String, Integer>>() {};
        Type type = token.getType();
        Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
        System.out.println(typeArguments[0].getTypeName());
        System.out.println(typeArguments[1].getTypeName());*/
        MDC.put("TRACE_ID","123456");
        log.info("---------:{}",MDC.get("TRACE_ID"));
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
        log.info("+++++++++:{}", copyOfContextMap);
        new Thread(()->{
            try {
                MDC.setContextMap(copyOfContextMap);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
         //   System.out.println("======"+MDC.get("TRACE_ID"));
            log.info("======:{}", MDC.get("TRACE_ID"));
        }).start();
        Thread.currentThread().join();
    }
}
