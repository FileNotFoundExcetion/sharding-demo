package com.sharding.mapper;

import com.sharding.ann.ShardingDS;
import com.sharding.vo.AgentProfitDetailDto;
import com.sharding.vo.ProfitCountInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@ShardingDS
public interface TestMapper {

    List<AgentProfitDetailDto> queryAgentMercAnnulFeeInfo(@Param("profitCountInfoDto") ProfitCountInfoDto profitCountInfoDto);

}
