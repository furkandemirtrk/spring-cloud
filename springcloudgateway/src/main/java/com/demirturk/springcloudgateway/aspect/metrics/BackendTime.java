package com.demirturk.springcloudgateway.aspect.metrics;

import com.demirturk.springcloudgateway.service.metrics.MetricsService;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Slf4j
@Component
public class BackendTime {
    private final Timer duration;

    public BackendTime(MetricsService metricsService) {
        this.duration = metricsService.timer("apigw.backendtime.aspect", null, null);
    }

    @Around("@annotation(com.demirturk.springcloudgateway.aspect.metrics.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endTime = System.currentTimeMillis();

        this.duration.record(endTime - startTime, TimeUnit.MILLISECONDS);
        return object;
    }
}
