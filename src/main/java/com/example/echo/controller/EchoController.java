package com.example.echo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class EchoController {

    @GetMapping("/echo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> get(@RequestBody(required = false) Object requestDto) {
        log.info("Enter GET /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    @PutMapping("/echo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> put(@RequestBody(required = false) Object requestDto) {
        log.info("Enter PUT /echo endpoint");
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }
}
