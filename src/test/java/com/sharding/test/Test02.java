package com.sharding.test;

import com.sharding.entity.ActivityInfo;
import com.sharding.entity.IncomeCountExtDo;
import com.sharding.entity.PosxDeviceDO;
import com.sharding.entity.PosxDirectAgentMerStatistics;
import com.sharding.entity.PosxOrderExtDO;
import com.sharding.entity.TAgentShardingRuleConfigDO;
import com.sharding.mapper.OrderInfoMapper;
import com.sharding.mapper.OrderMapper;
import com.sharding.mapper.TAgentShardingRuleConfigMapper;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
    public void selectPosxDirectAgentMerStatistics(){
        Map<String, Object> params=new HashMap<>();
        params.put("startTime","20220820");
        params.put("endTime","20220821");
        List<PosxDirectAgentMerStatistics> posxDirectAgentMerStatistics = orderMapper.selectPosxDirectAgentMerStatistics(params);
        System.out.println(posxDirectAgentMerStatistics);

    }
//SELECT * FROM `activity_info` WHERE create_time>='2021-01-12' and create_time<'2021-01-15';
    @Test
    public void selectActivityInfo1(){
      //  System.out.println(ZoneId.getAvailableZoneIds());
        LocalDate begin = LocalDate.of(2021, 1, 12);
        LocalDate end = LocalDate.of(2021, 1, 15);
        Date from = new Date(1610380800);
        Date to = new Date(1610640000);
        List<ActivityInfo> maps = orderMapper.selectActivityInfo1(from, to);
        System.out.println(maps.stream().map(ActivityInfo::getActivityId).collect(Collectors.toList()));
    }

    @Test
    public void selectPosxDevice(){
        PosxDeviceDO posxDeviceDO = orderMapper.selectPosxDevice("141800001092340");
        if (StringUtils.hasText(posxDeviceDO.getMerchantId())
                && !Objects.equals(posxDeviceDO.getMerchantId(), "123")) {
           System.out.println("=================");
        }
    }

    /**
     * 嵌套包含查询会有null
     */
    @Test
    public void findIncomeCount(){
        List<String> agentNos=new ArrayList<>();
        agentNos.add("100214");
        List<IncomeCountExtDo> incomeCount = orderMapper.findIncomeCount(false,
                "20221003","20221003",agentNos,
                100214,true,"24000","101106,100117,100214"
                );
        System.out.println(incomeCount);
    }

    @Resource
    private TAgentShardingRuleConfigMapper tAgentShardingRuleConfigMapper;
    @Test
    public void selectAllShardingRuleNos(){
        List<TAgentShardingRuleConfigDO> tAgentShardingRuleConfigDOS = tAgentShardingRuleConfigMapper.selectAllShardingRuleNos();
        System.out.println(tAgentShardingRuleConfigDOS);
    }

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void dd(){
        Map<String,Object> map=new HashMap<>();
        map.put("beginTime","20221228");
     //   map.put("orderId","202212281846041124346802");
        map.put("yinlianMerchantNo","831521175120240");
        List<PosxOrderExtDO> posxOrderExtDOS = orderInfoMapper.selectPosxOrderByHuBeiMap(map);
        System.out.println(posxOrderExtDOS);

        List<Integer> list = orderInfoMapper.selectCountByHuBeiPosxOrder(map);
        System.out.println(list);
        AtomicInteger totalSize = new AtomicInteger(0);
        if (CollectionUtils.isNotEmpty(list)) {
            list.stream().filter(Objects::nonNull)
                    .reduce(Integer::sum).ifPresent(totalSize::set);
        }
        System.out.println(totalSize.get());
    }
}
