package com.demirturk.springcloudgateway.filters.base;

import com.demirturk.springcloudgateway.aspect.metrics.TrackExecutionTime;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public abstract class AbstractGatewayGlobalFilterFactory implements GlobalFilter, Ordered, GatewayFilterDefaultMethods {

    @Override
    @TrackExecutionTime
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
        applyBeforeRoute(exchange, chain);

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() ->
                        applyAfterRoute(exchange, chain)
                ));
    }

    @Override
    public int getOrder(){
        return 0;
    }

}
