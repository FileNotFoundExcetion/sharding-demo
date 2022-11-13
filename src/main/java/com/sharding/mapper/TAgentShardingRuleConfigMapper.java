package com.sharding.mapper;

import com.sharding.entity.TAgentShardingRuleConfigDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TAgentShardingRuleConfigMapper  {

    @Select("select sharding_no from t_agent_sharding_rule_config where sharding_value = #{agentNo}")
    List<String> selectShardingRuleNo(@Param("agentNo") Integer agentNo);

    @Select("select sharding_value, sharding_no from t_agent_sharding_rule_config")
    List<TAgentShardingRuleConfigDO> selectAllShardingRuleNos();

}
