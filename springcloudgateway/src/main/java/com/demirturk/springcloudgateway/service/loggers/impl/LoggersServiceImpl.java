package com.demirturk.springcloudgateway.service.loggers.impl;

import com.demirturk.springcloudgateway.aspect.metrics.TrackExecutionTime;
import com.demirturk.springcloudgateway.service.loggers.LoggersService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.TraceContext;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoggersServiceImpl implements LoggersService {


    @Getter
    @Setter
    @Autowired
    private Tracer tracer;

    @TrackExecutionTime(name = "createTrace")
    @Override
    public void createTrace(String spanId) {
        TraceContext traceContext = tracer.traceContextBuilder()
                .traceId(String.valueOf(RandomUtils.nextLong()))
                .spanId(spanId)
                .sampled(true)
                .build();
        Objects.requireNonNull(tracer.currentTraceContext()).newScope(traceContext);
    }
}
