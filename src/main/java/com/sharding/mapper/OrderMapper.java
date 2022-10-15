package com.sharding.mapper;

import com.sharding.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    List<Order> selectOrderByOrderDate(Map<String,Object> params);

    List<String> selectOrderCountByOrderDate(Map<String,Object> params);
   //4 支付中
    //5 已退款
    //6部分退款
    List<Integer> selectOrderHistoryCountBySummary(Map<String, Object> params);

}
