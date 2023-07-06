package com.demirturk.firstservice.controller;

import com.demirturk.firstservice.util.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(ApiPaths.DummyController.CONTROLLER)
public class DummyController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Mono<String>> getName(@PathVariable("name") String name) {
        return ResponseEntity.ok(Mono.just("First Service Hello " + name));
    }

}
