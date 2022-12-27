package com.sharding.mapper;

import com.sharding.entity.ActivityInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ActivityInfoMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(ActivityInfo record);

    int insertSelective(ActivityInfo record);

    ActivityInfo selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(ActivityInfo record);

    int updateByPrimaryKey(ActivityInfo record);

    @Select("select * from activity_info")
    @ResultMap("BaseResultMap")
    List<ActivityInfo> selectActivity();

    @Update("update posx_merchant set mode_number = #{modeNumber}, update_time = now() where merchant_id = #{merchantId}")
    int updateModeNumber(@Param("merchantId") String merchantId,
                         @Param("modeNumber") String modeNumber);
}