package com.sharding.config;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

@Component
public class LogicTable {
    /**
     *
     * @param logicTableName
     * @return
     */
    public Pair<Boolean,String> convertLogicTable(String logicTableName){
        if(logicTableName.equals("posx_order_month")){
           return new ImmutablePair<>(true,"t_agent_order_%s_");
        }
        if(logicTableName.equals("posx_order")){
            return new ImmutablePair<>(false,"t_agent_order_%s_");
        }
        if(logicTableName.equals("posx_order_attachment_month")){
            return new ImmutablePair<>(true,"t_agent_order_add_value_%s_");
        }
        if(logicTableName.equals("posx_order_attachment")){
            return new ImmutablePair<>(false,"t_agent_order_add_value_%s_");
        }
        return null;
    }

}
