package com.demirturk.springcloudgateway.service.loggers;

import org.springframework.stereotype.Service;

@Service
public interface LoggersService {
    void createTrace(String spanId);
}
