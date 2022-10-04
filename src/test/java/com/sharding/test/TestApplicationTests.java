package com.sharding.test;

import com.sharding.entity.Order;
import com.sharding.mapper.OrderMapper;
import com.sharding.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TestApplicationTests {
   @Resource
   OrderMapper orderMapper;
	@Test
	void selectOrderByOrderDate() {
		//orderDate
		Map<String,Object> params=new HashMap<>();
		params.put("orderDate","20220930");
		List<Order> orders = orderMapper.selectOrderByOrderDate(params);
		System.out.println(orders);
	}

	@Resource
	private OrderService orderService;

	@Test
	public void queryOrder(){
		List<Order> orders = orderService.queryOrder();
		System.out.println(orders);
	}

}
