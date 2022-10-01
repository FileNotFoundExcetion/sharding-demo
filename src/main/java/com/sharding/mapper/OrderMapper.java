package com.sharding.mapper;

import com.sharding.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    List<Order> selectOrderByOrderDate(@Param("orderDate")String orderDate);

}
