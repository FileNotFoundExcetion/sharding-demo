package com.sharding.service;

import cn.hutool.core.date.DatePattern;
import com.sharding.entity.Order;
import com.sharding.entity.Pagination;
import com.sharding.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class OrderService {
    //30 3
    //29 5
    //28 5
    //27 1
    // 26 6
    //25 6
    //24 6
    @Resource
    private OrderMapper orderMapper;
    //SELECT * FROM `t_agent_order_1_0929` ORDER BY order_id desc
    //1. 0930日表已经满足的情况

    public List<Order> queryOrder(){
        List<Order> orders=new ArrayList<>();
        Map<String,Object> param=new HashMap<>();
        Pagination pagination=new Pagination();
        pagination.setPageIndex(2);
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
        orderTag: for (int i = 0; i <= days; i++) {
            LocalDate localDate = end.minusDays(i);
            String date = dateTimeFormatter.format(localDate);
            param.put("orderDate", date);
            List<String> list = orderMapper.selectOrderCountByOrderDate(param);
            int size = list.size();
            totalCount.getAndAdd(size);
            int totalOffset = totalCount.get();
            //实际的偏移量  10 -1 10 差11
            int res0 = totalOffset - actualTotalOffset;//20
            if (res0 < 0) {
                int abs = Math.abs(res0);//偏移量还差多少
                Pair<Integer, Integer> pageParam = new ImmutablePair<>(abs, pagination.getPageSize());
                String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                map.put(lastDate, pageParam);
            }
            if(res0>=0){
                //多出来的偏移量是否满足一页大小,如果不满足，还缺多少
              int actualAchieve=res0-pagination.getPageSize();
              if(actualAchieve<0){
                  int abs = Math.abs(actualAchieve);
                  Pair<Integer, Integer> pageParam = new ImmutablePair<>(0, abs);
                  String lastDate = dateTimeFormatter.format(localDate.minusDays(1));
                  map.put(lastDate, pageParam);
              }
              //>0拿上一页的偏移量
            }
            //res0=0 或者条数已经满足的情况下
            Pair<Integer, Integer> pageParam = map.get(date);
            if (Objects.nonNull(pageParam)) {
                param.put("start", pageParam.getLeft());
                param.put("length", pageParam.getRight());
            }
            int start =(Integer) param.get("start");
            if(start>=size){
              continue ;
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
