package com.sharding.config;

import com.sharding.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShardingConfig {

    @Bean
    Order order(){
        Order order=new Order();
        order.setOrderId("2222");
        return order;
    }
}
