package com.demirturk.firstservice.util;

public class ApiPaths {
    public ApiPaths() {
    }

    private static final String BASE_PATH = "/first-service/api"; //NOSONAR

    public static final class DummyController {
        public DummyController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/dummy";

    }
}
