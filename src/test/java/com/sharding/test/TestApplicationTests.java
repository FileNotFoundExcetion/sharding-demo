package com.sharding.test;

import com.sharding.entity.Order;
import com.sharding.mapper.OrderMapper;
import com.sharding.service.OrderService;
import com.sharding.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
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

	@Test
	public void selectOrderByOrderDateTemp(){
		Map<String,Object> params=new HashMap<>();
		params.put("orderDate","20220929");
		params.put("orderDate1","20220930");
		List<Integer> couunt = orderMapper.selectOrderByOrderDateTemp(params);
		System.out.println(couunt);
	}

	@Resource
	private OrderService orderService;

	@Test
	public void queryOrder(){
		List<Order> orders = orderService.queryOrder();
		System.out.println(orders);
	}

	@Value("#{testService1}")
	private TestService testService;

	@Value("#{testService2}")
	private TestService testService2;

	@Value("#{order.orderId}")
	private String orderId;

	@Test
	public void ss(){
		System.out.println(testService);
		System.out.println(testService2);
		System.out.println(orderId);
	}


}
