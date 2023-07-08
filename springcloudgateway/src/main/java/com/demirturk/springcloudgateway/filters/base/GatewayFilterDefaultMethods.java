package com.demirturk.springcloudgateway.filters.base;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;

public interface GatewayFilterDefaultMethods {

    default void applyBeforeRoute(ServerWebExchange exchange, GatewayFilterChain chain){}

    default void applyAfterRoute(ServerWebExchange exchange, GatewayFilterChain chain){}


}
