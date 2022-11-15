package com.sharding.config;

import com.google.common.collect.Range;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
public class MonthAddOrderComplexKeysShardingAlgorithm extends BaseComplexKeysShardingAlgorithm {

    private static final String AGENT_ORDER_ATTACH_SUFFIX = "t_agent_order_add_value_%s_";

    @SneakyThrows
    @Override
    public Collection<String> doSharding(Collection<String> databaseNames, ComplexKeysShardingValue<String> complexKeysShardingValue) {
        String logicTableName = complexKeysShardingValue.getLogicTableName();
        if (complexKeysShardingValue.getColumnNameAndRangeValuesMap().isEmpty() && complexKeysShardingValue.getColumnNameAndShardingValuesMap().isEmpty()) {
            throw new IllegalArgumentException("不支持除了[=, in, between...and, >=, <=]的操作");
        }
        Collection<Object> agentNos = super.getShardingValue(complexKeysShardingValue, KEY_AGENT_NO);
        Collection<Object> dates = super.getShardingValue(complexKeysShardingValue, KEY_ORDER_DATE);
        AtomicReference<String> agentNoValue=new AtomicReference<>();
        agentNos.stream().findFirst().ifPresent(agentNo->agentNoValue.set(String.valueOf(agentNo)));
        List<String> ruleNos = shardingRuleNoConfig.getRuleNo(agentNoValue.get());
        List<String> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(dates)) {
            Range<String> dateRange = super.getRangeShardingValue(complexKeysShardingValue, KEY_ORDER_DATE);
            if (dateRange.isEmpty()) {
                throw new IllegalArgumentException("根据分片键未找到对应的值或范围");
            }
            for (String ruleNo : ruleNos) {
                Collection<String> strings = super.rangeOfTables(databaseNames, dateRange, ruleNo, AGENT_ORDER_ATTACH_SUFFIX);
                list.addAll(strings);
            }
            return list;
        } else {
            for (Object date : dates) {
                for (String ruleNo : ruleNos) {
                    String month = date.toString().substring(0, 6);
                    String tMonthOrder = String.format(AGENT_ORDER_ATTACH_SUFFIX, ruleNo).concat(month);
                    if (databaseNames.contains(tMonthOrder)&&(!list.contains(tMonthOrder))) {
                            list.add(tMonthOrder);
                    }
                }
            }
            return list;
        }
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
        return "MonthAddOrderComplexKeysShardingAlgorithm";
    }

}
