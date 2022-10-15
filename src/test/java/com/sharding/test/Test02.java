package com.sharding.test;

import com.sharding.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class Test02 {
    @Value("#{orderMapper}")
    OrderMapper orderMapper;
    //跨月 会归并在集合里
    @Test
    public void selectOrderHistoryCountBySummary(){
        ///#{beginTime} and #{endTime}
        Map<String,Object> param=new HashMap<>();
        String beginTime="20220929";
        String endTime="20221001";
        String orderStatus="1";
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("orderStatus",orderStatus);
        List<Integer> list = orderMapper.selectOrderHistoryCountBySummary(param);
        System.out.println(list);
    }
}
