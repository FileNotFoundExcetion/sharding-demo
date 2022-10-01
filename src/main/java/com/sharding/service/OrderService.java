package com.sharding.service;

import cn.hutool.core.date.DatePattern;
import com.sharding.entity.Order;
import com.sharding.entity.Pagination;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {

    public List<Order> queryOrder(){
        Map<String,Object> param=new HashMap<>();
        Pagination pagination=new Pagination();
        String beginTime="20220924";
        String endTime="20220930";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePattern.PURE_DATE_PATTERN);
        LocalDate begin = LocalDate.parse(beginTime, dateTimeFormatter);
        LocalDate end = LocalDate.parse(endTime, dateTimeFormatter);
        long days = end.toEpochDay() - begin.toEpochDay();
        AtomicInteger totalCount = new AtomicInteger(0);
        int actualTotalOffset = (pagination.getPageIndex() - 1) * pagination.getPageSize();
        for (int i = 0; i <= days; i++) {
            LocalDate localDate = end.minusDays(i);
            String date = dateTimeFormatter.format(localDate);
            param.put("beginTime", date);
            param.put("endTime", date);

        }
        List<Order> orders=new ArrayList<>();

        return orders;
    }

}
