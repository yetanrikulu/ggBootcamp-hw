package com.example.thirdhomeworkyetanrikulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/conversion")
public class DollarToTlController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dollarToTL/{dollar}")
    public ResponseEntity<Double> calculateTl(@PathVariable double dollar){

        double tl = restTemplate.getForObject("http://localhost:8081/api/conversion/dollarToTL/"+dollar, Double.class);

        return new ResponseEntity<>(tl, HttpStatus.OK);
    }
    @GetMapping("/tlToDollar/{tl}")
    public ResponseEntity<Double> calculateDollar(@PathVariable double tl){

        double dollar = restTemplate.getForObject("http://localhost:8081/api/conversion/tlToDollar/"+tl, Double.class);

        return new ResponseEntity<>(dollar, HttpStatus.OK);
    }

}
