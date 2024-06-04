package com.ravi.multi.client.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/call/service")
public class TestController {

    @Autowired
    private WebClient webClient1;

    @Autowired
    private WebClient webClient2;

    @GetMapping("/client1")
    public String callServiceClient1() {
        return webClient1
                .get()
                .uri("https://api.example1.com/data")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/client2")
    public String callServiceClient2() {
        return webClient2
                .get()
                .uri("https://api.example2.com/data")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
