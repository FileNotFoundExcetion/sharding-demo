package com.sharding.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * posx_device 表模型
 */
@Data
public class PosxDeviceDO {

    /**
     * 列名: device_id
     * 备注: 设备表主键
     */

    private String deviceId;

    /**
     * 列名: device_no
     * 备注: 设备编号
     */

    private String deviceNo;

    /**
     * 列名: device_model
     * 备注: 设备型号
     */

    private String deviceModel;

    /**
     * 列名: hardware_no
     * 备注: 硬件编号
     */

    private String hardwareNo;

    /**
     * 列名: device_name
     * 备注: 设备名称(批量导入时按照设备类型和设备编号命名)
     */

    private String deviceName;

    /**
     * 列名: device_type
     * 备注: 设备类型0-传统pos,1-扫码枪,2-扫码盒,3-台牌,4-智能pos,5-云音箱,6-刷卡扫码盒,7-刷脸,8-收银插件,9-智能消费机
     */

    private Integer deviceType;

    /**
     * 列名: device_category
     * '1:设备 2:配件'
     */

    private Integer deviceCategory;

    /**
     * 列名: agent_no
     * 备注: 代理no
     */

    private Integer agentNo;

    /**
     * 列名: agent_no_tree
     * 备注: 代理层级
     */

    private String agentNoTree;

    /**
     * 列名: agent_id
     * 备注: 当前所属代理id
     */

    private String agentId;

    /**
     * 列名: agent_tree
     * 备注: 代理树
     */

    private String agentTree;

    /**
     * 列名: merchant_id
     * 备注: 商户id
     */

    private String merchantId;

    /**
     * 列名: store_id
     * 备注: 门店ID
     */

    private String storeId;

    /**
     * 列名: operator_id
     * 备注: 操作员ID
     */

    private String operatorId;

    /**
     * 列名: in_time
     * 备注: 入库时间 YYYY-MM-DD HH:mm:ss
     */

    private Date inTime;

    /**
     * 列名: in_status
     * 备注: 入库状态：0-已入库(未出库)，1-已出库
     */

    private Integer inStatus;

    /**
     * 列名: out_time
     * 备注: 出库时间 YYYY-MM-DD HH:mm:ss
     */
    private Date outTime;

    /**
     * 列名: activate_status
     * 备注: 激活状态: 0-未激活, 1-激活
     */
    private Integer activateStatus;

    /**
     * 列名: activate_time
     * 备注: 激活时间 YYYY-MM-DD HH:mm:ss
     */
    private Date activateTime;

    /**
     * 列名: recall_status
     * 备注: 撤回状态:  0-未撤回 1-已撤回
     */
    private Integer recallStatus;

    /**
     * 列名: recall_time
     * 备注: 撤回时间
     */
    private Date recallTime;

    /**
     * 列名: device_key
     * 备注: 设备密钥,3des加解密
     */
    private String deviceKey;

    /**
     * 列名: device_params
     * 备注: 设备参数
     */
    private String deviceParams;

    /**
     * 列名: contact
     * 备注: 联系人
     */
    private String contact;

    /**
     * 列名: contact_tel
     * 备注:
     */
    private String contactTel;

    /**
     * 列名: use_address
     * 备注: 使用地址
     */
    private String useAddress;

    /**
     * 列名: remark
     * 备注: 备注
     */
    private String remark;

    /**
     * 列名: create_time
     * 备注: 创建时间
     */
    private Date createTime;

    /**
     * 列名: update_time
     * 备注: 修改时间
     */
    private Date updateTime;

    /**
     * 列名: terminal_no
     * 备注: 设备终端号
     */
    private String terminalNo;

    /**
     * 列名: auth_code
     * 备注: pos授权码
     */
    private String authCode;

    /**
     * 列名: freeze
     * 备注: 是否冻结 0-否，1-是
     */
    private String freeze;

    /**
     * 列名: first_freeze_amount
     * 备注: 首笔冻结金额
     */
    private BigDecimal firstFreezeAmount;

    /**
     * 列名: reward_amount
     * 备注: 奖励金额
     */
    private BigDecimal rewardAmount;

    /**
     * 列名: first_trade_time
     * 备注: 首笔交易时间
     */
    private String firstTradeTime;

    /**
     * 列名: province_id
     * 备注: 设备省Id
     */
    private String provinceId;

    /**
     * 列名: city_id
     * 备注: 设备市Id
     */
    private String cityId;

    /**
     * 列名: province_name
     * 备注: 设备省名字
     */
    private String provinceName;

    /**
     * 列名: city_name
     * 备注: 设备市名字
     */
    private String cityName;

    /**
     * 列名: district_id
     * 备注: 设备区县id
     */
    private String districtId;

    /**
     * 列名: district_name
     * 备注: 设备区县名字
     */
    private String districtName;

    /**
     * 列名: device_longitude
     * 备注: 设备经度
     */
    private String deviceLongitude;

    /**
     * 列名: device_latitude
     * 备注: 设备纬度
     */
    private String deviceLatitude;

    /**
     * 列名: add_status
     * 备注: 设备状态 0 未操作 1-增机中 2-已绑定 3-解绑中
     */
    private Integer addStatus;

    /**
     * 列名: org_struct_id
     * 备注: 组织结构编号
     */
    private Integer orgStructId;

    /**
     * 列名: cm_id
     * 备注: 渠道经理编号
     */
    private Integer cmId;

    /**
     * 列名: org_struct_tree
     * 备注: 组织结构树
     */
    private String orgStructTree;

    /**
     * 列名: bm_id
     * 备注: 业务员编号
     */
    private Integer bmId;


    /**
     * 列名: purchase_source
     * 备注: 采购来源 0-旺铺管家 1-自备机 2-旺铺专项设备
     */
    private Integer purchaseSource;
}