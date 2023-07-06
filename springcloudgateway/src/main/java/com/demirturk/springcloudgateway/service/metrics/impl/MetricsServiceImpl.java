package com.demirturk.springcloudgateway.service.metrics.impl;

import com.demirturk.springcloudgateway.service.metrics.MetricsService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class MetricsServiceImpl implements MetricsService {

    private final MeterRegistry meterRegistry;

    @Override
    public Timer timer(String name, Duration minDuration, Duration maxDuration) {

        return Timer.builder(name)
                .minimumExpectedValue(Optional.ofNullable(minDuration).orElse(Duration.ofMillis(1)))
                .maximumExpectedValue(Optional.ofNullable(maxDuration).orElse(Duration.ofMillis(6000)))
                .register(meterRegistry);
    }
}
