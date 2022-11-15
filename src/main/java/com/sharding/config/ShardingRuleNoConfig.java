package com.sharding.config;

import com.google.common.base.Preconditions;
import com.sharding.entity.PosxAgentDO;
import com.sharding.entity.TAgentShardingRuleConfigDO;
import com.sharding.mapper.PosxAgentMapper;
import com.sharding.mapper.TAgentShardingRuleConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;


@Slf4j
@Component
public class ShardingRuleNoConfig {


    private static final String NON_HUBEI_RULE_NO = "0";

    @Resource
    private TAgentShardingRuleConfigMapper tAgentShardingRuleConfigMapper;

    @Resource
    private PosxAgentMapper agentMapper;

    private final Map<String, String> agentNoCache = new ConcurrentSkipListMap<>();

    private List<TAgentShardingRuleConfigDO> cacheList = new LinkedList<>();

    public List<String> getRuleNo(String agentNo) {
        try {
            if (StringUtils.isEmpty(agentNo)) {
                throw new IllegalArgumentException("分片键为空");
            }
            String firstAgentNo = getFirstAgentNoFromCache(agentNo);
            List<String> ruleNoList = getRuleNoFromCache(firstAgentNo);
            log.info("缓存命中分片键集合:{}", ruleNoList);
            if (!org.apache.commons.collections.CollectionUtils.isNotEmpty(ruleNoList)) {
                ruleNoList.add(NON_HUBEI_RULE_NO);
            }
            return ruleNoList;
        } catch (Exception e) {
            log.info("未找到对应的分片配置 异常",e);
            throw new IllegalArgumentException("未找到对应的分片配置");
        }
    }

    private String getFirstAgentNoFromCache(String agentNo) {
        log.info("从缓存中获取一级代理:{}", agentNo);
        if (StringUtils.isEmpty(agentNoCache.get(agentNo))) {
            log.info("未命中缓存");
            String firstAgentNo = getFirstAgentNo(agentNo);
            agentNoCache.put(agentNo, firstAgentNo);
        } else {
            log.info("命中缓存");
            String firstAgentNo = agentNoCache.get(agentNo);
            if (StringUtils.isEmpty(firstAgentNo)) {
                firstAgentNo = getFirstAgentNo(agentNo);
                agentNoCache.put(agentNo, firstAgentNo);
            }
        }
        log.info("缓存数据-{}:{}", agentNo, agentNoCache.get(agentNo));
        return agentNoCache.get(agentNo);
    }

    private List<String> getRuleNoFromCache(String firstAgentNo) {
        return cacheList.stream().filter(e -> firstAgentNo.equals(e.getShardingValue()))
                .map(TAgentShardingRuleConfigDO::getShardingNo)
                .collect(Collectors.toList());
    }

    private String getFirstAgentNo(String agentNo) {
            PosxAgentDO agentDO = agentMapper.selectByAgentNo(Integer.parseInt(agentNo));
            Preconditions.checkArgument(agentDO != null, "代理商信息不存在");
            String agentNoTree = agentDO.getAgentNoTree();
            Preconditions.checkArgument(StringUtils.isNotEmpty(agentNoTree), "代理商配置信息不全");
            return agentNoTree.split(",")[1];

    }

    @PostConstruct
    private void cacheRuleNo() {
        log.info("分片配置缓存加载....");
        cacheList = tAgentShardingRuleConfigMapper.selectAllShardingRuleNos();
        if (CollectionUtils.isEmpty(cacheList)) {
            throw new IllegalArgumentException("分片配置信息为空,缓存加载失败");
        }
        log.info("分片配置缓存加载完成:{}", cacheList);
    }
}
