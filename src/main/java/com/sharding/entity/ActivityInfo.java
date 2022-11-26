package com.sharding.entity;

import lombok.Data;

import java.util.Date;

/**
    * 活动图
    */
@Data
public class ActivityInfo {
    /**
    * 活动id
    */
    private Integer activityId;

    /**
    * banner名称
    */
    private String activityName;

    /**
    * 城市id 0全国
    */
    private Integer cityId;

    /**
    * 城市名称
    */
    private String cityName;

    /**
    * 活动图片url
    */
    private String activityPic;

    /**
    * 是否开启0：关闭；1：开启
    */
    private Boolean status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 修改人
    */
    private String updateBy;


}