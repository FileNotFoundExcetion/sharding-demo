package com.sharding.mapper;

import com.sharding.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    List<Order> selectOrderByOrderDate(Map<String,Object> params);

    List<String> selectOrderCountByOrderDate(Map<String,Object> params);

}
