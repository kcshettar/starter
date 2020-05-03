package com.kcs.starter.securingweb;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

public class CorrelationIdInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String correlationId = UUID.randomUUID().toString();
        logger.debug("CorrelationIdInterceptor : preHandle : set correlationId={}", correlationId);
        MDC.put("correlationId", correlationId);
        response.setHeader("correlationId", correlationId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.debug("CorrelationIdInterceptor : preHandle : unset correlationId");
        MDC.remove("correaltionId");
    }
}
