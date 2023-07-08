package com.demirturk.springcloudgateway.filters.loggers;

import com.demirturk.springcloudgateway.configuration.FilterRegistry;
import com.demirturk.springcloudgateway.filters.base.AbstractGatewayGlobalFilterFactory;
import com.demirturk.springcloudgateway.service.loggers.LoggersService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;

public class LoggerPostFilter extends AbstractGatewayGlobalFilterFactory {

    @Getter
    @Setter
    @Autowired
    private LoggersService loggersService;

    @Override
    public void applyAfterRoute(ServerWebExchange exchange, GatewayFilterChain chain){
        loggersService.createTrace(
                String.valueOf(RandomUtils.nextLong())
        );
        super.applyBeforeRoute(exchange, chain);
    }

    @Override
    public int getOrder(){
        return FilterRegistry.getOrder(LoggerPostFilter.class);
    }
}
