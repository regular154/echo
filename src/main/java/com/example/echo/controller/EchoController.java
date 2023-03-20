package com.example.echo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@Slf4j
public class EchoController {

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
}
