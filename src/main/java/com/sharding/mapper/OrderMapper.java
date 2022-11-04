package com.sharding.mapper;

import com.sharding.entity.Order;
import com.sharding.entity.PosxDirectAgentMerStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderMapper {

    List<Order> selectOrderByOrderDate(Map<String,Object> params);
    //跨天分组统计 会有重复的
    List<Integer> selectOrderByOrderDateTemp(Map<String,Object> params);

    List<String> selectOrderCountByOrderDate(Map<String,Object> params);
   //4 支付中
    //5 已退款
    //6部分退款
    List<Integer> selectOrderHistoryCountBySummary(Map<String, Object> params);


   List<PosxDirectAgentMerStatistics> selectPosxDirectAgentMerStatistics(Map<String, Object> params);

   List<Map> selectActivityInfo(@Param("startTime")Date startTime,@Param("endTime")Date endTime);

}
