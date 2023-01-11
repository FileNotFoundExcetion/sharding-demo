package com.sharding.mapper;

import com.sharding.ann.ShardingDS;
import com.sharding.entity.PosxOrder;
import com.sharding.entity.PosxOrderExtDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@ShardingDS
public interface OrderInfoMapper {
    List<PosxOrderExtDO> selectPosxOrderByHuBeiMap(Map<String, Object> param);

    List<Integer> selectCountByHuBeiPosxOrder(Map<String, Object> param);
    PosxOrder selectOrderIdByMonth(@Param("orderId")String orderId,
                                   @Param("agentNo") Integer agentNo,
                                   @Param("beginDate") String beginDate,
                                   @Param("endDate")String endDate);

}
