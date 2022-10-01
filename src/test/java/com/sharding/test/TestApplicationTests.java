package com.sharding.test;

import com.sharding.entity.Order;
import com.sharding.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TestApplicationTests {
   @Resource
   OrderMapper orderMapper;
	@Test
	void test() {
		List<Order> orders = orderMapper.selectOrderByOrderDate("20220930");
		System.out.println(orders);
	}

}
