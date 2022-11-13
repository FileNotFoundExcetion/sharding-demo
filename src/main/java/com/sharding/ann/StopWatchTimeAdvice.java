package com.sharding.ann;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author yunfeng
 * @Date 2022/9/1 16:06
 */
@Slf4j
@Aspect
@Component
public class StopWatchTimeAdvice {
    Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @Around("@annotation(AccessLog)")  // 或则直接使用扫描所有有注解的方法
    public Object access(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        final AccessLog annotation = method.getAnnotation(AccessLog.class);
        String nextId = null;
        if (annotation != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String traceId = MDC.get("trace_id");
            if (StringUtils.isNotEmpty(traceId)) {
                nextId = traceId;
            } else {
                nextId = snowflake.nextIdStr();
            }
            String sign = method.getDeclaringClass().getName() + "." + method.getName();
            String remoteHost = "N/A";
            // 在 controller 中获取到访问的 ip
            final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                final HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
                remoteHost = request.getRemoteHost();
            }
            if (annotation.isPrintReqParams()) {
                log.info("请求ID:{}", nextId);
                log.info("请求IP:{}", remoteHost);
                log.info("目标方法:{}", sign);
                log.info("请求参数:{}", objectMapper.writeValueAsString(args));
            }
        }

        Object proceed = point.proceed();  // 类似于调用过滤器链一样
        if (annotation != null && annotation.isPrintRes()) {
            log.info(CharSequenceUtil.format("{} INFO reqId={},results={}", DateUtil.now(), nextId, proceed));
        }
        return proceed;
    }
}
