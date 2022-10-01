package com.sharding.service;

import cn.hutool.core.date.DatePattern;
import com.sharding.entity.Order;
import com.sharding.entity.Pagination;
import com.sharding.mapper.OrderMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    //1. 0930日表已经满足的情况

    public List<Order> queryOrder(){
        List<Order> orders=new ArrayList<>();
        Map<String,Object> param=new HashMap<>();
        Pagination pagination=new Pagination();
        pagination.setPageIndex(1);
        pagination.setPageSize(10);
        param.put("start", (pagination.getPageIndex() - 1) * pagination.getPageSize());
        param.put("length", pagination.getPageSize());
        String beginTime="20220924";
        String endTime="20220930";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePattern.PURE_DATE_PATTERN);
        LocalDate begin = LocalDate.parse(beginTime, dateTimeFormatter);
        LocalDate end = LocalDate.parse(endTime, dateTimeFormatter);
        long days = end.toEpochDay() - begin.toEpochDay();
        AtomicInteger totalCount = new AtomicInteger(0);
        int actualTotalOffset = (pagination.getPageIndex() - 1) * pagination.getPageSize();
        Map<String, Pair<Integer, Integer>> map = new HashMap<>();
        orderTag:
        for (int i = 0; i <= days; i++) {
            LocalDate localDate = end.minusDays(i);
            String date = dateTimeFormatter.format(localDate);
            param.put("orderDate", date);
            List<String> list = orderMapper.selectOrderCountByOrderDate(param);
            int size = list.size();
            int lastTotalOffset = totalCount.getAndAdd(size);
            int totalOffset = totalCount.get();
            //当前条数已经不足页数大小
            int res0 = totalOffset - pagination.getPageSize();
            if (res0 < 0) {
                int abs = Math.abs(res0);//已有几条
                Pair<Integer, Integer> pageParam = new ImmutablePair<>(0, abs);
                String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                map.put(lastDate, pageParam);
            }
            if(res0 > 0){
                //条数是否满足当前条数
                int res = totalOffset - pagination.getPageSize() - actualTotalOffset;
                if (res < 0) {
                    int abs = Math.abs(res);
                    Pair<Integer, Integer> pageParam = new ImmutablePair<>(abs, pagination.getPageSize());
                    String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                    map.put(lastDate, pageParam);
                    continue;
                }else if(res>0){
                    //本次查询的偏移量
                    //0  0-10
                    if(lastTotalOffset-pagination.getPageSize()>0){
                        int offset=actualTotalOffset-(lastTotalOffset-pagination.getPageSize());
                        if(offset+pagination.getPageSize()<size){
                            param.put("start", offset);
                            param.put("length", pagination.getPageSize());
                        }else {
                            int nextOffset= offset+pagination.getPageSize()- size;
                            Pair<Integer, Integer> pageParam = new ImmutablePair<>(0, nextOffset);
                            String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                            map.put(lastDate, pageParam);
                        }
                    }else if(lastTotalOffset-pagination.getPageSize()==0){
                        //=0
                        Pair<Integer, Integer> pageParam = new ImmutablePair<>(0, pagination.getPageSize());
                        String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                        map.put(lastDate, pageParam);
                        continue;
                    }
                }
            }
            //res0=0 或者条数已经满足的情况下
            Pair<Integer, Integer> pageParam = map.get(date);
            if (Objects.nonNull(pageParam)) {
                param.put("start", pageParam.getLeft());
                param.put("length", pageParam.getRight());
            }
            List<Order> dbList = orderMapper.selectOrderByOrderDate(param);
            if(!CollectionUtils.isEmpty(dbList)){
                for (Order order:dbList){
                     orders.add(order);
                    if (orders.size() == pagination.getPageSize()) {
                       break orderTag;
                    }
                }
            }
        }
        return orders;
    }

}
