package com.sharding.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @Description 分润相关分表策略
 * @Author jia_h
 * @Date 2022/6/27 16:07
 * @Version 1.0
 */
@Slf4j
@Component
public class DayProfitComplexKeysShardingAlgorithm extends BaseComplexKeysShardingAlgorithm {

    private static final String AGENT_PROFIT = "t_agent_profit_";

    @Override
    public Collection<String> doSharding(Collection<String> databaseNames, ComplexKeysShardingValue<String> complexKeysShardingValue) {
        Collection<Object> orderDates = super.getShardingValue(complexKeysShardingValue, KEY_ORDER_DATE);
        if (CollectionUtils.isEmpty(orderDates)) {
            throw new IllegalArgumentException("未知的分片键");
        }
        List<String> list = new ArrayList<>();
        for (Object date: orderDates) {
            String day = String.valueOf(date).substring(4, 8);
            // 分润日表
            String tDayProfit = AGENT_PROFIT.concat(day);
            if (databaseNames.contains(tDayProfit)) {
                list.add(tDayProfit);
            }
        }
        return list;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {

    }

    @Override
    public String getType() {
        return "DayProfitComplexKeysShardingAlgorithm";
    }
}
