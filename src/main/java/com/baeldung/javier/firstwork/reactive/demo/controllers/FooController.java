package com.baeldung.javier.firstwork.reactive.demo.controllers;

import com.baeldung.javier.firstwork.reactive.demo.models.Foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FooController {
    @GetMapping("/foo")
    public Mono<Foo> getFoo(){
        return Mono.just(new Foo(1l,"Javier")).delayElement(Duration.ofSeconds(1));
    }
}
