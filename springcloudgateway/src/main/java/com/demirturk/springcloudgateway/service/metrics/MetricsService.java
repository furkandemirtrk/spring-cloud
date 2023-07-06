package com.demirturk.springcloudgateway.service.metrics;

import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public interface MetricsService {
    Timer timer(String name, Duration minDuration, Duration maxDuration);
}
