package com.demirturk.secondservice.util;

public class ApiPaths {
    public ApiPaths() {
    }

    private static final String BASE_PATH = "/second-service/api"; //NOSONAR

    public static final class DummyController {
        public DummyController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/dummy";

    }
}
