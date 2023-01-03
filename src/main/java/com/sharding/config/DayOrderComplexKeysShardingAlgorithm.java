package com.sharding.config;

import com.google.common.base.Preconditions;
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


@Slf4j
@Component
public class DayOrderComplexKeysShardingAlgorithm extends BaseComplexKeysShardingAlgorithm {

    private static final String AGENT_ORDER_SUFFIX = "t_agent_order_%s_";

    @SneakyThrows
    @Override
    public Collection<String> doSharding(Collection<String> databaseNames, ComplexKeysShardingValue<String> complexKeysShardingValue) {
        if (complexKeysShardingValue.getColumnNameAndShardingValuesMap().isEmpty()
                && complexKeysShardingValue.getColumnNameAndRangeValuesMap().isEmpty()) {
            throw new IllegalArgumentException("不支持的操作-分片键缺失");
        }
        Collection<Object> agentNos = super.getShardingValue(complexKeysShardingValue, KEY_AGENT_NO);
        List<String> ruleNos = shardingRuleNoConfig.getRuleNo(CollectionUtils.isEmpty(agentNos) ? "" : String.valueOf(agentNos.stream().findFirst().get()));
        Collection<Object> dates = super.getShardingValue(complexKeysShardingValue, KEY_ORDER_DATE);
        // 按日期范围查询场景 order_date between #{start} and #{end}
        List<String> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(dates)) {
            log.info("t_agent_order 按日期范围查询");
            Range<String> dateRange = super.getRangeShardingValue(complexKeysShardingValue, KEY_ORDER_DATE);
            if (dateRange.isEmpty()) {
                throw new IllegalArgumentException("根据分片键未找到对应的值或范围");
            }
            for (String ruleNo : ruleNos) {
                Collection<String> strings = super.rangeOfTablesByDays(databaseNames, dateRange, ruleNo, AGENT_ORDER_SUFFIX);
                list.addAll(strings);
            }
            log.info("t_agent_order 按日期范围查询:{}", list);
            Preconditions.checkArgument(org.apache.commons.collections.CollectionUtils.isNotEmpty(list), "未找到相应的日表");
            return list;
        } else {
            // 按日期精确查询 order_date = #{orderDate}
            log.info("t_agent_order  按日期精确查询");
            for (Object date : dates) {
                for (String ruleNo : ruleNos) {
                    String day = date.toString().substring(4, 8);
                    String tDayOrder = String.format(AGENT_ORDER_SUFFIX, ruleNo).concat(day);
                    log.info("查询表名:{}", tDayOrder);
                    if (databaseNames.contains(tDayOrder)) {
                        list.add(tDayOrder);
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
        log.info("[properties]" + properties);
    }

    @Override
    public String getType() {
        return "DayOrderComplexKeysShardingAlgorithm";
    }
}
