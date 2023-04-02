package com.example.echo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@Slf4j
public class EchoController {

    private final WebClient client = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    @GetMapping("/echo")
    public ResponseEntity<Object> get(@RequestBody(required = false) Object requestDto) {
        log.info("Enter GET /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @PutMapping("/echo")
    public ResponseEntity<Object> put(@RequestBody(required = false) Object requestDto) {
        log.info("Enter PUT /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @GetMapping("/ip")
    public ResponseEntity<String> getIp() throws UnknownHostException {
        log.info("Enter GET /ip endpoint");
        return new ResponseEntity<>(InetAddress.getLocalHost().getHostAddress(), HttpStatus.OK);
    }

    @PostMapping("/pass")
    public ResponseEntity<String> pass() {
        log.info("Enter POST /pass endpoint");
        String response = client.get()
                .uri("/ip")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info("Response: " + response);
        return new ResponseEntity<>("Passed", HttpStatus.OK);
    }
}
