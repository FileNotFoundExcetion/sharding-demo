package com.sharding.test;

import com.sharding.entity.PosxDirectAgentMerStatistics;
import com.sharding.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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

    @Test
    public void ss(){
        Map<String, Object> params=new HashMap<>();
        params.put("startTime","20220820");
        params.put("endTime","20220821");
        List<PosxDirectAgentMerStatistics> posxDirectAgentMerStatistics = orderMapper.selectPosxDirectAgentMerStatistics(params);
        System.out.println(posxDirectAgentMerStatistics);

    }
//SELECT * FROM `activity_info` WHERE create_time>='2021-01-12' and create_time<'2021-01-15';
    @Test
    public void ff(){
        Date date = new Date();
        date.setYear(2021);
        date.setMonth(1);
        date.setDate(12);
        Date date1 = new Date();
        date1.setYear(2021);
        date1.setMonth(1);
        date1.setDate(15);
        List<Map> maps = orderMapper.selectActivityInfo(date, date1);
        System.out.println(maps.size());
    }
}
