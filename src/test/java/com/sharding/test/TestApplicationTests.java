package com.sharding.test;

import com.sharding.entity.Order;
import com.sharding.entity.PosxOrder;
import com.sharding.mapper.OrderInfoMapper;
import com.sharding.mapper.OrderMapper;
import com.sharding.mapper.TestMapper;
import com.sharding.service.OrderService;
import com.sharding.service.TestService;
import com.sharding.vo.ProfitCountInfoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
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
		params.put("orderDate","20220929");
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

    @Resource
	private TestMapper testMapper;

	@Test
	public void queryAgentMercAnnulFeeInfo(){
		ProfitCountInfoDto profitCountInfoDto=new ProfitCountInfoDto();
		profitCountInfoDto.setBeginDate("20221202");
		profitCountInfoDto.setAgentNo(105508);
		profitCountInfoDto.setAgentNos(Arrays.asList(105508));
		profitCountInfoDto.setPaywayIds(Arrays.asList("22000", "23000", "27000", "10004", "29000", "24000"));
		profitCountInfoDto.setUnionpayOffers(0);
		testMapper.queryAgentMercAnnulFeeInfo(profitCountInfoDto);
	}

	@Test
	public void queryAgentMercValueAnnulFeeInfoGroup(){
		ProfitCountInfoDto profitCountInfoDto=new ProfitCountInfoDto();
		profitCountInfoDto.setBeginDate("20221202");
		profitCountInfoDto.setAgentNo(105508);
		profitCountInfoDto.setAgentNos(Collections.singletonList(105508));
		profitCountInfoDto.setPaywayIds(Arrays.asList("22000", "23000", "27000", "10004", "29000", "24000"));
		profitCountInfoDto.setUnionpayOffers(0);
		testMapper.queryAgentMercValueAnnulFeeInfoGroup(null,"D1", Collections.singletonList(105508),"20221202");
	}

	@Resource
	private OrderInfoMapper posxOrderMapper;

	@Test
	public void ff(){
		String orderId="202301091043208666700719";
		Integer agentNo=105488;
		PosxOrder orderEntity =posxOrderMapper .selectOrderIdByMonth(orderId, agentNo, orderId.substring(0, 8), orderId.substring(0, 8));
		System.out.println(orderEntity.getAgentNoTree());

	}
}
