package com.demirturk.springcloudgateway.aspect.metrics;

import com.demirturk.springcloudgateway.service.metrics.MetricsService;
import io.micrometer.core.instrument.Timer;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Aspect
@Slf4j
@Component
public class ExecutionTimeAdvice {

    @Autowired
    @Getter
    @Setter
    private MetricsService metricsService;

    @Around("@annotation(TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        String name = getAnnotationNameParameter(point);
        Timer duration = metricsService.timer("apigw.".concat(name), null, null);
        log.info(name + " started ....");
        long startTime = System.nanoTime();
        Object proceed = point.proceed();
        long executionTime = System.nanoTime() - startTime;
        duration.record(executionTime, TimeUnit.NANOSECONDS);
        log.info(name + " ended ....");
        return proceed;
    }

    private String getAnnotationNameParameter(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        return Optional.ofNullable(method.getAnnotation(TrackExecutionTime.class).name())
                .filter(s -> !s.isEmpty())
                .orElseGet(() -> getClassName(point, method.getName()));
    }

    private String getClassName(ProceedingJoinPoint point, String methodName){
        String[] arr = String.valueOf(point.getTarget().getClass()).split("\\.");
        return arr[arr.length - 1].concat(".").concat(methodName);
    }
}
