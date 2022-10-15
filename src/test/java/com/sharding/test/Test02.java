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

    @Test
    public void selectOrderHistoryCountBySummary(){
        ///#{beginTime} and #{endTime}
        Map<String,Object> param=new HashMap<>();
        String beginTime="20220927";
        String endTime="20220927";
        String orderStatus="5";
        param.put("beginTime",beginTime);
        param.put("endTime",endTime);
        param.put("orderStatus",orderStatus);
        List<Integer> list = orderMapper.selectOrderHistoryCountBySummary(param);
        System.out.println(list);
    }
}
