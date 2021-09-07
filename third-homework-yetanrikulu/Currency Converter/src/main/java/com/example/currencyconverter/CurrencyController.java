package com.example.currencyconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @GetMapping("/conversion/tlToDollar/{tl}")
    public double convertTltoDollar(@PathVariable double tl){
        return tl/8.5;
    }
    @GetMapping("/conversion/dollarToTL/{dollar}")
    public double convertDollartoTl(@PathVariable double dollar){
        return dollar*8.5;
    }

}
