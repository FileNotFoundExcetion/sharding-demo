package com.sharding.mapper;

import com.sharding.ann.ShardingDS;
import com.sharding.entity.PosxOrderExtDO;

import java.util.List;
import java.util.Map;

@ShardingDS
public interface OrderInfoMapper {
    List<PosxOrderExtDO> selectPosxOrderByHuBeiMap(Map<String, Object> param);

    List<Integer> selectCountByHuBeiPosxOrder(Map<String, Object> param);

}
