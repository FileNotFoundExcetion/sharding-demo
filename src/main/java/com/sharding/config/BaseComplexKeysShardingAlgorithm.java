package com.sharding.config;

import com.google.common.collect.Range;
import com.sharding.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
@Slf4j
@Component
public class BaseComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties props) {

    }

    public Collection<String> rangeOfTables(Collection<String> databaseNames,
                                            Range<String> dateRange,
                                            String ruleNo,
                                            String suffix) throws ParseException {
        String lower = dateRange.lowerEndpoint();
        String upper = dateRange.upperEndpoint();
        Date startDate = DateTimeUtil.parseDateFormat(lower, DateTimeUtil.DAY_FORMAT);
        int days = DateTimeUtil.compareDay(startDate, DateTimeUtil.parseDateFormat(upper, DateTimeUtil.DAY_FORMAT));
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= days; i++) {
            Date tradeDate = DateTimeUtil.add(startDate, Calendar.DAY_OF_MONTH, i);
            String date = DateTimeUtil.getFormatDate(tradeDate, DateTimeUtil.DAY_FORMAT);
            String month = date.substring(0, 6);
            // 订单日表
            String tMonthOrder = String.format(suffix, ruleNo).concat(month);
            if (databaseNames.contains(tMonthOrder)) {
                if (!list.contains(tMonthOrder)) {
                    list.add(tMonthOrder);
                }
            }
        }
        return list;
    }

    public Collection<Object> getShardingValue(ComplexKeysShardingValue<String> shardingValues, final String key) {
        Collection<Object> valueSet = new ArrayList<>();
        Map<String, Collection<String>> valueMap = shardingValues.getColumnNameAndShardingValuesMap();
        String[] keys = key.split("\\|");
        for (int i = 0; i < keys.length; i++) {
            if (valueMap.containsKey(keys[i])){
                valueSet.addAll(valueMap.get(keys[i]));
            }
        }
        return valueSet;
    }

    public Range<String> getRangeShardingValue(ComplexKeysShardingValue<String> shardingValues, final String key) {
        Map<String, Range<String>> rangeMap = shardingValues.getColumnNameAndRangeValuesMap();
        if (rangeMap.containsKey(key)) {
            return rangeMap.get(key);
        }
        throw new IllegalArgumentException("未找到对应的表");
    }


    public Collection<String> rangeOfTablesByDays(Collection<String> databaseNames,
                                                  Range<String> dateRange,
                                                  String ruleNo,
                                                  String suffix) throws ParseException {
        String lower = dateRange.lowerEndpoint();
        String upper = dateRange.upperEndpoint();
        Date startDate = DateTimeUtil.parseDateFormat(lower, DateTimeUtil.DAY_FORMAT);
        int days = DateTimeUtil.compareDay(startDate, DateTimeUtil.parseDateFormat(upper, DateTimeUtil.DAY_FORMAT));
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= days; i++) {
            Date tradeDate = DateTimeUtil.add(startDate, Calendar.DAY_OF_MONTH, i);
            String date = DateTimeUtil.getFormatDate(tradeDate, DateTimeUtil.DAY_FORMAT);
            String day = date.substring(4, 8);
            // 订单日表
            String orderName = String.format(suffix, ruleNo).concat(day);
            if (databaseNames.contains(orderName)) {
                if (!list.contains(orderName)) {
                    list.add(orderName);
                }
            }
        }
        return list;
    }
}
