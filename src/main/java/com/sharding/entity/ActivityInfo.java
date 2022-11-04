package com.sharding.entity;

import java.util.Date;

/**
    * 活动图
    */
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}