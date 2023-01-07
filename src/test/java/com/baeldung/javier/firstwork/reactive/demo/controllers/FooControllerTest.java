package com.baeldung.javier.firstwork.reactive.demo.controllers;

import com.baeldung.javier.firstwork.reactive.demo.models.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;

@RunWith(SpringRunner.class)
@WebFluxTest(FooController.class)
public class FooControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testGetMethod() {

        webTestClient.get()
                .uri("/foo")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Foo.class)
                .value(foo1 -> foo1.getName().equals("Javier"));
    }

    @Test
    public void testAsyncCalls(){
        System.out.println(new Date());
        webTestClient.get()
                .uri("/foo");
        System.out.println(new Date());
        webTestClient.get()
                .uri("/foo");
        System.out.println(new Date());
        webTestClient.get()
                .uri("/foo");
    }

}
