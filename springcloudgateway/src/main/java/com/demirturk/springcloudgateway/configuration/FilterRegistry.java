package com.demirturk.springcloudgateway.configuration;

import com.demirturk.springcloudgateway.filters.base.AbstractGatewayGlobalFilterFactory;
import com.demirturk.springcloudgateway.filters.loggers.LoggerPostFilter;
import com.demirturk.springcloudgateway.filters.loggers.LoggerPreFilter;

import java.util.HashMap;
import java.util.Map;

public class FilterRegistry {
    private FilterRegistry() {}

    private static final Map<Class<? extends AbstractGatewayGlobalFilterFactory>, Integer> FILTER_ORDER_MAP;

    public static final Integer INITIAL_FILTER_ORDER = 0;

    static {
        FILTER_ORDER_MAP = new HashMap<>();
        FilterRegistry.FILTER_ORDER_MAP.put(LoggerPreFilter.class, INITIAL_FILTER_ORDER -1);
        FilterRegistry.FILTER_ORDER_MAP.put(LoggerPostFilter.class, INITIAL_FILTER_ORDER + 100);
    }

    public static Integer getOrder(Class<? extends AbstractGatewayGlobalFilterFactory> filterClass){
        return FILTER_ORDER_MAP.get(filterClass);
    }
}
