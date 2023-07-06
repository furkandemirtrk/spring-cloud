package com.demirturk.secondservice.controller;

import com.demirturk.secondservice.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.DummyController.CONTROLLER)
public class DummyController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Mono<String>> getName(@PathVariable("name") String name) {
        return ResponseEntity.ok(Mono.just("Second Service Hello " + name));
    }

}

