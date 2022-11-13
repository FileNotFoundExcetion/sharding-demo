package com.sharding.mapper;

import com.sharding.ann.ShardingDS;
import com.sharding.entity.ActivityInfo;
import com.sharding.entity.IncomeCountExtDo;
import com.sharding.entity.Order;
import com.sharding.entity.PosxDeviceDO;
import com.sharding.entity.PosxDirectAgentMerStatistics;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
@ShardingDS
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

   List<ActivityInfo> selectActivityInfo(@Param("startTime") LocalDate startTime, @Param("endTime")LocalDate endTime);

    List<ActivityInfo> selectActivityInfo1(@Param("startTime") Date startTime, @Param("endTime")Date endTime);


    PosxDeviceDO selectPosxDevice(@Param("deviceNo")String deviceNo);

    List<IncomeCountExtDo> findIncomeCount(@Param("isDirectMerchant") Boolean isDirectMerchant, @Param("beginTime") String beginTime, @Param("endTime") String endTime
            , @Param("agentNos") List<String> agentNos, @Param("agentNo") Integer agentNo, @Param("isAllOrder") Boolean isAllOrder, @Param("paywayId") String paywayId, @Param("agentNoTree")String agentNoTree);

}
