package com.demirturk.springcloudgateway.configuration;

import com.demirturk.springcloudgateway.filters.loggers.LoggerPostFilter;
import com.demirturk.springcloudgateway.filters.loggers.LoggerPreFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFilterChainConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "apigateway.filters.loggers", name = "enabled")
    public LoggerPreFilter loggerPreFilter(){
        return new LoggerPreFilter();
    }

    @Bean
    @ConditionalOnProperty(prefix = "apigateway.filters.loggers", name = "enabled")
    public LoggerPostFilter loggerPostFilter(){
        return new LoggerPostFilter();
    }
}
