package com.sharding.mapper;

import com.sharding.entity.PosxAgentDO;
import org.apache.ibatis.annotations.Select;

public interface PosxAgentMapper {

    @Select("select * FROM `posx_agent` WHERE agent_no = #{agentNo}")
    PosxAgentDO selectByAgentNo(Integer agentNo);

}
